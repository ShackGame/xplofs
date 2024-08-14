package com.project.Xplo_FS.controller;

import com.project.Xplo_FS.dto.RegisterRequest;
import com.project.Xplo_FS.model.User;
import com.project.Xplo_FS.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){
        String res = userService.register(registerRequest);
        if(res.equalsIgnoreCase("success"))
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Your Fault");
    }

}
