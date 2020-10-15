Rendszerterv a jegyzetelő alkalmazáshoz
---------------------------------------

### 1. A rendszer célja:

   A rendszer célja hogy diákoknak egy olyan felületet biztosítson hordozható elektronikus eszközeiken (okostelefon ill. tablet)
amelyet használva könnyen tudnak óráikon valamint előadásaikon jegyzetelni, elvégzendő feladataikat proiritási sorrendben számontartani (TODO List), valamint szokásaikat
ütemezni és nyilvántartani. Ez a három tevékenység együtt nagyban garantálja, hogy az alkalmazást használó diák produktivitási szintje megnő, ami hozzájárul akadémiai sikerihez,
valamint későbbiekben a munka világában is kamatoznak majd a kialakított jó szokások. Az alkalmazás adatbázisa teljesen felhő alapú, így a diák több eszközről is hozzáfér
a saját fiókján felvitt összes adathoz, legyen az jegyzet, elvégzendő feladatok vagy saját jó szokásainak számontartása.

* **Note taking**

   A rendszer jegyzetelő része a világhírű Cornell metódust ültetné át
elektronikus környezetbe, ami már egyfajta útmutatást ad a diákoknak egy már bizonyítottan helyes és működő jegyzetelési stratégiához.
Továbbá a diákoknak minden jegyzete egy helyen lenne, a rendszer lehetőség biztosít a jegyzetek hatékony csoportosításához, azok 
átlátható rendszerezéséhez, valamint könnyű előkereséséhez. Ez utóbbit kulcsszavak szerinti, időpontbéli vagy esetleg tantárgy szerint
kereséssel valósítaná meg az alkalmazás, így jelentős számú és akár rendezetlen jegyzetek esetén is, a diák könnyedén, gyorsan és hatékonyan
rátalálhat a keresett jegyzetre, ha mondjuk emlékszik 1-2 szóra a jegyzetből vagy hogy körülbelül mikor készült a jegyzet. 
Ugyan a rendszernek nem kifejezett célja, hogy jegyzetelési tanácsadóként szolgáljon diákok számára, a környezet valamelyest rákényszeríti a
diákokat hogy egy helyes módszert használjanak és mivel az meglehetősen intuitív, ezért külön magyarázatot nem is igényel, a diákoknak nem
kell hosszas magyarázatokat végighallgatniuk hogy ráérezzenek a módszer nyújtotta előnyökre.  

* **Todo list**

  A rendszer Todo listájának célja egy egyszerű felület biztosítása, amelyben a felhasználó felveheti az összes feladatát egy helyen, listába rendezve, prioritást és határidőt
rendelve az adott feladathoz, ezzel biztosítva, hogy nem feledkezik meg az elvégzendő feladatokról. A rendszer opcionálisan emlékeztetőt küldhet a felhasználó számára
időközönként vagy a határidő előtt egy bizonyos időintervallumban. Az elvégzett feladatok egy külön tárolóba kerülnek (archívum), ahol továbbra is áttekinthetőek, de már nem 
módosíthatóak, csak véglegesen eltávolíthatóak.  

* **Habit tracking**

   A rendszer Habit tracking részének a célja egy olyan felület biztosítása a felhasználó számára, amelyre elvégezni kívánt szokásait felveheti, majd naponta, annak függvényében,
 hogy aznap elvégezte-e az adott szokást vagy nem, pipát vagy x-et rak a szoksához. Ily módon a felületre tekintve a teljesíteni kívánt szokásait listába renddezve fogja látni 
 5-7 napra visszamenőleg és a napok alatt pipa vagy x fog megjelenni. Természetesen a cél az, hogy a kialakítani kivánt szokások sorában csupa pipa legyen és egy ilyen felület, 
 amit becsületesen vezetve segíthet a felhasználónak áttekinteni, hogy mit is végzett el melyik napon, hozzájárul ahhoz, hogy a felhasználó jobban odafigyeljen napi szinten az
 apró szokásaira.


### 3. Üzleti folyamatok

