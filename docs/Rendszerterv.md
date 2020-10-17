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
 


### 2. Projekt terv:

  A rendszer létrehozásához rendelkezésre álló emberi erőforrások alapján a projekt a rendszerterv elfogadását követő öt héten belül
megvalósítható. A projektben az alábbi szerepkörök betöltése szükséges:

* Projektvezető: Aktívan részt vesz a fejlesztésben, a többi fejlesztő munkáját átlátja és koordinálja
* Designtervező: Megrendelői igények alapján előzetes képernyőterv készítése, egyeztetés a megrendelővel a
		végső designtervet illetően, a tényleges projekt design-jának megvalósítása
* Adatbázistervező: A projekthez tartozó teljes adatbázis létrehozásáért és megfelelő működéséért,
		   valamint a programozó által igényelt lekérdezések megvalósításáért felelős. 
* Programozó: A projektvezető által kijelölt programozási feladatok megoldásáért felelős  

##### Ütemterv
   | Fő feladatok     |Részfeladat| Prioritás     |Becslés|Eltelt idő|Hátralévő idő  |
   | -----------------|----------|:-------------:| -----|---------|-----------|
   | Cloud |Cloud rendszer integrálása a projektbe| Magas | 10-12 óra |          |  12 óra          |
   | Cloud |Felhasználó authentikáció| Magas | 14-16 óra |          |  16 óra          |
   | Cloud-Adatbázis |Adatbázis létrehozása| Magas | 14-16 óra |          |  16 óra          |
   | Cloud-Adatbázis |CRUD funkcionalitás implementálása| Magas | 16-18 óra |          |  18 óra          |
   | Cloud-Adatbázis          |Specifikus lekérdező funkciók           |Magas       |   14-16 óra |          |    16 óra        |
   | Programozói feladatok |Modell osztályok létrehozása| Közepes | 6-8 óra |          |  8 óra          |
   | Programozói feladatok |Egyéb részfeladatok| Közepes | 6-8 óra |          |  8 óra          |
   | UI     |  UI létrehozása         |  Közepes     | 6-8 óra     |          |   8 óra         |
   | UI     |  Controller osztályok       |  Magas     | 8-10 óra     |          |   10 óra         |
   | UI     |  UI elemek funkcionalitása        |  Magas     | 4-6 óra     |          |   6 óra         |
   | UI     |  Reszponzív design       |  Alacsony     | 13-14 óra     |          |   14 óra         |
   | Tesztelés     |  Tesztelés       |  Magas     | 12-14 óra     |          |   14 óra         |
   | Kényelmi funkciók     |  Létrehozás és tesztelés       |  Alacsony     | 16-18 óra     |          |   18 óra         |
   



### 3. Üzleti folyamatok

![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/BPMNF.png "BPMN diagramm")

Ezzel a programmal,a diákoknak próbálunk segítséget nyújtani. Ezzel a programmal képesek lesznek jegyzeteket létrehozni,a különböző napi teendőiket nyomon követni,
illetve a szokásaikat is megfigyelhetik. Mindezt egy Cloud alapú könnyen kezelhető felhasználói felületen.Ahogy a fent látható folyamat ábrán is látszik
a felhasználó a kezdő képernyőn képes lesz belépni,ha már van fiókja,ha pedig nincs akkor regisztálhat. Ha belépett akkor elsősorban a jegyzeteit fogja látni.
Itt a jegyzetek között görgetéssel vagy különböző paraméterek segítségével kereshet is. Egy "+" gombbal új jegyzetet vehet fel. Egy "X" gombbal pedig törölni tudja az adott jegyzetet.  
Ha pedig már meglévő jegyzetet szeretne szerkeszteni,akkor egy egyszerű kattintással a jegyzetre,majd egy "Edit note" gombra kattintva a szerkesztő felületre kerülhet.
Ezután ha a teendőit szeretné látni a felhasználó,akkor egy egyszerű lapozással megteheti azt,mivel a felhasználói felület egy úgynevezett Tabbed activity, amin három féle lap lesz található. 
A teendős felületen ismét csak görgetéssel tud keresni.Ugyancsak egy gombnyomással hozzá adhat a felhasználó egy teendőt. És szerkeszteni is képes lesz mint a jegyzeteit. Valamint minden teendőhöz tartozik egy checkbox,amit kipipálva jelezheti,hogy elkészül az adott feladattal. Ezen a "fülön" ha tovább lapoz egyet a felhasználó,akkor pedig a szokásait tudja nyomon követni.  

