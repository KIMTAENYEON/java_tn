package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;
@Service
public class MemberserviceImp implements MemberService{
	
	@Autowired
	MemberDAO memberDao;

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		MemberVO user = memberDao.getMember(member.getMe_id());
		System.out.println(user);
		return null;
	}

	@Override
	public MemberVO signup(MemberVO member) {
		MemberVO user = memberDao.getMember(member.getMe_id());
		if(user != null) {
			return null;
		}
		memberDao.setMember(member.getMe_id(), member.getMe_pw(), member.getMe_name(), 
				member.getMe_gender(), member.getMe_birth(), member.getMe_address(), member.getMe_phone());
		return null;
	}
	
}