![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/BPMNF.png "BPMN diagramm")

Ezzel a programmal,a diákoknak próbálunk segítséget nyújtani. Ezzel a programmal képesek lesznek jegyzeteket létrehozni,a különböző napi teendőiket nyomon követni,
illetve a szokásaikat is megfigyelhetik. Mindezt egy Cloud alapú könnyen kezelhető felhasználói felületen.Ahogy a fent látható folyamat ábrán is látszik
a felhasználó a kezdő képernyőn képes lesz belépni,ha már van fiókja,ha pedig nincs akkor regisztálhat. Ha belépett akkor elsősorban a jegyzeteit fogja látni.
Itt a jegyzetek között görgetéssel vagy különböző paraméterek segítségével kereshet is. Egy "+" gombbal új jegyzetet vehet fel. Egy "X" gombbal pedig törölni tudja az adott jegyzetet.  
Ha pedig már meglévő jegyzetet szeretne szerkeszteni,akkor egy egyszerű kattintással a jegyzetre,majd egy "Edit note" gombra kattintva a szerkesztő felületre kerülhet.
Ezután ha a teendőit szeretné látni a felhasználó,akkor egy egyszerű lapozással megteheti azt,mivel a felhasználói felület egy úgynevezett Tabbed activity, amin három féle lap lesz található. 
A teendős felületen ismét csak görgetéssel tud keresni.Ugyancsak egy gombnyomással hozzá adhat a felhasználó egy teendőt. És szerkeszteni is képes lesz mint a jegyzeteit. Valamint minden teendőhöz tartozik egy checkbox,amit kipipálva jelezheti,hogy elkészül az adott feladattal. Ezen a "fülön" ha tovább lapoz egyet a felhasználó,akkor pedig a szokásait tudja nyomon követni.  

### 6. Architekturális terv

![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/MVC.png "MVC")

Az alkalmazás az MVC architektúrális tervezési mintát követi.  
Eszerint a programunkat 3 részre osztjuk,a modellre,nézetre, és kontrollerre.  
A modell része foglalkozik a programunk során keletkező adatok,és a köztük lévő kapcsolatok kezelésével.  
Ide értjük a táblázatot,amiben a jegyzeteket kezeljük.  
A nézet vagy angolul view,része a programunknak,a megjelenítéssel foglalkozik.  
Ez fogja megjeleníteni a modellben kezelt adatokat.  


### 7. Tesztterv  

A teszttervet, azért alkotjuk meg, hogy az aplikáció kiadása tökéletes legyen, és a felhasználó egy teljesen hibátlan programot kapjon. 
A tesztelés feladata az, hogy a szoftver használata során fellépő hibák előfordulását csökkentse, a szoftver megbízhatóságát növelje és a szabványoknak, előírásoknak való megfelelőségét biztosítsa. 
A teszt végrehajtásáért a projekt menedzser felel és a tesztcsapat hajtja végre  

Elvárások a teszteléssel kapcsolatban:

* A tesztprogram az ebben a dokumentumban meghatározott tesztterv alapján fut.  
* Az this.BestTeam=true projektcsapat felelős a tesztadatok előállításáért.  
* Az olvasó ismeri az alapdokumentumokat, amelyek meghatározzák a rendszert.

### 8. Karbantartási terv  
A szoftver rendszernek támogatnia kell az alábbi tevékenységeket:  

* rendszer frissítése  
* általános átvizsgálás során észlelt hibák javítása  
* meghibásodás esetén az utolsó konzisztens állapot visszaállítása  
* rendszeres biztonsági mentés  
* általános átvizsgálás során észlelt hibák javítása  
* bejelentések során érkezett hibák javítása  
* felhasználók igényeinek folyamatos figyelése és felmérése  
* Módosítások hatásának figyelése, elemzése  
* biztonsági beállítások folyamatos felülvizsgálata és szükség esetén korrigálásuk.  

Rögzítendő eljárások:  

