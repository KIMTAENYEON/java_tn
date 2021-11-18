package day17;

import java.util.*;

public class ExdMapIteratorEx1 {

	public static void main(String[] args) {
		/* Map에서 반복문 사용하는 예제
		 * */
		Map<String, String> map = new HashMap<String, String>();
		map.put("abx123", "123123");
		map.put("qweqwe", "qweqwe");
		map.put("zzz", "zzzzzz");
		//keySet() : 맵에서 key값들을 하나의 set으로 만들어 주는 메소드
		Set<String> set = map.keySet();
		System.out.println(set);
		//Iterator를 이용하여 반복문을 활용
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println("ID : " + key + ", PW : " + value);
		}
	}

}
