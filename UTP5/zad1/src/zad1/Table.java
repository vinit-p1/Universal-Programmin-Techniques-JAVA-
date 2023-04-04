package zad1;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class Table extends AbstractTableModel{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] cName = {
			"country",
			"fDate",
			"toDate",
			"place",
			"price",
			"currency"
	};
		Locale locale;
		SimpleDateFormat dateFormat;
		ArrayList<Travel> data;
		ArrayList<TableModelListener> tmListener = new ArrayList<>();

		Table(Locale locale,SimpleDateFormat dateFormat, ArrayList<Travel> offers)
		{
			this.locale = locale;
			this.dateFormat = dateFormat;
			data = offers;
		}

		void setLocale(Locale locale)
		{
			this.locale = locale;
			for(TableModelListener listener : tmListener) 
				listener.tableChanged(new TableModelEvent(this, TableModelEvent.HEADER_ROW));
		}

		@Override
		public int getRowCount()
		{
			return data.size();
		}

		@Override
		public int getColumnCount()
		{
			return cName.length;
		}

		@Override
		public String getColumnName(int i)
		{
			final String[] columnName = {"country", "fdate", "todate", "location", "price", "currency"};
			return ResourceBundle.getBundle("zad1.HeadersBundle", locale).getString(columnName[i]);
		}

		@Override
		public void addTableModelListener(TableModelListener tableModelListener)
		{
			tmListener.add(tableModelListener);
		}

		@Override
		public void removeTableModelListener(TableModelListener tableModelListener)
		{
			tmListener.remove(tableModelListener);
		}
	
		@Override
		public Object getValueAt(int row, int column)
		{	
			Travel offer = data.get(row);
			
			String names= cName[column];
			switch(names)
			{
				case "country": return offer.getCountry(locale);
				case "fDate": return offer.getfDate(dateFormat);
				case "toDate": return offer.gettoDate(dateFormat);
				case "place": return offer.getLocation(locale);
				case "price": return offer.getPrice(locale);
				case "currency": return offer.getCurrency();
			}
			return "";
		}

	

	
	}


