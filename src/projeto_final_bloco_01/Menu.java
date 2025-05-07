package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.FoneController;
import projeto_final_bloco_01.model.Fone;
import projeto_final_bloco_01.model.FoneComFio;
import projeto_final_bloco_01.model.FoneSemFio;

public class Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		FoneController fone = new FoneController();
		
		int option, tipo, cargasBateria, microfone, id;
		String modelo, cor, formato;
		float preco;
		boolean microfoneBoolean = false;
		
		FoneComFio fcf = new FoneComFio("Samsumg PRO X", "Preto", 150, fone.gerarId(), 1, "Supra-auricular", true);
		fone.cadastrar(fcf);
		
		FoneSemFio fsf = new FoneSemFio("Phillips", "Branco", 200, fone.gerarId(), 3, "Intra-auricular", 4);
		fone.cadastrar(fsf);
		
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
					
					System.out.println("Digite o modelo do produto: ");
					sc.skip("\\R");
					modelo = sc.nextLine();
					
					System.out.println("Digite o preço do produto: ");
					preco = sc.nextFloat();
					
					System.out.println("Digite a cor do produto: ");
					sc.skip("\\R");
					cor = sc.nextLine();
					
					System.out.println("Digite o tipo do produto: (1 - USB-C; 2 - P10; 3 - Wireless");
					tipo = sc.nextInt();
					
					System.out.println("Digite o formato do produto: ");
					sc.skip("\\R");
					formato = sc.nextLine();
					
					switch(tipo) {
						case 1, 2 -> {
							System.out.println("Contém microfone? (1 - SIM; 2 - NÃO");
							microfone = sc.nextInt();
							if(microfone == 1) {
								microfoneBoolean = true;
							} else if(microfone == 2) {
								microfoneBoolean = false;
							}
							fone.atualizar(new FoneComFio(modelo, cor, preco, fone.gerarId(), tipo, formato, microfoneBoolean));
						}
						case 3 -> {
							System.out.println("Quantas cargas de bateria o fone tem?");
							cargasBateria = sc.nextInt();
							fone.atualizar(new FoneSemFio(modelo, cor, preco, fone.gerarId(), tipo, formato, cargasBateria));
						}
					}
					
					keyPress();
					break;
				case 2:
					System.out.println("Listar todos os fones");
					
					fone.listarTodos();
					
					keyPress();
					break;
				case 3:
					System.out.println("Consultar produto por ID");
					
					System.out.println("Digite o ID do produto: ");
					id = sc.nextInt();
					
					fone.procurarPorID(id);
					
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar produto");
					
					System.out.println("Digite o ID do produto: ");
					id = sc.nextInt();
					
					Optional<Fone> fones = fone.buscarNaCollection(id);
					
					if(fones.isPresent()) {
						System.out.println("Digite o modelo do produto: ");
						sc.skip("\\R");
						modelo = sc.nextLine();
						
						System.out.println("Digite o preço do produto: ");
						preco = sc.nextFloat();
						
						System.out.println("Digite a cor do produto: ");
						sc.skip("\\R");
						cor = sc.nextLine();
						
						System.out.println("Digite o tipo do produto: (1 - USB-C; 2 - P10; 3 - Wireless");
						tipo = sc.nextInt();
						
						System.out.println("Digite o formato do produto: ");
						sc.skip("\\R");
						formato = sc.nextLine();
						
						switch(tipo) {
							case 1, 2 -> {
								System.out.println("Contém microfone? (1 - SIM; 2 - NÃO");
								microfone = sc.nextInt();
								if(microfone == 1) {
									microfoneBoolean = true;
								} else if(microfone == 2) {
									microfoneBoolean = false;
								}
								fone.cadastrar(new FoneComFio(modelo, cor, preco, id, tipo, formato, microfoneBoolean));
							}
							case 3 -> {
								System.out.println("Quantas cargas de bateria o fone tem?");
								cargasBateria = sc.nextInt();
								fone.cadastrar(new FoneSemFio(modelo, cor, preco, id, tipo, formato, cargasBateria));
							}
						}
					} else {
						System.out.printf("\nO produto ID: %d não existe!", id);
					}
					
					keyPress();
					break;
				case 5:
					System.out.println("Deletar produto");
					
					System.out.println("Digite o ID do Produto: ");
					id = sc.nextInt();

					fone.deletar(id);
					
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
