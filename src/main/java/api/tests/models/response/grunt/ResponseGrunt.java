package api.tests.models.response.grunt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseGrunt{

	private List<ResponseGruntItem> responseGrunt;
}