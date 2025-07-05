package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBrandRequest {
    private int id;
	private String name;
}

// create yaparken ıd gormeyız bılmeyız ama guncelleme (update) yaparken neyı guncelleyecegımı bılmek gormek ısterım