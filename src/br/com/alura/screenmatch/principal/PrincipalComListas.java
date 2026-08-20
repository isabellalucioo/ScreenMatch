package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    static void main(String[] args) {
        Filme meuFilme = new Filme("Hairspray", 2007);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        Filme filmeDoPaulo = new Filme("Dogvile", 2003);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost", 2000);

        List<Titulo> lista = new LinkedList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item: lista){
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        List<String> buscaporArtista = new ArrayList<>();
        buscaporArtista.add("Adam Sandler");
        buscaporArtista.add("Paulo");
        buscaporArtista.add("Jacqueline");
        System.out.println(buscaporArtista);

        Collections.sort(buscaporArtista);
        System.out.println("Depois de Ordenar");
        System.out.println(buscaporArtista);

        System.out.println("Lista de Titulos Ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);



    }
}
