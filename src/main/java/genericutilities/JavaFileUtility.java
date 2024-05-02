package genericutilities;

import java.util.Random;

public class JavaFileUtility {
	public int getRandamNum(){
		Random ran=new Random();
		return ran.nextInt(100);
	}

}
