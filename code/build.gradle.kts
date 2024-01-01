import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.DokkaConfiguration.Visibility

plugins {
    kotlin("jvm") version "1.6.10"
    application
    id("org.jetbrains.dokka") version "1.9.10"
}

group = "me.hosakashun"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
}

dependencies {
    implementation("io.ktor:ktor-server-netty:1.6.3")
    implementation("io.ktor:ktor-html-builder:1.6.3")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.0")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("ServerKt")
}

tasks.dokkaHtml {
    outputDirectory.set(rootDir.resolve("documentation/html"))
}

tasks.dokkaGfm {
    outputDirectory.set(rootDir.resolve("documentation/markdown"))
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        configureEach {
            moduleName.set("Kaikei")
            // ModuleとPackageの説明追加のために、対象ファイルを追加
            includes.from("Module.md")
            // 明らかな機能を抑制するかどうか。デフォルト:trueだが、明示的に指定する。
            suppressObviousFunctions.set(true)
            // 指定したクラスで明示的にオーバーライドされていない継承メンバを抑制するかどうか。
            suppressInheritedMembers.set(true)
            documentedVisibilities.set(
                setOf(
                    Visibility.PUBLIC,
                    Visibility.PROTECTED,
                )
            )
        }
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}