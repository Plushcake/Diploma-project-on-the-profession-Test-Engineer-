#### План по проверке и автоматизации приложения «Мобильный хоспис».

###### Приложение включает в себя следующий функционал:

- информацию о претензиях и функционал для работы с ними.
- новостную сводку хосписа.
- тематические цитаты.
- редактирование, создания, удаление.

#### Обзор приложения:

###### Приложение включает в себя следующие разделы:

Раздел Авторизации (Authorization).

![19](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/19.png)

Раздел Главная (Main) с разделами News и Claims.

![1](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/1.png)

​ Меню со списком функций.

![2](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/2.png)

​ Тематические цитаты.

![3](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/3.png)

​ Личный кабинет.

![4](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/4.png)

Раздел Претензии (Claims).

![5](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/5.png)

​ Фильтрация.

![8](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/8.png)

![9](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/9.png)

​ Создание претензии.

![10](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/10.png)

![11](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/11.png)

Раздел Новости (News).

![6](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/6.png)

​ Переключение на последнее созданное сообщение.

![12](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/12.png)

​ Фильтрация Новостей.

![13](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/13.png)

![14](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/14.png)

​ Редактирование Новостей.

![17](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/17.png)

![18](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/18.png)

​ Создание Новостей.

![15](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/15.png)

![16](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/16.png)

Раздел правовой и технической информации (About).

![7](https://github.com/Plushcake/Diploma-project-on-the-profession-Test-Engineer-/blob/main/screenshot/7.png)

---

#### Производимый вид тестирования:

Функциональное тестирование.

#### Тестируемые области функциональности:

###### Основные разделы:

1. Authorization.

2. Main.

3. Claims.

4. News.

5. About.

###### Переход между разделами:

1. Переход в раздел Love is all.

2. В разделе Main переход в раздел All News (Раздел News) . Переход в раздел All Claims (Раздел Claims). Переход в раздел Creating Claims. Переход в раздел редактирование сообщение, переход в раздел Add comment, переход в раздел Editing Claims.

3. В разделе Claims переход в всплывающее меню Filtering. Переход в раздел Creating Claims. Переход в редактирование сообщения, переход в раздел Editing Claims, переход в раздел Add comment.

4. В разделе News переход в раздел Filtering News. Переход в раздел Control Panel, переход в раздел Filter news, переход раздел Creating News, переход в раздел Editing News

5. Переход в сплывающие меню Календаря и Часов.

6. Переход в раздел About. Переход по ссылкам на сторонние ресурсы Privacy Policy и Terms of use.

7. Переход между основными разделами: Authorization, Main, Claims, News, About.

#### План проверки (Перечень работ):

1. Тестирование раздела Authorization.

2. Тестирование раздела Main.

3. Тестирование раздела Claims.

4. Тестирование раздела News.

5. Тестирование раздела About.

6. Тестирование переходов между разделами.

7. Тестирование дополнительных опций внутри разделов.

#### План автоматизации приложения:

1. Тестирование авторизации. Вход и выход из аккаунта.

2. Тестирование открытие и закрытие всплывающих меню.

3. Тестирования перехода по разделам.

4. Тестирование создания сообщения и заполнение комментариев. Проверка на их создание.

5. Тестирование About. Переход по ссылкам на сторонние ресурсы.

#### Список инструментов используемых при автоматизации:

Visual Stidio Code - для создания и редактирования файлов в формате Markdown или любую удобную программу.

Android Studio - для просмотра, создания и редактирования кода. Создание автоматических тестов и запуска эмулятора мобильного устройства.

Record Espresso Test - для создание тестов пользовательского интерфейса. Входит в программу Android Studio.

Appium Inspector - для создание тестов пользовательского интерфейса.

Appium Server GUI - HTTP сервер.

Layout Inspector - для просмотра уникальных идентификаторов. Входит в программу Android Studio.

Allure Framework - отчет о тестировании.

GitHub - Хранение репозиторий.

JUnit - фреймворк для Java.

#### Потенциальные риски при автоматизации:

1. Изменения требований в проекте
2. Переработка интерфейса
3. Не значительные или значительные технические изменения в проекте.
4. Ошибка в планировании стратегии.

> Необходимо заново писать автоматизированный тест. Потеря времени, человеческих ресурсов, бюджета.

#### Интервальная оценка затрат в часах + поэтапные сроки выполнения работ:

За основу взят 8 часовой рабочий день и 5 рабочих дней в неделю. Примерно из 8 часового рабочего дня, сотрудник потратит на работу 5 - 6 часов. Это связанно с перерывом на питание, короткие перерывы, решение технических вопросов, форс мажорные обстоятельства и т.д.

Не будем приуменьшать количество часов, возьмем с запасом. Затраты в часах 200 часов и прибавим 60 часов на непредвиденные ситуации.

Итог примерно 260 часов на проект.
