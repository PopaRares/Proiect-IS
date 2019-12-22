package com.IS.SINU.services;

import com.IS.SINU.entities.dao.User;
import com.IS.SINU.entities.dto.UserDto;
import com.IS.SINU.exceptions.EmailExistsException;
import com.IS.SINU.exceptions.UsernameExistsException;
import com.IS.SINU.repositories.UserRepository;
import com.IS.SINU.security.activation.ActivationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws RuntimeException {
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(accountDto.getEmail());
        }
        if (usernameExist(accountDto.getUsername())) {
            throw new UsernameExistsException(accountDto.getUsername());
        }
        User user = new User(accountDto);
        String password = bCryptPasswordEncoder.encode(accountDto.getPassword());
        user.setPassword(password);

        String token = ActivationToken.generate();
        user.setActivationToken(token);
        userRepository.save(user);

        sendActivationEmail(user.getEmail(), token);

        return user;
    }

    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    private boolean usernameExist(String username) {
        User user = userRepository.findByUsername(username);
        return user != null;
    }

    private void sendActivationEmail(String recipientAddress, String token) throws MailException {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject("SINU Account Activation");
        email.setText("http://localhost:8080/user/activate?token=" + token);
        mailSender.send(email);
    }

}
