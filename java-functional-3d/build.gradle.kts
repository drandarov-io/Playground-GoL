plugins {
    java
}


dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:${rootProject.extra.get("jUnit5Version")}")
    testCompile("org.junit.jupiter:junit-jupiter-params:${rootProject.extra.get("jUnit5Version")}")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:${rootProject.extra.get("jUnit5Version")}")
}


configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}