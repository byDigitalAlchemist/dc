package org.dc.common.utility.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.dc.common.model.Sandbox;

public class CsvFileReader {

	//CSV file header
    private static final String [] FILE_HEADER_MAPPING = {"id","firstName","lastName","gender","age"};
	
	//Student attributes
	private static final String STUDENT_ID = "id";
	private static final String STUDENT_FNAME = "firstName";
	private static final String STUDENT_LNAME = "lastName";
	private static final String STUDENT_GENDER = "gender"; 
	private static final String STUDENT_AGE = "age";
	
	public static void readCsvFile(String fileName) {

		FileReader fileReader = null;
		
		CSVParser csvFileParser = null;
		
		//Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
     
        try {
        	
        	//Create a new list of student to be filled by CSV file data 
        	List<Sandbox> sandboxes = new ArrayList<Sandbox>();
            
            //initialize FileReader object
            fileReader = new FileReader(fileName);
            
            //initialize CSVParser object
            csvFileParser = new CSVParser(fileReader, csvFileFormat);
            
            //Get a list of CSV file records
            List csvRecords = csvFileParser.getRecords(); 
            
            //Read the CSV file records starting from the second record to skip the header
            for (int i = 1; i < csvRecords.size(); i++) {
            	CSVRecord record = (CSVRecord) csvRecords.get(i);
            	//Create a new student object and fill his data
            	Sandbox student = new Sandbox(Long.parseLong(record.get(STUDENT_ID)), record.get(STUDENT_FNAME), record.get(STUDENT_LNAME), record.get(STUDENT_GENDER), Integer.parseInt(record.get(STUDENT_AGE)));
                sandboxes.add(student);	
			}
            
            //Print the new student list
            for (Sandbox student : sandboxes) {
				System.out.println(student.toString());
			}
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }

	}
}
