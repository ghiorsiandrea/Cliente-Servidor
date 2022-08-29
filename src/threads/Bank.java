package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    public static final int SIZE_ARRAY = 101;

    public static void main(String[] args) {

        Acounts a=new Acounts();
        for(int i=1; i< SIZE_ARRAY; i++) {
            ExecuteTransfer r=new ExecuteTransfer(a, i, 2000);
            Thread t=new Thread(r);
            t.start();
        }
    }
}
class Acounts{
    private final double[] cuentas;
    private Lock closeBank = new ReentrantLock();
    public Acounts() {
        cuentas=new double[Bank.SIZE_ARRAY];
        for(int i=1; i<Bank.SIZE_ARRAY; i++) {
            cuentas[i]=2000;
        }
    }
    public void transfer(int origin, int destiny, double
            amount) {
        closeBank.lock();
        try {
            if(cuentas[origin]<amount) {
                return;
            }
            System.out.println(Thread.currentThread());
            cuentas[origin]-=amount;
            System.out.printf("%10.2f de %d para %d", amount, origin, destiny);
            cuentas[destiny]+=amount;
            System.err.printf("Saldo total: %10.2f%n", getTotalBalance());
        } finally {
            closeBank.unlock();
        }
        }

    public double getTotalBalance() {
        double AcountsTotal=0;
        for(double a: cuentas) {
            AcountsTotal+=a;
        }
        return AcountsTotal;
    }
}
class ExecuteTransfer implements Runnable{
    private Acounts banco;
    private int origen;
    private double maximo;
    public ExecuteTransfer(Acounts banco, int origen, double maximo) {
        this.banco=banco;
        this.origen=origen;
        this.maximo=maximo;
    }
    public void run() {
        try {
            while(true) {

                int toTheAccount=(int)(Math.random()*100);
                double AmmountTrans=maximo*Math.random();
                banco.transfer(origen, toTheAccount, AmmountTrans);
                Thread.sleep(6000);
            }
        }catch(InterruptedException e) {

        }
    }
}