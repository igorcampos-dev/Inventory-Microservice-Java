package io.userMicroservice.services.impl;

import io.userMicroservice.entity.dto.GetUserDTO;
import io.userMicroservice.entity.dto.UserDTO;
import io.userMicroservice.entity.model.User;
import io.userMicroservice.repositories.UserRepository;
import io.userMicroservice.services.UserService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(UserDTO userDTO) {
        Optional.of(userRepository.save(new User(userDTO))).orElseThrow();
    }

    @Override
    public String login(UserDTO dto) {
      return userRepository.findByName(dto.user().getName())
                .map( s -> {
                    String token = "este será o futuro token " + s.getName();
                      return token;
                           })
                .orElseThrow();
    }

    @Override
    public GetUserDTO findById(String userId) {
        return userRepository.findById(userId)
                .map(User::toModel).orElseThrow();
    }
}
