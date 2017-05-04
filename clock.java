import java.util.*;
import java.io.*;
import java.lang.*;

class Clock {

	private static Formatter f;

	public static void main(String[] args) {
		allAngles();
	}

	// write all angles to .txt file
	private static void allAngles() {

		// create file to store angles
		try {
			f = new Formatter("angles.txt");
		} catch (Exception e) {
			System.out.println("ERROR");
		}

		// for every min value up to 720 (which is 12hrs * 60min)
		for (int i = 0; i < 720; i++) {

			int h = (int) Math.floor(i / 60);	// hour value
			int m = (int) i % 60;				// minute value

			float a = angle(h, m);	// get degree angle value
			float rad = rad(a);		// get radian value

			// write to file
			if (m < 10) {
				f.format("%dmin or %d:0%d ---> %.2f (deg) ----- %.3f (rad)\n", i, h, m, a, rad);		// add extra zero to format
			} else {
				f.format("%dmin or %d:%d ---> %.2f (deg) ----- %.3f (rad)\n", i, h, m, a, rad);
			}
			// System.out.println(i + "min or " + h + ":" + m + " ---> " + angle(h, m));
		}

		f.close();	// close file
	}

	// return angle based on hour and minute
	private static float angle(int h, int m) {
		return 180.0f - Math.abs( (float) Math.abs( (float) ((60 * h) - (11 * m)) / 2) - 180.0f);
	}

	// convert degrees to radians
	private static float rad(float deg) {
		return deg * (float) (Math.PI / 180.0f);
	}
}