package com.nim.tools.recontool.generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.nim.tools.recontool.opencsv.CSVReader;
import com.nim.tools.recontool.opencsv.CSVWriter;

public abstract class GenericCSVFile {

	private String filePath;
	private File csvFile;
	private FileReader fileReader;
	private String[] header;
	private IColumnHeader[] columns;
	private CSVReader csvReader;
	private CSVWriter csvWriter;

	// in the case that there are multiple columns per header value, currently not used
	private HashMap<String, ArrayList<String>> headerValuesMappedToColumns = new HashMap<String, ArrayList<String>>();
	// in the case that there are multiple header values per column value, currently not used
	private HashMap<String, ArrayList<String>> columnsMappedToHeaderValues = new HashMap<String, ArrayList<String>>();

	public GenericCSVFile(String filePath) throws ReconToolException{
		this.filePath = filePath;
		try {
			fileReader = new FileReader(filePath);
			csvReader = new CSVReader(
					fileReader);
			header = getActualHeaderNames();
		} catch (FileNotFoundException e) {
			//System.out.println("Could not read file with name: " + filePath);
			throw new ReconToolException(false,"Could not read file with name: " + filePath);
			// e.printStackTrace();
		}
	}

	public abstract IColumnHeader[] getColumns();

	protected void addToColumnHeaderPair(String key, String value) {
		if (columnsMappedToHeaderValues.get(key) == null) {
			columnsMappedToHeaderValues.put(key, new ArrayList<String>());
		}
		columnsMappedToHeaderValues.get(key).add(value);
	}

	protected void addToHeaderColumnPair(String key, String value) {
		if (headerValuesMappedToColumns.get(key) == null) {
			headerValuesMappedToColumns.put(key, new ArrayList<String>());
		}
		headerValuesMappedToColumns.get(key).add(value);
	}

	public void getNewReaderWithNewHeader() {
		try {
			fileReader = new FileReader(filePath);
			csvReader = new com.nim.tools.recontool.opencsv.CSVReader(
					fileReader);
			header = getActualHeaderNames();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected String[] getActualHeaderNames() {
		String[] allElements = null;
		try {
			allElements = csvReader.readNext();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return allElements;
	}

	public Integer findColumnNumber(IColumnHeader columnName) {
		int i = 0;
		for (String s : header) {
			if (s.equalsIgnoreCase(columnName.getHeaderName())) {
				return i;
			}
			i++;
		}
		return null;
	}

	public Integer findColumnNumber(String columnName) {
		int i = 0;
		for (String s : header) {
			if (s.equalsIgnoreCase(columnName)) {
				return i;
			}
			i++;
		}
		return null;
	}

	public HashMap<String, ArrayList<String>> getHeadersMappedToColumns() {
		return headerValuesMappedToColumns;
	}

	public void setHeadersMappedToColumns(
			HashMap<String, ArrayList<String>> headersMappedToColumns) {
		this.headerValuesMappedToColumns = headersMappedToColumns;
	}

	public HashMap<String, ArrayList<String>> getColumnsMappedToHeaders() {
		return columnsMappedToHeaderValues;
	}

	public void setColumnsMappedToHeaders(
			HashMap<String, ArrayList<String>> columnsMappedToHeaders) {
		this.columnsMappedToHeaderValues = columnsMappedToHeaders;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public File getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(File csvFile) {
		this.csvFile = csvFile;
	}

	public FileReader getFileReader() {
		return fileReader;
	}

	public void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public CSVReader getCsvReader() {
		return csvReader;
	}

	public void setCsvReader(CSVReader csvReader) {
		this.csvReader = csvReader;
	}

	public CSVWriter getCsvWriter() {
		return csvWriter;
	}

	public void setCsvWriter(CSVWriter csvWriter) {
		this.csvWriter = csvWriter;
	}

	public String[] getHeader() {
		return header;
	}

	public void setHeader(String[] header) {
		this.header = header;
	}

}
