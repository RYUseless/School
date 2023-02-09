# Sos věci a tak :)

# Základní commandy v terminálu, na které si vzpomenu:
> `$` znamená základní oprávnění uživatele <br>
> `#` znamená root oprávnění uživatele <br>
> pokud mi terminál nechce brát příkaz kvůli nějaké neshodě v samotném příkazu, stačí za příkaz dát'--help', používá se i když si člověk nepamatuje všechny možnosti příkazu a tak, např:
> ``` 
> $ uname --help
> ```
### Souhrn nejzákladnějších příkazů:
1) `ls` - vypíše vám adresáře
> dále se používá 'ls -l', 'ls -a'... 'ls --help' pro více infa
2) `pwd` - printne právě používaný adresář
3) `cd` - stejné jak na windowsu, navigace do adresářů
4) `mkdir` - vytvoření, víc k tomuto později
5) `mv` - přesun/přejmenování složek
6) `touch`- vytvoření souboru, opět víc později
7) `cp` - podobné jako `mv`, ale pro soubory
8) `rm` - smazání složek/souborů
> jak se přesně maže složka a jak soubor zmíněno později
9) `touch` - vytvoření souboru
10) `ln` - Shortcut, "symbolický link" k jinačím složkám
11) `cat` - CLI output souboru
12) `clear` - cls obdova z windowsu
13) `echo` - cout, printf, system.out.println
14) `less` - output print, tuším taky na soubory
15) `man` - show manuálu k danému comandu
16) `uname` - get základní info o OS/Uživateli
17) `whoami` - výpis momentálně aktivního uživatele
18) `tar` - unzip .tar, .tar.gz a další zipovací soubory
19) `grep` - Hledání stringu v daném výpisu
20) `head` - vrací specifický počet řádků, ze začátku
21) `tail` - vrací specifický počet řádků, z konce
22) `diff` - hledání rozdílů, mezi dvěma soubory
23) `cmp` - hledání shody dvou souborů
24) `conn` - *diff* + *cmp* vykombené dohromady
25) `sort` - třídění outputu dané složky
26) `export` - exportování proměnné v linuxu
27) `zip` - zazipování složek v linuxu
28) `unzip` - odzipování složek v linu
29) `ssh` - ssh connect
30) `service` - příkaz na zapnutí/vypnutí služeb
31) `ps` - zobrazení aktivních procesů
32) `kill and killall` - ukončení procesů
33) `df` - zobrazí filesystem informace
34) `mount` - moutnutí zařízení k linuxu
35) `chmod` - mění oprávnění souborů
36) `chown` - příkaz k oprávnění složek nebo souborů
37) `ifconfig` - internet info, *ipconfig* wannabe
38) `traceroute` - KOM feels :)
39) `wget` - stahuje soubory přímo z netu
40) `ufw` - firewall, velmi jednoduchý na setup, GUI verze je: *gufw*
41) `iptables` - základní firewall, lehce komplikovanější
42) `apt,dnf,pacman, yum, rpm` - package manager, přes něj se stahují aplikace, balíčky atd.
43) `sudo` - přidání oprávnění, admin
44) `cal` - command line kalendář
45) `alias` - shortcut na nějaký často používané commandy
46) `dd` - používá se pro vytváření usb bootable devices a taky při /boot/efi
47) `whereis` - vyhledání lokace dané složky/programu 
48) `whatis` - vyhledání, k čemu daný příkaz je
49) `top` - zobrazení procesů které jsou právě aktivní s danou omáčkou
50) `useradd`a `usermod` - vytvoření/edit uživatelů
51) `passwd` - vytvoření nebo update hesel daných uživatelů

### Akce a reakce s souborama a složkama:
1) Vytvoření souboru (.txt, .md a další soubory):
``` 
$ touch soubor.txt
```
2) Vytvoření složky (prostě složka):
``` 
$ mkdir jmeno_slozky
```
3) Smazání souboru:
``` 
$ rm soubor.txt
```
4) Smazání složky:
``` 
$ rm -rf jmeno_slozky
```
> f je zde optional, ale tuším forcuje to smazání or smthn @gugl pomůže. <br>
> pokud dostanete *access denied*, tak by mělo stačit dát `sudo` před příkazy, propřípadě pak změnit oprávnění.
### zjišťování základního infa
1) Jméno uživatele:
``` 
$ whoami 
```
2) Verze kernelu, na které mi běží os:
``` 
$ uname -r
```
> další možnosti 'uname' si člověk zobrazí přes 'uname --help' <br>
3) zobrazení particí os:
``` 
$ lsblk
```
4) zobrazení USB věcí v OS:
``` 
$ lsusb
```
5) víc yumge zobrazení info o filesystému os:
``` 
# fdisk -l
```
> zde je potřeba sudo <br>

