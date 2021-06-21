# あなたとJAVAジェネレータ

## Overview

[Payara Micro](http://payara.co/home)を試す為に作ったシンプルなJava EEアプリケーションだったけどcargo-maven3-pluginを使ってWildFlyやPayaraで動かすように変更。

使っているEEな技術〜

* JSF
* JAX-RS
* CDI
* Concurrency Utilities for Java EE
* JPA
* Bean Validation

Java EE/Jakarta EEフォーエバー(～ 'ω' )～

## How to Run

まずはWARを作る。

```
mvn package
```

それからCargoでアプリケーションサーバーを動かす。

```
mvn cargo:run
```

http://localhost:8080/java-you/ を今すぐ開いてあなたとJAVA！

Payaraで動かしたい場合は`-Ppayara`を付ければ良い。

```
mvn cargo:run -Ppayara
```

TomEEは`-Ptomee`。

```
mvn cargo:run -Ptomee
```

## License

[Apache License Version 2.0](apache.org/licenses/LICENSE-2.0.txt)

## Author

[@backpaper0](https://twitter.com/backpaper0)

