package day14;

public class ExaStringEx3 {

	public static void main(String[] args) {
		/* 확장자를 포함한 파일명을 5개 배열에 저장하고, 저장된 파일에 이미지 파일이 있는지 확인하는 코드를 작성하세요
		 * 이미지파일 확장자 : jpg, bmp, gif, png
		 * */
		String str = "a.jpg, b.bmp, c.gif, d.png, e.exe";
		String str2 = "jpg, bmp, gif, png";
		String []file = str.split(", ");
		String []imageFile = str2.split(", ");
		
		for(String tmp : file) {
			boolean isImg = false;
			for(String tmp2 : imageFile) {
				if(tmp.endsWith(tmp2)) {
					System.out.println(tmp + "은 이미지입니다.");
					isImg = true;
					break;
				}
			}
			if(!isImg) {
				System.out.println(tmp + "은 이미지가 아닙니다.");
			}
		}
		System.out.println("----------------");
		//메소드 이용
		for(String fileName : file) {
			if(checkSuffix(imageFile, fileName)) {
				System.out.println(fileName + "은 이미지입니다.");
			}else {
				System.out.println(fileName + "은 이미지가 아닙니다.");
			}
		}
		
	}
	/* 확장자들과 파일명이 주어지면, 해당 파일이 확장자에 맞는지 알려주는 메소드
	 * 매개변수 : 확장자들, 파일명 => String[]suffixArray, String fillName
	 * 리턴타입 : 확장자에 맞는 파일명인지 아닌지 => boolean
	 * 매소드명 : checkSuffix
	 * */
	public static boolean checkSuffix(String[]suffixArray, String fileName) {
		for(String suffix : suffixArray) {
			if(fileName.endsWith(suffix)) {
				return true;
			}
		}
		
		return false;
	}

}
