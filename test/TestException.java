/**
 * 例外のテスト
 * try ~ catch ~ final
 */
import java.io.*;


class TestException {
    public static void main(String[] args) {
        System.out.println("Exception Test");

        // 第１引数を整数に変換する
        int mode = Integer.parseInt(args[1]);

        Exception1 exception1 = new Exception1();
        switch (mode) {
            case 1:
                exception1.test1(); 
                break;
            case 2:
                exception1.test2(); 
                break;
            case 3:
                exception1.test3();
                break;
            case 4:
                exception1.test4();                
                break;
            case 5:
                exception1.test5(args);
                break;
            case 6:
                exception1.test6();
                break;
            case 7:
                exception1.test7(100);
                exception1.test7(300);
                break;
            case 8:
                exception1.test8();
                break;
        }
    }
}


class Exception1 {
    // 例外をキャッチする 0除算
    public void test1() {
        try {
            int x = 10/0;  //(1)0で除算
        //例外ハンドラ
        } catch (ArithmeticException e) {
            System.out.println("0で除算はできません。");
        }
    }

    // 例外をキャッチする null pointer exception
    public void test2() {
        try {
            String str = null;
            String substr = str.substring(1,3);
        } catch (RuntimeException e) {
            System.out.println("nullぽ!");
        }
    }

    // ファイル入出力をtry~catchなしで呼び出す
    public void test3() {
        // OK
        // IO系のクラスを呼び出すのに try ~ catch を用意
        try {
            FileWriter exFile = new FileWriter("hoge.txt");
        } catch(IOException e) {
            System.err.println(e.getMessage());
        } 

        // NG
        // IO系のクラスを呼び出すのに try ~ catch を用意しない
        // コンパイル時に "エラー: 例外IOExceptionは報告されません。スローするには、捕捉または宣言する必要があります"というエラーが発生する
        // FileWriter exFile = new FileWriter("hoge.txt");
    }

    // 複数の catch 文
    public void test4() {
        try {
            // int ret = 100 / 0;  // 0除算注意
            String str = null;
            str.substring(0,1);
        } catch(ArithmeticException e) {
            System.err.println("エラー" + e.getMessage());
        } catch(NullPointerException e) {
            System.out.println("エラー" + e.getMessage());
        }
    }

    // try ~ catch ~ finally
    public void test5(String[] args) {
        try {
            int x = Integer.parseInt(args[2]);
            System.out.printf("100 / %d の答えは%d\n", x, (100/x));
        } catch(ArithmeticException e) {
            System.err.println("エラー" + e.getMessage());
        } finally {
            System.out.println("This program was finished.");
        }

        // ファイル操作のclose処理をfinallyで行う
        // これで途中の処理で何かしらエラーがあった場合にも必ずファイルがクローズされる
        FileWriter exFile = null;
        try {
            exFile = new FileWriter("hoge.txt");
            exFile.write("hoge");
        } catch(IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (exFile != null) {
                try {
                    exFile.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("close");
            }
        }
    }

    // 簡単な例外 throw 
    public void test6() {
        try {
            throwsTest();
        } catch (FileNotFoundException e) {
            System.out.println("エラー " + e.getMessage());
        }
    }

    // 自作例外クラスを throwし、それをcatchする
    public void test7(int val) {
        try {
            if (val < 0 || val > 255) {
                throw new MyException("val is out of bounds!");
            }
            System.out.println("val is " + String.valueOf(val));
        } catch (MyException e) {
            System.out.println(e);
        }
    }

    // 自前の画像をクリアする
    public void test8() {
        try {
            System.out.println("これからぬるぽ投げるよ");
            throw new NullPointerException("nullpo");
        } catch (NullPointerException e) {
            System.out.println("ぬるぽキャッチ");
        }
    }

    // throws 例外名 は
    // このメソッドはFileNotFoundException例外が発生する可能性があります。なので呼び出し元でcatchしてください。という意味
    void throwsTest() throws FileNotFoundException {
        // FileReader はファイルが見つからない場合に FileNotFoundException を投げる
        // なので try ~ catch を省略できる
        FileReader exFile = new FileReader("hoge2.txt");
    }
}

// 自作例外クラス
// 既存の例外クラスを継承する
class MyException extends Exception {
    public MyException(String str) {
        super("MyException:" + str);
    }
}
