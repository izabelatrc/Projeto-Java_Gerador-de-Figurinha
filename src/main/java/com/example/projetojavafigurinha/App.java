package com.example.projetojavafigurinha;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class App {
    public static void cria(InputStream inputStream, String nomeArquivo, String titulo) throws IOException {
        // pegando a imagem e armazenado nem imagemOriginal
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar uma nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth(); // pegando a largura da imagemOriginal
        int altura = imagemOriginal.getHeight(); // pegando a altura da imagemOriginal
        int novaAltura = altura + 200;// medida em pixel

        // gerando a nova imagem com transparência
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TYPE_INT_ARGB);

        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics(); // copiando a imagem original e colocando no espaço
                                                                     // da novaImagem
        graphics.drawImage(imagemOriginal, 0, 0, null); // desenhando a imagemOriginal na novaImagem; x e y é a posição
                                                        // que vai começar a desenhar

        // escrever uma mensagem na nova imagem
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setFont(fonte);
        graphics.setColor(Color.blue);
        graphics.drawString(titulo, largura / 4, novaAltura - 80);

        // escrever (salvar) a nova imagem em um arquivo
        String saida = "src/main/java/com/example/projetojavafigurinha/saida/";
        ImageIO.write(novaImagem, "png", new File(saida + nomeArquivo));
    }
}
