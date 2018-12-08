plugins {
    kotlin("jvm") version "1.3.10" apply false
}


val jUnit5Version by extra("5.3.1")


allprojects {
    group = "io.drandarov.gol"
    version = "1.0"

    repositories {
        mavenCentral()
    }
}


tasks {
    getByName<Wrapper>("wrapper") {
        distributionType = Wrapper.DistributionType.ALL
        gradleVersion = "5.0"
    }
}