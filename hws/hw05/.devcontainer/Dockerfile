FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

# System dependencies
RUN apt-get update && apt-get install -y \
    openjdk-11-jdk \
    git \
    build-essential \
    subversion \
    perl \
    cpanminus \
    unzip \
    wget \
    curl \
    ca-certificates \
    bzip2 \
    && rm -rf /var/lib/apt/lists/*

# Java 11 as default
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

# Clone Defects4J
WORKDIR /opt
RUN git clone https://github.com/rjust/defects4j.git
WORKDIR /opt/defects4j

# Install Perl module dependencies from the project's cpanfile, then bootstrap
RUN cpanm --notest --installdeps . && \
    ./init.sh

# Put Defects4J scripts (defects4j, gen_tests.pl, ...) on PATH
ENV PATH="/opt/defects4j/framework/bin:$PATH"

WORKDIR /workspace

CMD ["/bin/bash"]
