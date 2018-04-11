import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DevEnvironment {

	public static void main(String[] args) throws Exception {
		System.out.println("Main starting");
		DevEnvironment app = new DevEnvironment();
		
		//app.executeCommand("notepad.exe", false);
		
		app.executeCommand("ping google.com", true);
		
		//http://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
		//opens the page with the default browser
		app.executeCommand("rundll32 url.dll,FileProtocolHandler \"C:\\Users\\Mason\\eclipse-workspace\\DevEnviro\\src\\HTMLOutput.html\"", false); 
		
		//Compile a java application
		app.executeCommand("\"C:\\Program Files\\Java\\jdk1.8.0_121\\bin\\javac.exe\" -d \"C:\\Users\\Mason\\eclipse-workspace\\DevEnviro\\classes\" \"C:\\Users\\Mason\\eclipse-workspace\\DevEnviro\\src\\SimpleConsoleApp.java\"", true);
		app.executeCommand("\"C:\\Program Files\\Java\\jdk1.8.0_121\\bin\\java\" -classpath \"C:\\Users\\Mason\\eclipse-workspace\\DevEnviro\\classes\" SimpleConsoleApp", true);
		
		System.out.println("Main done");
	}

	private void executeCommand(String command, boolean wait) throws Exception {
		//Source: http://stackoverflow.com/questions/4842684/how-to-compile-run-java-program-in-another-java-program
		System.out.println(command);
		Process pro = Runtime.getRuntime().exec(command);
		if (wait)
		{
			printLines(command + " stdout:", pro.getInputStream());
			printLines(command + " stderr:", pro.getErrorStream());
			pro.waitFor();
			System.out.println(command + " exitValue() " + pro.exitValue());
		}
	}

	private static void printLines(String name, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(name + " " + line);
		}
	}

}
