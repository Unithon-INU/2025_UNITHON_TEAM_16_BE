# ─── 1) Build 스테이지 ───────────────────
FROM gradle:7.6-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean bootJar --no-daemon

# ─── 2) Runtime 스테이지 ─────────────────
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
CMD ["--spring.profiles.active=prod"]
