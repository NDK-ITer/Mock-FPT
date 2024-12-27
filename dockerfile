
# Sử dụng OpenJDK 21 làm base image
FROM openjdk:21-jdk-slim

# Cài đặt thư viện cần thiết (nếu có)
# RUN apt-get update && apt-get install -y <libraries>

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép mã nguồn vào container (giả sử mã nguồn của bạn ở thư mục hiện tại)
COPY . /app

# Biên dịch ứng dụng Java với Maven (hoặc Gradle) nếu cần
RUN ./mvnw clean package -DskipTests

# Expose port nếu ứng dụng sử dụng port cụ thể (ví dụ 8080)
EXPOSE 8080

# Lệnh để chạy ứng dụng khi container khởi động
CMD ["java", "-jar", "target/your-app.jar"]
