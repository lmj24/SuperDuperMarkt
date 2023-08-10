package de.sdm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "article")
@Getter
@Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long quality;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="type_id", nullable=false)
    private ArticleType type;
}
