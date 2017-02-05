/**
 * Created by shutaro on 2017/02/04.
 *
 * コンストラクター用のクラス
 */
public class Constructor1 {
    public long idNum;
    public String name = "<unnamed>";
    public Constructor1 orbits = null;

    private static long nextID = 0;

    // 初期化ブロック
    // コンストラクタよりも先に実行される処理
    {
        idNum = nextID++;
    }

    // デフォルトコストラクタ
    public Constructor1() {
        name = null;
        orbits = null;
    }

    // 引数ありのコンストラクタ
    public Constructor1(String bodyName, Constructor1 orbitsAround) {
        name = bodyName;
        orbits = orbitsAround;
    }

    public void test1() {
        name = "hoge";
    }

    public void disp() {
        System.out.printf("name:%s id:%d\n", name, idNum);
    }
}
