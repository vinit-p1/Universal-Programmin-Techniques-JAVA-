package zad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TravelData {
	 ArrayList<String> all = new ArrayList<>();
	


	@SuppressWarnings("resource")
	public TravelData(File dataDir) {
		try
		{
			
			File file= new File(dataDir.getAbsolutePath()+ "\\datafile.tsv");
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = br.readLine()) != null)
				{
					all.add(line);
				}
			
		}
		catch(Exception e) {System.out.println(e);}
	}



	public List<String> getOffersDescriptionsList(String locale, String dateFormat) {
		ArrayList<String> value = new ArrayList<>();
		for(String one : all)
		{
			try
			{
				value.add(new Travel(one.split("\t")).toString(locale, dateFormat));
			}
			catch (Exception e) {e.printStackTrace();}
		}
		return value;
	}

	
}
