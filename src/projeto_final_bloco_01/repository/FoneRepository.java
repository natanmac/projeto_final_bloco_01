package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Fone;

public interface FoneRepository {

	public void procurarPorID(int id);
	public void listarTodos();
	public void cadastrar(Fone fone);
	public void atualizar(Fone fone);
	public void deletar(int id);
	
}
