import java.lang.Math.*;
import javax.swing.*;
import java.util.*;

public class RatNum {
  private int a;
  private int b;
  private String s;
  private int DEFAULT_NUMERATOR = 0;
  private int DEFAULT_DENOMITOR = 1;

  public RatNum(String s){
    this.s = s;
    try{
      RatNum r = parse(this.s);
    }
    catch(Exception e){
      throw new NumberFormatException("Invalid format of input string #0");

    }
  }

  public RatNum(){
    this.a = DEFAULT_NUMERATOR;
    this.b = DEFAULT_DENOMITOR;
  }

  public RatNum(int a){
    this.a = a;
    this.b = DEFAULT_DENOMITOR;

  }
  public RatNum(int a, int b){
    this.a = a;
    this.b = b;
    if(this.b < 0){
      this.a = -1 * a;
      this.b = -1 * b;
    }
    if (this.b == 0){
      throw new NumberFormatException("Denominator cannot be set to 0");
    }
    if(this.a!=0){
      int intGCD = gcd( this.a, this.b);
      this.a = this.a / intGCD;
      this.b = this.b / intGCD;
    }

    int ratNum = this.a/this.b;
  }

  public RatNum(RatNum r){
    this.a = r.getNumerator();
    this.b = r.getDenominator();
  }

  public int getNumerator(){
    return a;
  }
  public int getDenominator(){
    return b;
  }
  /* */
  public static int gcd(int m, int n){
    int rr = 0;
    m=Math.abs(m);
    n=Math.abs(n);

    if(zero(m)==true||zero(n)==true){
      throw new IllegalArgumentException("Zero values not allowed");
    }

    while (true){
      rr = m % n;
      if(zero(rr)==true){
        return n;
      }
      else {
        m = n;
        n = rr;
      }
    }
  }
  private static boolean zero(int number){
    if(number == 0){
      return true;
    }
    else {
      return false;
    }
  }
  public String toString(){
    this.a = a;
    this.b = b;
    String stringratNum = this.a + "/" + this.b;
    return stringratNum;
  }
  public Double toDouble(){
    this.a = a;
    this.b = b;
    Double doubleratNum = this.a * 1.0 / this.b;
    System.out.println(doubleratNum);
    return doubleratNum;
  }

  public static RatNum parse(String s){

    if(s.indexOf('/')<0){
      s+="/1";
    }
    char[] input = s.toCharArray();
    int minPos = -1;
    int divPos = -1;
    int minCount = 0;
    int divCount = 0;
    int a;
    int b;

    int length = s.length();

    for(int i = 0; i<length; i++){
      if(input[i] == '-'){
        minCount++;
        if(minCount > 1){
          throw new NumberFormatException("Invalid format of input string #1");
        }
        minPos = i;
      }
      if(input[i] == '/'){
        divCount++;
        if(divCount > 1){
          throw new NumberFormatException("Invalid format of input string #2");
        }
        divPos = i;
      }
    }
    if(minPos !=0 && minPos != divPos + 1 && minPos != -1 || divPos == 0 || divPos == length -1){
      throw new NumberFormatException("invalid format of input string #3");
    }

    String sa = s.substring(0,divPos);
    String sb = s.substring(divPos + 1,length);

    try{
      a = Integer.parseInt(sa);
      b = Integer.parseInt(sa);
    }
    catch(Exception e){
      throw new NumberFormatException("Invalid format of iputstring #4");
    }
    return new RatNum(a,b);
  }

  public boolean equals(Object r){
    if(this == r){
      return true;
    }
    if(r == null || this.getClass() != r.getClass()) {
      return false;
    }

    RatNum ratNum = (RatNum) r;
    return(ratNum.getNumerator() == this.a && ratNum.getDenominator() == this.b);

  }

  public int hashCode(){

    return
  }




  /*
  public static void main(String[] args) {
  int n;
  int m;
  int greatestCommonDivider;

  Scanner scan= new Scanner(System.in);
  System.out.println("Put in numerator");
  m = scan.nextInt();
  System.out.println("Put in denominator");
  n = scan.nextInt();

  RatNum ratNum = new RatNum(m, n);


  greatestCommonDivider = gcd(m, n);
  System.out.println("Greatest common divider is " + greatestCommonDivider);
  System.out.println("Numerator is: " + ratNum.getNumerator());
  System.out.println("Denominator is: " + ratNum.getDenominator());
  //System.out.println("Double is" + ratNum.toDouble());
} */

}
