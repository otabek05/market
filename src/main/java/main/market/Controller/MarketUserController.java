package main.market.Controller;

import main.market.Entity.MarketUser;
import main.market.Service.MarketUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MarketUserController {

    private final MarketUserService service;
    private final PasswordEncoder passwordEncoder;

    public MarketUserController(MarketUserService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/register")
    public ResponseEntity create(@RequestBody MarketUser user){
        if (service.existsByLogin(user.getLogin())){
            return new ResponseEntity("This username is already exist", HttpStatus.BAD_REQUEST);
        }
        else if (!checkPasswordLength(user.getPassword())){
            return new ResponseEntity("Password must be at least 4 chatacters", HttpStatus.BAD_REQUEST);

        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        MarketUser result = service.save(user);
        return ResponseEntity.ok(result);
    }

    public boolean checkPasswordLength(String password){
        return  password.length()>= 4;
    }


}
