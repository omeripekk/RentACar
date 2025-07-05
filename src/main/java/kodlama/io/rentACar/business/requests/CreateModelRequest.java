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

public class CreateModelRequest {
    @NotNull // bu alan boş olamaz 
    @NotBlank // bu alanın boş veya boşluk karakterlerden olusmamasını belirtir
    @Size(min = 2, max = 20)
	private String name;
    @NotNull
	private int brandId;

}


// BU SINIF BİR DTO (Data Transfer Object) veri taşımak için kullanılan içinde sadece veri olan basit nesnedir. iş mantığı bulunmaz.
// Response kullanıcının ıstegı uzerıne gonderılen data ( gonderılen yanıt )
// Request  kullanıcın istedigi girdigi data  ( gelen istek )