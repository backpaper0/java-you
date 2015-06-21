あなたとJAVAジェネレータ
==================================================

## Overview

[Payara Micro](http://payara.co/home)を試す為にシンプルなJava EEアプリケーションを書いてみてる。

使っているEEな技術〜

* JSF
* JAX-RS
* CDI
* Concurrency Utilities for Java EE
* JPA

Java EEフォーエバー(～ 'ω' )～

## How to Run

IDEで `src/test/java/javayou/JavaYou.java` を実行する。

もしくは[Gradle](https://gradle.org/)でビルドして[Payara Micro](http://www.payara.co/introducing_payara_micro)のJARで動かす。
私の環境でのコマンド例はこちら。

```
gradle --daemon build
java -jar ~/payara-micro-4.1.152.1.jar --deploy ./build/libs/java-you.war
```

"Deployed 1 wars"というログが出たら起動完了。
http://localhost:8080/java-you/ を今すぐ開いてあなたとJAVA！

## Roadmap

[WildFly-Swarm](https://github.com/wildfly-swarm/wildfly-swarm)も気になってる。

## License

[Apache License Version 2.0](apache.org/licenses/LICENSE-2.0.txt)

## Author

[@backpaper0](https://twitter.com/backpaper0)

