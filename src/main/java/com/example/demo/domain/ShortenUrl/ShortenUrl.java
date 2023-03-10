package com.example.demo.domain.ShortenUrl;

import com.example.demo.domain.Audit;
import com.example.demo.domain.Member.Member;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

@Getter
@Entity
public class ShortenUrl extends Audit {

    @Id @GeneratedValue
    private Long id;

    @URL
    private String destination;

    @URL
    private String newUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    private int cnt;

    @Builder
    public ShortenUrl(String destination, String newUrl){
        this.destination = destination;
        this.newUrl = newUrl;
        this.cnt = 0;
    }

    public ShortenUrl() {
    }

    public void setMember(Member member){
        this.member = member;
        member.getUrls().add(this);
    }

    public void countUp() {
        this.cnt = this.cnt + 1;
    }

};
