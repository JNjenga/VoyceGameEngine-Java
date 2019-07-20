package tests;

import java.util.*;

import chasis.*;
import testunits.*;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
 		while (true) {
			
			System.out.println("Enter program id to run it :");
			System.out.println("\t-1. EXIT");
			System.out.println("\t1. Window test");
			System.out.println("\t2. The triangle");
			System.out.println("\t3. Texture Test");
			System.out.println("\tID: ");
			Engine e = null;
			switch ( scanner.nextInt()) {
			case 1:
				e = new Engine("Widnow test", 1080, 720,  new WindowTest());
				e.start();
				e = null;
				break;
			case 2:
				e = new Engine("The Triangle", 1080, 720,  new TheTriangle());
				e.start();
				e = null;
				break;
			case 3:
				e = new Engine("Texture Test", 1080, 720,  new TextureTest());
				e.start();
				e = null;
				break;
			case -1:
				System.exit(0);
				scanner.close();
				break;
				
			default:
				break;
			}
		}
	}
	
}
