# Sos věci a tak :)

# Základní commandy v terminálu, na které si vzpomenu:
> `$` znamená základní oprávnění uživatele
> `#` znamená root oprávnění uživatele
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
11) `cat` -
12) `clear`
13) `echo`
14) `less`
15) `man`
16) `uname`
17) `whoami`
18) `tar`
19) `grep`
20) `head`
21) `tail`
22) `diff`
23) `cmp`
24) `conn`
25) `sort`
26) `export`
27) `zip`
28) `unzip`
29) `ssh`
30) `service`
31) `ps`
32) `kill and killall`
33) `df`
34) `mount`
35) `chmod`
36) ``

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

