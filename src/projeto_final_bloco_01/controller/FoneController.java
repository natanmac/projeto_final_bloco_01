package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Fone;
import projeto_final_bloco_01.repository.FoneRepository;

public class FoneController implements FoneRepository {
	
	private ArrayList<Fone> listaFone = new ArrayList<Fone>();

	int id = 0;
	
	@Override
	public void procurarPorID(int id) {
		Optional<Fone> fone = buscarNaCollection(id);
		
		if(fone.isPresent()) {
			fone.get().visualizar();
		} else {
			System.out.printf("\nO fonde de ID: %d não foi encontrada!", id);
		}
	}

	@Override
	public void listarTodos() {
		for(var fone : listaFone) {
			fone.visualizar();
		}
	}

	@Override
	public void cadastrar(Fone fone) {
		listaFone.add(fone);
		System.out.println("Novo produto criado com Sucesso!");
	}

	@Override
	public void atualizar(Fone fone) {
		Optional<Fone> buscaFone = buscarNaCollection(fone.getId());

		if (buscaFone.isPresent()) {
			listaFone.set(listaFone.indexOf(buscaFone.get()), fone);
			System.out.printf("\nO Produto ID %d foi atualizado com sucesso!", fone.getId());
		} else {
			System.out.printf("\nO Produto ID %d não foi encontrado", fone.getId());
		}
	}

	@Override
	public void deletar(int id) {
		Optional<Fone> fone = buscarNaCollection(id);

		if (fone.isPresent()) {
			if (listaFone.remove(fone.get()) == true)
				System.out.printf("\nO fone ID %d foi excluído com sucesso!", id);
		} else {
			System.out.printf("\nO fone ID %d não foi encontrado", id);
		}
	}
	
	public int gerarId() {
		return ++id;
	}
	
	public Optional<Fone> buscarNaCollection(int numero) {
		for(var fone : listaFone) {
			if(fone.getId() == numero) {
				return Optional.of(fone);
			}
		}
		return Optional.empty();
	}

	
	
}
