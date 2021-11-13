package test1;

public class Rect extends Shape {

	public Rect(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	@Override
	public void check() {
		System.out.println("----사각형----");
		System.out.println("좌상점 : " + getLeft() + "," + getTop());
		System.out.println("우하점 : " + getRight() + "," + getBottom());
		System.out.println("가로 : " + (getRight() - getLeft()));
		System.out.println("세로 : " + (getBottom() - getTop()));
	}
	
}
