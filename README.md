# 🛒 Buy & Sell Portal (Spring Boot + React + GCP)

This is a full-stack web application where university students can post and explore listings to buy or sell items.  
Built using **Spring Boot**, **React**, and deployed with **Google Cloud Platform** (GCP).

---

## 🚀 Features

- User Authentication (Supabase/GCP Firebase)
- Post and browse listings with images
- Cloud-based image storage (Google Cloud Storage)
- PostgreSQL database (Supabase or Cloud SQL)
- RESTful API using Spring Boot
- Frontend built with React + Tailwind CSS

---

## 🧩 Tech Stack

| Layer       | Technology             |
|-------------|------------------------|
| Frontend    | React, Vite, Tailwind CSS |
| Backend     | Spring Boot, Java 17   |
| Auth        | Supabase Auth / Firebase Auth |
| Storage     | Google Cloud Storage   |
| Database    | Supabase PostgreSQL or Cloud SQL |
| Hosting     | GCP Cloud Run / Firebase Hosting |

---

## 📦 Getting Started

### 🔧 Backend (Spring Boot)

1. **Clone this repo**

   ```
   git clone https://github.com/yourusername/buy-and-sell-portal.git
   cd buy-and-sell-portal/server
   ```

2. **Set up DB connection in application.properties:**

   ```
      spring.datasource.url=jdbc:postgresql://<DB_HOST>:5432/<DB_NAME>
      spring.datasource.username=<YOUR_USERNAME>
      spring.datasource.password=<YOUR_PASSWORD>

      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
   ```
3. **Run the app:**
   ```
      ./mvnw spring-boot:run
   ```
