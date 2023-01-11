package com.linksys.demo.activemqpriority

import org.slf4j.LoggerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import javax.annotation.PostConstruct

@Service
class Producer(val jmsTemplate: JmsTemplate) {

    private val logger = LoggerFactory.getLogger(Producer::class.java)

    @PostConstruct
    fun onPostConstruct() {
        logger.info("Start producing")

        val lowPriorityPool = Executors.newFixedThreadPool(5) as ThreadPoolExecutor
        val highPriorityPool = Executors.newFixedThreadPool(5) as ThreadPoolExecutor
        for (i in 1..10) {
            for (k in 1..100) {
                lowPriorityPool.submit {
                    val ts = System.currentTimeMillis()
                    this.sendMessage("$ts,LOW", 0)
                }
            }
            highPriorityPool.submit {
                val ts = System.currentTimeMillis()
                this.sendMessage("$ts,HIGH", 9)
            }
            // logger.info("Pool, ${lowPriorityPool.activeCount}/${lowPriorityPool.poolSize}, ${highPriorityPool.activeCount}/${highPriorityPool.poolSize}")
        }
        logger.info("Finish producing")
    }

    fun sendMessage(msg: String, priority: Int) {
        jmsTemplate.send("my-queue") {
            val m = jmsTemplate.messageConverter?.toMessage(msg, it)!!
            m.jmsPriority = priority
            m
        }
    }
}
