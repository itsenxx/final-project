package org.juice_project.config.auth;

import org.juice_project.domain.EmployeeVO;
import org.juice_project.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringSecPrincipalDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeVO employeeVO = employeeMapper.selectByUserName(username);
        if (employeeVO == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new SpringSecPrincipalDetails(employeeVO);
    }
}
