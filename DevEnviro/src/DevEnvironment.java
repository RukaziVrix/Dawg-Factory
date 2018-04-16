import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DevEnvironment {

	public static void main(String[] args) throws Exception {
		System.out.println("Main starting");
		DevEnvironment app = new DevEnvironment();
		
		//app.executeCommand("notepad.exe", false);
		
		app.executeCommand("ping google.com", true);
		
		//http://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
		//opens the page with the default browser
		app.executeCommand("rundll32 url.dll,FileProtocolHandler \"..\\HTMLOutput.html\"", false);

		String htmlPath = new File("src/HTMLOutput.html")
                .getAbsolutePath();
		app.executeCommand("rundll32 url.dll,FileProtocolHandler \"" + htmlPath, false); 
		
		//Compile a java application
		String consoleAppPath = new File("src/SimpleConsoleApp.java")
                .getAbsolutePath();
		app.executeCommand("C:\\Program Files\\Java\\jdk1.8.0_161\\bin\\javac.exe" 
                + consoleAppPath, true);
//		app.executeCommand("\"C:\\Program Files\\Java\\jdk1.8.0_161\\bin\\java\" -classpath \"C:\\Users\\Mason\\eclipse-workspace\\DevEnviro\\classes\" SimpleConsoleApp", true);
		
		System.out.println("Main done");
	}

	private void executeCommand(String command, boolean wait) throws Exception {
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
