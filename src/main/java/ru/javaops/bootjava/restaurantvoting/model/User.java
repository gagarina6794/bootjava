package ru.javaops.bootjava.restaurantvoting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.util.StringUtils;
import ru.javaops.bootjava.restaurantvoting.config.SecurityConfig;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"password"})
public class User extends BaseEntity implements Serializable {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty
    @Size(max = 128)
    private String email;

    @Column(name = "first_name")
    @Size(max = 128)
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 128)
    private String lastName;

    @Column(name = "password")
    @Size(max = 256)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column(name = "details")
    private String details;

    public void setEmail(String email) {
        this.email = StringUtils.isEmpty(email) ? null : email.toLowerCase();
    }

    //    https://stackoverflow.com/questions/30260582/password-encoding-with-spring-data-rest
    public void setPassword(String rawPassword) {
        this.password = StringUtils.isEmpty(rawPassword) ? null : SecurityConfig.DELEGATING_PASSWORD_ENCODER.encode(rawPassword);
    }
}