# Sử dụng image Java làm base image
FROM openjdk:17-jdk-slim

# Cài đặt thư mục làm việc trong container
WORKDIR /app

# Copy file JAR vào container
COPY target/webclient-0.0.1-SNAPSHOT.jar /app/webclient-0.0.1-SNAPSHOT.jar

# Mở cổng ứng dụng (mặc định cổng Spring Boot là 8080)
EXPOSE 7000

# Lệnh chạy ứng dụng Spring Boot
CMD ["java", "-jar", "webclient-0.0.1-SNAPSHOT.jar"]
