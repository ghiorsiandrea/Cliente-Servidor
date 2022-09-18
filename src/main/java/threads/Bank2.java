package main.java.threads;

/**
 * Here we can appreciatte that in case that we had only one condition (sufficient balance - BANK) is more efficient the
 * solution provided by the use of the reserved word Synchronized (OBJECT)  + wait + notifyAll (BANK 2), it cames with
 * an implicit closing.
 *
 * In case we need define more than one condition, its better use the class Reentrant Lock with the Interface Condition
 * whit await and SignalAll (we need to define an explicit closing)
 */

public class Bank2 {
    public static final int SIZE_ARRAY = 101;

    public static void main(String[] args) {

        Acounts2 a2 = new Acounts2();
        for (int i = 1; i < SIZE_ARRAY; i++) {
            ExecuteTransfer2 r = new ExecuteTransfer2(a2, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }
    }

}

class Acounts2 {
    private final double[] cuentas2;
    // YA NO ES NECESARIO AL USAR SYNCHRONIZED
    // private Lock closeBank2 = new ReentrantLock();
    //private Condition sufficientBalance;

    public Acounts2() {
        cuentas2 = new double[Bank2.SIZE_ARRAY];
        for (int i = 1; i < Bank2.SIZE_ARRAY; i++) {
            cuentas2[i] = 2000;
        }

        //sufficientBalance = closeBank2.newCondition();
    }

    public  synchronized void transfer2(int origin, int destiny, double amount) {
        // YA NO ES NECESARIO AL USAR SYNCHRONIZED
        // closeBank2.lock();
        //try {
            String denied = "------------------------------------------------------------ TRANSACTION DENIED  ---------------------------------------------------------\n";
            String oringinAcc = String.format("   NON SUFFICIENT AMOUNT ON ACCOUNT Nº %d", origin);
            String balance = String.format("   BALANCE %10.2f", cuentas2[origin]);
            String amountt = String.format("   And you are trying to transfer:   %10.2f", amount);

            while (cuentas2[origin] < amount) {
                System.err.println(denied + oringinAcc + balance + amountt + "\n" + denied);
                // YA NO ES NECESARIO AL USAR SYNCHRONIZED
                // sufficientBalance.await();
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return;
            }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cuentas2[origin] -= amount;
            cuentas2[destiny] += amount;
            System.out.println(Thread.currentThread());
            System.out.printf("%10.2f de %d para %d  - ", amount, origin, destiny);
            System.out.printf("Balance: %10.2f%n\n", getTotalBalance());
            notifyAll();
            //sufficientBalance.signalAll();
        //} catch (InterruptedException e) {
           // throw new RuntimeException(e);
            // YA NO ES NECESARIO AL USAR SYNCHRONIZED
            // } finally {
           // closeBank2.unlock();
        }

    //}

    public double getTotalBalance() {
        double AcountsTotal = 0;
        for (double a : cuentas2) {
            AcountsTotal += a;
        }
        return AcountsTotal;
    }

}

class ExecuteTransfer2 implements Runnable {
    private Acounts2 banco2;
    private int origen;
    private double maximo;

    public ExecuteTransfer2(Acounts2 banco2, int origen, double maximo) {
        this.banco2 = banco2;
        this.origen = origen;
        this.maximo = maximo;
    }

    public void run() {
        try {
            while (true) {

                int toTheAccount = (int) (Math.random() * 100);
                double AmmountTrans = maximo * Math.random();
                banco2.transfer2(origen, toTheAccount, AmmountTrans);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        }
    }
}