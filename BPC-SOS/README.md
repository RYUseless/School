# Sos věci a tak :)

# Základní commandy v terminálu, na které si vzpomenu:
> `$` znamená základní oprávnění uživatele
> `#` znamená root oprávnění uživatele

+ pokud mi terminál nechce brát příkaz kvůli nějaké neshodě v samotném příkazu, '--help' pomáhá, např:
``` 
$ uname --help
```

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