package projeto_final_bloco_01.model;

public class FoneSemFio extends Fone {
	
	String formato;
	int cargasDaBateria;
	
	public FoneSemFio(String modelo, String cor, float preco, int id, int tipo, String formato, int cargasDaBateria) {
		super(modelo, cor, preco, id, tipo);
		this.formato = formato;
		this.cargasDaBateria = cargasDaBateria;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public int getCargasDaBateria() {
		return cargasDaBateria;
	}

	public void setCargasDaBateria(int cargasDaBateria) {
		this.cargasDaBateria = cargasDaBateria;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Formato do fone: " + this.formato);
		System.out.println("Quantas cargas de bateria o fone tem: " + this.cargasDaBateria);
	}

}
