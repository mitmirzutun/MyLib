package test;
import java.math.BigDecimal;
import java.math.BigInteger;
import math.MathOps;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger; 	
class TestMathOps {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Handler handler =  new ConsoleHandler();
	private static boolean DEBUGGING=true;
	private static Level level =Level.FINE;
	public static boolean testMathOps() {
		logger.setLevel(Level.ALL);
		handler.setLevel(Level.INFO);
	    if (DEBUGGING)
			handler.setLevel(level);
	    logger.addHandler(handler);
		logger.info("Starting testing");
		logger.info("Testing absolute function");
		if (!testAbs()) {
			logger.severe("Testing failed");
			return false;
		}
		logger.info("Testing GCD function");
		if (!testGCD()) {
			logger.severe("Testing failed");
			return false;
		}
		return true;
	}
	private static boolean testAbs() {
		logger.fine("Testing abs(BigInteger)");
		logger.finer("abs(BigDecimal.valueOf(-10))");
		if (MathOps.abs(BigInteger.valueOf(-10)).intValue()!=10) {
			return false;
		}
		logger.finer("abs(BigDecimal.valueOf(10))");
		if (MathOps.abs(BigInteger.valueOf(10)).intValue()!=10) {
			return false;
		}
		logger.finer("abs(BigDecimal.valueOf(0)");
		if (MathOps.abs(BigInteger.valueOf(0)).intValue()!=0) {
			return false;
		}
		logger.fine("Testing abs(long)");
		logger.finer("abs(-10)");
		if (MathOps.abs(-10)!=10) {
			return false;
		}
		logger.finer("abs(10)");
		if (MathOps.abs(10)!=10) {
			return false;
		}
		logger.finer("abs(0)");
		if (MathOps.abs(0)!=0) {
			return false;
		}
		logger.fine("Testing abs(BigDecimal)");
		logger.finer("abs(BigInteger.valueOf(-5.5))");
		if (MathOps.abs(BigDecimal.valueOf(-5.5)).doubleValue()!=5.5) {
			return false;
		}
		logger.finer("abs(BigInteger.valueOf(0.0))");
		if (MathOps.abs(BigDecimal.valueOf(5.5)).doubleValue()!=5.5) {
			return false;
		}
		logger.finer("abs(BigInteger.valueOf(0.0))");
		if (MathOps.abs(BigDecimal.valueOf(0.0)).doubleValue()!=0.0) {
			return false;
		}
		logger.fine("Testing abs(double)");
		logger.finer("abs(-5.5)");
		if (MathOps.abs(-5.5)!=-5.5) {
			return false;
		}
		logger.finer("abs(5.5)");
		if (MathOps.abs(5.5)!=5.5) {
			return false;
		}
		logger.finer("abs(0.0)");
		if (MathOps.abs(0.0)!=0) {
			return false;
		}
		return true;
	}
	private static boolean testEquality() {
		return true;
	}
	private static boolean testGCD() {
		return true;
	}
	public static void startDebugging() {
		DEBUGGING=true;
	}
	public static void stopDebugging() {
		DEBUGGING=false;
	}
	public static boolean isDebugging() {
		return DEBUGGING;
	}
	public static void setDebuggingLevel(Level l) {
		level=l;
	}
	public static Level getDebuggingLevel() {
		return level;
	}
}
