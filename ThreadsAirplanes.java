package controller;

import java.util.concurrent.Semaphore;

public class ThreadsAirplanes extends Thread {
	
	private int aviao;
	private String opc;
	Semaphore semaforo;
	
	public ThreadsAirplanes(int aviao, String opc, Semaphore semaforo) {
		this.aviao = aviao;
		this.opc = opc;
		this.semaforo = semaforo;
	}

	public void run() {
		EscolhePista();
		
		try {
			semaforo.acquire();
			EntraPista(); //CRÍTICO
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		semaforo.release();
		
		Manobrar();
		Taxiar();
		Decolar();
		Afastamento();
	}
	
	public void EscolhePista() {
		System.out.println("O aviao " +aviao+ " vai usar a pista " +opc+ ".");
	}
	
	public void EntraPista() {
		System.out.println("O aviao " +aviao+ " entrou na pista " +opc+ ".");
	}
	
	public void Manobrar() {
		int tempo = (int) ((Math.random() * 4100) + 3000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao " +aviao+ " fez a manobra em " +(tempo/1000)+ " segundos.");
	}
	
	public void Taxiar() {
		int tempo = (int) ((Math.random() * 5100) + 5000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao " +aviao+ " taxiou em " +(tempo/1000)+ " segundos.");
	}
	
	public void Decolar() {
		int tempo = (int) ((Math.random() * 3100) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao " +aviao+ " decolou em " +(tempo/1000)+ " segundos.");
	}
	
	public void Afastamento() {
		int tempo = (int) ((Math.random() * 5100 ) + 3000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao " +aviao+ " fez o afastamento em " +(tempo/1000)+ " segundos.");
	}
	
	
	
	
	
}
