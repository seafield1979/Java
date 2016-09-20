import MyPackage.*;
import MyPackage.AAA.*;
import MyPackage.BBB.*;
import MyPackage2.*;
import MyPackage2.AAA.*;
import MyPackage2.BBB.*;
import com.sunsunsoft.MyPackage3.*;
import com.sunsunsoft.MyPackage3.AAA.Hoge2;
import com.sunsunsoft.MyPackage3.BBB.Hoge3;

class TestPackage {
  public static void main(String args[]) {
    // MyPackage2のクラスを使用
    Hoge1 hoge1 = new Hoge1();
    hoge1.test1();

    Hoge2 hoge2 = new Hoge2();
    hoge2.test1();

    MyCalc cal1 = new MyCalc();
    int ret = cal1.calc(1,2);
    System.out.printf("ret: %d\n", ret);
  }
}