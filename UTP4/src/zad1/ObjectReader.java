package zad1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static zad1.Good.*;

public class ObjectReader implements Runnable {

	static ArrayList<Good> object= new ArrayList<>();
	Good goods=null;
	
	int counter=0;
	
	@Override
	public synchronized void run() {
		
		try {

			Scanner sc= new Scanner(new File(fPath()));
			while (sc.hasNext()) {
				String[] sep= sc.nextLine().split("\\s");
				goods = new Good(sep[0],sep[1]);
				object.add(goods);
				counter++;
				if(counter==200) {
					counter=0;
					System.out.println("created "+ object.size() + " objects");
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	public static ArrayList<Good> getObject() {
		return object;
	}

}
