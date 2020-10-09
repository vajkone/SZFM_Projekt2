Funkcionális specifikáció
-------------------------

### 1. Jelenleg helyzet leírása
A megrendelő jelenlegi helyzete a [követlményspecifikáció](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md) alapján az alábbi:  

*Cégünk oktatási, nevelési, módszertani tanácsadás, szakmai tervezés és egyéb oktatást kiegészítő, de nem közvetlenül oktatási szolgáltatásokat kínál. Ügyfeleink közé tartoznak
magánoktatóktól kezdve, általános és középiskolák valamint egyetemek is. Jelenlegi módszertanási ajánlásaink nem veszik teljesen figyelmbe a technológiai fejlesztések által kínált
előnyöket melyek a diákok javára válhatnak és ezen változtatni szeretnénk. Egyre több ügyfelünk igényel olyan szolgáltatásokat melyeket okos-eszközökön (telefon, tablet) vehetnek
igénybe és melyek hozzájárulnak a produktivitás növeléséhez valamint akadémiai sikereikhez. Jelenlegi helyzetünkben, ha ilyen kéréssel fordulnak hozzánk, mi csak egy harmadik
féltől származó alkalmazáshoz tudjuk ügyfeleinket továbbirányítani, valamint az alkalmazásnak a megfelelő, az ügyfél szükségleteit kielégítő használatát bemutatni és javasolni.
Ezen szeretnénk változtatni olyan formában, hogy a legtöbbet igényelt ilyen jellegű szolgáltatásokat egy tető alá hoznánk egy, a sajátunként értékesített applikációban.*  

A megrendelő cég jelenleg helyzetét mérlegelve és a cég igényei alapján elképzelt termékkel szemben támasztott követelményeket szem előtt tartva az alábbi funkcionális
specifikációban adjuk válaszunkat.


### 2. Vágyálom rendszer leírása
A megrendelő cég egy olyan mobil (android) applikáció fejlesztésével kereste meg cégünket melyet oktatásfejlesztési, tanulásjavítási és produktívtás növelési céllal ajánlana/
értékesítene azon ügyfeleinek akik elsősorban középiskolai és egyetemi diákok:  

*"elsősorban egyetemeknek és azok hallgatóinak (szeretnénk) egy olyan applikációt ajánlani, ami segíti őket az órai/előadásokon történő hatékony jegyzetelésben, hasznos és
produktív szokásaik monitorozásában (habit tracking), valamint elkészítendő feladataik hatékony feljegyzésében és nyomonkövetésében (TODO List). Az alkalmazás jegyzetelő részét
a világhírű Cornell jegyzetelési metódus mobilra illetve tabletre való átültetésével szeretnénk elérni. Ehhez egy könnyen, "macera nélkül" kezelhető felületre van szükség, ami
három részre (kérdések/kulcsszavak, jegyzet, összefoglaló) osztja az eszköz képernyőjét. Az egyes részek legyenek egymástól láthatóan elkülönítve, használatuk legyen intuitív. A
diákok a jegyzeteiket tudják könnyen elmenteni, keresni, módosítani, törölni, továbbá számukra logikus csoportokba (pl tantárgy szerint) rendezni. Azzal hogy a jegyzetjeik
mellett a diákok a jó szokásaikat és elvégzendő feladataikat is nyomon tudják követni, azt reméljük, hogy az applikáció ezen három eleme harmóniában élve egymással, elősegítik
egymást, pl egy olyan TODO hogy "jegyzetek átnézése" rögtön megoldható pusztán egy másik tabra való váltással ugyanazon applikáción belül, ezzel megspórolva az azzal járó
fáradtságot hogy kikeressük majd megnyitünk egy másik jegyzetelő appot, vagy akár a füzetünkben keresgélünk. Ezzel nagyban csökkenthető a tanulással járó "súrlódás", ami során
sok kis apró dolgot kell elvégezni a diáknak még a tényleges tanuláshoz eljut. Ezeknek a lépéseknek a végigjárása gyakran azt eredményezi diákoknál, hogy a célig, ami a
tényleges tanulás, a diák sosem jut el, mert egy részfolyamat közben mondjuk elterelődik a figyelme. Azzal hogy a tanulást biztosító eszközöket, valamint ennek és hasonló jó
szokások hatékony számontartását egy fedél alá hozzuk, bizunk benne hogy nagyban növelni tudjuk a diákok produktivitását azzal pedig akadémiai sikereiket. Továbbá szeretnénk ha
az alkalmazás Cloud alapú lenne, azaz ha egy diák az egyik eszközről elmentett jegyzeteit, feljegyzett teendőit és szokásait egy másik eszközön szeretné megtekinteni akkor
hitelesítő adatait (felhasználó név, jelszó) megadva, ezt további bonyodalom nélkül megtehesse."*  

Összefoglalva tehát egy olyan applikáció megteremtése a cél mely három fő funkcióval rendelkezik:
- Jegyzetelés
- Teendők számontartása
- Szokások nyomonkövetése  

Ezen felül az applikáció legyen cloud alapú, tehát az adatok (az elmentett jegyzetek, teendők és szokások) ne helyileg legyenek tárolva az eszközön, hanem felhőben, a diákok
fiókjához kapcsolva. Így az applikáció internetes hozzáférsést is igényel.  

### 3. Jelenlegi üzleti folyamatok  
Ahogy a megrendelői [követlményspecifikáció](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md)ban is olvasható a megrendelő jelenleg az alábbi üzleti folyamatokat folytatja:  

3.1 Iskolai tanácsadás.
3.2 Igények keresése közvélemény kutatással a diákok és tanárok körében.  
3.3 Tanulási módszerek publikálása.  
3.4 Különböző jegyzetelési módszerek tanítása Pl.Cornell módszer.  
3.5 Speciális igényű diákok segítése.  
3.6 Diákok jegyzetelési szokásainak felmérése.  
3.7 Diákok időbeosztásának kutatása.  
3.8 Diákok helyes időbeosztásának segítése.  

Összeségében tehát, a fentiek alapján a programnak a lehető legjobban diákbarátnak kell lennie, továbbá megfelelőnek kell lennie, akár speciális igényű diákoknak is. Semmilyen felesleges, esetekben bonyolultabb funkciót nem tartalmazhat. A cél, hogy a program teljesen beleilleszkedjen a cég jelenleg is végzett tevékenységeibe.  

### 4. Igényelt üzleti folyamatok

A megrendelő a [követlményspecifikációban](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md) kifejtette,hogy milyen folyamatokat szeretne megvalósítani.A már meglévő üzleti folyamataihoz,szeretne egy mobilalkalmazás kifejlesztését,amiben a felhasználók jegyzeteket tudnának létrehozni,illetve a különböző napi teendőiket követni.
Ebben a pontban a már általunk is kiegészített folyamatokat írjuk le.

4.1 Cloudos bejelentkezés => Felhasználó név és jelszó beírása után bejelentkezés gombbal belépés.  
4.2 Ha még nem regisztrált felhasználó,akkor új fiók létrehozása gombbal, új fiókot lehet regisztrálni.  
4.3 Cloudos jegyzet illetve teendők tárolása.  
4.4 Jegyzetek egyszerű kilistázása.  
4.5 Új jegyzet felvétele => plusz gomb megnyomása => jegyzet szerkesztő felület megjelenése => jegyzet megírása után mentésre kattintás.  

### 5. A rendszerre vonatkozó külső megszorítások  
A megrendelő a [követlményspecifikációban](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md) kifejtette, a rendszerre vonatkozó külső megszorításokat.
