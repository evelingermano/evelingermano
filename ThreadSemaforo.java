package br.com.evegermano.semafaro;


	public class ThreadSemaforo implements Runnable {
		private static CorSemaforo cor;	//Cores das Lâmpadas
		private boolean parar;		//Para o funcionamento do semáforo
		private boolean corMudou;	//Indica mudança da cor ativa

		//**********************************************************
		// Método Construtor
		//**********************************************************
		public ThreadSemaforo() {
			this.cor = CorSemaforo.AMARELO;
			new Thread(this).start();
		}

		//**********************************************************
		// Método Construtor
		//**********************************************************
		@Override
		public void run() {

			while(!parar) {
				try {
					switch (this.cor) {
					case VERMELHO: 	Thread.sleep(2000); break;
					case AMARELO: 	Thread.sleep(300); break;
					case VERDE: 	Thread.sleep(1500); break;
					}
					
					this.mudarCor(); //Mudar a cor
				}catch (Exception e) {e.printStackTrace();}
			}
		}

		//**********************************************************
		// Método para mudança da cor ativa do semáforo
		//**********************************************************
		private synchronized void mudarCor() {
			switch (this.cor) {
			case VERMELHO: this.cor = CorSemaforo.VERDE ; break;
			case AMARELO:  this.cor = CorSemaforo.VERMELHO ; break;
			case VERDE:    this.cor = CorSemaforo.AMARELO ; break;
			}
			this.corMudou = true;
			notify();
		}

		public synchronized void esperaCorMudar() {

			while(!this.corMudou) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			}
			this.corMudou = false;
		}

		public synchronized void desligarSemaforo() {
			this.parar = true;
		}	

		public CorSemaforo getCor() {
			return cor;
		}

}
