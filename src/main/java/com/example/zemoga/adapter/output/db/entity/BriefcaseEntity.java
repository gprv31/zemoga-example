package com.example.zemoga.adapter.output.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "briefcase")
public class BriefcaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "path_image")
  private String pathImage;

  @Column(name = "description")
  private String description;

  @Column(name = "user_twitter")
  private String userTwitter;
}
