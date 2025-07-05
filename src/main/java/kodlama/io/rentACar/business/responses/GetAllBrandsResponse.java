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

/* BU SINIF BİR DTO (Data Transfer Object) veri taşımak için kullanılan içinde sadece veri olan basit nesnedir.
Veriyi bir yerden alır başka yere taşır. */



// response kullanıcının ıstegı uzerıne gonderılen data   burada bana 250nk ları getırıyor
// request  kullanıcın istedigi girdigi data mesela sahıbındende 250nk dıye aradım 