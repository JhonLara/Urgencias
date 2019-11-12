plugins {
	id 'org.springframework.boot' version '2.2.0.RELEASE'
	id 'io.spring.dependency-management' version '1.0.8.RELEASE'
	id 'jacoco'
	id 'java'
	id "org.sonarqube" version "2.7"
}

group = 'com.ceiba.hotelmanager'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

sonarqube {
	properties {
		property "sonar.sourceEncoding", "UTF-8"
	}
}
configurations {
	developmentOnly
	runtimeClasspath {
		extendsFrom developmentOnly
	}
}

repositories {
	mavenCentral()
}
apply plugin: 'java'
apply plugin: 'jacoco'

dependencies {
	compile('org.modelmapper:modelmapper:1.1.0')
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok:1.18.10'
	annotationProcessor 'org.projectlombok:lombok:1.18.10'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	testCompile 'junit:junit:4.12'
	runtimeOnly 'com.h2database:h2'
	runtimeOnly 'mysql:mysql-connector-java'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
}

test {
	/*jacoco {
		append = false
		destinationFile = file("jacoco/jacocoTest.exec")
	}
	reports.junitXml.destination = file ("jacoco/test-results")
	*/
	useJUnitPlatform()
	dependsOn 'cleanTest'
}


//jacocoTestReport.dependsOn(test)

sonarqube {
	properties {
		property "sonar.sources", "src/main/java"
		property "sonar.java.binaries", "build/classes/java/main"
		property "sonar.tests", "src/test/java"
		property "sonar.test.binaries", "build/classes/java/test"
		property "sonar.jacoco.reportPaths", "build/jacoco/test.exec"
		property "sonar.junit.reportPaths", "build/test-results/test"
	}
}