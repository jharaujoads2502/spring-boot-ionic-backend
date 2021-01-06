package com.jha.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jha.cursomc.domain.Categoria;
import com.jha.cursomc.domain.Cidade;
import com.jha.cursomc.domain.Cliente;
import com.jha.cursomc.domain.Endereco;
import com.jha.cursomc.domain.Estado;
import com.jha.cursomc.domain.Produto;
import com.jha.cursomc.domain.enums.TipoCliente;
import com.jha.cursomc.repositories.CategoriaRepository;
import com.jha.cursomc.repositories.CidadeRepository;
import com.jha.cursomc.repositories.ClienteRepository;
import com.jha.cursomc.repositories.EnderecoRepository;
import com.jha.cursomc.repositories.EstadoRepository;
import com.jha.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
    @Autowired
	private CategoriaRepository categoriaRepository;
	
    @Autowired
	private ProdutoRepository produtoRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		
		Produto p1 = new Produto(null, "Computador",2000.00);
		Produto p2 = new Produto(null, "Impressora",800.00);
		Produto p3 = new Produto(null, "Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado("Minas Gerais",null);
		Estado est2 = new Estado("São Paulo",null);
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"Sao Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"MAria Silva","maria@gmail.com","123456789812",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("35553805","91721180"));
		
		Endereco e1 = new Endereco(null,"Rua Miguel Gibrim","144","Ao lado do Bichos e Capricos","Centro","37810000",cli1,c1);
		Endereco e2 = new Endereco(null,"Rua Barao do Rio Branco","97","Ao lado da capoeira","Centro","11810000",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
