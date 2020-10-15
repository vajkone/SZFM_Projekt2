Rendszerterv a jegyzetelő alkalmazáshoz
---------------------------------------


### 3. Üzleti folyamatok

![alt text](https://github.com/vajkone/SZFM_Projekt2/blob/main/K%C3%A9pek/BPMNF.png "BPMN diagramm")

Ezzel a programmal,a diákoknak próbálunk segítséget nyújtani. Ezzel a programmal képesek lesznek jegyzeteket létrehozni,a különböző napi teendőiket nyomon követni,
illetve a szokásaikat is megfigyelhetik. Mindezt egy Cloud alapú könnyen kezelhető felhasználói felületen.Ahogy a fent látható folyamat ábrán is látszik
a felhasználó a kezdő képernyőn képes lesz belépni,ha már van fiókja,ha pedig nincs akkor regisztálhat. Ha belépett akkor elsősorban a jegyzeteit fogja látni.
Itt a jegyzetek között görgetéssel vagy különböző paraméterek segítségével kereshet is. Egy "+" gombbal új jegyzetet vehet fel. Egy "X" gombbal pedig törölni tudja az adott jegyzetet.  
Ha pedig már meglévő jegyzetet szeretne szerkeszteni,akkor egy egyszerű kattintással a jegyzetre,majd egy "Edit note" gombra kattintva a szerkesztő felületre kerülhet.
Ezután ha a teendőit szeretné látni a felhasználó,akkor egy egyszerű lapozással megteheti azt,mivel a felhasználói felület egy úgynevezett Tabbed activity, amin három féle lap lesz található. 
A teendős felületen ismét csak görgetéssel tud keresni.Ugyancsak egy gombnyomással hozzá adhat a felhasználó egy teendőt. És szerkeszteni is képes lesz mint a jegyzeteit. Valamint minden teendőhöz tartozik egy checkbox,amit kipipálva jelezheti,hogy elkészül az adott feladattal. Ezen a "fülön" ha tovább lapoz egyet a felhasználó,akkor pedig a szokásait tudja nyomon követni.  

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


### 12. Telepítési terv  
Az alábbi pontban az aplikáció telepítésének menete van leírva.

Az alkalmazást, egy .apk kiterjesztésű telepítő fájllal lehet telepíteni egy android operációs rendszerű eszközre. 
Az alkalmazás android rendszerű telefonra és tabletre lett fejlesztve, más android opercációs rendszerű eszközökön nem biztosított az alkalmazás megfelelő működése.
Emelett megszabás még, hogy az adott androidos eszköznek 5.0 vagy annál nagyobb verziószámú android operációs rendszerszerrel kell rendelkeznie
Az alkalmazás telepíse előtt, még engedélyeznünk kell az adott eszközön, az ismeretlen forrásból származó alkalmazások telepitését.
Az engedély megadásának módja eszközönként eltérhet.  
