package com.project.Xplo_FS.service;

import com.project.Xplo_FS.dto.RegisterRequest;
import com.project.Xplo_FS.model.User;
import com.project.Xplo_FS.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public String register(RegisterRequest registerRequest){
        String res = "";
        if(registerRequest != null){
            Optional<User> dbUser = userRepository.findByUsername(registerRequest.username());
            if(dbUser.isEmpty()){
                UUID id = UUID.randomUUID();
                User user = User.builder()
                        .uuid(id)
                        .username(registerRequest.username())
                        .password(registerRequest.password())
                        .build();
                userRepository.save(user);
                res = "success";
            }

        }
        return res;
    }
}
