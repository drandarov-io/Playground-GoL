import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm")
}


dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.processing:core:3.3.7")

    testCompile("org.junit.jupiter:junit-jupiter-api:${rootProject.extra["jUnit5Version"]}")
    testCompile("org.junit.jupiter:junit-jupiter-params:${rootProject.extra["jUnit5Version"]}")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:${rootProject.extra["jUnit5Version"]}")
}


tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    test {
        useJUnitPlatform()
    }
}