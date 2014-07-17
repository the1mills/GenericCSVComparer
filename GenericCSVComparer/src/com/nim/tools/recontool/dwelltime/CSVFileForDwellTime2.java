package com.nim.tools.recontool.dwelltime;

import java.util.ArrayList;

import com.nim.tools.recontool.generic.GenericCSVFile;
import com.nim.tools.recontool.generic.IColumnHeader;

public class CSVFileForDwellTime2 extends GenericCSVFile {

	public CSVFileForDwellTime2(String filePath) throws Exception {
		super(filePath);
	}

	@Override
	public File2ColumnDwellTime[] getColumns() {
		return File2ColumnDwellTime.values();
	}

}
