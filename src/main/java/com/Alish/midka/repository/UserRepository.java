package com.Alish.midka.repository;

import com.Alish.midka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM Registration u Where u.name=?1 and u.password=?2", nativeQuery = true)
    User findByUserNameAndPasswordUser(String name, String password);



    @Query(value = "SELECT * FROM Admin u Where u.name=?1 and u.password=?2", nativeQuery = true)
    User findByUserNameAndPasswordAdmin(String name, String password);

    User findByUsername(String username);

}
