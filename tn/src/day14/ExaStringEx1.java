package day14;

public class ExaStringEx1 {

	public static void main(String[] args) {
		/* 5명의 이름을 배열에 저장하고, 성이 홍씨인 사람을 검색하는 코드를 작성하세요
		 * 홍이라는 글자로 시작하는지?		startsWidth
		 * 홍이라는 글자가 0번지에 있는지?	indexOf
		 * 홍이라는 글자가 있는지? x		contains
		 * */
		String str = "홍길동, 임꺽정, 김연홍, 김철수, 홍영희";
		String [] name = str.split(", ") ;
		
		//startsWidth
		for(String tmp : name) {
			if(tmp.startsWith("홍")) {
				System.out.println(tmp + "은 홍씨입니다.");
			}else {
				System.out.println(tmp + "은 홍씨가 아닙니다.");
			}
		}
		System.out.println("-------------");
		//indexOf
		for(String tmp : name) {
			if(tmp.indexOf("홍") == 0) {
				System.out.println(tmp + "은 홍씨입니다.");
			}else {
				System.out.println(tmp + "은 홍씨가 아닙니다.");
			}
		}

	}

}
