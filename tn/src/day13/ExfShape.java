package day13;
/* 도형 크기 변경, 도형 이동, 도형그리기 기능을 가진 Draw인터페이스를 만드세요.
 * */
public abstract class ExfShape implements ExfDraw {
	protected int left, right, top, bottom;
	
	@Override
	public void resize(int width, int height) {
		right = left + width;	bottom = top + height;
	}

	@Override
	public void move(int x, int y) {
		int width = right - left, height = bottom - top;
		left = x;				top = y;
		right = x + width; 		bottom = y + height;
	}
	
	public ExfShape(int x1, int y1, int x2, int y2) {
		left 	= x1 > x2 ? x2 : x1;
		right 	= x1 > x2 ? x1 : x1;
		top 	= y1 > y2 ? y2 : y1;
		bottom 	= y1 > y2 ? y1 : y1;
	}
}
