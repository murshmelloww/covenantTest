package test.api.covenant.models.response.hostedfiles;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHostedFiles{
	public ResponseHostedFiles() {
		super();
	}
	private List<ResponseHostedFilesItem> responseHostedFiles;
}