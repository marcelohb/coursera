package main.br.com.coursera.util;

public class Apresentacao {
	
	public void telaInicial() {
		System.out.println("/****************************************/");
		System.out.println("/*************** J O G O ****************/");
		System.out.println("/**************** D A S *****************/");
		System.out.println("/*********** P A L A V R A S ************/");
		System.out.println("/****************************************/");
	}
	
	public void escolherJogo() {
		System.out.println("/****************************************/");
		System.out.println("/**                                    **/");
		System.out.println("/** 1 - INICIAR                        **/");
		System.out.println("/**                                    **/");
		System.out.println("/** 2 - ESCOLHER MODO DE JOGO          **/");
		System.out.println("/**                                    **/");
		System.out.println("/****************************************/");
	}
	
	public void escolherModoDeJogo() {
		System.out.println("/****************************************/");
		System.out.println("/**                                    **/");
		System.out.println("/** 1 - FACIL                          **/");
		System.out.println("/**                                    **/");
		System.out.println("/** 2 - MEDIO                          **/");
		System.out.println("/**                                    **/");
		System.out.println("/** 3 - DIFICIL                        **/");
		System.out.println("/**                                    **/");
		System.out.println("/****************************************/");
	}
	
	public void vamosLa() {
		System.out.println("/****************************************/");
		System.out.println("/********** V A M O S  L Á **************/");
		System.out.println("/****************************************/");
	}
	
	public void escreverPalavra(String s) {
		int t = new Float((s.length()+2)/2).intValue();
		s = " " + s + " "; 
		int dif = 0,ed = 18-t;
		String e = "*";
		String d = "*";
		for (int i = 0; i<ed; i++) {
			e += "*"; d += "*";
		}
		if ((e.length()+s.length()+d.length()) > 38) {
			dif = (e.length()+s.length()+d.length())-38;
			d = d.substring(0,d.length()-dif);
		}
		System.out.println("/****************************************/");
		System.out.println("/*" + e + s + d + "*/");
		System.out.println("/****************************************/");
	}

	public void perdeu() {
		System.out.println("/****************************************/");
		System.out.println("/**  FROM FROM FROM FROM FROM FROM FROM */");
		System.out.println("/****************************************/");
		System.out.println("/*** V O C E    P E R D E U *************/");
		System.out.println("/****************************************/");
	}

	public void fimDeJogo() {
		System.out.println("/****************************************/");
		System.out.println("/**     F I M      D E    J O G O      **/");
		System.out.println("/****************************************/");
	}

	public void pontuacao(Double pontos) {
		int ed=19,dif=0;
		ed -= new Float(pontos.toString().length()/2).intValue();
		String e = "*";
		String d = "*";
		for (int i = 0; i<ed; i++) {
			e += "*"; d += "*";
		}
		if ((e.length()+pontos.toString().length()+d.length()) > 38) {
			dif = (e.length()+pontos.toString().length()+d.length())-38;
			d = d.substring(0,d.length()-dif);
		}
		
		System.out.println("/****************************************/");
		System.out.println("/**   P O N T U A C A O    F I N A L   **/");
		System.out.println("/****************************************/");
		System.out.println("/*" + e + pontos + d + "*/");
	}

}
