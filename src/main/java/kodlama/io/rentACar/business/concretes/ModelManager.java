package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service // İş mantığını içeren servis bileşeni
@AllArgsConstructor
public class ModelManager implements ModelService{

	private ModelRepository modelRepository;         // Veritabanı işlemlerini yapacak repository (DAO)
	private ModelMapperService modelMapperService;   // Entity ve DTO dönüşümlerini yapacak servis

	
	@Override
	public List<GetAllModelsResponse> getAll() {
      List<Model> models = modelRepository.findAll(); // Veritabanından tüm Model kayıtlarını getir
		
      // Her bir Model nesnesini GetAllModelsResponse DTO'suna dönüştür
		  List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model->this.modelMapperService
					   .forResponse()   // Response dönüşümü için mapper'i kullan
				   .map(model,GetAllModelsResponse.class))   // Model'i DTO'ya çevir
              .collect(Collectors.toList());   // Stream'deki tüm elemanları listeye çevir
				
		 return modelsResponse;  // DTO lıstesını dondur
	
	}
	
	@Override
	public void add(@RequestBody CreateModelRequest createModelRequest) {
		// CreateModelRequest DTO'sunu Model entity'sine dönüştür
	    Model model = this.modelMapperService.forRequest()
	                  .map(createModelRequest, Model.class);

	    this.modelRepository.save(model);
	}
	
}
