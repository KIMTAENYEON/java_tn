package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;
@Service
public class MemberserviceImp implements MemberService{
	
	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		MemberVO user = memberDao.getMember(member.getMe_id());
		//로그인에 성공하면 회원정보를 실패하면 null 반환 
		if(user == null)
			return null;
		//matches(원래 비번, 암호화된 비번) : 같으면(비번이 맞으면) true 다르면 false
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		return null;
	}

	@Override
	public boolean signup(MemberVO user) {
		if(user == null) 
			return false;
		if(user.getMe_id() == null)
			return false;
		if(user.getMe_pw() == null)
			return false;
		if(memberDao.getMember(user.getMe_id()) != null) 
			return false;
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		memberDao.insertMember(user);
		return true;
	}

	@Override
	public boolean idDuplicated(String id) {
		MemberVO user = memberDao.getMember(id);
		if(user == null)
			return false;
		return true;
	}
	
}