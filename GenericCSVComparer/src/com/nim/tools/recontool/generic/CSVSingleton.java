package com.nim.tools.recontool.generic;

import com.nim.tools.recontool.dwelltime.CSVFileForDwellTime1;
import com.nim.tools.recontool.dwelltime.CSVFileForDwellTime2;

public class CSVSingleton {
	
	public static GenericCSVFile file1;
	public static GenericCSVFile file2;

	private CSVSingleton() {}

	public static void tryToReadBothFiles(String filePath1, String filePath2) throws Exception {

		file1 = new CSVFileForDwellTime1(filePath1);
		file2 = new CSVFileForDwellTime2(filePath2);
	}

}
