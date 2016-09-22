// 複数のスレッドから利用されるクラス
// 特定の処理を行っている間は他のスレッドから呼び出して欲しくないメソッドには synchronized をつけて、同時アクセスされないようにする
class SynchronizedClass {
    // synchronized をつけることでこのメソッドにアクセスできるのは常に１つのスレッド
    // public void block1() {
    synchronized public void block1() {
        System.out.print("start!");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {

        }
        System.out.println("end!");
    }
}

class SynchronizedThread1 extends Thread {
    SynchronizedClass sc = null;

    // コンストラクタで共有のSynchronizedClassオブジェクトを取得する
    SynchronizedThread1(SynchronizedClass sc) {
        this.sc = sc;
    }
    
    public void run() {
        for (int i=0; i<100; i++) {
            sc.block1();
        }
    }
}

class TestThread {
    public static void main(String[] args) {
        System.out.println("Thread Test");
        SynchronizedClass sc = new SynchronizedClass();
        SynchronizedThread1 thread1 = new SynchronizedThread1(sc);
        SynchronizedThread1 thread2 = new SynchronizedThread1(sc);
        thread1.start();
        thread2.start();
    }
}