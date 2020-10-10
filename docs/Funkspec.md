Funkcionális specifikáció
-------------------------

### 1. Jelenleg helyzet leírása
A megrendelő jelenlegi helyzete a [követelményspecifikáció](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md) alapján az alábbi:  

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
Ahogy a megrendelői [követelményspecifikáció](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md#3-jelenlegi-%C3%BCzleti-folyamatok)ban is olvasható a megrendelő jelenleg az alábbi üzleti folyamatokat folytatja:  

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

A megrendelő a [követelményspecifikációban](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md#4-ig%C3%A9nyelt-%C3%BCzleti-folyamatok) kifejtette,hogy milyen folyamatokat szeretne megvalósítani.A már meglévő üzleti folyamataihoz,szeretne egy mobilalkalmazás kifejlesztését,amiben a felhasználók jegyzeteket tudnának létrehozni,illetve a különböző napi teendőiket követni.
Ebben a pontban a már általunk is kiegészített folyamatokat írjuk le.

4.1 Cloudos bejelentkezés => Felhasználó név és jelszó beírása után bejelentkezés gombbal belépés.  
4.2 Ha még nem regisztrált felhasználó,akkor új fiók létrehozása gombbal, új fiókot lehet regisztrálni.  
4.3 Cloudos jegyzet illetve teendők tárolása.  
4.4 Jegyzetek egyszerű kilistázása.  
4.5 Új jegyzet felvétele => plusz gomb megnyomása => jegyzet szerkesztő felület megjelenése => jegyzet megírása után mentésre kattintás.  
4.6 Már meglévő jegyzet szerkesztése => jegyzetre kattintás után megjelenik a szerkesztő felület.  
4.7 Jegyzetek törlése => "X" gomb megnyomásával,előtte  program rá kérdez hogy biztosan törölni szeretné-e az adott jegyzetet a felhasználó.  
4.8  Keresés a jegyzetek között => keresés gombra kattintva keresés cím,címke és szövegrészlet alapján.  
4.9 Rendezés ABC sorrend szerint => gombra kattintva abc sorrend szerint növekvő,mégegyszer megnyomva csökkenő szerinti listázás.  
4.10 Rendezés létrehozás dátuma szerint => gombra kattintva létrehozása dátuma szerint növekvő/csökkenő kilistázás.  
4.11 Teendők egyszerű kilistázása.  
4.12 Feladat felvétele => egy gomb megnyomása ami a feladat létrehozó felületre lép át.  
4.13 Feladatok törlése => gomb megnyomásával,előtte  rá kérdez a program hogy biztosan törölni szeretné-e az adott feladatot a felhasználó.  
4.14 A feladatokhoz tartozik egy checkbox,amit kipipálva jelezheti a felhasználó,hogy elvégezte a feladatot.  
4.15 Minden feladathoz megadható egy határidő.  

A megrendelő a [követelményspecifikáció](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md#4-ig%C3%A9nyelt-%C3%BCzleti-folyamatok) 4.3-as pontjában a "hamburgermenü" alkalmazását szerette volna navigálásra használni a különböző nézetek között. Mi azonban a "hamburgermenü" helyett egy "Tabbed" nézetet javaslunk. A képernyő felső részén 3 fül között lehet választani.
A jegyzetek,TODO lista illetve a szokások követése között. Ezáltal egy kényelmesebb felhasználói élményt hozhatunk létre.  



### 5. A rendszerre vonatkozó külső megszorítások  
A megrendelő a [követelményspecifikációban](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md#5-a-rendszerre-vonatkoz%C3%B3-szab%C3%A1lyok) kifejtette, a rendszerre vonatkozó külső megszorításokat.  
Ezek az alábbiak:  

5.1 Az alkalmazás íródjon Kotlin vagy Java programozási nyelven, de előnyben részesítjük a kotlin nyelvet.  
5.2 Az alkalmazásban megjelenő összes kép formátuma JPEG vagy PNG legyen.  
5.3 Az alkalmazás grafikus felületei XML-ben készüljenek.  
5.4 Az alkalmazás működjön minden 5.0 vagy annál nagyobb verziószámú androidos mobiltelefonokon, tabletekenen.  
5.5 A bejelentkezési adatok, a napi teendők és a jegyzetek online adatbázisban legyenek tárolva.  
5.6 A jegyzetek szerkesztője a Cornell jegyzetelési módszert valósítsa meg.  
5.7 Napi teendőt lehessen elvégzettnek jelölni.  
5.8 Az alkalmazás magyar vagy angol nyelvű legyen.  
5.9 Az alkalmazás megjelenése legyen szolid, egyszerű színek használata, rikító színeket ne tartalmazzon.  
5.10 AZ alkalmazás legyen könnyen átlátható, ne tartalmazzon bonyolult megoldásokat.  

A cég álltal megadott megszorítások teljesíthetőek, ezért teljes mértékben, a megrendelő igényei szerint fogjuk létrehozni az applikációt.  

### 6. Követelménylista
A megrendelői [követelményspecifikációban](https://github.com/vajkone/SZFM_Projekt2/blob/main/docs/K%C3%B6vspec.md#6-k%C3%B6vetelm%C3%A9nylista) összeállított követelménylistából az általunk elgondolt applikáció az összes pontnak megfelel.  
Ezek a követelmények az alábbiak voltak:  

K01 Az applikáció legyen egyszerű megjelenésű, könnyen kezelhető  
K02 Letisztult, igényes, modern grafikus felülettel rendelkezzen  
K03 A színek, képek, ikonok legyenek összhangban, ne üssenek el egymástól  
K04 Az alkalmazás legyen alacsony rendszerigényű  
K05 Ne tartalmazzon felesleges funkciókat  
K06 Az applikáció legyen Cloud alapú  
K07 Felhasználónév, jelszó megadásával lehessen bejelentkezni  
K08 Ne férjen hozzá a telefonon lévő többi adathoz  

### 7. Fogalomszótár
<strong>Cornell jegyzetelési módszer</strong>: Walter Pauk által kifejlesztett, előadásokon leadott tananyag jegyzetelési és tanulási módszere, mely megkönnyíti az ismeretek rendszerezését, elsajátítását és felidézését. Egyetemi, főiskolai tanulmányok során, valamint felnőttképzésben eredményesen használható.  
<strong>TODO lista</strong>: A tennivalók listája az időgazdálkodás és időtervezés egyik eszköze, egy felsorolás az elvégzendő teendőkről, a feladatok elvégzésének lépéseiről.  
<strong>Habit tracker</strong>: A szokásfigyelő arra alkalmas, hogy napról-napra figyelemmel kísérjük szokásainkat.  
<strong>Java</strong>: Általános célú, konkurens, osztály alapú, objektumorientált programozási nyelv. A Java programok fordítása rendszerint egy gépfüggetlen bájtkód reprezentációba történik, melynek végrehajtására a Java virtuális gépek szolgálnak.  
<strong>Kotlin</strong>: Erősen típusos programozási nyelv, Java virtuális gépre és JavaScript kódra is lefordítható. Bár a szintaxisa nem kompatibilis a Java programnyelvvel, a Kotlin együttműködik a Java-ban írt kóddal és épít a java programkönyvtár részeire.  
<strong>Android</strong>: Az Android egy Linux alapú operációs rendszer, amely elsősorban mobil készülékek és tabletek részére készült.  
<strong>Grafikus felhasználói felület</strong>: A felhasználó és a számítógép közti kommunikációt lehetővé tevő felület, amely szöveges parancsok és üzenetek helyett részben vagy teljesen grafikus elemek segítségével teszi lehetővé a vezérlést és a visszajelzést.  
<strong>XML</strong>: eXtensible Markup Language" (bővíthető jelölő nyelv). Ez egy általános célú leíró nyelv, melynek célja elsősorban adatok, információk, és ezek struktúráinak leírása.  
<strong>PNG</strong>: A PNG (Portable Network Graphics) képek tárolására, veszteségmentes tömörítésére alkalmas fájlformátum.  
<strong>JPEG</strong>: A JPEG (Joint Photographic Experts Group) képek tárolására alkalmas fájlformátum.  
<strong>Hamburgermenü</strong>: Programozók által, általában a bal sarokban lévő 3 vízszintes ikonra hivatkozik,amely egy menülistát nyit meg.  
<strong>Checkbox</strong>: A felhasználói felületen látható kis doboz, amit a felhasználó kipipálhat (rákattintva arra) ezáltal egy bináris döntést hoz meg, jelen esetben ha ki van pipálva akkor kész a feladat, ha nincs akkor nincs kész az adott feladat.  

### 8. Használati esetek

Használati eset diagramm:  

![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/usecase.png "usecase diagram")

