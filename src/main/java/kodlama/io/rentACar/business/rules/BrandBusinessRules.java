package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	
	private  BrandRepository brandRepository;
	public void checkIfBrandNameExists(String name) {
	   // Eğer verilen isimde bir marka zaten varsa hata fırlat
	   if(this.brandRepository.existsByName(name)) {
		   throw new BusinessException("Brand name already exists"); // java exception types
		   
	   }
	}
}
