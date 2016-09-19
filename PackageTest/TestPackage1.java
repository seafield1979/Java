/**
* パッケージのクラスを階層を直接指定して呼び出す
*/
class TestPackage1 {
    public static void main(String args[]) {
        // パッケージ内のクラスを使用する場合は直接クラス名でOK
        MyPackage.AAA.MyAAA aaa = new MyPackage.AAA.MyAAA();
        aaa.test1();

        MyPackage.BBB.MyBBB bbb = new MyPackage.BBB.MyBBB();
        bbb.test1();

        // パッケージ名.クラス名 でアクセスも可能
        MyPackage.MyApp app = new MyPackage.MyApp();
        app.test1();

    }
}