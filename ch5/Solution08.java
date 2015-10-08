package ch5;

/*Implement a function that draws a horizontal line from (x1,y) to (x2,y)*/
public class Solution08 {
	public void dradLine(byte[] screen, int width, int x1, int x2, int y) {
		int start = x1 % 8;
		int first_full_byte = x1 / 8;
		if (start != 0) {
			first_full_byte++;
		}

		int end = x2 % 8;
		int last_full_byte = x2 / 8;
		if (end != 7) {
			last_full_byte--;
		}

		// Set full byte
		for (int b = first_full_byte; b <= last_full_byte; b++) {
			screen[(width / 8) * y + b] = (byte) 0XFF;
		}

		// Create masks for start and end of line
		byte start_mask = (byte) (0XFF >> start);
		byte end_mask = (byte) ~(0XFF >> (end + 1));

		// Set start and end of line

		if ((x1 / 8) == (x2 / 8)) {
			byte mask = (byte) (start_mask & end_mask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (start != 0) {
				int byte_number = (width / 8) * y + first_full_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if (end != 7) {
				int byte_number = (width / 8) * y + last_full_byte + 1;
				screen[byte_number] |= end_mask;
			}
		}

	}
}
