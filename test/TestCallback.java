/*
    コールバックのテスト
    呼び出し元で登録したメソッドを別の場所から呼び出す
*/

class TestCallback implements MyClassCallbacks{
    public static void main(String args[]) {
        TestString strTest1 = new TestString();

        int mode = 0;
        if (args.length >= 2) {
            mode = Integer.parseInt(args[1]);
        }
        System.out.println(String.valueOf(mode));

        switch (mode) {
            case 1:
                test1();
                break;
            case 2:
                test2();
                break;
        }    
    }
    private static void test1() {
        TestCallback m = new TestCallback();

        Test1 test1 = new Test1();
        test1.setCallbacks(m);
        test1.method();        
        test1.method2();
    }
    private static void test2() {
        
    }

    // MyClassCallbacks のメソッドを実装
    public void callbackMethod() {
        System.out.println("finished!!");
    }
    public void callbackMethod2(int count) {
        System.out.println("count:" + count);
    }
}
interface MyClassCallbacks {
    public void callbackMethod();
    public void callbackMethod2(int count);
}

class Test1 {
    private MyClassCallbacks _myClassCallbacks;

    public void setCallbacks(MyClassCallbacks myClassCallbacks){
        _myClassCallbacks = myClassCallbacks;
    }

    public void method(){
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        // ここでコールバック呼び出し
        _myClassCallbacks.callbackMethod();
    }

    public void method2() {
        for (int i=0; i<10; i++) {
            _myClassCallbacks.callbackMethod2(i);
        }
    }
}
