package org.juice_project.config.auth;

import org.juice_project.domain.EmployeeVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class SpringSecPrincipalDetails implements UserDetails {
    private EmployeeVO employeeVO;

    private Map<String, Object> attrs;

    public SpringSecPrincipalDetails(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(() -> {
           return employeeVO.getRole();
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return employeeVO.getPassword();
    }

    @Override
    public String getUsername() {
        return String.valueOf(employeeVO.getEmpId());
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
}
