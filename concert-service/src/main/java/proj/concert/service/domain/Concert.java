package proj.concert.service.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import proj.concert.common.dto.PerformerDTO;

@Entity
@Table(name = "CONCERTS")
public class Concert{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(columnDefinition = "TEXT")
    private String blrb;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "CONCERT_DATES", joinColumns = @JoinColumn(name = "CONCERT_ID"))
    @Column(name = "DATE")
    private Set<LocalDateTime> dates = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "CONCERT_PERFORMER", joinColumns = @JoinColumn(name = "CONCERT_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID", nullable = false))
    @Fetch(FetchMode.SUBSELECT)
    private Set<Performers> performers = new HashSet<>();

    public Concert() {}

    public Concert(Long id, String title, String imageName, String blrb) {
        this.id = id;
        this.title = title;
        this.imageName = imageName;
        this.blrb = blrb;
    }

    public Concert(String title, String imageName) {
        this.title = title;
        this.imageName = imageName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBlurb() {
        return blrb;
    }

    public void setBlurb(String blrb) {
        this.blrb = blrb;
    }

    public Set<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(Set<LocalDateTime> dates) {
        this.dates = dates;
    }

    public Set<Performers> getPerformers() {
        return performers;
    }

    public void setPerformers(Set<Performers> performers) {
        this.performers = performers;
    }


}















