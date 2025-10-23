# Weather App - Android Project

Ứng dụng xem thời tiết với dữ liệu từ OpenWeatherMap API.

## 🚀 Tính năng

- ✅ Tìm kiếm thành phố theo tên
- ✅ Hiển thị thời tiết hiện tại (nhiệt độ, độ ẩm, tốc độ gió)
- ✅ Dự báo thời tiết 5 ngày
- ✅ Icon thời tiết trực quan
- ✅ Hỗ trợ Dark Mode
- ✅ Xử lý lỗi và trạng thái loading
- 🎯 (Optional) Sử dụng GPS để lấy vị trí hiện tại
- 🎯 (Optional) Cache dữ liệu offline với Room

## 📋 Yêu cầu

- Android Studio (phiên bản mới nhất)
- Android SDK 24+ (Android 7.0 Nougat trở lên)
- Tài khoản OpenWeatherMap (miễn phí)

## 🔑 Cấu hình API Key

### Bước 1: Đăng ký OpenWeatherMap API

1. Truy cập [OpenWeatherMap](https://openweathermap.org/api)
2. Tạo tài khoản miễn phí
3. Vào mục **API Keys** và copy API key của bạn

### Bước 2: Thêm API Key vào project

1. Mở file `local.properties` (nằm ở thư mục root của project)
2. Thêm dòng sau (thay `your_api_key_here` bằng API key thực):

```properties
OWM_API_KEY=your_actual_api_key_here
```

**⚠️ LƯU Ý QUAN TRỌNG:**
- File `local.properties` đã được thêm vào `.gitignore`
- **KHÔNG BAO GIỜ** commit API key lên GitHub
- Mỗi developer cần tạo API key riêng

### Bước 3: Sync Gradle

Sau khi thêm API key, sync Gradle:
- Nhấn **File** → **Sync Project with Gradle Files**

## 🏗️ Kiến trúc

Project sử dụng **MVVM (Model-View-ViewModel)** pattern:

```
app/
├── data/
│   ├── model/          # Data models (City, Weather, Forecast...)
│   ├── remote/         # API service & Retrofit client
│   └── repository/     # Repository pattern
├── ui/                 # Activities, ViewModels, Adapters
└── utils/              # Utility classes
```

## 📦 Dependencies

- **Retrofit 2** - Networking
- **Glide** - Image loading
- **Lifecycle Components** - ViewModel & LiveData
- **Room** - Local database (cache)
- **Play Services Location** - GPS
- **Material Components** - UI components

## 🛠️ Build & Run

1. Clone project
2. Mở trong Android Studio
3. Thêm API key vào `local.properties`
4. Sync Gradle
5. Chạy app (Shift+F10)

## 📱 Chức năng API

### Geocoding API
```
GET https://api.openweathermap.org/geo/1.0/direct
Params: q={city}, limit=1, appid={API_KEY}
```

### Current Weather API
```
GET https://api.openweathermap.org/data/2.5/weather
Params: lat={lat}, lon={lon}, units=metric, appid={API_KEY}
```

### 5 Day Forecast API
```
GET https://api.openweathermap.org/data/2.5/forecast
Params: lat={lat}, lon={lon}, units=metric, appid={API_KEY}
```

## 🎨 UI Features

- Material Design 3
- Dark Mode support
- Shimmer loading effect
- SwipeRefreshLayout
- RecyclerView cho danh sách dự báo

## 📝 TODO (Phase 2 & 3)

- [ ] Implement Repository pattern
- [ ] Create ViewModel
- [ ] Design UI layout
- [ ] Bind data với LiveData
- [ ] Error handling & loading states
- [ ] GPS location (optional)
- [ ] Room cache (optional)
- [ ] Unit tests (optional)

## 📄 License

This project is for educational purposes.

## 👨‍💻 Developer

Project created as part of Android development learning.

---

**📌 Ghi chú:** Các file errors "not on classpath" sẽ tự biến mất sau khi Gradle sync hoàn tất.
