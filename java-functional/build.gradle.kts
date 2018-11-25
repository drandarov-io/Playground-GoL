plugins {
    java
}


val jUnit5Version = "5.3.1"


dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:$jUnit5Version")
    testCompile("org.junit.jupiter:junit-jupiter-params:$jUnit5Version")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$jUnit5Version")
}


configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}