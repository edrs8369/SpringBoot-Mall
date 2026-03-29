# 🛒 Spring Boot Mall 電商後端專案

## 📌 專案介紹

本專案是一個使用 **Spring Boot** 開發的電商後端系統，主要提供商品管理、會員系統與訂單管理等核心功能。
透過 RESTful API 設計，實現前後端分離架構，並具備基本的身份驗證機制。

---

## 🚀 使用技術

* Java
* Spring Boot
* MySQL
* JDBC
* RESTful API
* Maven

---

## 🧩 系統功能

### 🛍️ 商品功能（Product）

* 新增商品（Create Product）
* 刪除商品（Delete Product）
* 查詢單一商品（Get Product）
* 商品條件查詢（Filter Products）

  * 分頁查詢
  * 依分類、名稱搜尋
  * 排序功能
* 更新商品（Update Product）

---

### 👤 帳號功能（User）

* 使用者註冊（Register）
* 使用者登入（Login）

---

### 📦 訂單功能（Order）

* 建立訂單（Create Order）
* 查詢訂單列表（Get Orders）

---

## ⚙️ API 設計概念

本專案採用 RESTful API 設計：

* 使用 HTTP Method（GET / POST / PUT / DELETE）
* 使用 JSON 作為資料傳輸格式
* 統一回傳格式，方便前端串接

---

## 🔐 驗證機制

* 使用 JWT（JSON Web Token）進行身份驗證
* 保護需要登入後才能操作的 API（如建立訂單）

---

## 📦 專案架構（簡述）

採用三層式架構：

* Controller：處理 API 請求
* Service：處理商業邏輯
* DAO：與資料庫互動

---

## 🧪 測試方式

可使用以下工具測試 API：

* Postman
* API Tester

---

## 🚀 專案啟動方式

```bash
git clone https://github.com/edrs8369/SpringBoot-Mall.git
cd your-project
mvn spring-boot:run
```

---

## 📌 未來優化方向

* 密碼加密改用 BCrypt（提升安全性）
* 加入 Redis 快取提升效能
* 增加訂單狀態管理（付款 / 出貨 / 完成）
* 整合前端（React / Vue）

