# kafka: C:\kafka_2.13-3.2.0\bin\windows
# Start server:
zookeeper-server-start.bat C:\kafka_2.13-3.2.0\config\zookeeper.properties
kafka-server-start.bat C:\kafka_2.13-3.2.0\config\server.properties
# Command kafka:
kafka-topics.bat --create --topic nxh --bootstrap-server localhost:9092
kafka-topics.bat --list --bootstrap-server localhost:9092