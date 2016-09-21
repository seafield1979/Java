
class TestClass{
    public static void main(String args[]) {
        int mode = 0;
        if (args.length >= 1) {
            try {
                mode = Integer.parseInt(args[1]);
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        switch (mode) {
            case 0:
                System.out.println(System.getProperty("file.encoding"));
        
                Test class1 = new Test();
                class1.test1(1);
                class1.print1();
                break;
            case 1:
                Test class2 = new Test();
                class2.print1();
                class2 = null;
                break;
            case 2:
                Test class3 = new Test();
                int hoge = class3.calc1(100,200);
                break;
            case 3:
            {
                // 引数なしコンストラクタ
                TestConstruct construct1 = new TestConstruct();
                construct1.disp();

                // 引数ありコンストラクタ
                TestConstruct construct2 = new TestConstruct("hoge", 100);
                construct2.disp();
            }
                break;
            case 4:
            {
                // TestSubConstruct sub1 = new TestSubConstruct("taro");
                TestSubConstruct sub1 = new TestSubConstruct();
                sub1.disp();
            }
                break;
            case 5:
            {
                // staticプロパティ、メソッドをテスト
                System.out.printf("static HOGE:%d\n", TestStatic.HOGE);
                TestStatic.test1();

                TestStatic static1 = new TestStatic(36);
                static1.disp();
                break;
            }
            case 6:
            {
                // 継承先のコンストラクタの動作テスト
                TestSubConstruct sub1 = new TestSubConstruct();
                sub1.hoge();
            }
                break;
            case 7:
            {
                // 抽象クラスのテスト
                HogeImpl hoge1 = new HogeImpl();
                hoge1.hoge();
                hoge1.hoge2("magic");
            }
                break;
            case 8:
            {
                // インターフェースのテスト
                InterfaceHogeImpl hoge1 = new InterfaceHogeImpl();
                hoge1.hoge();
                hoge1.calc(33,44);
            }
                break;
            default:
                System.out.printf("no test for %d\n", mode);
                break;
        }
    }
}
class Test{
    // プロパティ
    int val = 100;
    String str1;

    // コンストラクタ
    Test(){
        val = 100;
        str1 = "hoge";
    }

    // ファイナライザ
    @Override 
    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            destruction();
        }
    }

    // 自前で定義したデストラクタ
    private void destruction() {
        System.out.println("destruction");
    }

    public void print1(){
        System.out.print("hello");
        System.out.println("hello2");
        System.out.printf("hello3 %d", 123);
        System.out.printf("hello3 %d", 123);
        System.out.printf("hello3 %d", 123);
    }

    public void test1(int mode){
        if (mode == 1) {
            System.out.printf("%d %s", val, str1);
            System.out.println(str1);
        }
    }

    public int calc1(int a, int b) {
      System.out.printf("%d + %d", a, b);
      return a+b;
    }
}


// staticテスト
class TestStatic {
    int age;

    TestStatic(int age){
        this.age = age;
    }

    // static プロパティ
    // クラス外からオブジェクトを生成しないで呼び出すことができる
    public static final int HOGE = 256;

    // staticメソッド
    // オブジェクトを生成しないで呼び出すことができる
    public static void test1() {
        System.out.println("TestStatic test1()");
    }

    // 通常のメソッド
    public void disp(){
        // クラスメソッドを参照するには
        System.out.printf("TestStatic:disp() %d %d\n", age, this.HOGE);
        this.test1();
    }
}

// コンストラクタテスト
class TestConstruct
{
    protected String name;
    protected int age;

    // 引数なしコンストラクタ
    TestConstruct() {
        // 引数ありのコンストラクタを呼ぶ
        this("hogetaro", 99);
        System.out.println("TestContruct");
    }
    // 引数ありコンストラクタ
    TestConstruct(String name, int age) {
        System.out.println("TestContruct:name:age");
        this.name = name;
        this.age = age;
    }

    public void disp() { 
        System.out.printf("name: %s \nage: %d \n",name, age);
    }

    public void hoge() {
        System.out.println("hoge");
    }
}

// 継承
class TestSubConstruct extends TestConstruct
{
    TestSubConstruct() {
        // ここで自動で親クラスのコンストラクタ super() が呼ばれている
        // System.out.println("TestSubConstruct");

        // 自前で親クラスのコンストラクタを呼んだ場合は自動のコンストラクタ呼び出しはされなくなる
        // super();
        // System.out.println("TestSubConstruct");

        // 自クラスのコンストラクタを呼んだ場合でも、自動のコンストラクタ呼び出しはされなくなる。
        this("hoge");
        System.out.println("TestSubConstruct");        
    }

    TestSubConstruct(String name) {
        // ここで自動で親クラスのコンストラクタ super() が呼ばれている
        this.name = "sub:" + name;
        System.out.println("TestSubConstruct:name");
    }

    public void disp() {
        System.out.print("sub disp\n");
        super.disp();
    }

    // 親クラスのメソッドを上書き(オーバーライド)
    @Override public void hoge(){
        System.out.println("hoge hoge");
    }
}

/**
 * 抽象クラス
 */
abstract class AbstractHoge {
    protected String name;

    abstract public void hoge();
    abstract public void hoge2(String name);
}

/**
 *  実装クラス
 */
class HogeImpl extends AbstractHoge{ 
    
    public void hoge() {
        System.out.println("impl hoge");
    }
    public void hoge2(String name) {
        this.name = name;
        System.out.println("hoge2:" + this.name);
    }
}

/**
 * インターフェース
 */
interface InterfaceHoge {
    // 定数 (public は不要)
    int HOGE_MAX = 256;

    // 抽象メソッド (public は不要)
    void hoge();
    int calc(int a, int b);
}

class InterfaceHogeImpl implements InterfaceHoge{
    public void hoge() {
        System.out.printf("inpl hoge %d\n", InterfaceHoge.HOGE_MAX);
    }
    public int calc(int a, int b) {
        System.out.printf("calc: %d\n", a + b);
        return a + b;
    }
}