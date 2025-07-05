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
@NoArgsConstructor // sıranın bı onemı yok burda ama bunlara ozel
@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	 // 1 , 2 , 3 , 4 şeklinde gitmesini sağlar
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	
	@OneToMany(mappedBy = "brand") // "Benim birçok alt varlığım var"
    @JsonManagedReference  // yenı ekldnı
	private List<Model> models;
	
	/*
	 Bu sınıf bir entity'dir.
	 Veritabanındaki tabloyu temsil eder.
	*/
	
	// @Id Bu alan veritabanındaki primary key'dir.
	// Yeni bir marka eklendiğinde, id'yi bizim vermemize gerek yok.
    // Veritabanı id'yi otomatik olarak 1, 2, 3... şeklinde arttırır.
	
}