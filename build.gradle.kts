plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("plugin.jpa") version "1.9.25"
	id("com.microsoft.azure.azurefunctions") version "1.11.0"
}

group = "com.habit_tracker"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/release") }
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	// https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc
	implementation("com.microsoft.sqlserver:mssql-jdbc:12.8.1.jre11")

	// Import the Azure Spring Cloud dependencies BOM
	implementation(platform("com.azure.spring:spring-cloud-azure-dependencies:5.8.0"))

	// Azure App Configuration starter
	implementation("com.azure.spring:azure-spring-cloud-starter-appconfiguration-config:2.11.0")

	implementation("org.springframework.cloud:spring-cloud-function-kotlin:3.2.8") // Example version

	implementation("org.springframework.cloud:spring-cloud-function-kotlin:4.0.0")
	// Azure Functions Java library for HTTP triggers
	implementation("com.microsoft.azure.functions:azure-functions-java-library:1.4.2")

}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
