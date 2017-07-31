package org.dc.common.utility.csv.test;

import java.io.File;

import org.dc.common.utility.csv.CsvFileReader;
import org.dc.common.utility.csv.CsvFileWriter;
import org.junit.Test;

public class CsvFileReaderTest {

	@Test
	public void readCsvFile(){
		final String fileName = "J://DCHEMIST//CSV//test-csvfile.csv";
		File csvFile = new File(fileName);
		if(!csvFile.exists()){
			CsvFileWriter.writeCsvFile("J://DCHEMIST//CSV//test-csvfile.csv");
		}
		CsvFileReader.readCsvFile("J://DCHEMIST//CSV//test-csvfile.csv");
	}
}
