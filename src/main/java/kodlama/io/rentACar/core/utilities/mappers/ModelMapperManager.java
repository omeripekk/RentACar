package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service  // @Service // İş mantığını içeren servis bileşeni
@AllArgsConstructor
public class ModelMapperManager  implements ModelMapperService{

	private ModelMapper modelMapper;
		
	@Override
	public ModelMapper forResponse() {
		 // Cevap verirken kullanılır, biraz esnek eşleştirir
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true) // Belirsizlik yok sayılacak mı? 
		.setMatchingStrategy(MatchingStrategies.LOOSE); // Loose gevşek oluyor maplenmıyorsa bana kızma ( Esnek  eşleştirme )
	
		return this.modelMapper ;
	}

	@Override
	public ModelMapper forRequest() {
		  // İstek alırken kullanılır, tam eşleşme ister
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true) // Belirsizlik yok sayılacak mı?
		.setMatchingStrategy(MatchingStrategies.STANDARD); // Her şey maplensın maplenmıyorsa bana kız ( Sıkı eşleştirme )
		
		return this.modelMapper;
	}

}
