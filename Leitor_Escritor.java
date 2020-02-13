/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leitor_escritor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Leitor_Escritor {

    public static void main(String[] args) {
        ExecutorService executar_leitor = Executors.newFixedThreadPool(4);
        ScheduledExecutorService executar_escritor = Executors.newScheduledThreadPool(1);
        Buffer sharedLocation = new ImplementacaoBuffer();
        try {
            executar_leitor.execute(new Leitor(sharedLocation));

            executar_escritor.scheduleAtFixedRate(new Escritor(sharedLocation), 0, 1, TimeUnit.MILLISECONDS);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        executar_leitor.shutdown();
        executar_escritor.shutdown();
    }
}
