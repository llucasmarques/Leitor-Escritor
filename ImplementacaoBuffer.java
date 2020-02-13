/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leitor_escritor;

public class ImplementacaoBuffer implements Buffer {

    private int buffer = 0;

    private boolean occupied = false;

    public synchronized void escrever(int value) {

        while (occupied) {

            try {

                wait();

            } catch (InterruptedException exception) {

                exception.printStackTrace();

            }

        }

        this.buffer = value;

        occupied = true;

        System.out.print("\n" + "ESCREVEU " + buffer + "\n");

        notifyAll();

    }

    public synchronized int ler() {

        while (!occupied) {

            try {

                if (buffer == 0) {

                    wait();

                }

            } catch (InterruptedException exception) {

                exception.printStackTrace();

            }

        }

        occupied = false;

        if (buffer != 0) {

            System.out.print("\n" + "LEU " + buffer + "\n");

        }

        buffer = 0;

        System.out.print("\n" + "LEITOR ALTEROU BUFFER PARA : " + buffer + "\n");

        notify();

        return buffer;

    }
}
