package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController // ( annotation ) REST API için web katmanı, @Controller + @ResponseBody birleşimi
@RequestMapping("/api/brands")
public class BrandsController {
  private BrandService brandService;

  
@GetMapping() // Tüm markaları getir
public List<GetAllBrandsResponse> getAll(){
	return brandService.getAll();
    }


@GetMapping("/{id}") // ID'ye gore marka getır
public GetByIdBrandResponse getById(@PathVariable  int id){
	return brandService.getById(id);
    } 


@PostMapping() // Yenı marka ekle
@ResponseStatus(code=HttpStatus.CREATED)  // Başarılı ekleme işlemi sonrası 201 döner
public void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest) {
    this.brandService.add(createBrandRequest);
  }

@PutMapping // Var olan markayı guncelle
public void update(@RequestBody() @Valid UpdateBrandRequest updateBrandRequest) {
    this.brandService.update(updateBrandRequest);
   }


@DeleteMapping("/{id}") // ID'ye gore marka sıl
public void delete(@PathVariable int id) { // URL'deki id parametresini aldık
	this.brandService.delete(id); // Aldığımız id'yi brandService'in delete metoduna gönderdik
	// @PathVariable, URL’den parametre alır, metoda gönderir.
     } 

}  


// @RestController, bu sınıfın bir REST API denetleyicisi olduğunu Spring'e bildirir. Otomatik olarak @Controller ve @ResponseBody birleşimidir, yani metotlar direkt JSON veya XML döner.
// @RequestMapping, bir sınıf veya metodu belirli bir URL’ye bağlamak için kullanılır. Genelde sınıf seviyesinde kullanılır ve temel adresi tanımlar (örnek: /api/brands).
// @GetMapping, HTTP GET isteği ile çalışan bir metodu tanımlar. Tarayıcıdan veri çekmek veya listelemek için kullanılır (örnek: ürünleri listele).

// @RestController Bu sınıf internetten gelen istekleri (örneğin: bir uygulama ya da tarayıcıdan) karşılayacak bir sınıf demek. Yani bu sınıf, dışarıya veri verip veri alan bir kapı gibi çalışıyor.
// @RequestMapping Bu, gelen isteğin hangi adrese (URL’ye) yönlendirileceğini belirler. Mesela: /api/brands adresine gelen istekler bu sınıfa gelir demek.
// @GetMapping Bu, "bana verileri göster" isteğidir (GET isteği). Mesela ürünleri listelemek veya verileri göstermek istediğimizde bu kullanılır.