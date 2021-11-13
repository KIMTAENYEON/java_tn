package test1;

public class Ellipse extends Shape {

	public Ellipse(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	
	@Override
	public void check() {
		System.out.println("----타원----");
		System.out.println("좌상점 : " + getLeft() + "," + getTop());
		System.out.println("우하점 : " + getRight() + "," + getBottom());
		System.out.println("너비 : " + (getRight() - getLeft()));
		System.out.println("높이 : " + (getBottom() - getTop()));
	}

}
