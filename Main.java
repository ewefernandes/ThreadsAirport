package view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import controller.ThreadsAirplanes;

public class Main {

	public static void main(String[] args) {
		
		Random random = new Random();
		int aviao = 0;
		int opcao = 0;
		String opc;
		Semaphore semaforo = new Semaphore(1);
		
		for (aviao = 1; aviao < 4; aviao++) {
			opcao = random.nextInt(1,3);
			if (opcao == 1) {
				opc = "norte";
				ThreadsAirplanes plane = new ThreadsAirplanes(aviao, opc, semaforo);
				plane.start();
			} else {
				opc = "sul";
				ThreadsAirplanes plane = new ThreadsAirplanes(aviao, opc, semaforo); //o que aconteceria se eu mudasse o nome
				plane.start();
			}
		}
	}

}
