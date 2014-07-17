package com.nim.tools.recontool.generic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.nim.tools.recontool.dwelltime.File1ColumnDwellTime;
import com.nim.tools.recontool.dwelltime.File2ColumnDwellTime;

public abstract class CompareMultipleColumns extends CompareColumns {

	public CompareMultipleColumns(GenericCSVFile file1, GenericCSVFile file2) {
		super(file1, file2);
	}

	public void compareMultipleColumnsForGroupBySum(
			File1ColumnDwellTime file1GroupByColumn, File1ColumnDwellTime file1CountColumn,
			File2ColumnDwellTime file2GroupByColumn, File2ColumnDwellTime file2CountColumn) {

		boolean differenceFound = false;

		HashMap<String, ArrayList<Object>> file1Hash = new HashMap<String, ArrayList<Object>>();
		HashMap<String, ArrayList<Object>> file2Hash = new HashMap<String, ArrayList<Object>>();

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
		Integer columnNumberForGroupByColumnFile1 = this.getFile1().findColumnNumber(
				file1GroupByColumn);
		Integer columnNumberForGroupByColumnFile2 = this.getFile2().findColumnNumber(
				file2GroupByColumn);
		Integer columnNumberForCountColumnFile1 = this.getFile1().findColumnNumber(
				file1CountColumn);
		Integer columnNumberForCountColumnFile2 = this.getFile2().findColumnNumber(
				file2CountColumn);
		
		if(columnNumberForGroupByColumnFile1 == null || columnNumberForGroupByColumnFile2 == null ||
				columnNumberForCountColumnFile1 == null || columnNumberForCountColumnFile2 == null ){
			 try {
				 throw new ReconToolException("Can't find column number. Likely that there are unexpected headers in the CSV files. Check your CSV configuration enum .java files to see if they match the actual input CSV files.");
			} catch (ReconToolException e) {
				e.printStackTrace();
			}
		}

		for (String[] list : ls1) {
			String groupId = file1GroupByColumn
					.findColumnValueFromHeaderValue(list[columnNumberForGroupByColumnFile1]);
			if (file1Hash.get(groupId) == null) {
				file1Hash.put(groupId, new ArrayList<Object>());
			}
			file1Hash
					.get(groupId)
					.add(file1CountColumn
							.findColumnValueFromHeaderValue(list[columnNumberForCountColumnFile1]));
		}

		for (String[] list : ls2) {
			String groupId = file2GroupByColumn
					.findColumnValueFromHeaderValue(list[columnNumberForGroupByColumnFile2]);
			if (file2Hash.get(groupId) == null) {
				file2Hash.put(groupId, new ArrayList<Object>());
			}
			file2Hash
					.get(groupId)
					.add(file2CountColumn
							.findColumnValueFromHeaderValue(list[columnNumberForCountColumnFile2]));
		}

		for (String s : file1Hash.keySet()) {
			Integer sum1 = getSumIntegerList(file1Hash.get(s));
			Integer sum2 = getSumIntegerList(file2Hash.get(s));
			if (!sum1.equals(sum2)) {
				if (!differenceFound) {
					System.out
							.println("Found at least one difference in files...printing differences...");
				}
				System.out.println("file 1: " + file1GroupByColumn + ": " + s
						+ " " + file1CountColumn + " sum: " + sum1);
				System.out.println("file 2: " + file2GroupByColumn + ": " + s
						+ " " + file2CountColumn + " sum: " + sum2);
				System.out.println("");
				differenceFound = true;
			}
		}

		for (String s : file2Hash.keySet()) {
			Integer sum1 = getSumIntegerList(file1Hash.get(s));
			Integer sum2 = getSumIntegerList(file2Hash.get(s));
			if (!sum2.equals(sum1)) {
				if (!differenceFound) {
					System.out
							.println("Found at least one difference in files...printing differences...");
				}
				System.out.println("file 1: " + file1GroupByColumn + ": " + s
						+ " " + file1CountColumn + " sum: " + sum1);
				System.out.println("file 2: " + file2GroupByColumn + ": " + s
						+ " " + file2CountColumn + " sum: " + sum2);
				System.out.println("");
				differenceFound = true;
			}
		}

		if (!differenceFound) {
			System.out.println("looks all good");
		}
	}

	protected Integer getSumIntegerList(ArrayList<Object> intList) {
		if (intList == null) {
			return null;
		}
		Integer sum = 0;
		for (Object o : intList) {
			sum += (Integer.parseInt(o.toString()));
		}
		return sum;
	}

}
