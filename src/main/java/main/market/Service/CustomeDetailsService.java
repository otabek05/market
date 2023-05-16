package main.market.Service;

import main.market.Entity.MarketUser;
import main.market.Repository.repoMarketUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;
@Component
public class CustomeDetailsService implements UserDetailsService {
    private final repoMarketUser Userrepo;

    public CustomeDetailsService(repoMarketUser userrepo) {
        Userrepo = userrepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MarketUser user = Userrepo.findByLogin(username);
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return user.getRole().stream().map(role ->new  SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getLogin();
            }

            public String getName(){
                return user.getName();
            }
            public String getSurname(){
                 return user.getSurname();
            }


            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

        };
    }
}
