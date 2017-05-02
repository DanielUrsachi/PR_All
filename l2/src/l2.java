import java.util.concurrent.Semaphore;
import static java.lang.System.*;
/**
 * Created by Dan on 07-Apr-17.
 */
public class l2 extends Thread {

    //initializare semafoare
    static Semaphore s1 = new Semaphore(0);
    static Semaphore s2 = new Semaphore(0);
    static Semaphore s3 = new Semaphore(0);
    static Semaphore s4 = new Semaphore(0);
    static Semaphore s5 = new Semaphore(0);
    static Semaphore s6 = new Semaphore(0);

    static Thread t1 = new Thread() {
        @Override
        public void run() {
            try {
                out.println("Thread 1");
                Thread.sleep(1500);
                s1.release(2);  //incrementeaza semaforul
            } catch(InterruptedException v) {
                out.println(v);
            }
        }
    };
    static Thread t2 = new Thread() {
        @Override
        public void run() {
            try {
                s1.acquire();   //decrementează și eventual blochează firul
                out.println("Thread 2");
                Thread.sleep(1500);
                s2.release(2);  //incrementeaza semaforul
            } catch(InterruptedException v) {
                out.println(v);
            }
        }
    };
    static Thread t3 = new Thread() {
        @Override
        public void run() {
            try {
                s1.acquire();   //decrementează și eventual blochează firul
                s2.acquire();   //decrementează și eventual blochează firul
                s3.acquire();   //decrementează și eventual blochează firul
                s4.acquire();   //decrementează și eventual blochează firul
                s5.acquire();   //decrementează și eventual blochează firul
                s6.acquire();   //decrementează și eventual blochează firul
                out.println("Thread 3");
                Thread.sleep(1500);
            } catch(InterruptedException v) {
                out.println(v);
            }
        }
    };

    static Thread t4 = new Thread() {
        @Override
        public void run() {
            try {
                s4.acquire();   //decrementează și eventual blochează firul
                out.println("Thread 4");
                Thread.sleep(1500);
                s5.release(2);  //incrementeaza semaforul
            } catch(InterruptedException v) {
                out.println(v);
            }
        }
    };

    static Thread t5 = new Thread() {
        @Override
        public void run() {
            try {
                s2.acquire();   //decrementează și eventual blochează firul
                out.println("Thread 5");
                Thread.sleep(1500);
                s3.release();  //incrementeaza semaforul
            } catch(InterruptedException v) {
                out.println(v);
            }
        }
    };
    static Thread t6 = new Thread() {
        @Override
        public void run() {
            try {
                out.println("Thread 6");
                Thread.sleep(1500);
                s4.release(2);  //incrementeaza semaforul
            } catch(InterruptedException v) {
                out.println(v);
            }
        }
    };
    static Thread t7 = new Thread() {
        @Override
        public void run() {
            try {
                s5.acquire();   //decrementează și eventual blochează firul
                out.println("Thread 7");
                Thread.sleep(1500);
                s6.release();  //incrementeaza semaforul
            } catch(InterruptedException v) {
                out.println(v);
            }
        }
    };

    public static void main(String a[]) {
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}

