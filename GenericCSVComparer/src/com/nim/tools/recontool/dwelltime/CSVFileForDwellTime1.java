package com.nim.tools.recontool.dwelltime;

import java.util.ArrayList;

import com.nim.tools.recontool.generic.GenericCSVFile;
import com.nim.tools.recontool.generic.IColumnHeader;

public class CSVFileForDwellTime1 extends GenericCSVFile {

	public CSVFileForDwellTime1(String filePath) throws Exception {
		super(filePath);
	}

	@Override
	public File1ColumnDwellTime[] getColumns() {
		return File1ColumnDwellTime.values();
	}

}
