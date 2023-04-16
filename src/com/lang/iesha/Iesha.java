package com.lang.iesha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset; 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List; 


public class Iesha { 
	public static void main(String[] args) throws IOException{
		if(args.length > 1) {
		 System.out.println("Usage: jlox [scripts");
		 System.exit(64);
		}else if(args.length == 1){
		  runFile(args[0]);
		} else {
	      runPrompt();
		} 
		
	}
	
	private static void runFile(String path) throws IOException{
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		run(new String(bytes, Charset.defaultCharset()));
	}
	
	private static void runPrompt( ) throws IOException{
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader  = new BufferedReader(input);
		
		for(;;) {
			System.out.print("> ");
			String line = reader.readLine();
			if(line == null) break;
			run(line);
		}
	}
	
	private static void run(String source) {
		Scanner scan = new Scanner(source);
		 List<Token> tokens = scan.scanTokens();
		
		 for(Token token: tokens) {
		 	System.out.println(token);
		 }
	}

	public static void error(int line, String string) {
		System.out.println("There is an error on line: " + line + " error: " + string);
		
	}
}
