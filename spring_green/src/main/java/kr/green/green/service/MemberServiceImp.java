package kr.green.green.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import kr.green.green.dao.MemberDAO;
import kr.green.green.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	@Autowired
    MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public MemberVO login(MemberVO user) {
		if(user == null || user.getMe_id() == null || user.getMe_id().trim().length() == 0)
			return null;
		MemberVO dbUser = memberDao.selectMember(user.getMe_id());
		if(dbUser == null)
			return null;
		if(!passwordEncoder.matches(user.getMe_pw(), dbUser.getMe_pw()))
			return null;
		return dbUser;
	}

	@Override
	public boolean signup(MemberVO user) {
		//회원가입 안되는 경우 확인해서 회원가입 진행 
		if(user == null) 
			return false;
		//아이디 가능한지 확인 
		if(user.getMe_id() == null || user.getMe_id().trim().length() == 0)
			return false;
		//아이디 중복체크
		if(memberDao.selectMember(user.getMe_id()) != null) 
			return false;
		//비밀번호 가능한지 확인 
		if(user.getMe_pw() == null || user.getMe_pw().trim().length() == 0)
			return false;
		//성별 가능한지 확인 
		
		//가능하다면 회원가입을 진행 
		//비밀번호 암호화
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		memberDao.insertMember(user);
		return true;
	}

	@Override
	public String idCheck(String id) {
		if(id == null || id.trim().length() == 0)
			return "false";
		MemberVO dbUser = memberDao.selectMember(id);
		if(dbUser == null)
			return "true";
		else
			return "false";
	}

	@Override
	public MemberVO updateMember(MemberVO input, MemberVO user) {
		if(input == null || user == null)
			return null;
		if(input.getMe_name() == null || input.getMe_birth() == null || input.getMe_gender() == null)
			return null;
		input.setMe_id(user.getMe_id());
		input.setMe_authority(user.getMe_authority());
		if(input.getMe_pw() == null || input.getMe_pw().length() == 0) {
			input.setMe_pw(user.getMe_pw());
		}else {
			String encPw = passwordEncoder.encode(input.getMe_pw());
			input.setMe_pw(encPw);
		}
		if(input.getMe_address() == null || input.getMe_address().length() == 0) {
			input.setMe_address(user.getMe_address());
		}
		memberDao.updateMember(input);
		return input;
	}

	@Override
	public String findId(MemberVO member) {
		if(member == null)
			return "";
		return memberDao.findId(member);
	}
}
