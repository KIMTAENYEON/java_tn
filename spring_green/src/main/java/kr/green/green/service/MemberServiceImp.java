package kr.green.green.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	@Autowired
	private JavaMailSender mailSender;

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

	@Override
	public String findPw(MemberVO member) {
		if(member == null)
			return "false";
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user == null)
			return "false";
		String newPw = createRandomPw(6);
		String encPw = passwordEncoder.encode(newPw);
		user.setMe_pw(encPw);
		memberDao.updateMember(user);
		
		String setfrom = "k9313308@gmail.com";     // 보내는 사람 이메일    
    String tomail  = member.getMe_email();     // 받는 사람 이메일
    String title   = "새 비밀번호 입니다.";      // 제목
    String content = "새 비밀번호는 " + newPw + "입니다.";    // 내용

    try {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper 
            = new MimeMessageHelper(message, true, "UTF-8");

        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
        messageHelper.setTo(tomail);     // 받는사람 이메일
        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
        messageHelper.setText(content);  // 메일 내용

        mailSender.send(message);
    } catch(Exception e){
        System.out.println(e);
        return "error";
    }
    
		return "true";
	}
	private String createRandomPw(int maxSize){
		String pw = "";
		for(int i = 0; i < maxSize; i++) {
			int max = 61, min = 0;
			int r = (int)(Math.random() * (max - min +1) +min);
			if(0 <= r && r <= 9) {
				pw += (char)('0' + r);
			}else if(r <= 35) {
				pw += (char)('a' + (r - 10));
			//랜덤 수가 36~61이면 문자 A~Z
			}else if(r <= 61) {
				pw += (char)('A' + (r - 36));
			}
		}
		return pw;
	}
}
