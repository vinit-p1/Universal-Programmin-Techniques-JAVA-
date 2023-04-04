package zad1;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final Locale[] locales = {
			new Locale("pl", "PL"),
			new Locale("en", "GB")};
	
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Table tableModel;
		JPanel langPanel= new JPanel();
		JLabel localeLabel = new JLabel();
		JComboBox<Locale> localeBox = new JComboBox<>(locales);
		JTable dataTable = new JTable();
		
	GUI(ArrayList<Travel> data)
	{		
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		langPanel.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		setTitle("Travel Data");
		langPanel.add(localeLabel, BorderLayout.WEST);
		langPanel.add(localeBox, BorderLayout.CENTER);
		this.getContentPane().add(langPanel, "North");
		add(new JScrollPane(dataTable), BorderLayout.CENTER);
		

		tableModel = new Table(getSelectedLocale(),dateFormat, data);
		dataTable.setModel(tableModel);

		localeLabel.setText(ResourceBundle.getBundle("zad1.HeadersBundle", getSelectedLocale()).getString("locale"));
		localeBox.addActionListener(e -> {
				tableModel.setLocale(getSelectedLocale());
				localeLabel.setText(ResourceBundle.getBundle("zad1.HeadersBundle", getSelectedLocale()).getString("locale"));});


		pack();
		setVisible(true);
	}

	Locale getSelectedLocale()
	{
		return (Locale) localeBox.getSelectedItem();
	}
	
	

}
