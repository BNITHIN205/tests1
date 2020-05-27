package info.inetsolv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitabcApplication {

	private static String gitProjectProcessingLocation = "C:\\Work\\Test\\gitProcessingLocation";
	private static String localGITCloneLocation = "C:\\Users\\nithin\\Desktop\\MyGIT\\TestRepo";
	private static String java2GITBatchFile = "C:\\git_config\\gitcommands.bat";
	private static String errorLevel = "";

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("========= Inside Java2GIT Controller, Executing Script  ====");
		String[] command = { "cmd.exe", "/C", "Start", java2GITBatchFile, localGITCloneLocation, "TestProject3",
				"Initial Commit of GITHUB Project 5", errorLevel };
		Process process = Runtime.getRuntime().exec(command);
		System.out.println("======== After Java2GIT Controller, Executing Script  ====");
		BufferedReader errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		int exitVal = process.waitFor();
		System.out.println("added temp sop");
		System.out
				.println("========== Final Error Level ===" + errorLevel + "======== Exit Value is =======" + exitVal);

		System.out.println("OUTPUT");
		while ((line = inputStream.readLine()) != null)
			System.out.println(line);
		inputStream.close();
		System.out.println("ERROR");
		while ((line = errorStream.readLine()) != null)
			System.out.println(line);
		errorStream.close();
	}

}