### 4. Követelmények
A megrendelői [követelményspecifikációban](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md) leírtakat tudomásul véve az applikációt úgy tervezzük meg, hogy megjelenése egyszerű, szolid legyen, valamint könnyen kezelhető legyen a felhasználó számára. Az applikáció grafikus felhasználói felületét úgy tervezzük meg, hogy letisztult, igényes, valamint modern legyen. A színek, képek, ikonok összhangban lesznek, nem fognak elütni egymástól, illetve nem fogunk rikító színeket alkalmazni. Az applikációban csak JPEG vagy PNG formátumú kép fog megjelenni. Az alkalmazás grafikus felületeit XML-ben fogjuk elkészíteni.  
Megrendelőnk kérését, miszerint az applikáció rendszerigénye legyen alacsony, teljes mértékben teljesítjük. Az applikáció egy egyszerű alsó középkategóriás mobiltelefonon, illetve tableten is probléma nélkül használható lesz. Az applikáció nem fog hozzáférni az eszközön lévő többi adathoz.   
Az applikáció használatához a felhasználónak internetkapcsolatra lesz szüksége, ugyanis az adatok felhő alapú adatbázisban lesznek eltárolva a Google Firestore felhő alapú szolgáltatása segítségével. A felhasználó egy felhasználónév és jelszó párossal tud belépni az alkalmazásba.  
Megrendelőnk a "hamburgermenü" alkalmazását szerette volna navigálásra használni a különböző nézetek között, mi azonban a "hamburgermenü" helyett egy "tabbed" nézetet fogunk alkalmazni. A képernyő felső részén 3 fül (jegyzetek, TODO lista, szokásfigyelő) közül lehet majd választani, ezáltal egy kényelmesebb felhasználói élményt hozhatunk létre. Az alkalmazás könnyen átlátható lesz, nem fog bonyolult megoldásokat, felesleges funkciókat tartalmazni.  
A megrendelőnk igényeit szem előtt tartva a jegyzetek szerkesztője a Cornell jegyzetelési módszert fogja megvalósítani. A jegyzetek között lehet majd keresni cím, címke és szöveg alapján. A felhasználó a jegyzeteket ABC sorrend, valamit dátum szerint is fogja tudni rendezni, valamint törölni őket. 
A TODO feladatok külön nézetben kerülnek kilistázásra. Új feladatot egyszerűen vehet fel a felhasználó, megadhat hozzá egy határidőt, az adott feladatot egy checkbox kipipálásával elvégzettnek jelölheti, vagy törölheti. A harmadik nézetben a felhasználó a szokásait tudja feljegyezni és nyomon követni.  
Megrendelőnk kérése az volt, hogy az applikáció magyar vagy angol nyelvű legyen. Csapatunk az angol mellett döntött, hiszen ez a világ egyik legbeszéltebb nyelve.  
Az alkalmazás letöltése és használata díjmentes. Az alkalmazáson belül (inapp) sem találhatóak fizetéses elemek. Az applikáció és az alapjául szolgáló szoftvertermék a szerzői jogról szóló 1999. évi LXXVI. törvény és egyéb, a szellemi alkotásokra vonatkozó jogszabályi rendelkezések védelme alatt áll. A személyes adatok kezelése az információs önrendelkezési jogról és az információszabadságról szóló 2011. évi CXII. törvény rendelkezéseinek megfelelően történik. A felhasználónak be kell tartania minden hazai előírást és szabályozást, amely az applikációra vonatkozik. A Felhasználó az applikációt vagy annak bármely részét nem adhatja kölcsön, nem ruházhatja át, nem adhatja bérbe, sem más módon nem terjesztheti.

