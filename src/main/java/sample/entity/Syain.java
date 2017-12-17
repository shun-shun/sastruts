package sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="syain")
public class Syain {

    @Column(name="id") @Id @GeneratedValue public Integer id;

    @Column(name="name",nullable=false) public String name;

    @Column(name="password") public String password;

}