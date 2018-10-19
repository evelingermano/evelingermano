package br.com.evegermano.semafaro;

public class Semafaro {

	public static void main(String[] args) {

		ThreadSemaforo semaforo = new ThreadSemaforo();


		for(int i=0; i<=10; i++) {
			System.out.println(semaforo.getCor());
//			sem.setVisible(true);

			semaforo.esperaCorMudar();
		}

		semaforo.desligarSemaforo();
	}
}