package com.nim.tools.recontool.generic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nim.tools.recontool.dwelltime.File1ColumnDwellTime;
import com.nim.tools.recontool.dwelltime.File2ColumnDwellTime;

public abstract class CompareSingleColumns extends CompareColumns {

	public CompareSingleColumns(GenericCSVFile file1, GenericCSVFile file2) {
		super(file1, file2);
	}

	public void compareDistinctLists(File1ColumnDwellTime file1column,
			File2ColumnDwellTime file2column) {

	}

	public void compareDistinctCount(File1ColumnDwellTime file1column,
			File2ColumnDwellTime file2column) {

	}

	public void compareColumnSums(File1ColumnDwellTime file1column,
			File2ColumnDwellTime file2column) {

		this.getFile1().getNewReaderWithNewHeader();
		this.getFile2().getNewReaderWithNewHeader();

		List<String[]> ls1 = null;
		List<String[]> ls2 = null;
		try {
			ls1 = this.getFile1().getCsvReader().readAll();
			ls2 = this.getFile2().getCsvReader().readAll();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Integer columnNumberFile1 = this.getFile1().findColumnNumber(
				file1column);
		Integer columnNumberFile2 = this.getFile2().findColumnNumber(
				file2column);

		if (columnNumberFile1 == null || columnNumberFile2 == null) {
			try {
				throw new ReconToolException(true,
						"Can't find column number. Likely that there are unexpected headers in the CSV files. Check your CSV configuration enum .java files to see if they match the actual input CSV files.");
			} catch (ReconToolException e) {
				e.printStackTrace();
				if(e.isFatal()){
					System.exit(0);
				}
			}
		}

		Integer sum1 = 0;
		Integer sum2 = 0;

		for (String[] list : ls1) {
			String num = file1column
					.findColumnValueFromHeaderValue(list[columnNumberFile1]);
			sum1 += Integer.parseInt(num);
		}
		System.out.println("Sum for column \"" + file1column + "\" (column #"
				+ columnNumberFile1 + ") is " + sum1);

		for (String[] list : ls2) {
			String num = file2column
					.findColumnValueFromHeaderValue(list[columnNumberFile2]);
			sum2 += Integer.parseInt(num);
		}
		System.out.println("Sum for column \"" + file2column + "\" (column #"
				+ columnNumberFile2 + ") is " + sum2);

	}

}
