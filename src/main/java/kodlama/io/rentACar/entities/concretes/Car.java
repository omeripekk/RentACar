package kodlama.io.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor // Parametresiz constructor (otomatik oluşturulur - Lombok)
@Entity // verıtabanındakı tabloyu temsıl eder
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	 // ID degeri 1 , 2 , 3 , 4 şeklinde artar
	@Column(name="id")
	private int id;
	
	@Column(name="plate" , unique = true)
	private String plate;
	
	@Column(name="dailyPrice")
	private double dailyPrice;

	@Column(name="modelYear")
	private String modelYear;
	
	@Column(name="state")
	private int state;  // 1 - Available 2 - Rented 3 - Maintenance
		
	@ManyToOne
	@JoinColumn(name="model_id")  // Bu alan, Model tablosundaki ID ile foreign key ilişkisi kurar
	@JsonBackReference   // JSON serileştirmede sonsuz döngüyü engellemek için kullanılır
	private Model model;
}


