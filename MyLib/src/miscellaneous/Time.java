package miscellaneous;

public class Time {
	private int seconds;
	private static int halfDay=12*60*60;
	private static String formatString="hh:mm:ss";
	public Time() {
		this(0);
	}
	public Time(Time time) {
		this.seconds=time.seconds;
	}
	private Time(int seconds) {
		this.seconds=seconds;
	}
	public static Time parseTime(String time) {
		int seconds=0;
		if (time.substring(time.length()-3).equals(" am")) {
			time=time.substring(0,time.length()-3);
		} else if (time.substring(time.length()-3).contentEquals(" pm")) {
			seconds+=halfDay;
			time=time.substring(0,time.length()-3);
		}
		String[] data=time.split(":");
		if (data.length==2||data.length==3) {
			seconds+=Integer.parseInt(data[0])*3600+Integer.parseInt(data[1])*60;
		} if (data.length==3) {
			seconds+=Integer.parseInt(data[2]);
		}
		Time t=new Time(seconds);
		return t;
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		int hours=seconds/3600;
		sb.append(hours>=10?hours:"0"+hours);
		sb.append(":");
		int minutes=(seconds/60)%60;
		sb.append(minutes>=10?minutes:"0"+minutes);
		int seconds=this.seconds%60;
		switch (formatString) {
		case "hh:mm:ss":
			sb.append(":");
			sb.append(seconds>=10?seconds:"0"+seconds);
			break;
		case "hh:mm:ss am":
			sb.append(":");
			sb.append(seconds>=10?seconds:"0"+seconds);
		case "hh:mm am":
			sb.append(seconds<halfDay?" am":"pm");
		};
		return sb.toString();
	}
	public static String format() {
		return formatString;
	}
	public static void format(String formatString) {
		Time.formatString=formatString;
	}
	public static void main(String[] args) {
		String[] formatStrings= {"hh:mm","hh:mm:ss","hh:mm am","hh:mm:ss am"};
		int h,m;
		for (String formatString:formatStrings) {
			Time.formatString=formatString;
			for (h=0;h<10;h++) {
				for (m=0;m<10;m++) {
					System.out.println(Time.parseTime("0"+h+":0"+m));
				} for (m=10;m<60;m++) {
					System.out.println(Time.parseTime("0"+h+":"+m));
				}
			}
		}
	}
}
