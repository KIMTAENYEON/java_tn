package kr.green.green.service;

import kr.green.green.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO user);

	boolean signup(MemberVO user);

	String idCheck(String id);

}
