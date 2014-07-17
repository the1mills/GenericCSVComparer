package com.nim.tools.recontool.dwelltime;

import com.nim.tools.recontool.generic.IColumnHeader;

public enum File2ColumnDwellTime implements IColumnHeader {

	REPORTER_USER_ID {

		@Override
		public String getHeaderName() {
			return "reporter_user_id";
		}

		@Override
		public String findColumnValueFromHeaderValue(String parseFrom) {
			return parseFrom;
		}
	},
	TRANSACTION_ID {

		@Override
		public String getHeaderName() {
			return "transaction_id";
		}

		@Override
		public String findColumnValueFromHeaderValue(String parseFrom) {
			return parseFrom;
		}
	},
	TITLE_ID {

		@Override
		public String getHeaderName() {
			return "title_id";
		}

		@Override
		public String findColumnValueFromHeaderValue(String parseFrom) {
			return parseFrom;
		}
	},
	SUM {

		@Override
		public String getHeaderName() {
			return "sum";
		}

		@Override
		public String findColumnValueFromHeaderValue(String parseFrom) {
			return parseFrom;
		}
	};

}
