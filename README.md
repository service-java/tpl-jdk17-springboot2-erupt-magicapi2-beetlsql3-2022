# README

起步例子

---

# 技术选型 @stack

- erupt
  - https://www.erupt.xyz/#!/doc

- magic-api
  - https://www.ssssssss.org/magic-api/pages/quick/start/

- BeetlSQL3
  - https://beetlsql-doc.vercel.app/start/quick

- easyexcel
  - https://www.yuque.com/easyexcel/doc/easyexcel

---

# 服务部署 @deploy

- Centos安装jdk-17
  - https://blog.csdn.net/qq_43310219/article/details/120328075

```
cd /usr/local
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
tar -zxvf jdk-17_linux-x64_bin.tar.gz 

vim /etc/profile

export JAVA_HOME=/usr/local/java
export PATH=$PATH:$JAVA_HOME/bin;
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar;

source /etc/profile
```

- 启动服务

```
/usr/local/jdk-17.0.2/bin/java --add-opens java.base/java.lang=ALL-UNNAMED \
  --add-opens java.base/sun.net.util=ALL-UNNAMED \
  -jar /opt/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod 
```

---

# 代码生成

```java
// GenCodeTests.java
List<String> tableNames = Arrays.asList(
    "user",
    "user2"
);

@Test
void genCode() {

}
```