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
@NoArgsConstructor // sıranın bı onemı yok burda ama bunlara ozel
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	 // 1 , 2 , 3 , 4 şeklinde gitmesini sağlar
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
	@JoinColumn(name="model_id") // 'model_id' sütunu, Model tablosundaki 'id' sütununa bağlanır bağlanır (foreign key).
	// Yani her araba (Car), bir modele (Model) aittir.
	  @JsonBackReference
	private Model model;
}
