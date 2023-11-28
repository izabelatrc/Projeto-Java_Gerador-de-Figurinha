package com.example.projetojavafigurinha.controller;

import java.io.InputStream;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetojavafigurinha.App;
import com.example.projetojavafigurinha.model.Figurinha;

@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping("/figurinha")
    public String getFigurinha() {
        return "figurinha";
    }

    @PostMapping("/figurinha")
    // public ModelAndView Figurinha(
    public String gerarFigurinha(Figurinha figurinha) throws Exception {
        String titulo = figurinha.getTitulo();
        String nomeArquivo = figurinha.getNomeArquivo() + ".png";
        String urlImagem = figurinha.getUrlImagem();

        InputStream inputStream = new URL(urlImagem).openStream();

        App.cria(inputStream, nomeArquivo, titulo);

        return "redirect:/figurinha";
    }

}