FROM openjdk
WORKDIR /build
COPY pom.xml
COPY src/ /build/src
RUN mvn -B clean package -D

ADD target/artifacts/mentoria_jar/mentoria.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]