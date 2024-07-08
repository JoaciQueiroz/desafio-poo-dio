package br.com.dio.desafio.dominio;

public class ProgressaoDev {
    private Dev dev;
    private Bootcamp bootcamp;

    public ProgressaoDev(Dev dev, Bootcamp bootcamp) {
        this.dev = dev;
        this.bootcamp = bootcamp;
    }

    public void exibirProgresso() {
        System.out.println("Progresso do Dev: " + dev.getNome());

        System.out.println("Conteúdos Inscritos:");
        for (Conteudo conteudo : dev.getConteudosInscritos()) {
            System.out.println(" - " + conteudo.getTitulo());
        }

        System.out.println("Conteúdos Concluídos:");
        for (Conteudo conteudo : dev.getConteudosConcluidos()) {
            System.out.println(" - " + conteudo.getTitulo());
        }

        double progresso = calcularProgresso();
        System.out.println("Progresso: " + String.format("%.2f", progresso) + "%");
        System.out.println();
    }

    private double calcularProgresso() {
        int totalConteudos = dev.getConteudosInscritos().size() + dev.getConteudosConcluidos().size();
        int conteudosConcluidos = dev.getConteudosConcluidos().size();
        if (totalConteudos == 0) {
            return 0;
        }
        return ((double) conteudosConcluidos / totalConteudos) * 100;
    }
}

