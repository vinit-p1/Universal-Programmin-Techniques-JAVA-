package zad1;

import java.util.ArrayList;

public class Letters implements Runnable{
	
	String[] alpha= new String[10]; 
	boolean isDone=false;
	public ArrayList<Thread> threads = new ArrayList<Thread>();
	
	public Letters(String str) {
		super();
		for(int i=0; i < str.length(); i++) {
			alpha[i]= str.substring(i,i+1);
			threads.add(new Thread(this, "Thread " + alpha[i]));
		}		
	}
	
	public ArrayList<Thread> getThreads() {
		// TODO Auto-generated method stub
		return threads;
	}
	
	public void run() {
		
		threads.forEach(arg -> System.out.print(arg.getName().substring(7)));
		
	}


	public void finish() {
		// TODO Auto-generated method stub
		isDone = true;
	}
}
