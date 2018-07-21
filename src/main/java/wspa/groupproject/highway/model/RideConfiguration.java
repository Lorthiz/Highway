package wspa.groupproject.highway.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RideConfiguration {

    private List<User> instructors;
    private List<Vehicle> vehicles;
}
