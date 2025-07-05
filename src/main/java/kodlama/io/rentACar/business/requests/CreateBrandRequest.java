package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateBrandRequest {
	@NotNull // bu alan boş olamaz 
    @NotBlank // bu alanın boş veya boşluk karakterlerden olusmamasını belirtir
    @Size(min = 3, max = 20)
	private String name;

}

