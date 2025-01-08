# Задание
---
## Первый экран
+ Пользователь вводит BIN банковской карты и видит доступную информацию о нём (страна, координаты, тип карты(visa и тп), данные банка(url, телефон, сайт, город)) загруженную с https://binlist.net/
  
+ Нажатие на URL банка, телефон банка или координаты страны отправляет пользователя в приложение, которое может обработать эти данные (браузер, звонилка, карты)

+ Пользователь имеет возможность перейти на экран со списком карточек истории запросов.

## Второй экран
+ Список карточек истории запросов BIN номеров, с данными которые ранее были полученны с ендпоинта.  

+ История предыдущих запросов выводится списком. 

+ История предыдущих запросов не теряется при перезапуске приложения. 

---
# Стэк
Kotlin, MVVM, Coroutine, Hilt, Jetpack Compose, Material Design, Retrofit, Room

---
# Результат
<div align="center">
    <br/>
      <img src="https://github.com/user-attachments/assets/838e356d-e247-46c8-be52-f4b7db6d204e" width="30%" alt="firstr search" />
      <img src="https://github.com/user-attachments/assets/910ab853-0ed7-4ba0-836f-f192c8803893" width="30%" alt="second search" />
      <img src="https://github.com/user-attachments/assets/1f22c9cb-675c-4bd9-b3aa-f8cfc0d65837" width="30%" alt="search history" />
</div>
