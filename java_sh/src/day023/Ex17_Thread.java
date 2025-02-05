package day023;

public class Ex17_Thread {

	public static void main(String[] args) {
		
		/*
		 * +를 100번 출력하는 쓰레드와
		 * -를 100번 출력하는 쓰레드를 생성하여 실행하시오.
		 */
		
		Thread th1 = new MyThread();
		th1.start();
		Thread th2 = new Thread(new MyThread2());
		th2.start();
		Thread th3 = new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("+");
			}
		});
		th3.start();
	}

}

class MyThread extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("+");
		}
	}
}

class MyThread2 implements Runnable{
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("-");
		}
	}
}