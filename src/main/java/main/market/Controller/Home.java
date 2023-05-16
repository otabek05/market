package main.market.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class Home {


    @GetMapping("/home")
    public ResponseEntity home(){
        return ResponseEntity.ok("This is homepage!");
    }

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.ok("this is get page made for get api");
    }

    @GetMapping("/data")
    public ResponseEntity data(){
        return ResponseEntity.ok("Login has been successfully finished");
    }

    @GetMapping("/user")
    public ResponseEntity getCurrentUser(Authentication authentication){
        if(authentication.isAuthenticated()) {
            return ResponseEntity.ok(authentication.getPrincipal());
        }
        else {
            return ResponseEntity.badRequest().build();
        }



    }
}
