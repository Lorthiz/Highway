package wspa.groupproject.highway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rides")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private int length;

    @ManyToOne
    private User student;

    @ManyToOne
    private User instructor;

    @ManyToOne
    private Vehicle vehicle;

    @OneToMany
    private List<Comment> commentList;

}
