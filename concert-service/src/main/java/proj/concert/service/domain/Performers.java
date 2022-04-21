package proj.concert.service.domain;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import proj.concert.common.dto.PerformerDTO;
import proj.concert.common.types.Genre;


@Entity
@Table(name = "PERFORMERS")
public class Performers implements Comparable<Performers> {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(columnDefinition = "TEXT")
    private String blrb;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONCERT_ID", nullable = false)
    private List<Concert> concerts = new ArrayList<>();

    public Performers() {}

    public Performers(Long id, String name, String imageName, Genre genre, String blrb) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.genre = genre;
        this.blrb = blrb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getBlurb() {
        return blrb;
    }

    public void setBlurb(String blrb) {
        this.blrb = blrb;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Performers other = (Performers) obj;

        return new EqualsBuilder()
                .append(id, other.id)
                .append(name, other.name)
                .append(imageName, other.imageName)
                .append(genre, other.genre)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(imageName)
                .append(genre)
                .toHashCode();
    }

    @Override
    public int compareTo(Performers other) {
        return other.getName().compareTo(getName());
    }

}
