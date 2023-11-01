package io.userMicroservice.controllers;

import io.userMicroservice.entity.dto.GetUserDTO;
import io.userMicroservice.entity.dto.Response;
import io.userMicroservice.entity.dto.UserDTO;
import io.userMicroservice.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<Response> save(@Valid @RequestBody UserDTO dto){
        userService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("cadastrado,parabéns"));
    }

    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody UserDTO dto){
        String token = userService.login(dto);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    @GetMapping("/{userID}")
    public ResponseEntity<GetUserDTO> getUser(@PathVariable("userId") String userId){
        GetUserDTO dto = userService.findById(userId);

       return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
