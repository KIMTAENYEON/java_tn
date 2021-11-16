package day15;

public class ExdData <T extends Number>{
	T data;
	public void print() {
		System.out.println(data.getClass().getName() + " : " + data);
	}
	public  ExdData(T data) {
		this.data = data;
	}
	public T getDate() {
		return data;
	}
	public void setDate(T date) {
		this.data = date;
	}
	public void test(ExdData<?> data) {
		System.out.println(data);
	}

}

