
class InterfaceHogeImpl implements InterfaceHoge{
    void hoge() {
        System.out.println("inpl hoge %d", InterfaceHoge.HOGE_MAX);
    }
    int calc(int a, int b) {
        System.out.printf("calc: %d\n", a + b);
    }
}