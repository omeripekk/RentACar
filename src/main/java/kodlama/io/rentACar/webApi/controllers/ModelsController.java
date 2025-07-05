package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController // ( annotation ) REST API için web katmanı, @Controller + @ResponseBody birleşimi
@RequestMapping("/api/models")
public class ModelsController {
	private ModelService modelService;
	  
	@GetMapping()   // Tum modellerı lıstelemek icin HTTP GET istegı
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	    }


@PostMapping()  // Yenı model eklemek ıcın HTTP POST ısteğı
@ResponseStatus(code=HttpStatus.CREATED)  // Başarılı ekleme sonrası HTTP 201 (Created) döner
public void add(@RequestBody() @Valid  CreateModelRequest createModelRequest) {
    this.modelService.add(createModelRequest); 
  }
	

}
