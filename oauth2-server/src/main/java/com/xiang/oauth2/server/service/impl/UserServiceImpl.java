package com.xiang.oauth2.server.service.impl;

import com.xiang.oauth2.server.domain.user.UserAccount;
import com.xiang.oauth2.server.repository.UserAccountRepository;
import com.xiang.oauth2.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Jiangcheng Xiang
 */
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserAccountRepository userDao;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserAccount user = userDao.findByUsername(userId);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public void delete(Long id) {
        Optional<UserAccount> userAccountOptional = userDao.findById(id);

        userDao.delete(userAccountOptional.get());
    }

    public List findAll() {
        List list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public UserAccount save(UserAccount user) {
        return null;
    }
}
