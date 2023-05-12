package generic_utility;

import java.util.Random;

public class Java_Utility {
/**
 * @author maity
 * this method is used to get Random number
 * @return int
 */
	public int getRandomNum(int num) {
		Random ran = new Random();
		int ranNum = ran.nextInt(num);
		return ranNum;

	}

}
