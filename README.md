# Iron Ed25519 Signature Suite 2020

An implementation of the [EdDSA Cryptosuite 2020](https://w3c-ccg.github.io/di-eddsa-2020/) in Java.

[![Java 17 CI](https://github.com/filip26/iron-ed25519-cryptosuite-2020/actions/workflows/java17-build.yml/badge.svg)](https://github.com/filip26/iron-ed25519-cryptosuite-2020/actions/workflows/java17-build.yml)
[![Android (Java 8) CI](https://github.com/filip26/iron-ed25519-cryptosuite-2020/actions/workflows/java8-build.yml/badge.svg)](https://github.com/filip26/iron-ed25519-cryptosuite-2020/actions/workflows/java8-build.yml)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/806688cdb1d248e8b5cc2a67f6c2f0f8)](https://www.codacy.com/gh/filip26/iron-ed25519-cryptosuite-2020/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=filip26/iron-ed25519-cryptosuite-2020&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/806688cdb1d248e8b5cc2a67f6c2f0f8)](https://www.codacy.com/gh/filip26/iron-ed25519-cryptosuite-2020/dashboard?utm_source=github.com&utm_medium=referral&utm_content=filip26/iron-ed25519-cryptosuite-2020&utm_campaign=Badge_Coverage)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=filip26_iron-ed25519-cryptosuite-2020&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=filip26_iron-ed25519-cryptosuite-2020)
[![Maven Central](https://img.shields.io/maven-central/v/com.apicatalog/iron-ed25519-cryptosuite-2020.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.apicatalog%22%20AND%20a:%22iron-ed25519-cryptosuite-2020%22)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Features
* [Ed25519Signature2020](https://w3c-ccg.github.io/di-eddsa-2020/#ed25519signature2020)
  * Verifying VC/VP
  * Issuing VC/VP
* [VC HTTP API & Service](https://github.com/filip26/iron-vc-api)

## Installation

### Maven

```xml
<!-- Java 17 -->
<dependency>
    <groupId>com.apicatalog</groupId>
    <artifactId>iron-ed25519-cryptosuite-2020</artifactId>
    <version>0.8.1</version>
</dependency>

<dependency>
    <groupId>com.apicatalog</groupId>
    <artifactId>iron-verifiable-credentials</artifactId>
    <version>0.8.1</version>
</dependency>
```

or

```xml
<!-- Android (Java 8, Tink) -->
<dependency>
    <groupId>com.apicatalog</groupId>
    <artifactId>iron-ed25519-cryptosuite-2020-jre8</artifactId>
    <version>0.8.1</version>
</dependency>

<dependency>
    <groupId>com.apicatalog</groupId>
    <artifactId>iron-verifiable-credentials-jre8</artifactId>
    <version>0.8.1</version>
</dependency>
```

### Gradle

```gradle
compile group: 'com.apicatalog', name: 'iron-ed25519-cryptosuite-2020-jre8', version: '0.8.1'
```

## Documentation

[![javadoc](https://javadoc.io/badge2/com.apicatalog/iron-ed25519-cryptosuite-2020/javadoc.svg)](https://javadoc.io/doc/com.apicatalog/iron-ed25519-cryptosuite-2020)

## Usage

### Verifying 

```java
try {
  Vc.verify(credential|presentation, new Ed25519Signature2020())
      
    // optional
    .base(...)
    .loader(documentLoader) 
    .statusVerifier(...)
    .useBundledContexts(true|false)

    // custom | suite specific | parameters
    .param(DataIntegrity.DOMAIN.name(), ....)

    // assert document validity
    .isValid();
    
} catch (VerificationError | DataError e) {
  ...
}

```

### Issuing

```java
var suite = new Ed25519Signature2020();

var options = suite.createOptions()

    // proof options
    .verificationMethod(...)
    .purpose(...)
    .created(...)
    
    // optional
    .domain(testCase.domain);

Vc.sign(credential|presentation, keys, options)

   // optional
   .base(...)
   .loader(documentLoader) 
   .statusVerifier(...)
   .useBundledContexts(true|false)

   // return signed document in a compacted form
   .getCompacted(context);

```

## Contributing

All PR's welcome!

### Building

Fork and clone the project repository.

#### Java 17
```bash
> cd iron-ed25519-cryptosuite-2020
> mvn clean package
```

#### Java 8
```bash
> cd iron-ed25519-cryptosuite-2020
> mvn -f pom_jre8.xml clean package
```

## Resources
* [EdDSA Cryptosuite 2020](https://w3c-ccg.github.io/di-eddsa-2020/)
* [Iron Verifiable Credentials](https://github.com/filip26/iron-verifiable-credentials)

## Sponsors

<a href="https://github.com/digitalbazaar">
  <img src="https://avatars.githubusercontent.com/u/167436?s=200&v=4" width="40" />
</a> 

## Commercial Support
Commercial support is available at filip26@gmail.com
