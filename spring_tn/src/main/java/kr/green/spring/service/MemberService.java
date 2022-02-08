package kr.green.spring.service;

import java.util.List;

import kr.green.spring.vo.MainCategoryVO;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.MiddleCategoryVO;

public interface MemberService {

	MemberVO login(MemberVO member);

	boolean signup(MemberVO member);

	boolean idDuplicated(String id);

	MemberVO updateMember(MemberVO input, MemberVO user);

	String findId(MemberVO member);

	String findPw(MemberVO member);

	void updateAutoLogin(MemberVO user);

	MemberVO selectMemberBySessionId(String value);

	List<MainCategoryVO> selectMainCategory();

	List<MiddleCategoryVO> selectMiddlesCategory(Integer mi_ma_num);

	List<MiddleCategoryVO> selectSubCategory(Integer su_mi_num);

}