* Hibajelentések, hibanaplók  
* Karbantartás tervezése, megvalósítása, ellenőrzése  
* Engedélyezés és jóváhagyás módja  
* Karbantartási feljesztések  

Karbantartáshoz kötödő feladatok:
* Módosítás esetén: Hatáselemzés
* Hibakezelés esetén: Debbugolás, hibajavítás
* Mindkettő esetén: Regressziós tesztelés  

### 11. Funckionális terv

Ez az alkalmazás a diákok jegyzetelését és időbeosztását szeretné segíteni.A felhasználó képes lesz jegyzeteket létrehozni,törölni,szerkeszteni. Valamint a napi teendőit is felviheti a rendszerbe,és a különböző szokásait is nyomon követheti.  

![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/designplan1.png "designplan1")  

A fentebb látható képen láthatjuk a tervezett belépő,regisztráló illetve alapértelmezett képernyők terveit. Az első képen a már regisztrált felhasználó tud belépni,miután megadta a felhasználónevét illetve jelszavát, a login gomb segítségével. Valamint ha még nincs fiókja akkor rákattintva a Sign up gombra a második képre kerül át. Ahol pedig egy név,email,jelszó hármassal regisztrálhat a rendszerbe.A bejelentkezés után pedig az alapértelmezett képernyőre kerül,ami a jegyzetelő felület. Itt láthatja kilistázva a jegyzeteit(ha vannak).A jegyzetek között görgetéssel,vagy a nagyító segítségével kereshet. A "+" gombbal tud létrehozni jegyzetet. Minden jegyzetnél található egy piros "X" gomba,melynek segítségével törölni tudja a jegyzetet. Ha pedig szerkeszteni szeretné a jegyzetet akkor csak rá kell kattintania a jegyzetre,ami átvált a szerkesztő felületre.Látható a képen,hogy az oldalnak 3 "füle" van,ezek között elhúzással tud váltani a felhasználó.  

![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/designplan2.png "designplan2")  

Ezeken a képeken látható a jegyzetek közötti keresés megvalósítása. Valamint a jegyzeteket rendezheti is majd a felhasználó. Az utolsó képen pedig a jegyzetek szerkesztői felülete látható,ami a Cornell jegyzetelési technikát valósítja meg.

![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/habittracking.png "habittracking")

A HABITS "fülön" egy ehhez hasonló felület fogadja majd a felhasználót,ahonnan a különböző szokásait tudja  leolvasni.

<p float="left">
  <img src="https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/TodoList1.png" width="300" />
  <img src="https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/TodoList2.png" width="300" /> 
  
</p>

A feladatok listája pedig egy ehhez hasonló felületen fog megjelenni.Minden feladata a felhasználónak ki lesz listázva. Minden feladathoz tartozik egy checkbox,amit a felhasználó kipipálhat,így jelezve azt,hogy már teljesítette a feladatot. Ugyancsak a "+" gombbal tud a felhasználó új feladatot létrehozni,a meglévők mellé.Ez a "+" gomb pedig a második képen látható szerkesztő felületre fog váltani. Itt pedig megadhatja a felhasználó a feladatot,valamint azt,hogy mennyire sűrgős aza adott feladat. Majd egy gombbal elmentheti ezt.





### 12. Telepítési terv  
Az alábbi pontban az aplikáció telepítésének menete van leírva.

Az alkalmazást, egy .apk kiterjesztésű telepítő fájllal lehet telepíteni egy android operációs rendszerű eszközre. 
Az alkalmazás android rendszerű telefonra és tabletre lett fejlesztve, más android opercációs rendszerű eszközökön nem biztosított az alkalmazás megfelelő működése.
Emelett megszabás még, hogy az adott androidos eszköznek 5.0 vagy annál nagyobb verziószámú android operációs rendszerszerrel kell rendelkeznie
Az alkalmazás telepíse előtt, még engedélyeznünk kell az adott eszközön, az ismeretlen forrásból származó alkalmazások telepitését.
Az engedély megadásának módja eszközönként eltérhet.  
