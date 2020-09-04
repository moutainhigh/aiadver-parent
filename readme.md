爱因智能java微服务技术框架

#### sonar配置

```shell script
mvn sonar:sonar \
  -Dsonar.projectKey=csg-parent \
  -Dsonar.host.url=http://192.168.20.3:9002 \
  -Dsonar.login=73aa6622d9c0ce8dcafd17c6e96fc3c03a1ae688
```

#### skywalking配置

```shell script
-javaagent:E:\Java\apache-skywalking-apm-bin\agent\skywalking-agent.jar \
  -Dskywalking.agent.service_name=${spring.applicaiton.name} \
  -Dskywalking.collector.backend_service=192.168.20.3:11800
```

#### keypair文件生成

```shell script
keytool -genkeypair \
    -alias aiadver-jwt \
    -validity 3650 \
    -keyalg RSA \
    -dname "CN=aiadver-jwt,OU=aiadver,O=iflytek,L=guangzhou,C=CN" \
    -keypass aiadver123 \
    -keystore aiadver.jks \
    -storepass iflytek123

keytool -list -rfc --keystore aiadver.jks | openssl x509 -inform pem -pubkey
```