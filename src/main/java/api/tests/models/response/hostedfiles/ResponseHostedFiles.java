package api.tests.models.response.hostedfiles;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHostedFiles{
	public ResponseHostedFiles() {
		super();
	}
	private List<ResponseHostedFilesItem> responseHostedFiles;
}