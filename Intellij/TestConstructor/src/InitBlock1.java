/**
 * Created by shutaro on 2017/02/04.
 * 初期化ブロックのサンプル
 */
public class InitBlock1 {
    String name;
    int id;
    static int idNum;

    // 初期化ブロック
    {
        name = "no name";
        idNum++;
    }

    // コンストラクタ
    InitBlock1(String name) {
        if (name != null) {
            this.name = name;
        }
        id = idNum;
    }

    // デバッグ表示
    public void disp() {
        System.out.printf("name:%d id:%d\n", name, id);
    }
}
