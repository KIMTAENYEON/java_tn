package day12;

public class ExaRect extends ExaShape{
	/* 도형 클래스를 상속 받아 사각형 클래스를 만드세요.
	 * 사각형 클래스는 도형의 테두리와 일치한다
	 * */
	public ExaRect(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	@Override
	public void print() {
		System.out.println("----사각형----");
		System.out.println("좌상점 : " + getLeft() + "," + getTop());
		System.out.println("우하점 : " + getRight() + "," + getBottom());
		System.out.println("가로 : " + getWidth());
		System.out.println("세로 : " + getHeight());
	}
	public void testR() {
		System.out.println("사각형");
	}
}