plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.hibernate:hibernate-core:6.3.0.Final")
    implementation("mysql:mysql-connector-java:5.1.13")
}

tasks.test {
    useJUnitPlatform()
}