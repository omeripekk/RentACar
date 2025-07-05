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
@NoArgsConstructor // Parametresiz constructor (otomatik oluşturulur - Lombok)
@Entity  // verıtabanındakı tabloyu temsıl eder
public class Model {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // ID degeri 1 , 2 , 3 , 4 şeklinde artar
		@Column(name="id")
		private int id;

		@Column(name="name")
		private String name;
		
	    @Version // Optimistic Locking için kullanılır, aynı veriye eş zamanlı erişimlerde çakışmaları önler
		private int version;
			
		
		@ManyToOne  // 	"Ben bir tane ana varlığa bağlıyım"
		@JoinColumn(name="brand_id") // Bu alan, Brand tablosundaki ID ile foreign key ilişkisindedir
		private Brand brand;
		
		@OneToMany(mappedBy= "model")  // "Benim birçok alt varlığım var"
	    @JsonManagedReference  // JSON serileştirmede sonsuz döngüyü engellemek için kullanılır
		private List<Car> cars; 
		

}
