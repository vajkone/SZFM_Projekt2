### Tesztelési jegyzőkönyv


| Tesztelő  | művelet | Kapott eredmény | tesztelt funkció | A teszt a várt eredményt produkálta? |
| ----------------- | ------------- | ------------- | ------------- | ------------- |
| Kiss Máté |  Note létrehozása adatbázisban | Létrejött | CreateNote() | igen |
| Garbóczy Vajk |  Keresés a Note-ok adatbázisában id alapján | Sikeres | getNoteById() | igen |
| Garbóczy Vajk |  Keresés a Note-ok adatbázisában Text alapján | Sikeres | getNoteByText() | igen |
| Földesi Zoltán |  Keresés a Note-ok adatbázisában Label alapján | Sikeres | getNoteByLabel() | igen |
| Földesi Zoltán |  Keresés a Note-ok adatbázisában Title alapján | Sikeres | getNoteByTitle() | igen |
| Mózes Nóra | Note címének frissítése | Sikeres frissítés | updateNote() | igen |  
| Mózes Nóra | Cím nélküli mentés | felugró üzenet kapása | "toast" kiírása | igen |
| Kiss Máté |Felugró ablak,megkérdezi hogy szeretnénk-e menteni | Sikeres | véletlen kilépés elleni védelem | igen |
| Garbóczy Vajk |Felugró ablak megkérdezi,hogy biztos törölni szeretnénk-e| Sikeres | véletlen törlés elleni védelem| igen |
| Garbóczy Vajk |Gombra kattintva rendezzük a Note listánkat| Sikeres | A lista elemek ABC szerinti sorba rendeződnek| igen |
| Garbóczy Vajk |Gombra kattintva rendezzük a Note listánkat| Sikeres | A lista elemek dátum szerinti sorba rendeződnek| igen |
| Garbóczy Vajk |Keresés gombra kattintva felugrik a keresési felület| Sikeres | gombnyomásra betöltődik a layout| igen |
| Garbóczy Vajk |Keresési felületen "keresés" gombra nyomva keresünk a Note listában| Sikeres | Azokat a Note-okat kapjuk vissza listában amik tartalmazzák a beírt stringet| igen |
| Garbóczy Vajk |Gombra kattintva alaphelyzetbe állítjuk Note listánkat| Sikeres | A lista elemek visszarendeződnek alaphelyzetükbe| igen |
| Kiss Máté |Felugró ablak megkérdezi,hogy biztos törölni szeretnénk-e a Todo-t| Sikeres | véletlen törlés elleni védelem  | igen |
| Kiss Máté |Todo felvétele a listába | Sikeres | Todo felvétele az adatbázisba  | igen |
| Mózes Nóra | Todo törlése a listából | Sikeres | Todo törlése az adatbázisból | igen |
| Mózes Nóra | Habit törlése a listából | Sikeres | Habit törlése az adatbázisból | igen |
| Földesi Zoltán |  Habitek kilistázása| Megjelennek a habitek  |getHabits()  | igen |
| Földesi Zoltán |  Habit felvétele a listába | Sikeres |createHabit,saveHabit()  | igen |
| Földesi Zoltán |  Habitre való kattintás | Habit összegző képernyő behozása | habitSum | igen |
| Földesi Zoltán |  Habit checkbox bekattintása | Checkbox ki lesz pipálva |updateHabit()  | igen |
| Földesi Zoltán | Dátumok megfelelő változása | Sikeres |onCreate()  | igen |
| Földesi Zoltán | Checkboxok csúszása | Sikeres | slideHabit()  | igen |
| Földesi Zoltán |  Cím nélküli mentés | Felugró ablak jelzi,hogy adjunk meg címet | Cím nélküli mentés elleni védelem  | igen |
| Kiss Máté |  Cím nélküli Todo mentés | Felugró ablak jelzi,hogy adjunk meg címet | Cím nélküli Todo mentés elleni védelem  | igen |
| Kiss Máté |  Todo Checkbox kattintás | sikeres|  A checkbox kattintásra változik | igen |
| Kiss Máté |  Kész Todok listázása | sikeres|  A done lista kiíratása, getDoneTodo()  | igen |
| Kiss Máté |  Kijelentkezés | sikeres|  Felhasználó kijelentkezés | igen |
| Mózes Nóra | Menu használat | A menü megfelelően működik | menu gombok | igen |
