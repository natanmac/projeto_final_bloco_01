package projeto_final_bloco_01.model;

import java.text.NumberFormat;

public abstract class Fone {
	
	private String modelo, cor;
	float preco;
	int id, tipo;
	
	
	public Fone(String modelo, String cor, float preco, int id, int tipo) {
		this.modelo = modelo;
		this.cor = cor;
		this.preco = preco;
		this.id = id;
		this.tipo = tipo;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void visualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		String tipo = "";
		
		switch(this.tipo) {
			case 1 -> tipo = "Fone com fio";
			case 2 -> tipo = "Fone sem fio";
			default -> tipo = "Inválido";
		}
		
		System.out.println("*****************************************************");
		System.out.println("                  DADOS DO FONE                      ");
		System.out.println("*****************************************************");
		System.out.println("Modelo do fone: " + this.modelo);
		System.out.println("Cor do fone: " + this.cor);
		System.out.println("Tipo do fone: " + tipo);
		System.out.println("ID do produto: " + this.id);
		System.out.println("Preço do produto: " + nfMoeda.format(this.preco));
	}
	

}
