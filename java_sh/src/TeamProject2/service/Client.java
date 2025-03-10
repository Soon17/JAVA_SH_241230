package TeamProject2.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

import TeamProject2.mode.vo.Chat;

/*
 * Client 클래스를 이용하여
 * 서버와 클라이언트가 문자열을 주고받는 예제
 */

public class Client {

	private String id;
	private Socket s;
	private final static String EXIT = "q";
	private Scanner sc = new Scanner(System.in);
	
	public Client(String id, Socket s) {
		this.id = id;
		this.s = s;
	}

	public void connection() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			int menu = 0;
			do {
				printMenu();
				
				try{
					menu = sc.nextInt();
					sc.nextLine();
				} catch(InputMismatchException e) {
					System.out.println("[입력이 올바르지 않습니다]");
					sc.nextLine();
					continue;
				}
				
				oos.writeInt(menu);
				oos.flush();
				
				runMenu(menu, ois, oos);
				
			}while(menu != 4);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch (menu) {
		case 1:
			chat(oos, ois);
			break;
		case 2:
			makeRoom(oos, ois);
			break;
		case 3:
			enterRoom(oos, ois);
			break;
		case 4:
			
			break;

		default:
			break;
		}
	}

	private void enterRoom(ObjectOutputStream oos, ObjectInputStream ois) {
		// TODO Auto-generated method stub
		try {
			while(true) {
				System.out.print("입장할 방의 번호를 입력하세요: ");
				int roomNum;
				try{
					roomNum = sc.nextInt();
					sc.nextLine();
				} catch(InputMismatchException e) {
					System.out.println("[입력이 올바르지 않습니다]");
					sc.nextLine();
					continue;
				}
				oos.writeInt(roomNum);	
				oos.flush();
				
				if(ois.readBoolean()) {
					//입장 공지 수령
					System.out.println(ois.readUTF());
					//시작 공지 수령
					System.out.println(ois.readUTF());
					//첫 필드 수령
					System.out.println(ois.readUTF());
					boolean blackWin;
					boolean myWin;
					while(true) {
						String blackTurn = ois.readUTF();
						System.out.println(blackTurn);
						String blackstone = ois.readUTF();
						System.out.println(blackstone);
						blackWin = ois.readBoolean();
						oos.writeBoolean(blackWin);
						oos.flush();
						if(blackWin) break;
						
						while(true) {
							System.out.print("좌표 입력:");
							int x = 0, y = 0;
							try {
								x = sc.nextInt();
								y = sc.nextInt();
								sc.nextLine();
							} catch(InputMismatchException e) {
								System.out.println("[입력이 올바르지 않습니다]");
								sc.nextLine();
								continue;
							}
							oos.writeInt(x);
							oos.writeInt(y);
							oos.flush();
							boolean ternEnd = ois.readBoolean();
							if(ternEnd) {
								oos.writeBoolean(ternEnd);
								oos.flush();
								break;
							}
							else {
								oos.writeBoolean(ternEnd);
								oos.flush();
								String reInput = ois.readUTF();
								System.out.println(reInput);
							}
						}
						
						String myField = ois.readUTF();
						System.out.println(myField);
						myWin = ois.readBoolean();
						if(myWin) break;
					}
					String gameOver = ois.readUTF();
					System.out.println(gameOver);
					break;
				} else {
					//입장 불가 공지 수령
					System.out.println(ois.readUTF());
					continue;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void makeRoom(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			while(true) {
				System.out.print("개설할 방의 번호를 입력하세요: ");
				int roomNum;
				try{
					roomNum = sc.nextInt();
					sc.nextLine();
				} catch(InputMismatchException e) {
					System.out.println("[입력이 올바르지 않습니다]");
					sc.nextLine();
					continue;
				}
				oos.writeInt(roomNum);	
				oos.flush();
				boolean success = ois.readBoolean();
				if(success) {
					//개설 완료 공지 수령
					System.out.println(ois.readUTF());
					boolean findOther = ois.readBoolean();
					if(findOther) {
						//상대 서버로부터 입장 공지 수령
						System.out.println(ois.readUTF());
						//상대 서버로부터 게임 시작 공지 수령
						System.out.println(ois.readUTF());
						//자신의 서버로 입장을 알림
						oos.writeBoolean(true);
						oos.flush();
						
						/*
						 * 오목 시작
						 */
						// 첫 필드 수령
						System.out.println(ois.readUTF());
						boolean whiteWin;
						boolean myWin;
						while(true) {
							
							while(true) {
								
								System.out.print("좌표 입력:");
								int x = 0, y = 0;
								try {
									x = sc.nextInt();
									y = sc.nextInt();
									sc.nextLine();
								} catch(InputMismatchException e) {
									System.out.println("[입력이 올바르지 않습니다]");
									sc.nextLine();
									continue;
								}
								oos.writeInt(x);
								oos.writeInt(y);
								oos.flush();
								boolean ternEnd = ois.readBoolean();
								if(ternEnd) {
									oos.writeBoolean(ternEnd);
									oos.flush();
									break;
								}
								else {
									oos.writeBoolean(ternEnd);
									oos.flush();
									String reInput = ois.readUTF();
									System.out.println(reInput);
								}
							}
							
							String myField = ois.readUTF();
							System.out.println(myField);
							myWin = ois.readBoolean();
							if(myWin) break;
							String whiteTurn = ois.readUTF();
							System.out.println(whiteTurn);
							String whitestone = ois.readUTF();
							System.out.println(whitestone);
							whiteWin = ois.readBoolean();
							oos.writeBoolean(whiteWin);
							oos.flush();
							if(whiteWin) break;
						}
						String gameOver = ois.readUTF();
						System.out.println(gameOver);
						
					}
					break;
				} else {
					//개설 불가 공지 수령
					System.out.println(ois.readUTF());
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void chat(ObjectOutputStream oos, ObjectInputStream ois) {
		try{
			oos.writeUTF(id);
			oos.flush();
		} catch(Exception e) {
			System.out.println("대기실 입장 중 오류 발생");
			e.printStackTrace();
		}
		sendChat(oos);
		receiveChat(ois);
	}

	private void sendChat(ObjectOutputStream oos) {
		Thread th = new Thread(()->{
			
			try {
				Thread.sleep(10);
				while(true) {
					System.out.print("채팅 입력(종료q): ");
					String chat = sc.nextLine();
					oos.writeObject(new Chat(id, chat));
					oos.flush();
					
					if(chat.equals(EXIT)) break;
				}
				
				System.out.println("[대기실을 나갑니다]");
				
			} catch (Exception e) {
				System.out.println("[송신 중 오류 발생]");
				e.printStackTrace();
			}
		});
		th.start();
	}

	private void receiveChat (ObjectInputStream ois) {
		try {
			while(true) {
				String s = ois.readUTF();
				if(s.equals(EXIT)) break;
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println("[수신 중 오류 발생]");
			e.printStackTrace();
		}
	}

	private void printMenu() {
		System.out.println("--------메뉴--------");
		System.out.println("1. 대기실 입장하기");
		System.out.println("2. 오목 게임 방 만들기");
		System.out.println("3. 오목 게임 방 들어가기");
		System.out.println("4. 종료하기");
		System.out.println("-------------------");
		System.out.print("메뉴 입력: ");
	}
}
