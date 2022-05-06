package proj.concert.service.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "CONCERTS")
public class Concert{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name="BLURB", length=1024)
    private String blurb;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "CONCERT_DATES", joinColumns = @JoinColumn(name = "CONCERT_ID"))
    @Column(name = "DATE")
    private Set<LocalDateTime> dates = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "CONCERT_PERFORMER", joinColumns = @JoinColumn(name = "CONCERT_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID", nullable = false))
    @Fetch(FetchMode.SUBSELECT)
    @Column(name = "PERFORMER")
    private Set<Performer> performers;
    public Concert() {}

    public Concert(Long id, String title, String imageName, String blrb, Set<Performer> performers) {
        this.id = id;
        this.title = title;
        this.imageName = imageName;
        this.blurb = blrb;
        this.performers = performers;
    }
    public Concert(Long id, String title, String imageName, String blrb) {
        this.id = id;
        this.title = title;
        this.imageName = imageName;
        this.blurb = blrb;
        //this.performers = performers;
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
        return blurb;
    }

    public void setBlurb(String blrb) {
        this.blurb = blrb;
    }

    public Set<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(Set<LocalDateTime> dates) {
        this.dates = dates;
    }

    public Set<Performer> getPerformers() {
        return this.performers;
    }

    public void setPerformers(Set<Performer> performers) {
        this.performers = performers;
    }


}