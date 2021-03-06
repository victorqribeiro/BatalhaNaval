package Trabalho_BatalhaNaval;

import java.util.Scanner;
class BatalhaNaval{

public static void batalha (){
    System.out.println("O jogo contem:\n");
        System.out.println("|Embarcação  |Quantidade|Formato|");
        System.out.println("|Hidroaviões |         5|      A|");
        System.out.println("|Submarinos  |         4|      S|");
        System.out.println("|Cruzadores  |         3|     CC|");
        System.out.println("|Encouraçados|         2|    EEE|");
        System.out.println("|Porta-aviões|         1|   PPPP|\n");
}

public static char[][] tab (){
    char[][] tabuleiro = {
			{'A','.','C','C','.','.','.','.','.','C'},
			{'.','.','.','.','.','.','.','.','.','C'},
			{'.','.','P','P','P','P','.','.','.','.'},
			{'A','.','.','.','.','.','.','C','C','.'},
			{'.','.','A','.','S','.','.','.','.','.'},
			{'.','.','.','.','.','.','.','.','.','.'},
			{'.','S','.','.','S','.','.','.','.','A'},
			{'.','.','.','.','.','.','E','.','.','.'},
			{'S','.','.','.','.','.','E','.','.','A'},
			{'.','E','E','E','.','.','E','.','.','.'},
			};
    return tabuleiro;
}
    
public static void Tiros(char[][] nAcertados){
	int i,j;
	System.out.println("   1 2 3 4 5 6 7 8 9 10");
	for(i=0; i<nAcertados.length; i++){
		if((i+1)<10){
			System.out.print(" "+(i+1)+" ");
		}else{
			System.out.print((i+1)+" ");
		}
		for(j=0; j<nAcertados[0].length; j++){
			if(nAcertados[i][j] != 0){
				System.out.print(nAcertados[i][j]+" ");
			}else{
				System.out.print("  ");
			}
		}
		System.out.println("");
	}
}

public static void main(String[] args){
	Scanner entrada = new Scanner(System.in);
	boolean sair = false;
	Double random1, random2, random3;
	int posicao, navioY, navioX;
        
        
	String[] navios	= {"A","A","A","A","A","S","S","S","S","CC","CC","CC","EEE","EEE","PPPP"};
	int navioTotal = navios.length-1;
	//char[][] tabuleiro = new char[10][10];

	char [][] tabuleiro = BatalhaNaval.tab();

	// As linhas abaixo sorteiam as peças no tabuleiro
	/* 
	for(int i = 0; i < tabuleiro.length; i++){
		for(int j = 0; j < tabuleiro[0].length; j++){
			tabuleiro[i][j] = '.';
		}
	}
	while(navioTotal >= 0){
		int ok = 0;
		random1 = Math.ceil(Math.random() * 2)-1;
		random2 = Math.ceil(Math.random() * tabuleiro.length)-1;
		random3 = Math.ceil(Math.random() * tabuleiro[0].length)-1;
		posicao = random1.intValue();
		navioY = random2.intValue();
		navioX = random3.intValue();

		if(posicao == 1){
			if(navioX+navios[navioTotal].length() < tabuleiro[0].length){
				for(int i=0; i < navios[navioTotal].length(); i++){
					if(tabuleiro[navioY][navioX+i] == '.'){
						tabuleiro[navioY][navioX+i] = navios[navioTotal].charAt(i);
						ok++;
					}else{
						break;
					}	
				}
				if(ok == navios[navioTotal].length()){
					navioTotal--;
				}
			}
		}else{
			if(navioY+navios[navioTotal].length() < tabuleiro.length){
				for(int j=0; j < navios[navioTotal].length(); j++){
					if(tabuleiro[navioY+j][navioX] == '.'){
						tabuleiro[navioY+j][navioX] = navios[navioTotal].charAt(j);
						ok++;
					}else{
						break;
					}	
				}
				if(ok == navios[navioTotal].length()){
					navioTotal--;
				}
			}
		}
	}
	*/
	
	char[][] nAcertados = new char[10][10];
        int vezes =0;
        int Hidroavioes=0, Submarinos=0, Cruzadores = 0, Encouraçados = 0, Portaa = 0, Encouraçado = 0, Cruzador =0, Porta =0;
        
        BatalhaNaval.batalha();
        
        while(sair==false){
		Tiros(nAcertados);
		System.out.println("\nDigite as coordenadas do ataque no formato x y. Ex.: 5 3");
                System.out.println("Para sair digite 0.");
		String tiro = entrada.nextLine();
		if(tiro.equals("0")){
			sair = true;
		}else{
			vezes ++;
                        if(tiro.matches("\\d \\d") || tiro.matches("\\d{2} \\d{2}") || tiro.matches("\\d \\d{2}") || tiro.matches("\\d{2} \\d")){	
				String[] coords = tiro.split(" ");
				int coordY = Integer.parseInt(coords[0]);
				int coordX = Integer.parseInt(coords[1]);
				if(coordY > 0 && coordY < 11 && coordX > 0 && coordX < 11){
					if(nAcertados[coordY-1][coordX-1] == 0){	
					if(tabuleiro[coordY-1][coordX-1] != '.'){
						System.out.println("Acertou um "+tabuleiro[coordY-1][coordX-1]+"");
                                            switch (tabuleiro[coordY-1][coordX-1]) {
                                                case 'A':
                                                    Hidroavioes ++;
                                                    System.out.println("Afundou um Hidroavião.");
                                                    if(Hidroavioes <5){
                                                        System.out.println("Falta "+(5-Hidroavioes)+" Hidroaviões");
                                                    }
                                                    if(Hidroavioes == 5){
                                                        System.out.println("Todos os Hidroaviões foram afundados.");
                                                    }
                                                    break;
                                                case 'S':
                                                    Submarinos ++;
                                                    System.out.println("Afundou um Submarino.");
                                                    if(Submarinos <4){
                                                        System.out.println("Falta "+(4-Submarinos)+" Submarinos");
                                                    }
                                                    if(Submarinos == 4){
                                                        System.out.println("Todos os Submarinos foram afundados.");
                                                    }
                                                    break;
                                                case 'C':
                                                    if(tiro.equals("1 3") || tiro.equals("1 4")||tiro.equals("4 8") || tiro.equals("4 9")||tiro.equals("1 10") || tiro.equals("2 10")){
                                                    Cruzadores ++;
                                                    }
                                                    if(Cruzador <3){
                                                        System.out.println("Afundou um Cruzador");
                                                        System.out.print("Falta "+(3-Cruzador)+" Cruzador");
                                                        
                                                    }    
                                                    
                                                    if(Cruzadores == 6){
                                                        System.out.println("Todos os Cruzadores foram afundados.");
                                                    }
                                                    break;
                                                case 'E':
                                                    if(tiro.equals("10 4")|| tiro.equals("10 3")|| tiro.equals("10 2")|| tiro.equals("8 7")||tiro.equals("9 7")||tiro.equals("10 7")){
                                                    Encouraçados ++;
                                                    }
                                                    if(Encouraçados == 3 || Encouraçados == 6){
                                                        System.out.println("Afundou um Encoraçado.");
                                                        Encouraçado ++;
                                                    }
                                                    if(Encouraçado < 2){
                                                        System.out.print("Falta "+(2-Encouraçado)+" Encouraçados");
                                                    }
                                                    if(Encouraçados == 6){
                                                        System.out.println("Todos os Encouraçados foram afundados.");
                                                    }
                                                    break;
                                                case 'P':
                                                    Portaa ++;
                                                    if(Portaa == 4){
                                                        Porta++;
                                                        System.out.println("Afundou um Porta-avião.");
                                                        System.out.println("Todos os Porta-aviões afundaram.");
                                                    }
                                                    break;
                                                default:
                                                    break;
                                            }
					}else{
						System.out.println("Água!");
					}
					nAcertados[coordY-1][coordX-1] = tabuleiro[coordY-1][coordX-1];
				}else{
					System.out.println("Você já tentou essa coordenada.");
				}
				}else{
					System.out.println("Coordenadas devem estar entre 1 e 10.");
				}

			}else{
				System.out.println("Entrada inválida!");
			}
                        System.out.print("\n");
		}
	}
        
        System.out.println("FIM DE JOGO!!");
        System.out.println("Você atirou "+vezes+" vezes.");
        System.out.println("Você acertou "+Hidroavioes+" Hidroaviões.");
        System.out.println("Você acertou "+Submarinos+" Submarinos.");
        System.out.println("Você acertou "+Cruzador+" Cruzadores.");
        System.out.println("Você acertou "+Encouraçado+" Encouraçados.");
        System.out.println("Voce acertou "+Porta+" Porta-aviões.");
}

}

