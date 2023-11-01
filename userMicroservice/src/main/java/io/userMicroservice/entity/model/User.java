package io.userMicroservice.entity.model;

import io.userMicroservice.entity.dto.GetUserDTO;
import io.userMicroservice.entity.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String last_name;
    private String address;
    private String password;
    private String email;

    public User(UserDTO dto) {
        this.name = dto.name();
        this.last_name = dto.last_name();
        this.address = dto.address();
        this.password = dto.password();
        this.email = dto.email();
    }

    public GetUserDTO toModel(){
        return new GetUserDTO(this.name, this.email, this.last_name, this.address);
    }
}
