package com.example.demo.domain.Member;

import com.example.demo.domain.ShortenUrl.ShortenUrl;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Email
	@Column(name="MEMBER_ID")
	private String memberId;

	private String name;

	@OneToMany(mappedBy="member")
	private List<ShortenUrl> urls = new ArrayList<>();
}
