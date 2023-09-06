package javaeetutorials.jpa.orm.relationship;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ARTIST_CUSTOM")
public class Artist {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "jnd_art_on_cd",
            joinColumns = @JoinColumn(name = "art_fk"),
            inverseJoinColumns = @JoinColumn(name = "cd_fk"))
    private List<CD> cds;

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

    public List<CD> getCds() {
        return cds;
    }

    public void setCds(List<CD> cds) {
        this.cds = cds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) && Objects.equals(name, artist.name) && Objects.equals(cds, artist.cds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cds);
    }
}