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
	private static Level level =Level.FINEST;
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
		logger.info("Testing sign function");
		if (!testSign()) {
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
		if (MathOps.abs(-5.5)!=5.5) {
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
	private static boolean testSign() {
		logger.fine("sign(BigInteger)");
		logger.finer("sign(BigInteger.valueOf(-10))");
		if (MathOps.sign(BigInteger.valueOf(-10))!=-1) {
			return false;
		}
		logger.finer("sign(BigInteger.valueOf(10))");
		if (MathOps.sign(BigInteger.valueOf(10))!=1) {
			return false;
		}
		logger.finer("sign(BigInteger.valueOf(0))");
		if (MathOps.sign(BigInteger.valueOf(0))!=0) {
			return false;
		}
		logger.fine("sign(long)");
		logger.finer("sign(-10)");
		if (MathOps.sign(-10)!=-1) {
			return false;
		}
		logger.finer("sign(10)");
		if (MathOps.sign(10)!=1) {
			return false;
		}
		logger.finer("sign(0)");
		if (MathOps.sign(0)!=0) {
			return false;
		}
		logger.fine("sign(BigDecimal)");
		logger.finer("sign(BigDecimal.valueOf(-10))");
		if (MathOps.sign(BigDecimal.valueOf(-10))!=-1) {
			return false;
		}
		logger.finer("sign(BigDeccimal.valueOf(10))");
		if (MathOps.sign(BigDecimal.valueOf(10))!=1) {
			return false;
		}
		logger.finer("sign(BigDecimal.valueOf(0))");
		if (MathOps.sign(BigDecimal.valueOf(0))!=0) {
			return false;
		}
		logger.fine("sign(double)");
		logger.finer("sign(-10d)");
		if (MathOps.sign(-10d)!=-1) {
			return false;
		}
		logger.finer("sign(10d)");
		if (MathOps.sign(10d)!=1) {
			return false;
		}
		logger.finer("sign(0d)");
		if (MathOps.sign(0d)!=0) {
			return false;
		}
		return true;
	}
	private static boolean testEquality() {
		logger.info("Testing greater than function");
		if (!testGreaterThan()) {
			return false;
		}
		return true;
	}
	private static boolean testGreaterThan() {
		logger.fine("greaterThan(BigInteger,BigInteger)");
		logger.finer("greaterThan(BigInteger.ZERO,BigInteger.ZERO)");
		if (!MathOps.greaterThan(BigInteger.ZERO,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.TEN,BigInteger.ZERO)");
		if (!MathOps.greaterThan(BigInteger.TEN,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.ZERO,BigInteger.TEN)");
		if (!MathOps.greaterThan(BigInteger.ZERO,BigInteger.TEN)) {
			return false;
		}
		logger.fine("greaterThan(BigInteger,long)");
		logger.finer("greaterThan(BigInteger.ZERO,0)");
		if (!MathOps.greaterThan(BigInteger.ZERO,0)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.ZERO,10)");
		if (!MathOps.greaterThan(BigInteger.ZERO,10)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.ZERO,-10)");
		if (!MathOps.greaterThan(BigInteger.ZERO,-10)) {
			return false;
		}
		logger.fine("greaterThan(long,BigInteger)");
		logger.finer("greaterThan(0,BigInteger.ZERO)");
		if (!MathOps.greaterThan(0,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(10,BigInteger.ZERO)");
		if (!MathOps.greaterThan(10,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(-10,BigInteger.ZERO)");
		if (!MathOps.greaterThan(-10,BigInteger.ZERO)) {
			return false;
		}
		logger.fine("greaterThan(long,long)");
		logger.finer("greaterThan(0,0)");
		if (!MathOps.greaterThan(0,0)) {
			return false;
		}
		logger.finer("greaterThan(10,0)");
		if (!MathOps.greaterThan(10,0)) {
			return false;
		}
		logger.finer("greaterThan(-10,0)");
		if (!MathOps.greaterThan(-10,0)) {
			return false;
		}
		logger.fine("greaterThan(BigInteger,BigInteger)");
		logger.finer("greaterThan(BigInteger.ZERO,BigInteger.ZERO)");
		if (!MathOps.greaterThan(BigDecimal.ZERO,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.TEN,BigInteger.ZERO)");
		if (!MathOps.greaterThan(BigDecimal.TEN,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.ZERO,BigInteger.TEN)");
		if (!MathOps.greaterThan(BigDecimal.ZERO,BigDecimal.TEN)) {
			return false;
		}
		logger.fine("greaterThan(BigDecimal,long)");
		logger.finer("greaterThan(BigDecimal.ZERO,0)");
		if (!MathOps.greaterThan(BigDecimal.ZERO,0)) {
			return false;
		}
		logger.finer("greaterThan(BigDecimal.ZERO,10)");
		if (!MathOps.greaterThan(BigDecimal.ZERO,10)) {
			return false;
		}
		logger.finer("greaterThan(BigDecimal.ZERO,-10)");
		if (!MathOps.greaterThan(BigDecimal.ZERO,-10)) {
			return false;
		}
		logger.fine("greaterThan(long,BigDecimal)");
		logger.finer("greaterThan(0,BigDecimal.ZERO)");
		if (!MathOps.greaterThan(0,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(10,BigDecimal.ZERO)");
		if (!MathOps.greaterThan(10,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(-10,BigDecimal.ZERO)");
		if (!MathOps.greaterThan(-10,BigDecimal.ZERO)) {
			return false;
		}
		logger.fine("greaterThan(double,double)");
		logger.finer("greaterThan(0,0d)");
		if (!MathOps.greaterThan(0,0d)) {
			return false;
		}
		logger.finer("greaterThan(10,0d)");
		if (!MathOps.greaterThan(10,0d)) {
			return false;
		}
		logger.finer("greaterThan(-10,0d)");
		if (!MathOps.greaterThan(-10,0d)) {
			return false;
		}
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
