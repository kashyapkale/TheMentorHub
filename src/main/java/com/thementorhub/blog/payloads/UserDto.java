package com.thementorhub.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {


    private int id;

    @NotEmpty
    @Size(min=4,message="Username must be of minimum 4 characters")
    private String name;

    @Email(message="Email Address is not valid")
    private String email;

    @NotEmpty
    @Size(min=4,max=10,message="Password must be of minimum 4 characters and max 10 Chars")
    private String password;

    @NotEmpty
    private String about;
}
