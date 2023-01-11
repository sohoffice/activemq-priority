Console log
===========

```
2023-01-11 14:04:21.392  INFO 97123 --- [           main] c.l.demo.activemqpriority.Producer       : Start producing
2023-01-11 14:04:21.396  INFO 97123 --- [           main] c.l.demo.activemqpriority.Producer       : Finish producing
2023-01-11 14:04:21.583  INFO 97123 --- [           main] .l.d.a.ActivemqPriorityDemoApplicationKt : Started ActivemqPriorityDemoApplicationKt in 1.126 seconds (JVM running for 1.787)
2023-01-11 14:04:21.630  INFO 97123 --- [ntContainer#0-1] c.l.d.a.Consumer$Consumer                : 3 HIGH 233
2023-01-11 14:04:21.630  INFO 97123 --- [ntContainer#0-5] c.l.d.a.Consumer$Consumer                : 4 LOW 236
2023-01-11 14:04:21.630  INFO 97123 --- [ntContainer#0-4] c.l.d.a.Consumer$Consumer                : 1 HIGH 232
2023-01-11 14:04:21.631  INFO 97123 --- [ntContainer#0-2] c.l.d.a.Consumer$Consumer                : 2 HIGH 233
2023-01-11 14:04:21.632  INFO 97123 --- [ntContainer#0-3] c.l.d.a.Consumer$Consumer                : 5 HIGH 237
2023-01-11 14:04:21.654  INFO 97123 --- [ntContainer#0-1] c.l.d.a.Consumer$Consumer                : 6 LOW 261
2023-01-11 14:04:21.656  INFO 97123 --- [ntContainer#0-4] c.l.d.a.Consumer$Consumer                : 7 LOW 263
2023-01-11 14:04:21.657  INFO 97123 --- [ntContainer#0-5] c.l.d.a.Consumer$Consumer                : 8 LOW 264
2023-01-11 14:04:21.658  INFO 97123 --- [ntContainer#0-2] c.l.d.a.Consumer$Consumer                : 9 LOW 266
2023-01-11 14:04:21.660  INFO 97123 --- [ntContainer#0-3] c.l.d.a.Consumer$Consumer                : 10 HIGH 266
2023-01-11 14:04:21.668  INFO 97123 --- [ntContainer#0-6] c.l.d.a.Consumer$Consumer                : 11 HIGH 272
2023-01-11 14:04:21.672  INFO 97123 --- [ntContainer#0-1] c.l.d.a.Consumer$Consumer                : 12 HIGH 277
2023-01-11 14:04:21.673  INFO 97123 --- [ntContainer#0-4] c.l.d.a.Consumer$Consumer                : 13 HIGH 278
2023-01-11 14:04:21.675  INFO 97123 --- [ntContainer#0-5] c.l.d.a.Consumer$Consumer                : 14 LOW 282
2023-01-11 14:04:21.676  INFO 97123 --- [ntContainer#0-2] c.l.d.a.Consumer$Consumer                : 15 HIGH 281
2023-01-11 14:04:21.678  INFO 97123 --- [ntContainer#0-3] c.l.d.a.Consumer$Consumer                : 16 HIGH 283
...
2023-01-11 14:04:29.639  INFO 97123 --- [ionShutdownHook] c.l.d.a.Consumer$Consumer                : Stat  LOW: LongSummaryStatistics{count=1000, sum=2340802, min=236, average=2340.802000, max=4192}
2023-01-11 14:04:29.640  INFO 97123 --- [ionShutdownHook] c.l.d.a.Consumer$Consumer                : Stat HIGH: LongSummaryStatistics{count=10, sum=2592, min=232, average=259.200000, max=283}
```
