package storedprocedure;
import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputClass {

	public static String getInput(String prompt){
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		out.print(prompt);
		out.flush();
		
		try{
			return stdin.readLine();
		}catch(IOException e){
			return "Error: " + e.getMessage();
		}
	}
	
	public static double getDoubleInput(String prompt) throws NumberFormatException{
		String input = getInput(prompt);
		return Double.parseDouble(input);
	}
}