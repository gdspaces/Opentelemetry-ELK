# OpenTelemetry Demo Project

## Overview

This demo project demonstrates an end-to-end observability pipeline using OpenTelemetry for tracing and metrics. It consists of three main flows:
1. **Tracing and Spans** for application observability.
2. **Application Metrics** for monitoring service health and performance.
3. **Server Metrics** for tracking server resource utilization.

## Architecture

### 1. Tracing and Span Flow
This flow tracks request traces across services, capturing latency and dependencies for better observability of distributed systems.

- **Technology Stack**:
  - **Java Spring Boot Application** -> **OpenTelemetry SDK** -> **Jaeger Collector** -> **Kafka** -> **Jaeger Ingester** -> **Cassandra** -> **Jaeger Query**
 


- **Explanation**:
  - The Java Spring Boot application generates traces using OpenTelemetry SDK.
  - The Jaeger Collector receives and forwards traces to Kafka.
  - Jaeger Ingester consumes traces from Kafka, stores them in Cassandra, and exposes them via Jaeger Query for visual analysis.

### 2. Application Metrics Flow
This flow collects application-specific metrics like request rate, error rate, and response time.

- **Technology Stack**:
  - **Java Spring Boot Application** -> **OpenTelemetry SDK** -> **Prometheus** -> **Grafana**

- **Explanation**:
  - The Java Spring Boot application collects metrics using OpenTelemetry SDK.
  - Prometheus scrapes these metrics and stores them for analysis.
  - Grafana provides a visual dashboard for real-time application metrics.
 


### 3. Server Metrics Flow
This flow captures server health metrics such as CPU, memory, and load.

- **Technology Stack**:
  - **OpenTelemetry Collector** -> **Prometheus** -> **Grafana**

- **Explanation**:
  - The OpenTelemetry Collector gathers system-level metrics and sends them to Prometheus.
  - Grafana visualizes these metrics, providing insights into server performance.

## Setup

### Prerequisites

1. **Java 17 or later** (for Spring Boot Application)
2. **Docker** and **Docker Compose** (for deploying Jaeger, Prometheus, Kafka, Cassandra, and Grafana)
3. **Prometheus and Grafana** configured for data storage and visualization

### Steps

1. **Clone the Repository**:
    ```bash
    git clone <repository_url>
    ```

2. **Build the Spring Boot Application and initial setup**:
    ```bash
    ./run.ksh
    ```

3. **Deploy Components**:
    - Run Docker Compose to deploy Jaeger, Kafka, Cassandra, Prometheus, and Grafana.
    ```bash
    docker-compose up -d
    ```

4. **Configure OpenTelemetry SDK**:
    - Set up tracing and metrics in the Spring Boot application using the OpenTelemetry SDK.

5. **Access Dashboards**:
   - **Jaeger UI**: [http://localhost:16686](http://localhost:16686) (for viewing traces)
   - **Grafana**: [http://localhost:3000](http://localhost:3000) (for viewing application and server metrics)
   - **Host Metrics**: [http://localhost:8889/metrics](http://localhost:8889/metrics) (for server metrics)
   - **Application Metrics**: [http://localhost:9464/metrics](http://localhost:9464/metrics) (for Delivery Service Application metrics)
   - **Application Metrics**: [http://localhost:9465/metrics](http://localhost:9465/metrics) (for Invetory Service Application metrics)
   - **Application Metrics**: [http://localhost:9466/metrics](http://localhost:9466/metrics) (for Order Service Application metrics)
   - **Kafka UI**: [http://localhost:8080/](http://localhost:8080/) (for monitoring Kafka)
   - **Prometheus UI**: [http://localhost:9090/](http://localhost:9090/) (for monitoring Prometheus)
   - 
## Usage

1. **Tracing**:
    - Interact with the Spring Boot application to generate traces.
    - Use Jaeger UI to view and analyze trace data.

2. **Application Metrics**:
    - View application-specific metrics in Grafana under the configured dashboard.

3. **Server Metrics**:
    - Monitor server health in Grafana under the server metrics dashboard.

## Summary

This project provides a comprehensive observability solution using OpenTelemetry, Jaeger, Prometheus, and Grafana. It covers distributed tracing, application metrics, and server monitoring, enabling effective monitoring of both application and infrastructure layers.
