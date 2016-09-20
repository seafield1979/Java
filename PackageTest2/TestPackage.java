import MyPackage2.*;
import MyPackage2.AAA.*;
import MyPackage2.BBB.*;
import MyPackage3.*;

class TestPackage {
  public static void main(String args[]) {
    // MyPackage2のクラスを使用
    Hoge1 hoge1 = new Hoge1();
    hoge1.test1();

    MyCalc cal1 = new MyCalc();
    int ret = cal1.calc(1,2);
    System.out.printf("ret: %d\n", ret);
  }
}