package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.ClassGroup;
import com.IS.SINU.entities.dao.Subject;
import com.IS.SINU.entities.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByActivationToken(String activationToken);

    @Transactional
    @Modifying
    @Query("update User u set u.activated = true where u.id = ?1")
    void activateUser(long id);

    @Query("select new com.IS.SINU.entities.dao.ClassGroup(S.scheduleId.teaching.class_name, S.scheduleId.group) from ScheduleEntry S where S.scheduleId.teaching.professor.id = ?1")
    List<ClassGroup> getClassGroupList(Long id);

    @Query("select S.scheduleId.group.students from ScheduleEntry S where S.scheduleId.teaching.class_name.subject = ?1")
    List<List<User>> findBySubject(Subject subject);
}
