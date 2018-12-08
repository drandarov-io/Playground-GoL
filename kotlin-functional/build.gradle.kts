import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm")
}


dependencies {
    compile(kotlin("stdlib-jdk8"))

    testCompile("org.junit.jupiter:junit-jupiter-api:${rootProject.extra.get("jUnit5Version")}")
    testCompile("org.junit.jupiter:junit-jupiter-params:${rootProject.extra.get("jUnit5Version")}")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:${rootProject.extra.get("jUnit5Version")}")
}


tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}