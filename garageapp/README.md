# GarageApp

Garaj uygulaması, müşterilerinize park etmek için otomatik bir bilet sistemi sunar. Bu uygulama, Java Spring Boot kullanılarak geliştirilmiştir.

## Kurulum

1. Bu depoyu klonlayın:

    ```bash
    git clone https://github.com/cetinbulut/garage-app.git
    ```

2. Proje dizinine gidin:

    ```bash
    cd garage-app
    ```

3. Uygulamayı başlatın:

    ```bash
    ./mvnw spring-boot:run
    ```

4. Tarayıcınızda `http://localhost:8080/garage` adresine giderek uygulamaya erişebilirsiniz.

## Kullanım

Uygulama, aşağıdaki API'ler üzerinden kullanılabilir:

- **/garage/park** (POST): Yeni bir aracı garaja park etmek için kullanılır. Parametreler:
    - `plate`: Araç plakası
    - `color`: Araç rengi
    - `type`: Araç tipi (car, jeep, truck)

- **/garage/leave** (POST): Bir aracı garajdan çıkarmak için kullanılır. Parametre:
    - `orderNum`: Park edilen aracın sıra numarası

- **/garage/status** (GET): Garajdaki araçların durumunu gösterir.

## Örnek Kullanım

- Bir otomobil park etmek için:

    ```bash
    curl -X POST "http://localhost:8080/garage/park?plate=34-ASD-123&color=Black&type=car"
    ```

- Bir jeep park etmek için:

    ```bash
    curl -X POST "http://localhost:8080/garage/park?plate=34-QWE-456&color=Green&type=jeep"
    ```

- Bir kamyon park etmek için:

    ```bash
    curl -X POST "http://localhost:8080/garage/park?plate=34-ZXC-789&color=Red&type=truck"


- Bir aracı garajdan çıkarmak için:

    ```bash
    curl -X POST "http://localhost:8080/garage/leave?orderNum=1"
    ```

- Garajdaki araç durumunu görüntülemek için:

    ```bash
    curl -X GET "http://localhost:8080/garage/status"
    ```

## Postman
Örnek kullanımları Postman scripti ile yapmak için proje kök dizini içine eklenmiş GarageApp.postman_collection.json dosyasını Postman ile import edebilirsiniz.