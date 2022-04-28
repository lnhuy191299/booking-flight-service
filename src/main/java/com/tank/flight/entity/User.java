package com.tank.flight.entity;

import com.tank.flight.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String userName;
  @Column private String passWord;
  @Column private Role role;
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Booking> booking;
}
