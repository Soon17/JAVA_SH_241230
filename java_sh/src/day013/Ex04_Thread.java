package day013;


public class Ex04_Thread {

	public static void main(String[] args) {
		
		
		MyThread th1 = new MyThread();
		
		//Runable 인터페이스를 구현한 구현클래스 이용
		Thread th2 = new Thread(new MyThread2());
		
		//Runable 인터페이스를 구현한 익명클래스를 이용(람다식)
		Thread th3 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				System.out.print("*");
			}
		});
		
		th1.start();
		th2.start();
		th3.start();
		
		for (int i = 0; i < 10000; i++) {
			System.out.print("|");
		}
	}

}

class MyThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.print("-");
		}
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.print("+");
		}
	}
}