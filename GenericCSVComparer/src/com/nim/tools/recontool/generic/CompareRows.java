package com.nim.tools.recontool.generic;

public class CompareRows {

	protected GenericCSVFile file1;
	protected GenericCSVFile file2;
	
	public CompareRows(GenericCSVFile file1, GenericCSVFile file2) {
		this.file1 = file1;
		this.file2 = file2;
	}

	public GenericCSVFile getFile1() {
		return file1;
	}

	public void setFile1(GenericCSVFile file1) {
		this.file1 = file1;
	}

	public GenericCSVFile getFile2() {
		return file2;
	}

	public void setFile2(GenericCSVFile file2) {
		this.file2 = file2;
	}
}
