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
