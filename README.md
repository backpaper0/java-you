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
* Bean Validation

Java EEフォーエバー(～ 'ω' )～

## How to Run

IDEで `src/test/java/javayou/JavaYou.java` を実行する。

もしくは[Gradle](https://gradle.org/)でビルドして[Payara Micro](http://www.payara.co/introducing_payara_micro)のJARで動かす。
Payara Microで動かすためのGradleタスクを書いたので次のコマンドで実行できる。

```
gradlew run
```

"Deployed 1 wars"というログが出たら起動完了。
http://localhost:8080/java-you/ を今すぐ開いてあなたとJAVA！

### Docker

Dockerfileも用意してみたのでイメージ作ってみるも良し！
タスク作ったのでGradleでビルドできるます。

```
gradlew dockerBuild
docker run -d -p 8080:8080 java-you
```

## Roadmap

[WildFly-Swarm](https://github.com/wildfly-swarm/wildfly-swarm)も気になってる。

## License

[Apache License Version 2.0](apache.org/licenses/LICENSE-2.0.txt)

## Author

[@backpaper0](https://twitter.com/backpaper0)

