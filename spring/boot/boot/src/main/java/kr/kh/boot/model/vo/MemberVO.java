package kr.kh.boot.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
    private String me_id;
    private String me_pw ;
    private String me_email;
    private String me_authority;
    private String me_cookie;
	private String me_limit;
	Date date = new Date();
}
