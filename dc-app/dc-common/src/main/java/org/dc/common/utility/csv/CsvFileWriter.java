package org.dc.common.utility.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.dc.common.model.Sandbox;

public class CsvFileWriter {

	// Delimiter used in CSV file
	private static final String NEW_LINE_SEPARATOR = "\n";

	// CSV file header
	private static final Object[] FILE_HEADER = { "id", "firstName", "lastName", "gender", "age" };

	public static void writeCsvFile(String fileName) {

		// Create new Sandboxs objects
		Sandbox sandbox1 = new Sandbox(1, "Ahmed", "Mohamed", "M", 25);
		Sandbox sandbox2 = new Sandbox(2, "Sara", "Said", "F", 23);
		Sandbox sandbox3 = new Sandbox(3, "Ali", "Hassan", "M", 24);
		Sandbox sandbox4 = new Sandbox(4, "Sama", "Karim", "F", 20);
		Sandbox sandbox5 = new Sandbox(5, "Khaled", "Mohamed", "M", 22);
		Sandbox sandbox6 = new Sandbox(6, "Ghada", "Sarhan", "F", 21);

		// Create a new list of Sandbox objects
		List<Sandbox> sandboxList = new ArrayList<Sandbox>();
		sandboxList.add(sandbox1);
		sandboxList.add(sandbox2);
		sandboxList.add(sandbox3);
		sandboxList.add(sandbox4);
		sandboxList.add(sandbox5);
		sandboxList.add(sandbox6);

		FileWriter fileWriter = null;

		CSVPrinter csvFilePrinter = null;

		// Create the CSVFormat object with "\n" as a record delimiter
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

		try {

			// initialize FileWriter object
			fileWriter = new FileWriter(fileName);

			// initialize CSVPrinter object
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

			// Create CSV file header
			csvFilePrinter.printRecord(FILE_HEADER);

			// Write a new Sandbox object list to the CSV file
			for (Sandbox sandboxItem : sandboxList) {
				List<String> sandboxDataRecord = new ArrayList();
				sandboxDataRecord.add(String.valueOf(sandboxItem.getId()));
				sandboxDataRecord.add(sandboxItem.getFirstName());
				sandboxDataRecord.add(sandboxItem.getLastName());
				sandboxDataRecord.add(sandboxItem.getGender());
				sandboxDataRecord.add(String.valueOf(sandboxItem.getAge()));
				csvFilePrinter.printRecord(sandboxDataRecord);
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
				e.printStackTrace();
			}
		}
	}
}
