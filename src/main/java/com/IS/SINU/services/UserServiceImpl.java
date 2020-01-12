package com.IS.SINU.services;

import com.IS.SINU.entities.dao.*;
import com.IS.SINU.entities.dto.UserDto;
import com.IS.SINU.entities.enums.Parity;
import com.IS.SINU.entities.enums.Weekday;
import com.IS.SINU.exceptions.*;
import com.IS.SINU.repositories.GroupRepository;
import com.IS.SINU.repositories.ScheduleRepository;
import com.IS.SINU.repositories.TeachingRepository;
import com.IS.SINU.repositories.UserRepository;
import com.IS.SINU.security.activation.ActivationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Autowired
    private TeachingRepository teachingRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private GroupRepository groupRepository;

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
        repository.save(user);
        if(isTufisi(user)) {
            User tufisi = repository.findByUsername(user.getUsername());

            //making Tufisi an IS teacher
            Teaching t = new Teaching();
            t.setClassId(2L);//lab IS
            t.setProfessorId(tufisi.getId());
            t = teachingRepository.save(t);

//            Group g = groupRepository.findById(10L).get();

            //making Tufisi teach to group 10
//            ScheduleIdentity sID = new ScheduleIdentity();
//            sID.setTeaching(t);
//            sID.setGroup(g);
//
//            System.out.println(g);
//
//            ScheduleEntry s = new ScheduleEntry();
//            s.setScheduleId(sID);
//            s.setDay(Weekday.THURSDAY);
//            s.setTime(new Date());
//            s.setLocation("Pe Barițiu acolo în stânga, înainte de scări");
//            s.setParity(Parity.BOTH);
//
//            System.out.println(s);
//
//            scheduleRepository.save(s);
//            scheduleRepository.makeTufisiOurTeacher(t.getId());
        }
        System.out.println("Saved " + user);
        sendActivationEmail(user.getEmail(), token);
        return user;
    }


    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        return user != null;
    }

    private boolean usernameExist(String username) {
        User user = repository.findByUsername(username);
        return user != null;
    }

    private void sendActivationEmail(String recipientAddress, String token) throws MailException {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject("SINU Account Activation");
        email.setText("http://localhost:8080/user/activate/" + token);
        System.out.println("Ready to send email!");
        mailSender.send(email);
    }

    @Override
    public User activateAccount(String token) {
        User user = repository.findByActivationToken(token);
        if(user == null || user.getActivated()) {
            throw new InvalidTokenException();
        }
        if(!ActivationToken.verifyToken(token)) {
            throw new ExpiredTokenException();
        }
        repository.activateUser(user.getId());
        user.setActivated(true);
        return user;
    }

    @Override
    public User getUser(String username) {
        User user = repository.findByUsername(username);
        if(user == null) {
            throw new NonexistentUserException(username, "user");
        }
        return user;
    }

    @Override
    public List<ClassGroup> getTeachingList(Long id) {
        return repository.getClassGroupList(id);
    }

    private boolean isTufisi(User user) {
        return user.getFirstName().equals("Radu") || user.getLastName().equals("Tufisi");
    }

}
