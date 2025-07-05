package kodlama.io.rentACar.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentACar.entities.concretes.Brand;

@Repository // Veritabanı ile ilgili sorguları yapan arayüz (CRUD işlemleri burada tanımlanır) 
public interface BrandRepository extends JpaRepository<Brand,Integer>{ //  Brand -> Entity sınıfı, Integer -> ID (primary key) tipi
	// JpaRepository  Brand tablosu için CRUD işlemlerini otomatik sağlar
	// Brand  Entity sınıfı  Integer  ID (primary key) tipi
	// JpaRepository sayesinde Brand tablosu için CRUD işlemleri (create, read, update, delete) otomatik olarak sağlanır
	
	boolean existsByName(String name);  // exists turkcesı var olmak  // sprıng jpa keywords
	// Veritabanında belirtilen isimde bir marka var mı diye kontrol eder.
}
