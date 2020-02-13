/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leitor_escritor;

public class Leitor implements Runnable {

    private Buffer sharedLocation;

    public Leitor(Buffer shared) {

        sharedLocation = shared;

    }

    public void run() {

        for (int x = 0; x <= 120; x++) {

            sharedLocation.ler();

        }

    }

}