### 5. Fizikai környezet
Az általunk elgondolt applikáció az Android Studio fejlesztői környezetben fog készülni. Android operációs rendszert futtató mobiltelefonokon, illetve tableteken lesz elérhető. Minimum 5.0.0 verziójú vagy annál magasabb Android operációs rendszeren lesz használható, a közeljövőben más mobil operációs rendszeren nem lesz elérhető.  
Ahogy a megrendelői [követelményspecifikációban](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md#5-a-rendszerre-vonatkoz%C3%B3-szab%C3%A1lyok) is olvasható, a megrendelőnk kérése az volt, hogy az applikáció Java vagy Kotlin programozási nyelven íródjon. Csapatunk a Kotlin mellett döntött, ugyanis a Kotlin az Android hivatalos nyelve, óriási fejlesztői közösség épül köré és sokkal több frissítés érhető el az Androidra Kotlinon keresztül.  
A megrendelőnk igényeit szem előtt tartva az applikációt úgy tervezzük meg, hogy a rendszerigénye alacsony legyen, egy egyszerű alsó középkategóriás mobiltelefonon, illetve tableten is probléma nélkül használható lesz.  
A felvitt adatok tárolását felhő alapú adatbázisban valósítjuk meg, amihez a Google Firestore felhő szolgáltatását választottuk.

### 6. Architekturális terv

![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/MVC.png "MVC")

Az alkalmazás az MVC architektúrális tervezési mintát követi.  
Eszerint a programunkat 3 részre osztjuk,a modellre,nézetre, és kontrollerre.  
A modell része foglalkozik a programunk során keletkező adatok,és a köztük lévő kapcsolatok kezelésével.  
Ide értjük a táblázatot,amiben a jegyzeteket kezeljük.  
A nézet vagy angolul view,része a programunknak,a megjelenítéssel foglalkozik.  
Ez fogja megjeleníteni a modellben kezelt adatokat.  
A kontroller része a programnak a felhasználótól származó műveleteket fogja kezelni.  
A felhasználó által adott parancsokat fogja a modellben létrehozni. Például ha a felhasználó kitöröl egy jegyzetet,
akkor a kontroller fogja kitörölni az adott rekordot a táblából.  
Tehát a felhasználó használja a kontrollert,a kontroller módosítja a modellt,a modell frissíti a nézetet amit majd a felhasználó látni fog.  
A modell réteget kell változtatnunk,ha bármilyen változást szeretnénk majd a későbbiekben végrehajtani az adatbázisunk struktúráján.  
A programunk úgy került kialakításra,hogy ez az esetleges változás a többi réteget ne érintse.  
Az MVC tervezési minta sok előnnyel rendelkezik,ezekért is került a választásunk erre a mintára.  
Egyidejűleg lehet fejleszteni,tehát többen tudunk egyszerre dolgozni a komponenseken.  
Az elemek alapvetően nagy részben függetlenek egymástól,ezért könnyen változtathatóak.  
Könnyen bővíthető is,mivel a felelősségek szét vannak osztva a komponensek között.  
Az alkalmazásunk online alkalmazás lesz. Cloudos rendszerrel lesz megoldva az adatok illetve a felhasználók tárolása.  
Így a felhasználók különböző eszközökről is el tudják érni a jegyzeteiket,illetve feladataikat.


### 7. Tesztterv  

A teszttervet, azért alkotjuk meg, hogy az aplikáció kiadása tökéletes legyen, és a felhasználó egy teljesen hibátlan programot kapjon. 
A tesztelés feladata az, hogy a szoftver használata során fellépő hibák előfordulását csökkentse, a szoftver megbízhatóságát növelje és a szabványoknak, előírásoknak való megfelelőségét biztosítsa. 
A teszt végrehajtásáért a projekt menedzser felel és a tesztcsapat hajtja végre  

Elvárások a teszteléssel kapcsolatban:

* A tesztprogram az ebben a dokumentumban meghatározott tesztterv alapján fut.  
* Az this.BestTeam=true projektcsapat felelős a tesztadatok előállításáért.  
* Az olvasó ismeri az alapdokumentumokat, amelyek meghatározzák a rendszert.  

A teszt elvégzéséhez, erőforrások szükségesek.  
Szükséges erőforrások:  
- klimatizált helyiség, ahol a jelenlegi szabályozásoknak megfelelően, a tagok 1,5m tudnak egymástól elhelyezkedni.
- Stabil áramellátás  
- Megfelelő tűzvédelemmel ellátott épület.  
- Megfelelő számú fali csatlakozó
- Stabil internetelérés
- 5.0,vagy annál nagyobb verziószámú android operációs rendszerű mobilkészülékek. Különböző képernyő méretben  
- 5.0,vagy annál nagyobb verziószámú android operációs tablet. Különböző képernyő méretben  

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

### 10. Adatbázis terv 

Az adatbázis felhő alapú lesz, amihez a Google Firestore felhő szolgáltatását választottuk. A Firestore NoSQL alapú, táblák helyett úgynevezett dokumentumokkal és kollekciókkal
dolgozik. Az adatok egy-egy kollekción belül JSON sémát követve kerülnek elmentésre, field-value párokban. A felhasználók adatai is mentésre kerülnek, tovább minden regisztrált
felhasználó automatikusan generált globálisan Unique Id-t kap, ami szükséges lesz a későbbiekben, ugyanis az appon belül mentett dokumentumai ehhez az Id-hoz lesznek
hozzárendelve.

#### User database pattern
  ![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/UserDb.png "User database")  
  
A mentett adatok számára fentartott adatbázisban egy Users szuperkollekcióba kerül az összes felhasználó Id-ja, amikhez további 3 kollekció, a Notes, Todos és Habits
alkollekciók lesznek rendelve:

#### Saved data pattern
  ![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/DocsAndCollections.png "Saved data")  

Végül minden alkollekcióba, a megfelelő helyükre, auto Id-val mentésre kerülnek a dokumentumok a bennük található adatokkal field-value párban.

#### Saved fields and values
   ![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/NoteDb2.png "Saved field and values")  





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
