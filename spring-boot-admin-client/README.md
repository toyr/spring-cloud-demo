#Client端配置
| 参数 | 默认值 | 说明 |
| --- | --- | --- |
spring.boot.admin.client.enabled    |    true    |    是否启用springbootAdmin客户端
spring.boot.admin.client.url    |        |    要注册的server端的url地址。如果要同时在多个server端口注册，则用逗号分隔各个server端的url地址
spring.boot.admin.client.api-path    |    instances    |    server端获取client信息的路径，默认情况下server通过访问/instances请求来获取到client端的信息。（client端向server端注册，注册成功后server端会给该client创建一个唯一的clientID值。当server端需要获取client的信息，比如health信息时，server端会发送http://IP:PORT/instances/clientID/actuator/health即可，这里的http://IP:PORT是client所在服务器的IP地址，instances就是该属性的值）
spring.boot.admin.client.username    |        |    如果server端需要进行认证时，该属性用于配置用户名
spring.boot.admin.client.password    |        |    如果server端需要进行认证时，该属性用于配置密码
spring.boot.admin.client.period    |    10000    |    注册时间间隔，单位是毫秒（client通过持续不断地向server端进行注册来保持client端与server端的连接）
spring.boot.admin.client.connect-timeout    |    5000    |    注册连接超时时间，单位是毫秒.当client向server进行注册时，如果5秒钟没有注册完成则认为本次注册失败；
spring.boot.admin.client.read-timeout    |    5000    |    注册读取超时，单位是毫秒
spring.boot.admin.client.auto-registration    |    true    |    是否开启自动注册
spring.boot.admin.client.auto-deregistration    |    null    |    是否开启自动注销,如果服务端运行在云平台，默认值是true
spring.boot.admin.client.register-once    |    true    |    如果值为true的话，client只会在一个server端进行注册（按照spring.boot.admin.client.url中设置的server的顺序）。如果该server端宕机，会自动在下一个server端进行注册。如果该属性值为false，则会在所有的server端进行注册
spring.boot.admin.client.instance.management-url    |    默认该属性值与management-base-url 和 management.context-path两个属性值有关    |    注册的management-url，如果可用的url不同的话可以重写该值
spring.boot.admin.client.instance.management-base-url    |    默认该属性值与management.port, service-url 以及server.servlet-path有关    |    用于计算management-url 的基本URL。该路径值在运行时进行获取并赋值给 base url
spring.boot.admin.client.instance.health-url    |        |    注册的health-url地址，如果可用的url不同可以重写该值
spring.boot.admin.client.instance.service-base-url    |        |    用于计算service-url 的基本URL。该路径值在运行时进行获取并赋值给 base url。
spring.boot.admin.client.instance.service-url    |        |    注册的service-url值
spring.boot.admin.client.instance.name    |    默认值是配置的spring.application.name的值    |    客户端工程的名字
spring.boot.admin.client.instance.prefer-ip    |    false    |    是否使用注册的ip地址来取代上述各个url中hostname的值