package kodlama.io.rentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentACar.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication   // Spring Boot uygulaması olduğunu belirtir, otomatik konfigürasyonları yapar
@RestControllerAdvice    // Controller’larda oluşan istisnaları (exception) merkezi olarak yakalamak için
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	
	
	@ExceptionHandler   // BusinessException türündeki hataları yakalar
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)  // HTTP 400 döner
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
	
		return problemDetails;
	}
	


@ExceptionHandler   // Doğrulama hatalarını yakalar (ör: @Valid uyarınca)
@ResponseStatus(code = HttpStatus.BAD_REQUEST) // HTTP 400 döner
public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
    ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
    validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
    validationProblemDetails.setValidationErrors(new HashMap<>());

    // Her bir alan hatasını alıp map’e ekler (alan adı -> hata mesajı)
    for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
        validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return validationProblemDetails;
}
	
	@Bean   // Spring konteynerıne ModelMapper nesnesını ekler ıhtiyac halinde otomatik kullanılır
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}  
}

