package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllBrandsResponse {
	private int id;
    private String name;
}




//BU SINIF BİR DTO (Data Transfer Object) veri taşımak için kullanılan içinde sadece veri olan basit nesnedir. iş mantığı bulunmaz.
//Response kullanıcının ıstegı uzerıne gonderılen data ( gonderılen yanıt )
//Request  kullanıcın istedigi girdigi data  ( gelen istek )