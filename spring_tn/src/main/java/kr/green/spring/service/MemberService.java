package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO member);

	MemberVO signup(MemberVO member);

}