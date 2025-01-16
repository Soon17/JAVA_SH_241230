package day013;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex05_Synchronized {

	public static void main(String[] args) {
		
		BankBook bb = new BankBook("홍길동", 0);
		Customer1 c1 = new Customer1("홍길동", bb);
		Customer1 c2 = new Customer1("홍길동 아빠", bb);
		
		c1.start();
		c2.start();
	}

}

@AllArgsConstructor
class Customer1 extends Thread {
	
	private String name;
	private BankBook bankbook;
	
	@Override
	public void run() {
		System.out.println(name + "님이 " + 10000 + "원을 ATM으로 입금중입니다.");
		bankbook.deposit(name, 10000);
	}
}

@AllArgsConstructor
class Customer2 extends Thread {
	
	private String name;
	private BankBook bankbook;
	
	@Override
	public void run() {
		System.out.println(name + "님이 " + 10000 + "원을 모바일 앱으로 입금중입니다.");
		bankbook.deposit(name, 10000);
	}
}

@Data
@AllArgsConstructor
class BankBook {
	private String name;
	private int balance;
	
	//동기화가 필요.
	public synchronized void deposit(String name, int money) {
		
		System.out.println(name + "님 입금 전 잔액: " + balance);
		balance += money;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name + " : " + money + "원 입금. 잔액 : " + balance);
	}
}