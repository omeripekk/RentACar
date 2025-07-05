package kodlama.io.rentACar.core.utilities.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{
	// Dogrulama hatalarını hangı alanda ne hata var dıye tutuyor
	private Map<String, String> validationErrors;

}
