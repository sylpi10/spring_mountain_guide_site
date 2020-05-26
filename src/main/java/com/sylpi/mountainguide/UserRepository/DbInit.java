package com.sylpi.mountainguide.UserRepository;

import com.sylpi.mountainguide.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        //delete all
        this.userRepository.deleteAll();

        // create some users
        User yoann = new User("yoann", passwordEncoder.encode("yoannpass"), "ADMIN");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN");

        List<User> users = Arrays.asList(yoann, admin);
        this.userRepository.saveAll(users);

//        this.userRepository.save(yoann);
    }
}

