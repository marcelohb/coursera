package main.semana01;

public class Principal {

	public static void main(String args[]) {
		
		Paciente p1 = new Paciente(86.500, 1.8);
		Paciente p2 = new Paciente(54.980, 1.56);
		Paciente p3 = new Paciente(112.0, 1.71);
		
		p1.imprimir();
		p2.imprimir();
		p3.imprimir();
		
	}
}
