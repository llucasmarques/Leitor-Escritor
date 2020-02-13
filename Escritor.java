/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leitor_escritor;

public class Escritor implements Runnable {

    private Buffer sharedLocation;

    private int z;

    public Escritor(Buffer shared) {

        sharedLocation = shared;

    }

    public void run() {

        for (int z = 0; z <= 120; z++) {

            sharedLocation.escrever(z);

        }

    }

}
