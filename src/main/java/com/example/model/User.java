package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author Michał Ciołczyk
 */
@Entity
@Table(name = "example_users")
@Data
@AllArgsConstructor
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private Boolean credentialsNonExpired = true;

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(nullable = false)
    private Boolean accountNonLocked = true;

    @Column(nullable = false)
    private Boolean accountNonExpired = true;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        final String role = "ROLE_" + getRole().toString();
        final GrantedAuthority userAuthority = new SimpleGrantedAuthority(role);
        return newArrayList(userAuthority);
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
