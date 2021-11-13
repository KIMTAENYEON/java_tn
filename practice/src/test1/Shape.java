package test1;

import java.util.Scanner;

public class Shape implements ShapeInterface{
	private int left, right, top, bottom;	//시작점 : left, top 끝점 : right, bottom
	Scanner scan = new Scanner(System.in);
	Shape [] list;
	Shape [] cancelList;	//실행취소 한 도형들
	int count ,cancelCount = 0;				//list에 있는 수 , 실행취소 한 도형 수

	public Shape(int size) {
		list = new Shape [size];
		cancelList = new Shape[size];
	}
	public Shape(int x1, int y1, int x2, int y2) {
		left 	= x1 > x2 ? x2 : x1;
		right 	= x1 > x2 ? x1 : x2;
		top 	= y1 > y2 ? y2 : y1;
		bottom 	= y1 > y2 ? y1 : y2;
	}
	
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getBottom() {
		return bottom;
	}
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	@Override
	public void draw() {	//도형 그리기
		int num = 0;
		do {
			System.out.print("그릴 도형을 선택하세요(1. 사각형, 2. 타원) : ");
			num = scan.nextInt();
			scan.nextLine();	//숫자를 하나이상 지정할때 뒤에 숫자제거하는역활
			switch(num) {
			case 1 : 
				if(count < list.length) {	
					System.out.print("점 두개를 입력하세요(예 : 1 2 3 4 => (1,2) (3,4)) : ");
					int x1 = scan.nextInt();
					int y1 = scan.nextInt();
					int x2 = scan.nextInt();
					int y2 = scan.nextInt();
					scan.nextLine();	//숫자를 더 입력할때 뒤에 숫자제거하는역활
					list[count] = new Rect(x1, y1, x2, y2);
					count++;
					System.out.println("사각형을 그렸습니다.");
				}else {
					System.out.println("도형을 더 그릴수 없습니다.");
				}
				break;
			case 2 :
				if(count < list.length) {
					System.out.print("점 두개를 입력하세요(예 : 1 2 3 4 => (1,2) (3,4)) : ");
					int x1 = scan.nextInt();
					int y1 = scan.nextInt();
					int x2 = scan.nextInt();
					int y2 = scan.nextInt();
					scan.nextLine();	//숫자를 더 입력할때 뒤에 숫자제거하는역활
					list[count] = new Ellipse(x1, y1, x2, y2);
					count++;
					System.out.println("타원을 그렸습니다.");
				}else {
					System.out.println("도형을 더 그릴수 없습니다.");
				}
				break;
			default : 
				System.out.println("번호를 잘못 입력했습니다.");
			}
		}while(num > 2 || num < 1);
	}
	@Override
	public void rewind() {	//다시실행
		if(cancelCount > 0 && count < list.length) {
			list[count] = cancelList[cancelCount-1]; 
			cancelList[cancelCount-1] = null;
			cancelCount--;
			count++;
			System.out.println("다시 실행되었습니다.");
		}else {
			System.out.println("다시 실행할 도형이없습니다.");
		}
	}
	@Override
	public void cancel() {	//실행취소
		if(count > 0 && cancelCount < cancelList.length) {
			cancelList[cancelCount] = list[count-1];
			list[count-1] = null;
			count--;
			cancelCount++;
			System.out.println("실행취소가 되었습니다.");
		}else {
			System.out.println("도형이 없습니다.");
		}
	}
	@Override
	public void check() {	//도형확인
		for(Shape tmp : list) {
			if(tmp != null) {
				if(tmp instanceof Ellipse) {
					((Ellipse) tmp).check();
				}else if(tmp instanceof Rect) {
					((Rect) tmp).check();
				}
			}
		}
	}
}
