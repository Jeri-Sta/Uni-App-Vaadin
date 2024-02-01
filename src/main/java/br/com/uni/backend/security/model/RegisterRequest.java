package br.com.uni.backend.security.model;


import br.com.uni.backend.person.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Person person;
    private String email;
    private String password;
}
