package day14;

public class ExaStringEx2 {

	public static void main(String[] args) {
		/* 5명의 이름을 저장하고, 저장된 이름중 홍길동이 있는지 확인하세요.
		 * */
		String str = "홍길동, 임꺽정, 홍길동이, 김홍길동, 홍영희";
		String [] name = str.split(", ") ;
		//indexOf 	: 이용 가능하나 추가 작업이 필요
		//contains 	: 이용 가능하나 추가 작업이 필요
		//startsWith, endsWith : 이용 가능하나 추가 작업이 필요
		//equals : 이용 가능
		//equals 
		int count = 0;
		String search = "홍길동";
		for(String tmp : name) {
			if(tmp.equals(search)) {
				count++;
			}
		}
		if(count != 0) {
			System.out.println(search + "는 " + count + "명 있습니다.");
		}else {
			System.out.println(search + "는 없습니다.");
		}
		//indexOf
		count = 0;
		search = "홍길동";
		for(String tmp : name) {
			if(tmp.indexOf(search) == 0 && tmp.length() == search.length()) {
				count++;
			}
		}
		if(count != 0) {
			System.out.println(search + "는 " + count + "명 있습니다.");
		}else {
			System.out.println(search + "는 없습니다.");
		}
		//startsWith, endsWith
		count = 0;
		search = "홍길동";
		for(String tmp : name) {
			if(tmp.startsWith(search)&& tmp.length() == search.length()) {
				count++;
			}
		}
		if(count != 0) {
			System.out.println(search + "는 " + count + "명 있습니다.");
		}else {
			System.out.println(search + "는 없습니다.");
		}
		//contains
		count = 0;
		search = "홍길동";
		for(String tmp : name) {
			if(tmp.contains(search)&& tmp.length() == search.length()) {
				count++;
			}
		}
		if(count != 0) {
			System.out.println(search + "는 " + count + "명 있습니다.");
		}else {
			System.out.println(search + "는 없습니다.");
		}

	}

}
