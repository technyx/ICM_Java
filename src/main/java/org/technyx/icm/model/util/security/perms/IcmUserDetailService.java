package org.technyx.icm.model.util.security.perms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.technyx.icm.model.entity.User;
import org.technyx.icm.model.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class IcmUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Details not found for the user " + username);
        } else {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(String.valueOf(user.getRole())));
            return new org.springframework.security.core.userdetails.User(user.getUsername()
                    , user.getPassword()
                    , authorities);
        }
    }
}
