
# Sử dụng OpenJDK 21 làm base image
FROM openjdk:21-jdk-slim

# Cài đặt Maven
RUN apt-get update && apt-get install -y maven

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép mã nguồn vào container
COPY . /app

# Đảm bảo mvnw có quyền thực thi
RUN chmod +x ./mvnw

# Biên dịch ứng dụng với Maven
RUN ./mvnw clean package -DskipTests

# Expose port nếu ứng dụng sử dụng port 8080
EXPOSE 8080

# Lệnh để chạy ứng dụng khi container khởi động
CMD ["java", "-jar", "target/webclient-0.0.1-SNAPSHOT.jar"]
