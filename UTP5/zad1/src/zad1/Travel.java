package zad1;


import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class Travel {
	

	Locale locale;
	String country;
	Date fDate;
	Date toDate;
	String location;
	Float price;
	Currency currency;


	Travel(String[] elements) throws ParseException
	{
		locale = new Locale(elements[0].substring(0, 2), elements[0].substring(elements[0].length() - 2));
		country = countryConverter(elements[1], locale, Locale.ENGLISH);
		fDate = new SimpleDateFormat("yyyy-MM-dd").parse(elements[2]);
		toDate = new SimpleDateFormat("yyyy-MM-dd").parse(elements[3]);
		location = fromString(elements[4]);
		price = NumberFormat.getInstance(locale).parse(elements[5]).floatValue();
		currency = Currency.getInstance(elements[6]);
	}
	
	public String toString(String locale, String dateFormat)
	{
		Locale newLocale = new Locale(locale.substring(0, 2), locale.substring(locale.length() - 2));
		SimpleDateFormat date = new SimpleDateFormat(dateFormat);
		return getCountry(newLocale) + " " +
			getfDate(date) + " " +
			gettoDate(date) + " " +
			getLocation(newLocale) + " " +
			getPrice(newLocale) + " " +
			getCurrency();
	}

	String countryConverter(String country, Locale lFrom, Locale lTo)
	{
		for(Locale locale : Locale.getAvailableLocales())
		{
			if(locale.getDisplayCountry(lFrom).equals(country)) 
				return locale.getDisplayCountry(lTo);
		}
		return "";
	}
	
	String fromString(String location)
	{
		ResourceBundle lBundle = ResourceBundle.getBundle("zad1.LocationsBundle", locale);
		Enumeration<String> keys = lBundle.getKeys();
		while(keys.hasMoreElements())
		{
			String tag = keys.nextElement();
			if(location.equals(lBundle.getString(tag))) 
				return tag;
		}
		return null;
	}

	Object[] toArray() {
        return new Object[]{locale, country, fDate, toDate, location, price, currency};
    }
	
	String getCountry(Locale locale)
	{
		return this.country;
	}

	String getfDate(SimpleDateFormat dateFormat)
	{
		return dateFormat.format(fDate);
	}

	String gettoDate(SimpleDateFormat dateFormat)
	{
		return dateFormat.format(toDate);
	}

	String getLocation(Locale locale)
	{
		ResourceBundle bl= ResourceBundle.getBundle("zad1.LocationsBundle", locale);
		return bl.getString(location);
	}

	String getPrice(Locale locale)
	{
		return NumberFormat.getInstance(locale).format(price);
	}

	String getCurrency()
	{
		return currency.toString();
	}

}