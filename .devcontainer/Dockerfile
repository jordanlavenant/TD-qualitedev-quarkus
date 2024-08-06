FROM debian:12-slim

RUN apt update
RUN apt install -y git curl wget unzip

# Install JDK 17
RUN apt install -y openjdk-17-jdk-headless=17.0.11+9-1~deb12u1 openjdk-17-jre-headless=17.0.11+9-1~deb12u1
# Install Gradle 7
RUN mkdir /opt/gradle
WORKDIR /opt/gradle
RUN wget https://services.gradle.org/distributions/gradle-7.6.4-bin.zip
RUN unzip -d /opt/gradle gradle-7.6.4-bin.zip
ENV PATH="/opt/gradle/gradle-7.6.4/bin:${PATH}"
RUN rm gradle-7.6.4-bin.zip

# Install Node 22
RUN curl -fsSL https://deb.nodesource.com/setup_22.x -o nodesource_setup.sh
RUN bash nodesource_setup.sh
RUN apt install -y nodejs
# Install PNPM
RUN corepack enable pnpm
RUN corepack use pnpm@9.6.0
