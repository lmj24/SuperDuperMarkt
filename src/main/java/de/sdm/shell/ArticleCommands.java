package de.sdm.shell;

import de.sdm.model.Article;
import de.sdm.model.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@ShellComponent
public class ArticleCommands {

    Logger logger = LoggerFactory.getLogger(ArticleCommands.class);

    @Autowired
    private ArticleRepository articleRepository;

    private final String tabbleDefinition = "| %-12s | %-10s | %-15s | %-10s |%n";
    private final String tabbleColumnLine = "------------------------------------------------------------%n";

    @ShellMethod(key = "all", value = "Gibt alle vorhandenen Artikel zurück")
    public void allArticles(@ShellOption(defaultValue = "spring") String arg) {
        List<Article> articles = this.articleRepository.findAll();
        if (articles != null & !articles.isEmpty()) {
            System.out.println("");
            System.out.printf(this.tabbleColumnLine);
            System.out.printf("Alle Artikel:%n");
            System.out.printf(this.tabbleColumnLine);
            System.out.printf(this.tabbleDefinition, "Bezeichnung", "Qualität", "Verfallsdatum", "Preis");
            System.out.printf(this.tabbleColumnLine);

            for (Article article : articles)
                System.out.printf(this.tabbleDefinition,
                        article.getName(), article.getQuality(), article.getExpirationDate(), article.getPrice());
        } else
            System.out.println("No articles found.");
    }

    @ShellMethod(key = "get for", value = "Gibt alle vorhandenen Artikel für ein bestimmtes Datum zurück")
    public void getAllArticlesByDate(@ShellOption String dateInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy");

        LocalDate date = null;
        try {
            date = LocalDate.parse(dateInput, formatter);
        } catch (Exception ex) {
            System.out.println("Falsches Datumsformat, bitte erneut versuchen. Beispiel: "
                    + LocalDate.now().format(formatter));
        }

        if (date.isBefore(LocalDate.now()))
            System.out.println("Das angegebene Datum liegt in der Vergangenheit.");

        
    }
}
