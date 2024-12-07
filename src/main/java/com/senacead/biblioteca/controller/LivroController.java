package com.senacead.biblioteca.controller;

import com.senacead.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LivroController {

    private final List<Livro> listaLivros = new ArrayList<>();

@GetMapping ("/home")
    public String home(){
    return "index";
}

@GetMapping ("/login")
    public String login(){
    return "login";
}

    @GetMapping ("/cadastrarlivros") //chama o form de cadastro de livro
    public String cadastrarLivros( Model model){
    model.addAttribute("livro", new Livro());
        return "cadastrarlivros";
    }

@PostMapping("/salvarlivros") // recebe os dados do forms de cadastro de livro e salva na lista de livros
    public String salvarLivros (@ModelAttribute Livro livro, Model model) {
    livro.setId(listaLivros.size() + 1);//adiciona id
    livro.setLido(false); // informação default se ele nao foi lido
    listaLivros.add(livro); // insere na lista de livros
    return "redirect:/listarlivros"; // chama a lista de livros salvos
}

@GetMapping("/listarlivros")
    public String listarLivros(Model model) {
    model.addAttribute("lista", listaLivros);
    return "listarlivros";
}

}
