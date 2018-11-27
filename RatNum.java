import java.lang.Math.*;
import javax.swing.*;
import java.util.*;

public class RatNum {
  private int a;
  private int b;

  public RatNum(){
    this.a = 0;
    this.b = 1;
  }

  public RatNum(int a){
    this.a = a;
    this.b = 1;

  }
  public RatNum(int a, int b){
    this.a = a;
    this.b = b;
    if(this.b < 0){
      this.a = -1 * a;
      this.b = -1 * b;
    }
    if (this.b == 0){
      throw new NumberFormatException("Denominator = 0");
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

public static int parse(String s){
  this.s = s;
  int length = str.length();
  for(int i = 0; i < length; i++){

  }
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
