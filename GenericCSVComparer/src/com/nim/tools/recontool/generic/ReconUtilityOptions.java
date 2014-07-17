package com.nim.tools.recontool.generic;
//package com.nim.start;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.kohsuke.args4j.Argument;
//import org.kohsuke.args4j.Option;
//
//public class ReconUtilityOptions {
//
//	static public final Integer DEFAULT_TIMEOUT = new Integer(30000);
//
//	@Option(name = "-e", aliases = { "--environment" }, metaVar = "ENVNAME", usage = "environment variant to use (dev, test, qa, prod)")
//	private String envName = null;
//
//	@Option(name = "-j", aliases = { "--jobfile" }, metaVar = "FILENAME", usage = "job description file to load")
//	private String jobFile = null;
//
//	@Argument
//	private List<String> arguments = new ArrayList<String>();
//
//	public class ArgumentException extends Exception {
//		private static final long serialVersionUID = 1L;
//
//		public ArgumentException(String message) {
//			super(message);
//		}
//
//		public ArgumentException(String message, Throwable cause) {
//			super(message, cause);
//		}
//
//		public ArgumentException(Throwable cause) {
//			super(cause);
//		}
//	}
//
//	public String getEnvName() {
//		return envName;
//	}
//
//	public String getJobFile() {
//		return jobFile;
//	}
//
//	public void setJobFile(String jobFile) {
//		this.jobFile = jobFile;
//	}
//
//	public List<String> getArguments() {
//		return arguments;
//	}
//
//}
