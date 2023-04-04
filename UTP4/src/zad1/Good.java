package zad1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.Scanner;


public class Good {

	String id, weight;
	static Path path= Paths.get(fPath());
//	Random ran= new Random();
//	double num;
//	int count=0;
//	int iid=00001;

	public Good(String id, String weight) {
		this.id = id;
		this.weight = weight;
	}
	
	public static String fPath(){
		return "..//Goods.txt";
	}
	
	 public static int rows(){
	        int rows=0;
	        try {
	            rows= (int) Files.lines(path).count();
	          } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return rows;
	    }
	public Good() throws IOException {
		
		
	}
	
//	public void fileGenerator() throws Exception {
//		File goods= new File(fPath());
//		goods.createNewFile();
//		
//		FileWriter gwrite= new FileWriter(fPath());
//		while(count!=10000) {
//			
//			num= (float) ran.nextInt(200)/10.0;
//			gwrite.write(iid+" "+ num + "\n");
//			iid++;
//			count++;
//		}
//		gwrite.close();
//	}
	
	
	
	public String getId() {
		return id;
	}

	public String getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", weight=" + weight + "]";
	}
	
	
	
}
