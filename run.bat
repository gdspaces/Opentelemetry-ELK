cd DeliveryService

rm -rf nohup.out

mvn clean install

java -javaagent:..\opentelemetry-javaagent.jar -javaagent:..\elastic-apm-agent-1.52.1.jar -Dotel.exporter.otlp.endpoint=http://localhost:4317 -Dotel.exporter.otlp.protocol=grpc  -Dotel.resource.attributes=service.name=DeliveryService  -Dotel.metrics.exporter=prometheus  -Dotel.exporter.prometheus.port=9464   -Dotel.logs.exporter=none   -Dotel.instrumentation.runtime-metrics.enabled=true -Delastic.apm.service_name=DeliveryService -Delastic.apm.application_packages=com.example -Delastic.apm.server_urls=http://localhost:8200 -Delastic.apm.secret_token=devoops! -jar target/DeliveryService-0.0.1-SNAPSHOT.jar

