plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("http://localhost:8081/repository/maven-snapshots/")
        isAllowInsecureProtocol = true
        credentials {
            username = "admin"
            password = "myPassword123"
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.example:mylib:1.2-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}