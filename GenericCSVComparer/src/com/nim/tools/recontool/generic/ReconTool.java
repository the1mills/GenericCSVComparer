package com.nim.tools.recontool.generic;

import java.util.ArrayList;

import com.nim.tools.recontool.dwelltime.CompareMultipleColumnsForDwellTime;
import com.nim.tools.recontool.dwelltime.CompareSingleColumnsForDwellTime;
import com.nim.tools.recontool.dwelltime.File1ColumnDwellTime;
import com.nim.tools.recontool.dwelltime.File2ColumnDwellTime;

//import org.kohsuke.args4j.CmdLineException;
//import org.kohsuke.args4j.CmdLineParser;

public class ReconTool {

	private static String FILE1_PATH; // "src/main/java/com/nim/csv/file1.csv";
	private static String FILE2_PATH; // "src/main/java/com/nim/csv/ViewingTimeAllocationsSearchResults233.csv";
	private static ArrayList<String> args = new ArrayList<String>();

	// private static ReconUtilityOptions options;
	// private static CmdLineParser parser;

	public static void main(String[] args) throws ReconToolException {

		parseCmdArgs(args); 
		// parseArguments(args);

		try {
			CSVSingleton.tryToReadBothFiles(FILE1_PATH, FILE2_PATH);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		run();

	}

	private static void run() {

		if (ReconTool.args.get(4).equalsIgnoreCase("-totaldwelltime")) {
			CompareSingleColumns csc = new CompareSingleColumnsForDwellTime(
					CSVSingleton.file1, CSVSingleton.file2);
			csc.compareColumnSums(File1ColumnDwellTime.DWELL_TIME,
					File2ColumnDwellTime.SUM);
		} else {

			CompareMultipleColumns cmc = new CompareMultipleColumnsForDwellTime(
					CSVSingleton.file1, CSVSingleton.file2);

			if (ReconTool.args.get(4)
					.equalsIgnoreCase("-dwelltimebytitleid")) {
				cmc.compareMultipleColumnsForGroupBySum(
						File1ColumnDwellTime.TITLE_ID,
						File1ColumnDwellTime.DWELL_TIME,
						File2ColumnDwellTime.TITLE_ID, File2ColumnDwellTime.SUM);
			}

			else if (ReconTool.args.get(4).equalsIgnoreCase(
					"-dwelltimebytransactionid")) {
				cmc.compareMultipleColumnsForGroupBySum(
						File1ColumnDwellTime.TRANSACTION_ID,
						File1ColumnDwellTime.DWELL_TIME,
						File2ColumnDwellTime.TRANSACTION_ID,
						File2ColumnDwellTime.SUM);

			} else if (ReconTool.args.get(4).equalsIgnoreCase(
					"-dwelltimebyuserid")) {
				cmc.compareMultipleColumnsForGroupBySum(
						File1ColumnDwellTime.USER_ID,
						File1ColumnDwellTime.DWELL_TIME,
						File2ColumnDwellTime.REPORTER_USER_ID,
						File2ColumnDwellTime.SUM);

			} else {
				printOutOptions();
				System.exit(0);
			}
		}
	}

	private static void parseCmdArgs(String[] argsIn) {

		for (String s : argsIn) {
			args.add(s);
		}
		if (args.size() < 5) {
			printOutOptions();
			System.exit(0);
		}

		FILE1_PATH = args.get(2);
		FILE2_PATH = args.get(3);
	}

	public static void printOutOptions() {
		System.out.println("Not enough arguments or a malformed option.");
		System.out
				.println("First argument is the name and extension of a CSV file with output from the NIM DB.");
		System.out
				.println("Second argument is the name and extension of a CSV file with output from the Metrics DB.");
		System.out
				.println("Third argument is an option. Available options are:");
		System.out.println("'-totaldwelltime'");
		System.out.println("'-dwelltimebytitleid'");
		System.out.println("'-dwelltimebytransactionid'");
		System.out.println("'-dwelltimebyuserid'");
		System.out
				.println("For example, './recontool <file1>.csv <file2>.csv -dwelltimebytitle'");
		// System.out.println("(Program Exited).");
	}

	// private static void parseArguments(String[] args) {
	//
	// try {
	// options = new ReconUtilityOptions();
	// parser = new CmdLineParser(options);
	// parser.parseArgument(args);
	// } catch (CmdLineException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// //
	// // Get the environment name from the command line, or from the
	// // environment if no
	// // command line option is present.
	// //
	// List<String> arguments = options.getArguments();
	//
	// // String env;
	// // env = options.getEnvName();
	// // if (env == null || env.trim().isEmpty()) {
	// // Map<String, String> envs = System.getenv();
	// // env = envs.get("nim_env");
	// // if (env == null || env.trim().isEmpty()) {
	// // try {
	// // throw options.new ArgumentException(
	// //
	// "environment must be set via nim_env environment variable or the --environment option");
	// // } catch (ArgumentException e) {
	// // // TODO Auto-generated catch block
	// // e.printStackTrace();
	// // }
	// // }
	// // }
	//
	//
	// }

	// public CmdLineParser getParser() {
	// return parser;
	// }
	//
	// public void setParser(CmdLineParser parser) {
	// ReconUtility.parser = parser;
	// }

	// public ReconUtilityOptions getOptions() {
	// return options;
	// }
	//
	// public void setOptions(ReconUtilityOptions options) {
	// ReconUtility.options = options;
	// }

}
