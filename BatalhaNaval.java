import java.util.Scanner;
class BatalhaNaval{

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
	char[][] tabuleiro = new char[10][10];
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
	
	char[][] nAcertados = new char[10][10];
        int vezes =0;
        int Hidroavioes=0, Submarinos=0;
        
	System.out.println("O jogo contem:\n");
        System.out.println("|Embarcação  |Quantidade|Formato|");
        System.out.println("|Hidroaviões |         5|      A|");
        System.out.println("|Submarinos  |         4|      S|");
        System.out.println("|Cruzadores  |         3|     CC|");
        System.out.println("|Encouraçados|         2|    EEE|");
        System.out.println("|Porta-aviões|         1|   PPPP|\n");
        
        while(sair==false){
		Tiros(nAcertados);
		System.out.println("Digite as coordenadas do ataque no formato x y. Ex.: 5 3");
		String tiro = entrada.nextLine();
		if(tiro.equals("0")){
			sair = true;
		}else{
			vezes ++;
                        if(tiro.matches("\\d \\d") || tiro.matches("\\d{2} \\d{2}") || tiro.matches("\\d \\d{2}") || tiro.matches("\\d{2} \\d")){	
				String[] coords = tiro.split(" ");
				int coordY = Integer.parseInt(coords[0]);
				int coordX = Integer.parseInt(coords[1]);
				if(nAcertados[coordY-1][coordX-1] == 0){	
					if(tabuleiro[coordY-1][coordX-1] != '.'){
						System.out.println("Acertou um "+tabuleiro[coordY-1][coordX-1]);
                                                if(tabuleiro[coordY-1][coordX-1] == 'A'){
                                                    Hidroavioes ++;
                                                            System.out.println("Afundou um Hidroavião");
                                                            if(Hidroavioes == 5){
                                                                System.out.println("Todos os Hidroaviões foram afundados");
                                                            }
                                                }else if(tabuleiro[coordY-1][coordX-1] == 'S'){
                                                    Submarinos ++;
                                                            System.out.println("Afundou um Submarino");
                                                            if(Submarinos == 4){
                                                                System.out.println("Todos os Submarinos foram afundados");
                                                            }
                                                }
					}else{
						System.out.println("Água!");
					}
					nAcertados[coordY-1][coordX-1] = tabuleiro[coordY-1][coordX-1];
				}else{
					System.out.println("Você já tentou essa coordenada.");
				}

			}else{
				System.out.println("Entrada inválida!");
			}
		}
	}
        System.out.println("Você tentou "+vezes+" vezes.");
        System.out.println("Você acertou "+Hidroavioes+" Hidroaviões.");
        System.out.println("Você acertou "+Submarinos+" Submarinos.");
}

}
