package algospot.WILDCARD;

public class Main {

	public static void main(String[] args) {

	}
	
	public static boolean match(String w, String s) {
		int pos = 0;
		while(pos < s.length() && pos < w.length() && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) {
			pos++;
		}
	}
}
