plugins {
    id("zavudev.kotlin")
    application
}

dependencies {
    implementation(project(":zavudev-kotlin-core"))
    implementation(project(":zavudev-kotlin-client-okhttp"))
}

application {
    // Use `./gradlew :zavudev-kotlin-example:run` to run `Main`
    // Use `./gradlew :zavudev-kotlin-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.zavudev.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
