package com.example.inscripcionup.Models;

public class Monitor_secretario {
    private boolean min_hojas_esperando;
    private boolean max_hojas_esperando;
    public Monitor_secretario () {
        min_hojas_esperando = true;
        max_hojas_esperando = false;
    }
    public synchronized void wait_buffet () {
        while (!min_hojas_esperando) { //Guarda booleana
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("El secretario toma las hojas a repartir");
        min_hojas_esperando = false;
        max_hojas_esperando = true;
        this.notifyAll();
    }

    public synchronized void release_buffet () {
        while (!max_hojas_esperando) //Guarda booleana
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println("El secretario ha repartido los papeles a llenar");
        max_hojas_esperando = false;
        min_hojas_esperando = true;
        this.notifyAll();
    }
}
