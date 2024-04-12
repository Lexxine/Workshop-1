# Workshop1

# Prosty projekt zarządzania zadaniami w konsoli

Ten projekt to prosty program konsolowy, który umożliwia zarządzanie zadaniami. Oto instrukcje dotyczące korzystania z programu:

## Metody projektu Tasks
Aplikacja musi posiadać następujące funkcje:

1.wyświetlanie wszystkich dostępnych zadań,
2.wyjście z aplikacji,
3.dodanie zadania,
4.usuwanie zadania,
5.wczytywanie danych z pliku przy starcie aplikacji,
6.zapis danych do pliku,
7.sprawdzanie poprawność wartości liczbowej podczas usuwania.

### Metoda wyświetlająca opcje dostępne w programie

Metoda ta wyświetla dostępne opcje w programie, które użytkownik może wykonać. Nagłówek "Please select an option:" jest wyświetlany w kolorze niebieskim.

Dostępne opcje to:
- add
- remove
- list
- exit

### Metoda pobierająca dane z pliku

Przed rozpoczęciem korzystania z programu, należy wywołać tę metodę, która wczyta dane z pliku tasks.csv do tablicy.

### Pobieranie wybranej akcji

Program korzysta z klasy Scanner, aby pobrać od użytkownika wybraną opcję. W zależności od wyboru użytkownika, program wywołuje odpowiednią metodę.

### Dodawanie zadania

Po wybraniu opcji "add", użytkownik zostanie poproszony o podanie szczegółów nowego zadania, które zostanie dodane do tablicy zadan.

### Listowanie zadań

Po wybraniu opcji "list", program wyświetla wszystkie zadania aktualnie znajdujące się w tablicy.

### Usuwanie zadania

Po wybraniu opcji "remove", użytkownik zostanie poproszony o podanie numeru zadania do usunięcia z tablicy.

### Usuwanie zadania — walidacja

Przed usunięciem zadania, program sprawdza poprawność wprowadzonych informacji, aby zapobiec błędom.

### Zakończenie programu

Po wybraniu opcji "exit", dane z tablicy są zapisywane do pliku tasks.csv, a program kończy swoje działanie.

## Instrukcja uruchomienia

1. Skompiluj pliki źródłowe programu.
2. Uruchom program w środowisku uruchomieniowym, np. w terminalu.

## Autor

Ten projekt został stworzony przez [Aleksandra Kostecka].

---

