package sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lyricBot")
public class Tweet {

	@Column(name="id") @Id @GeneratedValue public Integer id;

	@Column(name="lyrics",nullable=false) public String lyrics;

	@Column(name="songName",nullable=false) public String songName;

	@Column(name="artist",nullable=false) public String artist;
}
