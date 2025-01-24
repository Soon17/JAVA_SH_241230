package TeamProject;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stone {
	private int x, y;

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
