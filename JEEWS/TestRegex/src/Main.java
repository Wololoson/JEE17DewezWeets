import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main
{
  public static void main(String[] args)
  {
    String txt="0483/12.28.58";

    String re1="(0)";	// Any Single Character 1
    String re2="(\\d)";	// Any Single Digit 1
    String re3="(\\d)";	// Any Single Digit 2
    String re4="(\\d)";	// Any Single Digit 3
    String re5="(\\/)";	// Any Single Character 2
    String re6="(\\d)";	// Any Single Digit 4
    String re7="(\\d)";	// Any Single Digit 5
    String re8="(\\.)";	// Any Single Character 3
    String re9="(\\d)";	// Any Single Digit 6
    String re10="(\\d)";	// Any Single Digit 7
    String re11="(\\.)";	// Any Single Character 4
    String re12="(\\d)";	// Any Single Digit 8
    String re13="(\\d)";	// Any Single Digit 9

    Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11+re12+re13,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    System.out.println(p.toString());
    Matcher m = p.matcher(txt);
    if (m.find())
    {
        String c1=m.group(1);
        String d1=m.group(2);
        String d2=m.group(3);
        String d3=m.group(4);
        String c2=m.group(5);
        String d4=m.group(6);
        String d5=m.group(7);
        String c3=m.group(8);
        String d6=m.group(9);
        String d7=m.group(10);
        String c4=m.group(11);
        String d8=m.group(12);
        String d9=m.group(13);
        System.out.print("("+c1.toString()+")"+"("+d1.toString()+")"+"("+d2.toString()+")"+"("+d3.toString()+")"+"("+c2.toString()+")"+"("+d4.toString()+")"+"("+d5.toString()+")"+"("+c3.toString()+")"+"("+d6.toString()+")"+"("+d7.toString()+")"+"("+c4.toString()+")"+"("+d8.toString()+")"+"("+d9.toString()+")"+"\n");
    }
  }
}