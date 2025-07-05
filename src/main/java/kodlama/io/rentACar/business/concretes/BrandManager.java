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
			
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand->this.modelMapperService.forResponse()
					   .map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
				
		return brandsResponse;
	
	}
	
	
	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		
		Brand brand = this.modelMapperService.forRequest()
				.map(createBrandRequest, Brand.class);
/* createBrandRequest içindeki verileri Brand sınıfının alanlarına otomatik olarak atar  manuel get/set işlemlerini 
gereksiz kılar böylece birden fazla nesne olduğunda hepsini tek tek yazmaktan kurtuluruz  
Map İşlem (veri dönüştürme) */
				
        this.brandRepository.save(brand);	
	}


	@Override
	public GetByIdBrandResponse getById(int id) {
    Brand brand = this.brandRepository.findById(id).orElseThrow();
     
        GetByIdBrandResponse response = this.modelMapperService.forResponse()// modelMapperService ini gelen yanıtı ( response ) islemek için kullanıyoruz
        		.map(brand, GetByIdBrandResponse.class);
        
		return response;
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) { // dısardan bir UpdateBrandRequest aldık 
		Brand brand = this.modelMapperService.forRequest() // modelMapperService ini gelen isteği ( request ) islemek için kullanıyoruz
				.map(updateBrandRequest, Brand.class); //     updateBrandRequest içindeki verileri alıp brand sınıfına nesne( obje ) olusturuyoruz
		this.brandRepository.save(brand);
	}


	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
		
	}
}

// @Service: "Bu bir servis sınıfıdır!" der. Yani, iş mantığını (hesaplama, veri işleme gibi şeyleri) buraya yazarız ve Spring bunu yönetir.

//@Autowired: "Bunu benim yerime otomatik bağlar" der. Başka bir sınıfa ihtiyacın varsa, elle oluşturmadan Spring'in senin yerine onu eklemesini sağlar.

//@Override: Ben bu metodu değiştirdim!" diye Java'ya haber verir. Eski bir metodu alıp içeriğini kendimize göre yeniden yazarız.




// controllers ıstegın yapıldıgı yer 

// DataAccess (Veri Erisim Katmanı): Veritabanı işlemlerini yapar, veriyi okur/yazar.

// Business (İş Katmanı): İş kurallarını uygular, DataAccess’i kullanır.

// API (Sunum Katmanı): Kullanıcıya veya diğer uygulamalara hizmet verir, Business katmanını kullanır.
