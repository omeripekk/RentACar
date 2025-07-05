package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.rentACar.entities.concretes.Model;


//Bu arayüz, Model entity'si için veritabanı işlemlerini (CRUD) yapmamıza olanak tanır
//JpaRepository sayesınde hazır metotlarla kayıt ekleme, listeleme, güncelleme ve silme işlemleri otomatık saglanır

public interface ModelRepository extends JpaRepository<Model, Integer>{
	// Model -> Entity sınıfı 	Veritabanındaki tabloyu temsil eder.
    // Integer -> Model entity'sının ID (primary key) verı tıpı
}