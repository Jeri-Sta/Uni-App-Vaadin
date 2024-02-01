package br.com.uni.backend.security;

import br.com.uni.backend.common.messages.GeneralMessages;
import br.com.uni.backend.exception.UniException;
import br.com.uni.backend.exception.bundle.AuthenticationAppException;
import br.com.uni.backend.person.PersonValidator;
import br.com.uni.backend.security.jwt.JwtService;
import br.com.uni.backend.security.model.AuthenticationRequest;
import br.com.uni.backend.security.model.AuthenticationResponse;
import br.com.uni.backend.security.model.RegisterRequest;
import br.com.uni.backend.security.model.Role;
import br.com.uni.backend.user.UserRepository;
import br.com.uni.backend.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PersonValidator personValidator;

    public AuthenticationResponse register(RegisterRequest reuqest) throws UniException {
        var email = userRepository.findByEmail(reuqest.getEmail());
        if(email.isPresent()){
            throw new AuthenticationAppException(GeneralMessages.EMAIL_ALREADY_REGISTERED);
        }
        var user = User.builder()
                .person(reuqest.getPerson())
                .email(reuqest.getEmail())
                .password(passwordEncoder.encode(reuqest.getPassword()))
                .role(Role.USER)
                .build();
        personValidator.validateFields(user.getPerson());
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest reuqest) throws UniException {
        var user = userRepository.findByEmail(reuqest.getEmail());
        if(user.isEmpty()){
            throw new AuthenticationAppException(GeneralMessages.EMAIL_NOT_FOUND);
        }
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reuqest.getEmail(), reuqest.getPassword()));
        } catch (AuthenticationException e) {
            throw new AuthenticationAppException(GeneralMessages.LOGIN_FAILED);
        }
        var jwtToken = jwtService.generateToken(user.get());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
