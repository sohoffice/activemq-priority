package com.linksys.demo.activemqpriority

import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicInteger
import java.util.regex.Pattern
import javax.annotation.PreDestroy

@Service
class Consumer {

    private val logger = LoggerFactory.getLogger(Consumer::class.java)
    private val messageRegex = Pattern.compile("(\\d+),(.*)")

    private val lowList = mutableListOf<Long>()
    private val highList = mutableListOf<Long>()

    @JmsListener(destination = "my-queue")
    fun onMessage(data: String?) {
        if (data == null) {
            return
        }
        val m = messageRegex.matcher(data)
        if (m.matches()) {
            val startedAt = m.group(1).toLong()
            val msg = m.group(2)
            val duration = System.currentTimeMillis() - startedAt
            if (msg.startsWith("LOW")) {
                lowList.add(duration)
            } else if (msg.startsWith("HIGH")) {
                highList.add(duration)
            }
            logger.info("${Consumer.nextCounter()} ${m.group(2)} $duration")
        }
    }

    @PreDestroy
    fun onPreDestroy() {
        val lowStats = lowList.stream().mapToLong { it.toLong() }.summaryStatistics()
        val highStats = highList.stream().mapToLong { it.toLong() }.summaryStatistics()

        logger.info("Stat  LOW: $lowStats")
        logger.info("Stat HIGH: $highStats")
    }

    object Consumer {

        private var counter = AtomicInteger(0)

        fun nextCounter(): Int = counter.incrementAndGet()
    }
}
