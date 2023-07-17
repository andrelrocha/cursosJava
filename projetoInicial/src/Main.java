public class Main {
    public static void main(String[] args) {
        Filme filmeNovo = new Filme("Batman");

        String nomeAnime = "Cowboy Bepop";

        System.out.printf("Anime: %s\n", nomeAnime);

        String nomeFilme = filmeNovo.getNome();

        System.out.println(nomeFilme);

        String animeTop =   """
                            Naruto
                            Berserk
                            Outro
                            """;

        System.out.println(animeTop);

        double media = (8.5+5.9+10) / 3;

        int mediaEmInteiro = (int)media;

    }
}
