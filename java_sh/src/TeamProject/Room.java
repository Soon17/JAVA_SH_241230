package TeamProject;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Room {
	
	private int roomNum;
	
	private List<ObjectOutputStream> gamers = new ArrayList<ObjectOutputStream>();
	
	private boolean full = false;
	
	private OmokProgram omok;
	
	public Room(int roomNum) {
		this.roomNum = roomNum;
	}
	
	public void runOmok(ObjectOutputStream oos1, ObjectOutputStream oos2) {
		
		omok = new OmokProgram();
		omok.run();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return roomNum == other.roomNum;
	}
	
	public void setClient(ObjectOutputStream oos) {
		gamers.add(oos);
		if(gamers.size() == 2) full = true;
	}

	@Override
	public String toString() {
		return "[" + roomNum + "번 방, 인원 " + gamers.size() + "명]";
	}
	
	
}