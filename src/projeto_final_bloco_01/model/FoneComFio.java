package projeto_final_bloco_01.model;

public class FoneComFio extends Fone{
	
	private String conexao;
	private boolean microfone;
	
	
	public FoneComFio(String modelo, String cor, float preco, int id, int tipo, String formato, boolean microfone) {
		super(modelo, cor, preco, id, tipo);
		this.conexao = formato;
		this.microfone = microfone;
	}


	public String getFormato() {
		return conexao;
	}


	public void setFormato(String formato) {
		this.conexao = formato;
	}


	public boolean isMicrofone() {
		return microfone;
	}


	public void setMicrofone(boolean microfone) {
		this.microfone = microfone;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tipo de conexao do fone: " + this.conexao);
		System.out.println("Contém microfone: " + this.microfone);
	}
	
	

}
