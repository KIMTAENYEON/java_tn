package day13;

public interface ExdRemoteController {
	public void powerOn();
	public void powerOff();

}
interface ExdTvRemoteController extends ExdRemoteController{
	public void volumUp();
	public void volumDown();
	public void channelUp();
	public void channelDown();
	public void changeChannel(int num);
}
class ExdTvRemoteCon implements ExdTvRemoteController{
	
	private boolean power = false;	//TV전원 상태
	private int channel = 1;
	private int volum = 0;
	private final int maxChannel;
	private final int maxVolum;
	
	@Override
	public void powerOn() {
		power = true;
		System.out.println("전원이 켜졌습니다");
	}

	@Override
	public void powerOff() {
		power = false;
		System.out.println("전원이 꺼졌습니다.");	
	}

	@Override
	public void volumUp() {
		//TV가 꺼져있으면 소리 올리지 마세요.
		if(!power) {
			return;
		}
		++volum;
		volum = volum > maxVolum ? maxVolum : volum;
		System.out.println("소리 : " + volum);
	}

	@Override
	public void volumDown() {
		if(!power) {
			return;
		}
		--volum;
		volum = volum < 0 ? 0 : volum;
		System.out.println("소리 : " + volum);
	}

	@Override
	public void channelUp() {
		if(!power) {
			return;
		}
		++channel;
		channel = channel > maxChannel ? maxChannel : channel;
		System.out.println("채널 : " + channel);
	}

	@Override
	public void channelDown() {
		if(!power) {
			return;
		}
		--channel;
		channel = channel < 0 ? 0 : channel;
		System.out.println("채널 : " + channel);
	}

	@Override
	public void changeChannel(int num) {
		if(!power) {
			return;
		}
		channel = maxChannel < num ? maxChannel : num;
		System.out.println("채널 : " + channel);
	}
	public ExdTvRemoteCon(int maxVolum, int maxChannel) {
		this.maxChannel = maxChannel;
		this.maxVolum = maxVolum;
	}
}
class ExdLGTvRemoteCon extends ExdTvRemoteCon{
	public final static String LOGO = "LG";
	public ExdLGTvRemoteCon(int maxVolum, int maxChannel) {
		super(maxVolum, maxChannel);
	}
}
class ExdSamSungTvRemoteCon extends ExdTvRemoteCon{
	public final static String LOGO = "SAMSUNG";
	public ExdSamSungTvRemoteCon(int maxVolum, int maxChannel) {
		super(maxVolum, maxChannel);
	}
}