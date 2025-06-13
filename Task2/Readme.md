# Task 2

- Author: Uladzislau Mikhayevich
- Group: 23-HR-JA2
- Variant: 8

## Task description
**Свободная касса.** В ресторане быстрого обслуживания есть несколько
касс. Посетители стоят в очереди в конкретную кассу. Посетитель,
стоящий в очереди, может принять решение о переходе в другую очередь.
Посетитель может сделать предварительный заказ и получить его в любой
кассе без очереди.

## Rules
- Любая сущность, желающая получить доступ к разделяемому ресурсу, должна быть
потоком.
- Программа должна использовать возможности синхронизации, поставляемые
библиотеками java.util.concurrent и java.util.concurrent.locks.
- Не использовать synchronized, volatile, а также BlockingQueue и другие ограниченно
потокобезопасные коллекции.
- Классы и другие сущности приложения должны быть грамотно структурированы по пакетам
и иметь отражающую их функциональность название.
- Использовать шаблон State для описания состояний объекта, если только этих состояний
больше двух.
- Для создания потоков разрешается использовать по возможности Callable
- Вместо Thread.sleep использовать только возможности перечисления TimeUnit.
- Данные инициализации объектов считывать из файла. Данные в файле корректны.
- В приложении должен присутствовать потокобезопасный Singleton. При его создании
запрещено использовать enum.
- Для записи логов использовать Log4J2 или любой другой.
- Разрешается для вывода работы потоков использовать метод main.
