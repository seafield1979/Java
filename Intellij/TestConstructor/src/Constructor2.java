/**
 * Created by shutaro on 2017/02/05.
 *
 * コンストラクターの呼び出し順番を確認
 */
public class Constructor2 {
    int id;
    String name;

    Constructor2() {
        id = 100;
        name = "nanashi";
        System.out.print("Constructor2\n");
    }

    public void hello() {
        System.out.print("hello Constructor2\n");
    }
}

class Constructor21 extends Constructor2 {
    Constructor21() {
        System.out.print("Constructor21\n");
    }
}