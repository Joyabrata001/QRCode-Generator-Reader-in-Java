# QR Code Generator and Reader in Java

This project provides utilities for generating and reading QR codes in Java. It leverages the open-source libraries from [Project Nayuki](https://www.nayuki.io/page/qr-code-generator-library) for QR code generation and [ZXing](https://github.com/zxing/zxing) for QR code reading.

## Libraries Used

1. **QR Code Generator**:
   - Library: [Nayuki QR Code Generator](https://www.nayuki.io/page/qr-code-generator-library)
   - License: MIT
   - Description: A reliable and efficient library for generating QR codes. It provides various options for customizing the QR code such as error correction levels.

2. **QR Code Reader**:
   - Library: [ZXing (Zebra Crossing)](https://github.com/zxing/zxing)
   - License: Apache 2.0
   - Description: A popular library for reading data from QR codes. Although the official Google API is deprecated, the community-maintained version is still widely used and supported.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven or Gradle for dependency management

### Installation

#### Maven
Ensure the following dependencies in your `pom.xml`:
```xml
<dependencies>
    <!-- Nayuki QR Code Generator -->
    <dependency>
        <groupId>io.nayuki</groupId>
        <artifactId>qrcodegen</artifactId>
        <version>1.7.0</version>
    </dependency>
    <!-- ZXing Core -->
    <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>core</artifactId>
        <version>3.4.1</version>
    </dependency>
    <!-- ZXing Java SE Extensions -->
    <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>javase</artifactId>
        <version>3.4.1</version>
    </dependency>
</dependencies>