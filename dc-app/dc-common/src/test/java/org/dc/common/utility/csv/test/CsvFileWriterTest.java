package org.dc.common.utility.csv.test;

import org.dc.common.utility.csv.CsvFileWriter;
import org.junit.Test;

public class CsvFileWriterTest {

	@Test
	public void writeCsvFile(){
		CsvFileWriter.writeCsvFile("J://DCHEMIST//CSV//test-csvfile.csv");
	}
}
