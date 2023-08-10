package de.sdm.shell;

import de.sdm.model.Article;
import de.sdm.model.repository.ArticleRepository;
import de.sdm.util.CalculationUtils;
import de.sdm.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@ShellComponent
public class ArticleCommands {

    private final String tabbleDefinition = "| %-15s | %-6s | %-9s | %-14s |%n";
    private final String tabbleColumnLine = "---------------------------------------------------------%n";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy");

    @Autowired
    private ArticleRepository articleRepository;

    @ShellMethod(key = "all", value = "Gibt alle vorhandenen Artikel zurück")
    public void allArticles(@ShellOption(defaultValue = "spring") String arg) {
        List<Article> articles = this.articleRepository.findAll();
        if (articles != null & !articles.isEmpty()) {
            System.out.println();
            System.out.printf(this.tabbleColumnLine);
            System.out.printf("Alle Artikel:%n");
            System.out.printf(this.tabbleColumnLine);
            System.out.printf(this.tabbleDefinition, "Bezeichnung", "Preis", "Qualität", "Verfallsdatum");
            System.out.printf(this.tabbleColumnLine);

            for (Article article : articles)
                System.out.printf(this.tabbleDefinition, article.getName(), article.getPrice(),
                        article.getQuality(), DateUtils.getExpirationDate(article.getExpirationDate(), this.formatter));
        } else System.out.println("No articles found.");
    }

    @ShellMethod(key = "get for", value = "Gibt alle vorhandenen Artikel für ein bestimmtes Datum zurück")
    public void getAllArticlesByDate(@ShellOption(defaultValue = "") String dateInput) {
        if (dateInput == null || dateInput.isEmpty())
            dateInput = LocalDate.now().format(this.formatter);

        LocalDate date = null;
        try {
            date = LocalDate.parse(dateInput, this.formatter);
        } catch (Exception ex) {
            System.out.println("Falsches Datumsformat, bitte erneut versuchen. Beispiel: " + LocalDate.now().format(this.formatter));
        }

        if (date.isBefore(LocalDate.now()))
            System.out.println("Das angegebene Datum liegt in der Vergangenheit.");

        List<Article> articles = this.articleRepository.findAll();
        if (articles != null & !articles.isEmpty()) {
            System.out.println();
            System.out.printf(this.tabbleColumnLine);
            System.out.printf("Alle Artikel für : " + date.format(this.formatter) + "%n");
            System.out.printf(this.tabbleColumnLine);
            System.out.printf(this.tabbleDefinition, "Bezeichnung", "Preis", "Qualität", "Entsorgen");
            System.out.printf(this.tabbleColumnLine);

            for (Article article : articles) {
                boolean dispose = false;
                BigInteger quality = article.getQuality();

                switch (article.getType().getName()) {
                    case "Wein":
                        quality = CalculationUtils.calculateWineQuality(article.getQuality(), LocalDate.now(), date);
                        break;
                    case "Käse":
                        break;
                    case "Obst":
                        break;
                    case "Milch":
                        break;
                    default:
                        break;
                }

                System.out.printf(this.tabbleDefinition, article.getName(), article.getPrice(),
                        quality, dispose);
            }
        } else System.out.println("No articles found.");
    }
}
