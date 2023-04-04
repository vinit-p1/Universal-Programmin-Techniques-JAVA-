package zad1;

import static zad1.Good.*;


public class WeightCounter implements Runnable {

	@Override
	public synchronized void run() {
		
		double weightSum=0;
		int counter = 0;
		
		for(int i= 0; i<rows(); i++) {
			weightSum= weightSum + Double.parseDouble(ObjectReader.getObject().get(i).getWeight());
			if(counter==100) {
				System.out.println("counted the weight of "+ i + " goods");
				counter=0;
			}
			counter++;
		}
	
		System.out.println("Sum of Weight is " + weightSum);
		System.out.println(fPath());
	}

	
}
