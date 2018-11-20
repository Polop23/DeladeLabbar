import java.lang.Math.*;
import javax.swing.*;
import java.util.*;

public class RatNum {
int p;
int q;

RatNum(){
  this.p = 0;
  this.q = 1;
}

RatNum(int a){
  this.p = a;
  this.q = 1;
}
RatNum(int a, int b){
  if()
  this.p = a;
  this.q = b;
}
  /* */
  public static int gcd(int m, int n){
    int r = 0;
    m=Math.abs(m);
    n=Math.abs(n);

    if(zero(m)==true||zero(n)==true){
      throw new IllegalArgumentException("Zero values not allowed");
    }

  while (true){
    r = m % n;
    if(zero(r)==true){
      return n;
    }
    else {
      m = n;
      n = r;
    }
  }
}
  private static Boolean zero(int number){
  if(number == 0){
    return true;
  }
  else {
    return false;
  }
}
  public static void main(String[] args) {
    int n;
    int m;
    int greatestCommonDivider;

    Scanner scan= new Scanner(System.in);

      System.out.println("Put in numerator");
      m = scan.nextInt();
      System.out.println("Put in denominator");
      n = scan.nextInt();

    greatestCommonDivider = gcd(m, n);
    System.out.println("Greatest common divider is" + greatestCommonDivider);







  }
}
