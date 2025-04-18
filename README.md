# 🧩 mySpringApp — Simple User Management System

简易用户管理系统（基于 Spring Boot + MyBatis）

---

## 📖 Description / 项目介绍

This project is a simple user management system built with **Spring Boot**, **MyBatis**, and **MySQL**. It demonstrates CRUD (Create, Read, Update, Delete) operations via RESTful APIs and supports switching between JPA and MyBatis for data access.

该项目是一个基于 Spring Boot、MyBatis 和 MySQL 的简易用户管理系统，演示了通过 RESTful API 实现的用户的增删改查（CRUD）功能，支持在 JPA 和 MyBatis 数据访问方式之间切换。

---

## 🚀 Tech Stack / 技术栈

- 🌱 Java 17
- 🔧 Spring Boot 3.4.x
- 📂 MyBatis 3.0.2
- 📊 MySQL 8.x
- 🧰 Lombok, BeanUtils
- 🔍 Postman / curl (API 测试)

---

## 📦 Features / 功能亮点

- ✅ 用户添加、查询、更新、删除
- ✅ 支持前后端分离 JSON 交互
- ✅ 使用 DTO + BeanUtils 抽象字段
- ✅ MyBatis XML 动态 update (只更新非 null 字段)
- ✅ API 给回统一格式（`ResponseMessage<T>`）
- ✅ 保留了 JPA 切换支持 (SPA 模式)

---

## 📁 Project Structure / 项目结构

```
src/
👉 controller/     // 控制器层
👉 service/        // 业务逻辑层
👉 mybatis/        // MyBatis 接口
👉 repository/     // JPA 接口
👉 dto/            // 数据传输对象
👉 pojo/           // 实体类 (POJO)
👉 mapper/         // XML 映射文件
👉 config/         // 配置类
```

---

## 🔧 How to Run / 如何运行

### 📌 Prerequisites / 前置要求：

- JDK 17+
- Maven 3.6+
- MySQL (port: 3306)

### ✅ Step-by-Step / 步骤：

```bash
git clone https://github.com/comevback/mySpringApp.git
cd mySpringApp
```

配置数据库 connection：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/my_spring_sql?useSSL=false&serverTimezone=Asia/Tokyo&allowPublicKeyRetrieval=true
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.configuration.map-underscore-to-camel-case=true
```

初始化数据表：

```sql
CREATE TABLE table_user (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(100),
  password VARCHAR(100),
  email VARCHAR(100)
);
```

启动项目：

```bash
./mvnw spring-boot:run
```

---

## 📮 API Endpoints / 接口列表

| Method | Endpoint     | Description |
| ------ | ------------ | ----------- |
| POST   | `/user`      | 添加用户        |
| GET    | `/user/{id}` | 查询单个用户      |
| GET    | `/user`      | 查询所有用户      |
| PUT    | `/user/{id}` | 更新用户信息 (动态) |
| DELETE | `/user/{id}` | 删除用户        |

返回格式：

```json
{
  "code": 200,
  "message": "success!",
  "data": {...}
}
```

---

## 🧪 Example Request / 实例请求

### Add user / 添加用户

```bash
curl -X POST http://localhost:8080/user \
  -H "Content-Type: application/json" \
  -d '{
    "userName": "dundun",
    "password": "abc123",
    "email": "dundun@gmail.com"
}'
```

---

## 🧑‍💼 Author / 作者

- 👤 GitHub: [@comevback](https://github.com/comevback)
- ✉️ Email: [xuxiang5012@gmail.com](mailto\:xuxiang5012@gmail.com)

---

## 📄 License

This project is open-source and available under the MIT License.

---

