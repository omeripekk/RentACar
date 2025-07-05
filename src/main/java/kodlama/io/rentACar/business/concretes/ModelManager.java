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

	private ModelRepository modelRepository;        // Veritabanı işlemlerini yapacak nesne
	private ModelMapperService modelMapperService;  // Entity-DTO dönüşümünü yapacak nesne
	 // private final BrandRepository brandRepository; 

	
	@Override
	public List<GetAllModelsResponse> getAll() {
      List<Model> models = modelRepository.findAll(); // Veritabanından tüm Model kayıtlarını getir
		
  	// Her bir Model nesnesini GetAllModelsResponse türüne dönüştür
		  List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model->this.modelMapperService
					   .forResponse() // Dönüştürücü başlat
				   .map(model,GetAllModelsResponse.class))  // Çevir
              .collect(Collectors.toList()); //  Listeye çevir
				
         // Listeyi döndür
		 return modelsResponse;
	
	}
	
	

	
	/*
	@Override
	public void add(CreateModelRequest createModelRequest) {
	    // Yeni bir Model nesnesi oluştur
	    Model model = new Model();
	    model.setName(createModelRequest.getName());

	    // İlgili brandId’ye sahip Brand’i veritabanından bul
	    Brand brand = brandRepository.findById(createModelRequest.getBrandId())
	                                 .orElseThrow(() -> new RuntimeException("Brand bulunamadı"));

	    // Model nesnesine Brand'i set et
	    model.setBrand(brand);

	    // Veritabanına kaydet
	    this.modelRepository.save(model);
	} */


	@Override
	public void add(@RequestBody CreateModelRequest createModelRequest) {
	    Model model = this.modelMapperService.forRequest()
	                  .map(createModelRequest, Model.class);

	    this.modelRepository.save(model);
	}
	
	}
