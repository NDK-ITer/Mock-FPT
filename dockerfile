# Sử dụng image maven chính thức với OpenJDK 11
FROM maven:3.8.4-openjdk-11-slim as build

# Đặt thư mục làm việc
WORKDIR /app

# Sao chép pom.xml và cài đặt các dependency
COPY pom.xml .
RUN mvn dependency:go-offline

# Sao chép mã nguồn và build ứng dụng
COPY src ./src
RUN mvn clean package -DskipTests

# Sử dụng OpenJDK 21 cho container cuối
FROM openjdk:21-jdk-slim

WORKDIR /app

# Sao chép tệp JAR từ build stage vào container cuối
COPY --from=build /app/target/webclient-0.0.1-SNAPSHOT.jar /app/webclient-0.0.1-SNAPSHOT.jar

# Mở cổng 8080
EXPOSE 8080

# Lệnh để chạy ứng dụng
CMD ["java", "-jar", "webclient-0.0.1-SNAPSHOT.jar"]
