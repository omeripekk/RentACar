package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


	@Table(name="models")
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor // sıranın bı onemı yok burda ama bunlara ozel
	@Entity
	public class Model {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)	 // 1 , 2 , 3 , 4 şeklinde gitmesini sağlar
		@Column(name="id")
		private int id;

		@Column(name="name")
		private String name;
		
		   @Version
		    private int version;
			
		
		@ManyToOne  // 	"Ben bir tane ana varlığa bağlıyım"
		@JoinColumn(name="brand_id") // Bu sütun, ilişkilendirilen tablodaki id alanına karşılık gelen foreign key’dir.
		private Brand brand;
		
		@OneToMany(mappedBy= "model")  // "Benim birçok alt varlığım var"
		// mappedBy = "model" ifadesi, Car sınıfındaki 'model' alanı ile ilişkiyi belirtir.
	    @JsonManagedReference // yenı eklendı 
		private List<Car> cars; 
		

}
