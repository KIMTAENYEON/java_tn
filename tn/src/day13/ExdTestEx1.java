package day13;

public class ExdTestEx1 {
	public static void main(String[] args) {
		ExdLGTvRemoteCon lgR = new ExdLGTvRemoteCon(30, 900);
		lgR.volumUp();
		lgR.powerOn();
		for(int i = 1; i <= 30; i++) {
			lgR.volumUp();
		}
		for(int i = 1; i <= 30; i++) {
			lgR.volumDown();
		}
		System.out.println(lgR.LOGO);
		lgR.changeChannel(901);
		lgR.powerOff();
	}
}
