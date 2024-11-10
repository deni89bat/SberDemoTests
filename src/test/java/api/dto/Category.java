package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private int id;
}
