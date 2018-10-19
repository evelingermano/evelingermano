package br.com.evegermano.semafaro;


	public class ThreadSemaforo implements Runnable {
		private static CorSemaforo cor;	//Cores das L�mpadas
		private boolean parar;		//Para o funcionamento do sem�foro
		private boolean corMudou;	//Indica mudan�a da cor ativa

		//**********************************************************
		// M�todo Construtor
		//**********************************************************
		public ThreadSemaforo() {
			this.cor = CorSemaforo.AMARELO;
			new Thread(this).start();
		}

		//**********************************************************
		// M�todo Construtor
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
		// M�todo para mudan�a da cor ativa do sem�foro
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
