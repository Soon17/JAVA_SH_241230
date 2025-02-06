package TeamProject;

import java.io.ObjectOutputStream;

import lombok.Data;

@Data
public class Room {
	
	private int roomNum;
	
	private ObjectOutputStream oos1;
	private ObjectOutputStream oos2;
	
	private OmokProgram omok;
	
	public Room(int roomNum, ObjectOutputStream oos1) {
		this.roomNum = roomNum;
		this.oos1 = oos1;
	}
	
	public void runOmok(ObjectOutputStream oos1, ObjectOutputStream oos2) {
		
//		omok = new OmokProgram(oos1, oos2);
//		omok.run();
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
}