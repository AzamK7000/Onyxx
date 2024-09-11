package com.onyxx.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class ClientUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role")
  private Role role;
  private Integer mobileNo;
  private String name;
  private String email;
  private String city;
  private boolean status;
  @CreationTimestamp
  private LocalDateTime createDate;
  @UpdateTimestamp
  private LocalDateTime UpdateDate;
}
