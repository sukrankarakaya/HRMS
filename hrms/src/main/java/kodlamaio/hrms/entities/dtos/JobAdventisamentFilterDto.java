package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdventisamentFilterDto {

   // private String seach;
    private List<Integer> JobPositionIds;
    private List<Integer> cityIds;
    private List<Integer> workTimeIds;
    private List<Integer> wayOfWorkIds;





}
