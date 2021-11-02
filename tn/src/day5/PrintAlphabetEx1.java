package day5;

public class PrintAlphabetEx1 {
	//알파벳역순출력
	public static void main(String[] args) {
		/* zyx...cba가 출력되도록 코드를 작성하세요.
		 * */
		//방법1
		char ch;
		for(ch = 'z'; ch >= 'a'; ch--)
		{
			System.out.print(ch + " ");
		}
		
		System.out.println();
		//방법2
		int i;
		for(i = 0; i < 26; i++)
		{
			System.out.print((char)('z' - i) + " ");
		}

	}

}
