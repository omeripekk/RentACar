package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor // Parametresiz constructor (otomatik oluşturulur - Lombok)
@Entity // verıtabanındakı tabloyu temsıl eder
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	 // ID otomatık 1 , 2 , 3 , 4 seklinde artar
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	
	@OneToMany(mappedBy = "brand")  // "Benim birçok alt varlığım var"
    @JsonManagedReference  // JSON serileştirmede sonsuz döngüyü engellemek için kullanılır
	private List<Model> models;
		
}