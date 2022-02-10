package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.dao.MemberDAO;
import kr.green.green.vo.MemberVO;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public List<MemberVO> getMemberList() {		
		return memberDao.selectMemberList();
	}

	@Override
	public boolean changeAuthority(MemberVO member, MemberVO user) {
		if(member == null || user == null)
			return false;
		if(!user.getMe_authority().equals("슈퍼 관리자"))
			return false;
		//바꾸려는 권한이 슈퍼 관리자인 경우
		if(member.getMe_authority().equals("슈퍼 관리자"))
			return false;
		//아이디와 일치하는 회원 정보를 가져옴 
		MemberVO dbUser = memberDao.selectMember(member.getMe_id());
		//해당 회원의 권한이 슈퍼 관리자인지 아닌지 확인 	
		//슈퍼관리자라면 false를 리턴
		if(dbUser == null || dbUser.getMe_authority().equals("슈퍼 관리자"))
			return false;
		dbUser.setMe_authority(member.getMe_authority());
		memberDao.updateMember(dbUser);
		return true;
	}
}