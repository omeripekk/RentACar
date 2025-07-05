package kodlama.io.rentACar.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentACar.entities.concretes.Brand;

@Repository // Veritabanı ile ilgili sorguları yapan arayüz (CRUD işlemleri için)
public interface BrandRepository extends JpaRepository<Brand,Integer>{
	// JpaRepository  Brand tablosu için CRUD işlemlerini otomatik sağlar
	// Brand  Entity sınıfı  Integer  ID (primary key) tipi

	boolean existsByName(String name);  // exists turkcesı var olmak  // sprıng jpa keywords
	  // Belirtilen isimde bir marka (Brand) veritabanında var mı diye kontrol eder.
      // true ya da false döner.
}
