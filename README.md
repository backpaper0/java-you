# あなたとJAVAジェネレータ

## Overview

[Payara Micro](http://payara.co/home)を試す為に作ったシンプルなJava EEアプリケーションだったけどcargo-maven3-pluginを使ってWildFlyやPayaraで動かすように変更。

使っているEEな技術〜

* JSF
* JAX-RS
* CDI
* Concurrency Utilities for Java EE
* JPA
* JTA
* Bean Validation

Java EE/Jakarta EEフォーエバー(～ 'ω' )～

## How to Run

まずはWARを作る。

```
./mvnw package
```

それからCargoでアプリケーションサーバー(WildFly)を動かす。

```
./mvnw cargo:run
```

http://localhost:8080/java-you/ を今すぐ開いてあなたとJAVA！

Payaraで動かしたい場合は`-Ppayara`を付ければ良い。

```
./mvnw cargo:run -Ppayara
```

TomEEは`-Ptomee`。

```
./mvnw cargo:run -Ptomee
```

## License

[The MIT License](https://opensource.org/licenses/MIT)

## Author

[@backpaper0](https://twitter.com/backpaper0)

