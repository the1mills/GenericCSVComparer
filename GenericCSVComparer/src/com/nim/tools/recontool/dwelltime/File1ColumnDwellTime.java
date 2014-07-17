package com.nim.tools.recontool.dwelltime;


import com.nim.tools.recontool.generic.IColumnHeader;

public enum File1ColumnDwellTime implements IColumnHeader{
	
	DWELL_TIME{

		@Override
		public String getHeaderName() {
			return "Dwell Time";
		}

		@Override
		public String findColumnValueFromHeaderValue(String parseFrom) {
			return parseFrom;
		}
		
	},
	
	TRANSACTION_ID{

		@Override
		public String getHeaderName() {
			return "External ID";
		}

		@Override
		public String findColumnValueFromHeaderValue(String parseFrom) {
			String[] split = parseFrom.split("-");
			return split[split.length - 3];
		}
		
	},
	
	USER_ID{

		@Override
		public String getHeaderName() {
			return "External ID";
		}

		@Override
		public String findColumnValueFromHeaderValue(String parseFrom) {
			String[] split = parseFrom.split("-");
			return split[split.length - 4];
		}
		
	},
	
	
	TITLE_ID{

		@Override
		public String getHeaderName() {
			return "External ID";
		}

		@Override
		public String findColumnValueFromHeaderValue(String parseFrom) {
			String[] split = parseFrom.split("-");
			return split[split.length - 2];
		}
		
	};
	


}
