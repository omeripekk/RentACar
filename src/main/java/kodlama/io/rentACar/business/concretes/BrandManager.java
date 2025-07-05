package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service // İş mantığını içeren servis bileşeni
public class BrandManager  implements BrandService{
   private BrandRepository brandRepository;
   private ModelMapperService modelMapperService;
   private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll(){
		
		List<Brand> brands = brandRepository.findAll();  
		
		// Brand entity'lerini GetAllBrandsResponse DTO'larına dönüştürür	
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand->this.modelMapperService.forResponse()
					   .map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
				
		return brandsResponse;
	
	}
	
	
	@Override
	public void add(CreateBrandRequest createBrandRequest) {
	    // Aynı isimde marka var mı diye ıs kuralını kontrol et
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		

        // DTO'dan entity nesnesine dönüşüm yap
		Brand brand = this.modelMapperService.forRequest()
				.map(createBrandRequest, Brand.class);
				
        this.brandRepository.save(brand);	
	}


	@Override
	public GetByIdBrandResponse getById(int id) {
    Brand brand = this.brandRepository.findById(id).orElseThrow();
     
    // Entity'yi response DTO'ya donustur
        GetByIdBrandResponse response = this.modelMapperService.forResponse()
        		.map(brand, GetByIdBrandResponse.class);
        
		return response;
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) { 
		  // Update ıstegını entity'ye donustur
		Brand brand = this.modelMapperService.forRequest() 
				.map(updateBrandRequest, Brand.class); 
		this.brandRepository.save(brand);
	}


	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
		
	}
}


// @Service: Bu sınıfın bir servis (iş mantığı) sınıfı olduğunu belirtir. İş kuralları ve veri işlemleri burada yapılır, Spring bunu yönetir.

// @Autowired: (Sende yok ama bilmek için) Spring'in ilgili sınıfın örneğini otomatik olarak oluşturup buraya eklemesini sağlar. Elle nesne yaratmaya gerek kalmaz.

// @Override: Bir üst sınıf veya interface'deki metodu geçersiz kıldığını, yani kendi istediğin şekilde yeniden yazdığını belirtir.

// Controller: Kullanıcıdan veya başka uygulamalardan gelen istekleri alır, işler ve yanıt verir.

// DataAccess (Veri Erişim Katmanı): Veritabanı ile doğrudan iletişim kurar. Veri okuma, yazma, güncelleme ve silme işlemlerini yapar.

// Business (İş Katmanı): Uygulamanın iş kurallarını uygular, DataAccess katmanını kullanarak işlemleri gerçekleştirir.

// API (Sunum Katmanı): Kullanıcıya ya da dış sistemlere hizmet sunan katmandır. Business katmanını kullanarak veri döner veya veri alır.
