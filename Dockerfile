# 选择 Java 21 的官方运行环境镜像
FROM eclipse-temurin:21-jdk

ENV SPRING_PROFILES_ACTIVE=docker

# JAR 包名称（Maven 编译后默认路径）
ARG JAR_FILE=target/mySpringApp-0.0.1-SNAPSHOT.jar

# 复制 jar 到容器中
COPY ${JAR_FILE} app.jar

# 启动服务
ENTRYPOINT ["java", "-jar", "/app.jar"]
