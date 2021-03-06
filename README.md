# Movie Shop

## Spring & Docker Uygulaması

![](spring-boot-docker.png)

### Spring Nedir?
Spring Java için geliştirilmiş, açık kaynak olan bir uygulama geliştirme framework'üdür. Spring Framework'ün temel özellikleri harhangi bir Java uygulaması tarafından kullanılabilmektedir. Eklentileri ile birlikte Java Enterprise platform üzerinde web uygulamaları ve mikroservisler geliştirmek için de kullanılabilir.

### Docker Nedir?

Docker, uygulamalarınızı hızla derlemenize, test etmenize ve dağıtmanıza imkan tanıyan bir yazılım platformudur. Docker, yazılımları kitaplıklar, sistem araçları, kod ve çalışma zamanı dahil olmak üzere yazılımların çalışması için gerekli her şeyi içeren container adlı standartlaştırılmış birimler halinde paketler. Docker'ı kullanarak her ortama hızla uygulama dağıtıp uygulamaları ölçeklendirebilir ve kodunuzun çalışacağından emin olabilirsiniz.

### Docker Nasıl Çalışır?
Docker, kodunuzu çalıştırmanın standart bir yolunu sağlayarak çalışır. Docker, konteyner'lara yönelik bir işletim sistemidir. Bir sanal makinenin sunucu donanımını sanallaştırmasına (doğrudan yönetme gereksinimini ortadan kaldırma) benzer şekilde konteyner'lar da bir sunucunun işletim sistemini sanallaştırır. Docker her sunucuya yüklenir ve konteyner'ları oluşturmak, başlatmak veya durdurmak için kullanabileceğiniz basit komutlar sağlar.

### Kullanılan Araçlar

```
JDK: v11.0.11
Maven: v3.8.1
Docker: v20.10.7
```

### Endpointler

```
GET: /api/v1/directors
GET: /api/v1/directors/{id}
GET: /api/v1/directors?name
GET: /api/v1/directors?surname
POST: /api/v1/directors | params: {name: String, surname: String}
GET: /api/v1/movies
GET: /api/v1/movies/{id}
GET: /api/v1/movies?name
POST: /api/v1/movies | params: {name: String, rank: int, directorId: UUID}
```

### Docker Kullanım Talimatları

1. Projeyi tamamladıktan sonra konteynerlaştırmak istediğimiz versiyoununun .jar ya da .war paketini oluşturmalıyız.
2. mvn clean -> Build Project -> mvn install işlemleri ile /target dizini içerisinde .jar ya da .war paketi oluşacaktır.
3. Projenin en üst dizini içerisinde Dockerfile dosyasını oluşturuyoruz ve gerekli konfigürasyonlarını yapıyoruz.
    ```
    # Dockerfile
    
    /* Projemizin teknolojisine göre seçiyoruz. (Docker Hub içerisinden bulabiliriz.) */ 
    FROM openjdk:11
    
    /* Konteynerımızı hangi dizinde oluşturmak istediğimizi belirliyoruz. */
    WORKDIR /app
    
    /* İmajını oluşturmak istediğimiz dosyayı belirtiyoruz. /target içerisinden /app içersine imaj kopyalıyoruz. */
    COPY target/movie-shop-0.0.1-SNAPSHOT.jar movie-shop-0.0.1-SNAPSHOT.jar
    
    /* Kullanılacak komutun argümanlarını belirtiyoruz. */
    ENTRYPOINT ["java", "-jar", "movie-shop-0.0.1-SNAPSHOT.jar"]
    ```
4. Projemizin içerisindeyken Dockerfile konfigürasyonu tamamlandıktan sonra imajımızı oluşturmak için şu komutları
   giriyoruz.
    - movieshop ismiyle tag'leyip, versiyonunu belirtiyoruz. Nokta da Dockerfile dosyasını bulmaya yarıyor.
        > docker build -t movieshop:0.0.1 .
    - Bu komut movishop ismiyle önceden oluşturduğumuz movieshop:0.0.1 imajını çalıştır demek.
        > docker run -d --name movieshop movieshop:0.0.1
5. Bazı Docker komutları.
    - Bu komutla şu an hangi imajların çalıştığını görebiliriz.
        > docker ps
    - Bu komut ile movieshop konteynerını dinleriz.
        > docker logs -f movieshop
    - Bu komut ile istediğimiz konteynerı sonlandırırız.
        > docker kill movieshop
    - Bu komut ile istediğimiz konteynerı sileriz. (Eğer çalışır durumdaysa --force tag'ini eklemeliyiz.)
        > docker rm movieshop (docker rm --force movieshop)
    - Bu komut ile port map'leme işlemi yapıyoruz. Yani konteynerımızdaki uygulamamızı hangi port ile erişeceğimizi
    belirliyoruz. Mesela -p 9090:8080 tag'ini yazarsak 9090 port'u üzerinden uygulamamıza erişebiliriz.
    Burada 9090 hangi port'tan erişeceğimizi, 8080 ise konteyner içerisinde uygulamanın hangi port üzerinden olduğuydu.
        > docker run -d -p 9090:8080 --name movieshop movieshop:0.0.1
    - Bu komut ile oluşturulmuş Image listesini görebiliriz.
        > docker image ls
    - Bu komut ile belirtilen ID'li image'ı silebiliriz.
        > docker rmi <ImageID>
    - Bu komut ile image'ımızın terminalini kullanabiliyoruz.
        > docker exec -it movieshop bash
6. Ayrıca aynanda birden fazla konteynerla çalışmak istiyorsak docker-compose.yml dosyası oluşturmamız gerekmektedir.
Birden fazla servis tanımlayıp aynanda çalıştırabiliriz. Mesela bu projede h2database ayrı bir konteyner olarak
kullanılacaktır. Onun için de application-docker.properties içerisinde h2database konfigürasyonlarını yaptık. Ardından
Dockerfile dosyamızı ve docker-compose.yml dosyalarımızı buna göre ayarladık.
    - docker-compose.yml dosyasını çalıştırmak için de şu komut gereklidir.
        > docker-compose up
