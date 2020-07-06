package com.auth0.brasilprev.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
	
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public ApplicationUser signUp(ApplicationUser user) throws Exception {
    	
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return applicationUserRepository.save(user);
    }

}
