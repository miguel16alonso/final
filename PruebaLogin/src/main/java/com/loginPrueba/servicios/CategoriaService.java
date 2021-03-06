package com.loginPrueba.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.loginPrueba.modelo.Categoria;
import com.loginPrueba.modelo.Producto;
import com.loginPrueba.repositorios.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {

	@Autowired CategoriaRepository categoriaRepositorio;
	
	public List<Categoria> findAll() {
		return (List<Categoria>) categoriaRepositorio.findAll();
	}	
	
	public Page<Categoria> findAllPaginated(Pageable pageable) {
		return categoriaRepositorio.findAll(pageable);
	}
	
	public Categoria save(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}
	
	public Categoria findById(Long id) {
		return categoriaRepositorio.findById(id).orElse(null);
	}
	
	public Categoria delete(Categoria categoria) {
		Categoria result = findById(categoria.getId());
		categoriaRepositorio.delete(result);
		return result;
	}
}
