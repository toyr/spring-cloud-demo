# 主要的功能点有：

- 显示应用程序的监控状态
- 应用程序上下线监控
- 查看 JVM，线程信息
- 可视化的查看日志以及下载日志文件
- 动态切换日志级别
- Http 请求信息跟踪
- 其他功能点……

#Server端配置
| 参数 | 默认值 | 说明 |
| --- | --- | --- |
spring.boot.admin.context-path	|/	|server端的访问路径
spring.boot.admin.monitor.period|	10000|	更新client端状态的时间间隔，单位是毫秒
spring.boot.admin.monitor.status-lifetime|	100000|	client端状态的生命周期，该生命周期内不会更新client状态。单位是毫秒
spring.boot.admin.monitor.connect-timeout|	2000|	查询client状态信息时的连接超时时间，单位是毫秒（如果2秒内没有获取到client的状态信息，则认为连接已经断开）
spring.boot.admin.monitor.read-timeout|	2000|	查询client状态信息时的读取超时时间，单位是毫秒（如果2秒内没有获取到client的状态信息，则认为读取失败）
spring.boot.admin.metadata-keys-to-sanitize|	默认值是".password", ".secret",".∗secret", ".key", ".",".token", ".credentials.", ".*vcap_services",".credentials.",".∗vcap services"|	要被过滤掉的元数据（当与正则表达式相匹配时，这些数据会在输出的json数据中过滤掉）
spring.boot.admin.probed-endpoints|	默认是"health", "env", "metrics", "httptrace:trace", "threaddump:dump", "jolokia", "info", "logfile", "refresh", "flyway", "liquibase", "heapdump", "loggers", "auditevents"|	要获取的client的端点信息
spring.boot.admin.instance-proxy.ignored-headers|	默认值是"Cookie", "Set-Cookie", "Authorization"|	向client发起请求时不会被转发的headers信息
spring.boot.admin.ui.brand|		|在导航栏中显示的brand值
spring.boot.admin.ui.title|	默认是"Spring Boot Admin"|	显示的页面标题
