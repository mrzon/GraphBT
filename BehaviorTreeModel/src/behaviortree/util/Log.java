package behaviortree.util;

public class Log {
	private static boolean en = true;
	
	public static void d(String text) {
		if(en) System.out.println("(d) " + text);
	}

}
