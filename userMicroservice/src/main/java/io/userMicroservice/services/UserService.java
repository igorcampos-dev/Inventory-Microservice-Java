package io.userMicroservice.services;

import io.userMicroservice.entity.dto.GetUserDTO;
import io.userMicroservice.entity.dto.UserDTO;

public interface UserService {

    void save(UserDTO userDTO);

    String login(UserDTO dto);

    GetUserDTO findById(String userId);
}
