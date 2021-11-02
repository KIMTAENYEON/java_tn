package day5;

public class PrintAlphabetEx2 {
	//알파벳출력(삼각형)
	public static void main(String[] args) {
		/* a
		 * ab
		 * abc
		 * abcd
		 * ...
		 * abcd...xyz
		 * */
		char ch, ch1;
		for(ch = 'a'; ch <= 'z'; ch++)
		{
			for(ch1 = 'a'; ch1 <= ch; ch1++)
			
				System.out.print(ch1);
			
				System.out.println();
		}
		
		
	}

}
