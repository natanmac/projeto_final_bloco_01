package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

import projeto_final_bloco_01.model.FoneComFio;
import projeto_final_bloco_01.model.FoneSemFio;

public class Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int option;
		
		FoneComFio fcf = new FoneComFio("Samsumg PRO X", "Preto", 150, 1, 1, "Intra auricular", true);
		fcf.visualizar();
		
		FoneSemFio fsf = new FoneSemFio("Phillips", "Branco", 200, 2, 2, "Intra auricular", 4);
		fsf.visualizar();
		
		while(true) {
			
			System.out.println("******************************************");
			System.out.println("Gerenciador de Ecommerce - Fones Brazukas ");
			System.out.println("1 - Criar um novo produto");
			System.out.println("2 - Listar todos os fones");
			System.out.println("3 - Consultar produto por ID");
			System.out.println("4 - Atualizar produto");
			System.out.println("5 - Deletar produto");
			System.out.println("6 - Fechar programa");
			System.out.println("******************************************");
			System.out.println("\nEntre com a opção desejada: ");
			
			
			option = sc.nextInt();
			
			if(option == 6) {
				System.out.println("Encerrando o gerenciador do Ecommerce - Fones Brazukas");
				sc.close();
				System.exit(0);
			}
				
			switch(option) {
				case 1:
					System.out.println("Cadastrar novo produto");
					
					
					keyPress();
					break;
				case 2:
					System.out.println("Listar todos os fones");
					
					
					keyPress();
					break;
				case 3:
					System.out.println("Consultar produto por ID");
					
					
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar produto");
					
					
					keyPress();
					break;
				case 5:
					System.out.println("Deletar produto");
					
					
					keyPress();
					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					
					keyPress();
					break;
			}
			
		}

	}
	
	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao tentar ler o teclado");
		}
	}

}
