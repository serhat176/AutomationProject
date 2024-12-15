Uçuş Arama Otomasyon Testi
Bu proje, enuygun.com web sitesinin uçuş arama ve rezervasyon sisteminin otomasyon testi için geliştirilmiştir. Proje, kullanıcıların uçuş arama, filtreleme, fiyat kontrolü ve seçim işlemlerini test etmeye yönelik olarak Cucumber ve Selenium WebDriver kullanarak yazılmıştır. Projeyi textng.xml dosyası üzerinden çalıştırabilirsiniz. Test raporuna testi koştuktan sonra yandaki dizinden ulaşabilirsiniz: \AutomationProject\target\cucumber-reports.html.

Teknolojiler
Java: Proje, Java programlama dilinde yazılmıştır.
Selenium WebDriver: Web sayfalarını otomatikleştirmek ve test etmek için kullanılır.
Cucumber: BDD (Behavior Driven Development) yaklaşımını kullanarak test senaryoları yazılır.
TestNG: Testlerin çalıştırılması ve raporlama işlemleri için kullanılır.

Proje Yapısı
1. Pages
Pages klasörü, web sayfası elemanlarını ve etkileşimleri yöneten sınıfları içerir. Bu sınıflar, test senaryolarında kullanılan sayfalara ait işlemleri içerir.
BaseTest: WebDriver'ın başlatılması ve sayfa bekleme gibi temel işlemler gerçekleştirilir.
FlightForm: Uçuş arama formu ve gerekli parametrelerle ilgili işlemler yapılır.
FlightList: Uçuş listelerinin kontrolü ve uçuşların filtrelenmesi işlemleri gerçekleştirilir.

2. StepDefinitions
StepDefinitions klasörü, Cucumber test adımlarını içerir. Burada yer alan her bir sınıf, belirli bir sayfa veya işlevle ilgili işlemleri adım adım tanımlar.
BaseTestSteps: Temel test adımları (örneğin, bekleme işlemleri) burada tanımlanır.
FlightListSteps: Uçuş listesiyle ilgili adımlar (filtrelere tıklama, uçuş seçme) burada tanımlanır.
SaatFiltrelemeSteps: Saat filtreleme ve uçuş arama senaryolarına ilişkin adımlar burada yer alır.

3. Runner
Runner klasörü, Cucumber testlerinin başlatılmasını sağlayan sınıfları içerir.
Runner_General: Cucumber testlerini çalıştırmak için kullanılan sınıf. Test raporları burada yapılandırılır.

4. Hooks
Hooks klasörü, testlerin öncesinde ve sonrasında çalıştırılacak işlemleri içerir. Testin başlatılmadan önce ve bitiminde yapılması gereken işlemleri burada tanımlayabilirsiniz.

Kullanım
1. Gerekli Bağımlılıkları Yükleyin
Proje, Maven veya Gradle gibi araçlar kullanılarak bağımlılıklar yönetilebilir. Aşağıda Maven kullanılarak bağımlılıkların eklenmesi gösterilmektedir.


2. WebDriver Kurulumu
Selenium WebDriver için ChromeDriver kullanılmıştır. chromedriver.exe dosyasını indirip projenizde belirtilen Drivers/ klasörüne yerleştirmeniz gerekmektedir.

3. Testlerin Çalıştırılması
Testleri çalıştırmak için aşağıdaki adımları takip edebilirsiniz:

Runner_General sınıfını TestNG ile çalıştırarak testlerinizi başlatın.
Cucumber senaryoları src/test/resources altında bulunan .feature dosyalarına yazılmaktadır.
Testlerin sonunda, test raporları target/cucumber-reports.html dosyasında oluşturulacaktır.
Test Senaryoları
Proje içerisinde 3 adet temel test senaryosu bulunmaktadır:

Saat Filtreleme: Uçuşlar belirli bir saat aralığına göre filtrelenir ve saatlerin doğru aralıkta olup olmadığı kontrol edilir.
Havayolu Listeleme: Belirli bir havayolu seçildikten sonra, fiyatların arttığı ve havayolunun doğru olduğu kontrol edilir.
Impacti En Yüksek Bölge: Uçuşlar seçilirken kişi sayıları ve sınıfları ayarlanır ve fiyatlar kontrol edilir.
