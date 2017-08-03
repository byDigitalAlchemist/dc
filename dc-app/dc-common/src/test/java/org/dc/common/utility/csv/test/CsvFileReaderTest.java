package org.dc.common.utility.csv.test;

import java.io.File;

import org.dc.common.utility.csv.CsvFileReader;
import org.dc.common.utility.csv.CsvFileWriter;
import org.junit.Test;

public class CsvFileReaderTest {

	@Test
	public void readCsvFile(){
		final String fileName = "D://INTERVIEW//CSV//test-csvfile.csv";
		File csvFile = new File(fileName);
		if(!csvFile.exists()){
			CsvFileWriter.writeCsvFile("D://INTERVIEW//CSV//test-csvfile.csv");
		}
		CsvFileReader.readCsvFile("D://INTERVIEW//CSV//test-csvfile.csv");
	}
}
