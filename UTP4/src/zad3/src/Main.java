/**
 *
 *  @author Pahilajani Vinit 
 *
 */

package zad1;

import static zad1.Good.fPath;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Main {

  public static void main(String[] args) throws Exception {
	  Random ran= new Random();
		double num;
		int count=0;
		int iid=00001;
			
			File goods= new File(fPath());
			goods.createNewFile();
			
			FileWriter gwrite= new FileWriter(fPath());
			while(count!=10000) {
				
				num= (float) ran.nextInt(200)/10.0;
				gwrite.write(iid+" "+ num + "\n");
				iid++;
				count++;
			}
			gwrite.close();
		
	  ObjectReader or= new ObjectReader();
	  WeightCounter wc= new WeightCounter();
	  
	  Thread t1 = new Thread(or);
//	  Thread.sleep(500);
	  Thread t2 = new Thread(wc);
	  
	  t1.start();
	  t2.start();
  }
}
