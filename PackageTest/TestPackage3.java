import MyPackage3.*;

class TestPackage3 {
  public static void main(String args[]) {
    MyCalc cal1 = new MyCalc();
    int ret = cal1.calc(1,2);
    System.out.printf("ret: %d\n", ret);
  }
}