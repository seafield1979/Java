/**
 * Created by shutaro on 2017/02/05.
 */
public class TestOverride {

    public void hello() {
        System.out.print("TestOverride hello\n");
    }
}


class TestOverride2 extends TestOverride {
    public void hello() {
        System.out.print("TestOverride2 hello\n");
    }
}