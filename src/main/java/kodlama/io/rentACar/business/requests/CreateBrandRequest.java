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

/* BU SINIF BİR DTO (Data Transfer Object) veri taşımak için kullanılan içinde sadece veri olan basit nesnedir.
Veriyi bir yerden alır başka yere taşır. */



//response kullanıcının ıstegı uzerıne gonderılen data   burada bana 250nk ları getırıyor
//request  kullanıcın istedigi girdigi data mesela sahıbındende 250nk dıye aradım 
// son kullanıcıdan data alıyorsan request ona bişi veriyorsan response     istek geliypr request   yanıt verıyorsun response  