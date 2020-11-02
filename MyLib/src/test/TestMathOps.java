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
	private static Level level=Level.FINEST;
	public static void main(String...args) {
		System.out.println(MathOps.fak(-1));
	}
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
		logger.info("Testing equality functions");
		if (!testEquality()) {
			logger.severe("Testing failed");
			return false;
		}
		logger.info("Testing GCD function");
		if (!testGCD()) {
			logger.severe("Testing failed");
			return false;
		}
		logger.info("Testing Fibonacci function");
		if (!testFib()) {
			logger.severe("Testing failed");
			return false;
		}
		logger.info("Testing Fakulty function");
		if (!testFak()) {
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
		logger.finer("abs(BigInteger.valueOf(10))");
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
		logger.finer("abs(BigDecimal.valueOf(-5.5))");
		if (MathOps.abs(BigDecimal.valueOf(-5.5)).doubleValue()!=5.5) {
			return false;
		}
		logger.finer("abs(BigDecimal.valueOf(0.0))");
		if (MathOps.abs(BigDecimal.valueOf(5.5)).doubleValue()!=5.5) {
			return false;
		}
		logger.finer("abs(BigDecimal.valueOf(0.0))");
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
		if (!testEquals()) {
			return false;
		}
		if (!testLessThan()) {
			return false;
		}
		if (!testGreaterOrEquals())
			return false;
		if (!testLessOrEquals())
			return false;
		return true;
	}
	private static boolean testGreaterThan() {
		logger.fine("greaterThan(BigInteger,BigInteger)");
		logger.finer("greaterThan(BigInteger.ZERO,BigInteger.ZERO)");
		if (MathOps.greaterThan(BigInteger.ZERO,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.TEN,BigInteger.ZERO)");
		if (!MathOps.greaterThan(BigInteger.TEN,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.ZERO,BigInteger.TEN)");
		if (MathOps.greaterThan(BigInteger.ZERO,BigInteger.TEN)) {
			return false;
		}
		logger.fine("greaterThan(BigInteger,long)");
		logger.finer("greaterThan(BigInteger.ZERO,0)");
		if (MathOps.greaterThan(BigInteger.ZERO,0)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.ZERO,10)");
		if (MathOps.greaterThan(BigInteger.ZERO,10)) {
			return false;
		}
		logger.finer("greaterThan(BigInteger.ZERO,-10)");
		if (!MathOps.greaterThan(BigInteger.ZERO,-10)) {
			return false;
		}
		logger.fine("greaterThan(long,BigInteger)");
		logger.finer("greaterThan(0,BigInteger.ZERO)");
		if (MathOps.greaterThan(0,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(10,BigInteger.ZERO)");
		if (!MathOps.greaterThan(10,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(-10,BigInteger.ZERO)");
		if (MathOps.greaterThan(-10,BigInteger.ZERO)) {
			return false;
		}
		logger.fine("greaterThan(long,long)");
		logger.finer("greaterThan(0,0)");
		if (MathOps.greaterThan(0,0)) {
			return false;
		}
		logger.finer("greaterThan(10,0)");
		if (!MathOps.greaterThan(10,0)) {
			return false;
		}
		logger.finer("greaterThan(-10,0)");
		if (MathOps.greaterThan(-10,0)) {
			return false;
		}
		logger.fine("greaterThan(BigDecimal,BigDecimal)");
		logger.finer("greaterThan(BigDecimal.ZERO,BigDecimal.ZERO)");
		if (MathOps.greaterThan(BigDecimal.ZERO,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(BigDecimal.TEN,BigDecimal.ZERO)");
		if (!MathOps.greaterThan(BigDecimal.TEN,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(BigDecimal.ZERO,BigDecimal.TEN)");
		if (MathOps.greaterThan(BigDecimal.ZERO,BigDecimal.TEN)) {
			return false;
		}
		logger.fine("greaterThan(BigDecimal,long)");
		logger.finer("greaterThan(BigDecimal.ZERO,0)");
		if (MathOps.greaterThan(BigDecimal.ZERO,0)) {
			return false;
		}
		logger.finer("greaterThan(BigDecimal.ZERO,10)");
		if (MathOps.greaterThan(BigDecimal.ZERO,10)) {
			return false;
		}
		logger.finer("greaterThan(BigDecimal.ZERO,-10)");
		if (!MathOps.greaterThan(BigDecimal.ZERO,-10)) {
			return false;
		}
		logger.fine("greaterThan(long,BigDecimal)");
		logger.finer("greaterThan(0,BigDecimal.ZERO)");
		if (MathOps.greaterThan(0,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(10,BigDecimal.ZERO)");
		if (!MathOps.greaterThan(10,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterThan(-10,BigDecimal.ZERO)");
		if (MathOps.greaterThan(-10,BigDecimal.ZERO)) {
			return false;
		}
		logger.fine("greaterThan(double,double)");
		logger.finer("greaterThan(0,0d)");
		if (MathOps.greaterThan(0,0d)) {
			return false;
		}
		logger.finer("greaterThan(10,0d)");
		if (!MathOps.greaterThan(10,0d)) {
			return false;
		}
		logger.finer("greaterThan(-10,0d)");
		if (MathOps.greaterThan(-10,0d)) {
			return false;
		}
		return true;
	}
	private static boolean testEquals() {
		logger.fine("equals(BigInteger,BigInteger)");
		logger.finer("equals(BigInteger.ZERO,BigInteger.ZERO)");
		if (!MathOps.equals(BigInteger.ZERO,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("equals(BigInteger.TEN,BigInteger.ZERO)");
		if (MathOps.equals(BigInteger.TEN,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("equals(BigInteger.ZERO,BigInteger.TEN)");
		if (MathOps.equals(BigInteger.ZERO,BigInteger.TEN)) {
			return false;
		}
		logger.fine("equals(BigInteger,long)");
		logger.finer("equals(BigInteger.ZERO,0)");
		if (!MathOps.equals(BigInteger.ZERO,0)) {
			return false;
		}
		logger.finer("equals(BigInteger.ZERO,10)");
		if (MathOps.equals(BigInteger.ZERO,10)) {
			return false;
		}
		logger.finer("equals(BigInteger.ZERO,-10)");
		if (MathOps.equals(BigInteger.ZERO,-10)) {
			return false;
		}
		logger.fine("equals(long,BigInteger)");
		logger.finer("equals(0,BigInteger.ZERO)");
		if (!MathOps.equals(0,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("equals(10,BigInteger.ZERO)");
		if (MathOps.equals(10,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("equals(-10,BigInteger.ZERO)");
		if (MathOps.equals(-10,BigInteger.ZERO)) {
			return false;
		}
		logger.fine("equals(long,long)");
		logger.finer("equals(0,0)");
		if (!MathOps.equals(0,0)) {
			return false;
		}
		logger.finer("equals(10,0)");
		if (MathOps.equals(10,0)) {
			return false;
		}
		logger.finer("equals(-10,0)");
		if (MathOps.equals(-10,0)) {
			return false;
		}
		logger.fine("equals(BigDecimal,BigDecimal)");
		logger.finer("equals(BigDecimal.ZERO,BigDecimal.ZERO)");
		if (!MathOps.equals(BigDecimal.ZERO,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("equals(BigDecimal.TEN,BigDecimal.ZERO)");
		if (MathOps.equals(BigDecimal.TEN,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("equals(BigDecimal.ZERO,BigDecimal.TEN)");
		if (MathOps.equals(BigDecimal.ZERO,BigDecimal.TEN)) {
			return false;
		}
		logger.fine("equals(BigDecimal,long)");
		logger.finer("equals(BigDecimal.ZERO,0)");
		if (!MathOps.equals(BigDecimal.ZERO,0)) {
			return false;
		}
		logger.finer("equals(BigDecimal.ZERO,10)");
		if (MathOps.equals(BigDecimal.ZERO,10)) {
			return false;
		}
		logger.finer("equals(BigDecimal.ZERO,-10)");
		if (MathOps.equals(BigDecimal.ZERO,-10)) {
			return false;
		}
		logger.fine("equals(long,BigDecimal)");
		logger.finer("equals(0,BigDecimal.ZERO)");
		if (!MathOps.equals(0,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("equals(10,BigDecimal.ZERO)");
		if (MathOps.equals(10,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("equals(-10,BigDecimal.ZERO)");
		if (MathOps.equals(-10,BigDecimal.ZERO)) {
			return false;
		}
		logger.fine("equals(double,double)");
		logger.finer("equals(0,0d)");
		if (!MathOps.equals(0,0d)) {
			return false;
		}
		logger.finer("equals(10,0d)");
		if (MathOps.equals(10,0d)) {
			return false;
		}
		logger.finer("equals(-10,0d)");
		if (MathOps.equals(-10,0d)) {
			return false;
		}
		return true;
	}
	private static boolean testLessThan() {
		logger.fine("lessThan(BigInteger,BigInteger)");
		logger.finer("lessThan(BigInteger.ZERO,BigInteger.ZERO)");
		if (MathOps.lessThan(BigInteger.ZERO,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("lessThan(BigInteger.TEN,BigInteger.ZERO)");
		if (MathOps.lessThan(BigInteger.TEN,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("lessThan(BigInteger.ZERO,BigInteger.TEN)");
		if (!MathOps.lessThan(BigInteger.ZERO,BigInteger.TEN)) {
			return false;
		}
		logger.fine("lessThan(BigInteger,long)");
		logger.finer("lessThan(BigInteger.ZERO,0)");
		if (MathOps.lessThan(BigInteger.ZERO,0)) {
			return false;
		}
		logger.finer("lessThan(BigInteger.ZERO,10)");
		if (!MathOps.lessThan(BigInteger.ZERO,10)) {
			return false;
		}
		logger.finer("lessThan(BigInteger.ZERO,-10)");
		if (MathOps.lessThan(BigInteger.ZERO,-10)) {
			return false;
		}
		logger.fine("lessThan(long,BigInteger)");
		logger.finer("lessThan(0,BigInteger.ZERO)");
		if (MathOps.lessThan(0,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("lessThan(10,BigInteger.ZERO)");
		if (MathOps.lessThan(10,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("lessThan(-10,BigInteger.ZERO)");
		if (!MathOps.lessThan(-10,BigInteger.ZERO)) {
			return false;
		}
		logger.fine("lessThan(long,long)");
		logger.finer("lessThan(0,0)");
		if (MathOps.lessThan(0,0)) {
			return false;
		}
		logger.finer("lessThan(10,0)");
		if (MathOps.lessThan(10,0)) {
			return false;
		}
		logger.finer("lessThan(-10,0)");
		if (!MathOps.lessThan(-10,0)) {
			return false;
		}
		logger.fine("lessThan(BigDecimal,BigDecimal)");
		logger.finer("lessThan(BigDeicmal.ZERO,BigInteger.ZERO)");
		if (MathOps.lessThan(BigDecimal.ZERO,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("lessThan(BigInteger.TEN,BigInteger.ZERO)");
		if (MathOps.lessThan(BigDecimal.TEN,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("lessThan(BigInteger.ZERO,BigInteger.TEN)");
		if (!MathOps.lessThan(BigDecimal.ZERO,BigDecimal.TEN)) {
			return false;
		}
		logger.fine("lessThan(BigDecimal,long)");
		logger.finer("lessThan(BigDecimal.ZERO,0)");
		if (MathOps.lessThan(BigDecimal.ZERO,0)) {
			return false;
		}
		logger.finer("lessThan(BigDecimal.ZERO,10)");
		if (!MathOps.lessThan(BigDecimal.ZERO,10)) {
			return false;
		}
		logger.finer("lessThan(BigDecimal.ZERO,-10)");
		if (MathOps.lessThan(BigDecimal.ZERO,-10)) {
			return false;
		}
		logger.fine("lessThan(long,BigDecimal)");
		logger.finer("lessThan(0,BigDecimal.ZERO)");
		if (MathOps.lessThan(0,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("lessThan(10,BigDecimal.ZERO)");
		if (MathOps.lessThan(10,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("lessThan(-10,BigDecimal.ZERO)");
		if (!MathOps.lessThan(-10,BigDecimal.ZERO)) {
			return false;
		}
		logger.fine("lessThan(double,double)");
		logger.finer("lessThan(0,0d)");
		if (MathOps.lessThan(0,0d)) {
			return false;
		}
		logger.finer("lessThan(10,0d)");
		if (MathOps.lessThan(10,0d)) {
			return false;
		}
		logger.finer("lessThan(-10,0d)");
		if (!MathOps.lessThan(-10,0d)) {
			return false;
		}
		return true;
	}
	private static boolean testGreaterOrEquals() {
		logger.fine("greaterOrEquals(BigInteger,BigInteger)");
		logger.finer("greaterOrEquals(BigInteger.ZERO,BigInteger.ZERO)");
		if (!MathOps.greaterOrEquals(BigInteger.ZERO,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterOrEquals(BigInteger.TEN,BigInteger.ZERO)");
		if (!MathOps.greaterOrEquals(BigInteger.TEN,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterOrEquals(BigInteger.ZERO,BigInteger.TEN)");
		if (MathOps.greaterOrEquals(BigInteger.ZERO,BigInteger.TEN)) {
			return false;
		}
		logger.fine("greaterThan(BigInteger,long)");
		logger.finer("greaterThan(BigInteger.ZERO,0)");
		if (!MathOps.greaterOrEquals(BigInteger.ZERO,0)) {
			return false;
		}
		logger.finer("greaterOrEquals(BigInteger.ZERO,10)");
		if (MathOps.greaterOrEquals(BigInteger.ZERO,10)) {
			return false;
		}
		logger.finer("greaterOrEquals(BigInteger.ZERO,-10)");
		if (!MathOps.greaterOrEquals(BigInteger.ZERO,-10)) {
			return false;
		}
		logger.fine("greaterOrEquals(long,BigInteger)");
		logger.finer("greaterOrEquals(0,BigInteger.ZERO)");
		if (!MathOps.greaterOrEquals(0,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterOrEquals(10,BigInteger.ZERO)");
		if (!MathOps.greaterOrEquals(10,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("greaterOrEquals(-10,BigInteger.ZERO)");
		if (MathOps.greaterOrEquals(-10,BigInteger.ZERO)) {
			return false;
		}
		logger.fine("greaterOrEquals(long,long)");
		logger.finer("greaterOrEquals(0,0)");
		if (!MathOps.greaterOrEquals(0,0)) {
			return false;
		}
		logger.finer("greaterOrEquals(10,0)");
		if (!MathOps.greaterOrEquals(10,0)) {
			return false;
		}
		logger.finer("greaterOrEquals(-10,0)");
		if (MathOps.greaterOrEquals(-10,0)) {
			return false;
		}
		logger.fine("greaterOrEquals(BigInteger,BigInteger)");
		logger.finer("greaterOrEquals(BigInteger.ZERO,BigInteger.ZERO)");
		if (!MathOps.greaterOrEquals(BigDecimal.ZERO,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterOrEquals(BigInteger.TEN,BigInteger.ZERO)");
		if (!MathOps.greaterOrEquals(BigDecimal.TEN,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterOrEquals(BigInteger.ZERO,BigInteger.TEN)");
		if (MathOps.greaterOrEquals(BigDecimal.ZERO,BigDecimal.TEN)) {
			return false;
		}
		logger.fine("greaterOrEquals(BigDecimal,long)");
		logger.finer("greaterOrEquals(BigDecimal.ZERO,0)");
		if (!MathOps.greaterOrEquals(BigDecimal.ZERO,0)) {
			return false;
		}
		logger.finer("greaterOrEquals(BigDecimal.ZERO,10)");
		if (MathOps.greaterOrEquals(BigDecimal.ZERO,10)) {
			return false;
		}
		logger.finer("greaterOrEquals(BigDecimal.ZERO,-10)");
		if (!MathOps.greaterOrEquals(BigDecimal.ZERO,-10)) {
			return false;
		}
		logger.fine("greaterOrEquals(long,BigDecimal)");
		logger.finer("greaterOrEquals(0,BigDecimal.ZERO)");
		if (!MathOps.greaterOrEquals(0,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterOrEquals(10,BigDecimal.ZERO)");
		if (!MathOps.greaterOrEquals(10,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("greaterOrEquals(-10,BigDecimal.ZERO)");
		if (MathOps.greaterOrEquals(-10,BigDecimal.ZERO)) {
			return false;
		}
		logger.fine("greaterOrEquals(double,double)");
		logger.finer("greaterOrEquals(0,0d)");
		if (!MathOps.greaterOrEquals(0,0d)) {
			return false;
		}
		logger.finer("greaterOrEquals(10,0d)");
		if (!MathOps.greaterOrEquals(10,0d)) {
			return false;
		}
		logger.finer("greaterOrEquals(-10,0d)");
		if (MathOps.greaterOrEquals(-10,0d)) {
			return false;
		}
		return true;
	}
	private static boolean testLessOrEquals() {
		logger.fine("lessOrEquals(BigInteger,BigInteger)");
		logger.finer("lessOrEquals(BigInteger.ZERO,BigInteger.ZERO)");
		if (!MathOps.lessOrEquals(BigInteger.ZERO,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("lessOrEquals(BigInteger.TEN,BigInteger.ZERO)");
		if (MathOps.lessOrEquals(BigInteger.TEN,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("lessOrEquals(BigInteger.ZERO,BigInteger.TEN)");
		if (!MathOps.lessOrEquals(BigInteger.ZERO,BigInteger.TEN)) {
			return false;
		}
		logger.fine("lessOrEquals(BigInteger,long)");
		logger.finer("lessOrEquals(BigInteger.ZERO,0)");
		if (!MathOps.lessOrEquals(BigInteger.ZERO,0)) {
			return false;
		}
		logger.finer("lessOrEquals(BigInteger.ZERO,10)");
		if (!MathOps.lessOrEquals(BigInteger.ZERO,10)) {
			return false;
		}
		logger.finer("lessOrEquals(BigInteger.ZERO,-10)");
		if (MathOps.lessOrEquals(BigInteger.ZERO,-10)) {
			return false;
		}
		logger.fine("lessOrEquals(long,BigInteger)");
		logger.finer("lessOrEquals(0,BigInteger.ZERO)");
		if (!MathOps.lessOrEquals(0,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("lessOrEquals(10,BigInteger.ZERO)");
		if (MathOps.lessOrEquals(10,BigInteger.ZERO)) {
			return false;
		}
		logger.finer("lessOrEquals(-10,BigInteger.ZERO)");
		if (!MathOps.lessOrEquals(-10,BigInteger.ZERO)) {
			return false;
		}
		logger.fine("lessOrEquals(long,long)");
		logger.finer("lessOrEquals(0,0)");
		if (!MathOps.lessOrEquals(0,0)) {
			return false;
		}
		logger.finer("lessOrEquals(10,0)");
		if (MathOps.lessOrEquals(10,0)) {
			return false;
		}
		logger.finer("lessOrEquals(-10,0)");
		if (!MathOps.lessOrEquals(-10,0)) {
			return false;
		}
		logger.fine("lessOrEquals(BigInteger,BigInteger)");
		logger.finer("lessOrEquals(BigInteger.ZERO,BigInteger.ZERO)");
		if (!MathOps.lessOrEquals(BigDecimal.ZERO,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("lessOrEquals(BigInteger.TEN,BigInteger.ZERO)");
		if (MathOps.lessOrEquals(BigDecimal.TEN,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("lessOrEquals(BigInteger.ZERO,BigInteger.TEN)");
		if (!MathOps.lessOrEquals(BigDecimal.ZERO,BigDecimal.TEN)) {
			return false;
		}
		logger.fine("lessOrEquals(BigDecimal,long)");
		logger.finer("lessOrEquals(BigDecimal.ZERO,0)");
		if (!MathOps.lessOrEquals(BigDecimal.ZERO,0)) {
			return false;
		}
		logger.finer("lessOrEquals(BigDecimal.ZERO,10)");
		if (!MathOps.lessOrEquals(BigDecimal.ZERO,10)) {
			return false;
		}
		logger.finer("lessOrEquals(BigDecimal.ZERO,-10)");
		if (MathOps.lessOrEquals(BigDecimal.ZERO,-10)) {
			return false;
		}
		logger.fine("lessOrEquals(long,BigDecimal)");
		logger.finer("lessOrEquals(0,BigDecimal.ZERO)");
		if (!MathOps.lessOrEquals(0,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("lessOrEquals(10,BigDecimal.ZERO)");
		if (MathOps.lessOrEquals(10,BigDecimal.ZERO)) {
			return false;
		}
		logger.finer("lessOrEquals(-10,BigDecimal.ZERO)");
		if (!MathOps.lessOrEquals(-10,BigDecimal.ZERO)) {
			return false;
		}
		logger.fine("lessOrEquals(double,double)");
		logger.finer("lessOrEquals(0,0d)");
		if (!MathOps.lessOrEquals(0,0d)) {
			return false;
		}
		logger.finer("greaterThan(10,0d)");
		if (MathOps.lessOrEquals(10,0d)) {
			return false;
		}
		logger.finer("lessOrEquals(-10,0d)");
		if (!MathOps.lessOrEquals(-10,0d)) {
			return false;
		}
		return true;
	}
 	private static boolean testGCD() {
		logger.fine("GCD(long...)");
		logger.finer(Long.toString(MathOps.GCD(4,6)));
		logger.finer("GCD(4,6)");
 		if (MathOps.GCD(4,6)!=2)
 			return false;
		logger.finer("GCD(4,6,8)");
 		if (MathOps.GCD(4,6,8)!=2)
 			return false;
		logger.finer("GCD(4,0)");
 		if (MathOps.GCD(4,0)!=4)
 			return false;
		logger.finer("GCD(4,4)");
 		if (MathOps.GCD(4,4)!=4)
 			return false;
 		logger.fine("GCD(Object...)");
 		logger.finer("GCD(4,BigInteger.valueOf(6))");
 		if (!MathOps.equals(MathOps.GCD(4,BigInteger.valueOf(6)),2))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),6)");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),6),2))
 			return false;
 		logger.finer("GCD(4,BigInteger.Zero)");
 		if (!MathOps.equals(MathOps.GCD(4,BigInteger.ZERO),4))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),0)");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),0),4))
 			return false;
 		logger.finer("GCD(4,BigInteger.valueOf(4))");
 		if (!MathOps.equals(MathOps.GCD(4,BigInteger.valueOf(4)),4))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),4)");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),4),4))
 			return false;
 		logger.finer("GCD(4,6,BigInteger.valueOf(8))");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),6),2))
 			return false;
 		logger.finer("GCD(4,BigInteger.valueOf(6),8)");
 		if (!MathOps.equals(MathOps.GCD(4,BigInteger.valueOf(6),8),2))
 			return false;
 		logger.finer("GCD(4,BigInteger.valueOf(6),BigInteger.valueOf(8))");
 		if (!MathOps.equals(MathOps.GCD(4,BigInteger.valueOf(6),BigInteger.valueOf(8)),2))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),6,8)");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),6,8),2))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),6,BigInteger.valueOf(8))");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),6,BigInteger.valueOf(8)),2))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),6,8)");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),6,8),2))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),BigInteger.valueOf(6),8)");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),BigInteger.valueOf(6),8),2))
 			return false;
 		logger.fine("GCD(BigInteger...)");
 		logger.finer("GCD(BigInteger.valueOf(4),BigInteger.valueOf(6))");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),BigInteger.valueOf(6)), 2))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),BigInteger.valueOf(6),BigInteger.valueOf(8))");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),BigInteger.valueOf(6),BigInteger.valueOf(8)), 2))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),BigInteger.valueOf(4))");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),BigInteger.valueOf(4)), 4))
 			return false;
 		logger.finer("GCD(BigInteger.valueOf(4),BigInteger.valueOf(6),BigInteger.valueOf(8))");
 		if (!MathOps.equals(MathOps.GCD(BigInteger.valueOf(4),BigInteger.ZERO), 4))
 			return false;
		return true;
	}
 	private static boolean testFib() {
 		logger.fine("fib(9)");
 		if (!MathOps.equals(MathOps.fib(9),34))
 			return false;
 		logger.fine("fib(-9)");
 		if (!MathOps.equals(MathOps.fib(-9), 34))
 			return false;
 		logger.fine("fib(-8)");
 		if (!MathOps.equals(MathOps.fib(-8), -21))
 			return false;
 		return true;
 	}
 	private static boolean testFak() {
 		logger.fine("fak(5)");
 		if (!MathOps.equals(MathOps.fak(5),120))
 			return false;
 		logger.fine("fak(0)");
 		if (!MathOps.equals(MathOps.fak(0),1))
 			return false;
 		logger.fine("fak(-10)");
 		try {
 			MathOps.fak(-10);
 			return false;
 		} catch (exceptions.NegativeNumberException e) {
 			
 		} catch (Exception e) {
 			return false;
 		}
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
