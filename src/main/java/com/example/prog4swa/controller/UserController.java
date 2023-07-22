package com.example.prog4swa.controller;

import com.example.prog4swa.model.UserEntity;
import com.example.prog4swa.model.UserSession;
import com.example.prog4swa.repository.UserSessionRepository;
import com.example.prog4swa.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@AllArgsConstructor
public class UserController implements WebMvcConfigurer {
    private final AuthenticationService authenticationService;
    private final UserSessionRepository userSessionRepository;

    @GetMapping("/login")
    public String showLoginForm(UserEntity userEntity) {
        return "login";
    }

    @PostMapping("/login")
    public String authenticateUser(UserEntity userEntity, HttpServletResponse response){
        if(authenticationService.authenticate(userEntity.getUserName(), userEntity.getPassword(), response)){
            return "redirect:/employees";
        }
        return "/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        String sessionId = authenticationService.extractSessionIdFromRequest(request);
        UserSession userSession = userSessionRepository.findBySessionId(sessionId);
        authenticationService.deleteCookie(response, "userSessionId");
        userSessionRepository.delete(userSession);
        return "redirect:/login";
    }

}
