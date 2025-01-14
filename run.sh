#!/bin/sh

cd order-inventory-delivery-system/

docker-compose up -d

cd DeliveryService

rm -rf nohup.out

mvn clean install

nohup java -javaagent:../opentelemetry-javaagent.jar \
     -Dotel.exporter.otlp.endpoint=http://0.0.0.0:4317 \
     -Dotel.exporter.otlp.protocol=grpc \
     -Dotel.resource.attributes=service.name=DeliveryService\
     -Dotel.metrics.exporter=prometheus \
     -Dotel.exporter.prometheus.port=9464 \
	 -Dotel.logs.exporter=none \
     -Dotel.instrumentation.runtime-metrics.enabled=true \
     -jar target/DeliveryService-0.0.1-SNAPSHOT.jar &\
	 
cd ../InventoryService

rm -rf nohup.out

mvn clean install

nohup java -javaagent:../opentelemetry-javaagent.jar \
     -Dotel.exporter.otlp.endpoint=http://0.0.0.0:4317 \
     -Dotel.exporter.otlp.protocol=grpc \
     -Dotel.resource.attributes=service.name=InventoryService\
     -Dotel.metrics.exporter=prometheus \
	 -Dotel.logs.exporter=none \
     -Dotel.exporter.prometheus.port=9465 \
     -Dotel.instrumentation.runtime-metrics.enabled=true \
     -jar target/InventoryService-0.0.1-SNAPSHOT.jar &\

cd ../OrderService

rm -rf nohup.out

mvn clean install

nohup java -javaagent:../opentelemetry-javaagent.jar \
     -Dotel.exporter.otlp.endpoint=http://0.0.0.0:4317 \
     -Dotel.exporter.otlp.protocol=grpc \
     -Dotel.resource.attributes=service.name=OrderService\
	 -Dotel.logs.exporter=none \
     -Dotel.metrics.exporter=prometheus \
     -Dotel.exporter.prometheus.port=9466 \
     -Dotel.instrumentation.runtime-metrics.enabled=true \
     -jar target/OrderService-0.0.1-SNAPSHOT.jar &\

cd ..
cd ..

cd host 

#https://opentelemetry.io/docs/collector/installation/#deb-installation
nohup otelcol --config otel-collector-config.yaml &

cd ..


