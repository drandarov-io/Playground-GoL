plugins {
    java
}

val jUnit5Versin = "5.3.1"

group = "io.drandarov"
version = "1.0"

repositories {
    mavenCentral()
}


dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:$jUnit5Versin")
    testCompile("org.junit.jupiter:junit-jupiter-params:$jUnit5Versin")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$jUnit5Versin")
}


configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    getByName<Wrapper>("wrapper") {
        distributionType = Wrapper.DistributionType.ALL
        gradleVersion = "5.0-rc-4"
    }
}