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
        gradleVersion = "5.0-rc-4"
    }
}