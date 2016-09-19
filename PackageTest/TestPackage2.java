/**
 * import でパッケージを読み込む
 * import でパッケージを読み込むと各パッケージのクラス名の前にパッケージパスをつける必要がなくなる
 * 
 *  import MyPackage.MyApp; 
 *  でパッケージをロードすると
 *  MyApp app = new MyApp(); 
 *  のように書けるようになる。
 */

import MyPackage.MyApp;
import MyPackage.AAA.MyAAA;
import MyPackage.BBB.MyBBB;

class TestPackage2 {
    public static void main(String args[]) {
        // パッケージ内のクラスを使用する場合は直接クラス名でOK
        MyAAA aaa = new MyAAA();
        aaa.test1();

        MyBBB bbb = new MyBBB();
        bbb.test1();

        // パッケージ名.クラス名 でアクセスも可能
        MyApp app = new MyApp();
        app.test1();

    }
}