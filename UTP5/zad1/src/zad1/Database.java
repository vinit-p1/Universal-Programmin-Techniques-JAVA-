package zad1;

import java.sql.*;
import java.util.ArrayList;


public class Database {
	Connection connect;
	TravelData td;
	int id=1;
	
	public Database(String url, TravelData traveldata) {
		td= traveldata;
		try {
			connect= DriverManager.getConnection(url,"root","password");
			if (connect== null)
				System.err.println("Failed to connect please try again");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);}
		
		
	}

	public void create() {
		String drop="DROP TABLE IF EXISTS traveldata";
		
		try {
			Statement st= connect.createStatement();
			st.executeUpdate(drop);
			connect.createStatement().execute("CREATE TABLE traveldata(" 
					+"ID_TRAVEL INT PRIMARY KEY NOT NULL, "
					+"COUNTRY_CODE VARCHAR(20),"
					+"COUNTRY_NAME VARCHAR(255),"
					+"FROM_DATE DATE,"
					+"TO_DATE DATE,"
					+"LOCATION VARCHAR (100),"
					+"PRICE VARCHAR (100),"
					+"CURRENCY VARCHAR(100));"
					);
			PreparedStatement ps= connect.prepareStatement("INSERT INTO traveldata VALUES(?,?,?,?,?,?,?,?)");
			for (String record : td.all)
			{
				String[] element = record.split("\\t");

				
				ps.setInt(1, id);
				id++;
				ps.setString(2, element[0]);
				ps.setString(3, element[1]);
				ps.setString(4, element[2]);
				ps.setString(5, element[3]);
				ps.setString(6, element[4]);
				ps.setString(7, element[5]);
				ps.setString(8, element[6]);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void showGui()
	{
		ArrayList<Travel> travels = new ArrayList<>();
		try
		{
			ResultSet table = connect.createStatement().executeQuery("SELECT * FROM traveldata");
			while(table.next())
			{
				String[] elements = new String[7];
				for(int i = 0; i < 7; ++i)
				{
					elements[i] = table.getString(i + 2);
				}
				travels.add(new Travel(elements));
			}
		}
		catch (SQLException e) {e.printStackTrace();}
		catch (Exception e) {e.printStackTrace();}
		new GUI(travels);
	}
}
	

	
