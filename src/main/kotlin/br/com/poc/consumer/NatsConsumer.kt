package br.com.poc.consumer

import br.com.poc.connection.NatsConnection
import io.micronaut.context.annotation.Prototype
import io.nats.streaming.MessageHandler
import io.nats.streaming.SubscriptionOptions

@Prototype
class NatsConsumer(private val connection: NatsConnection) {

    fun listen(subject: String, queueGroup: String?, messageHandler: MessageHandler) {
        connection
                .createConnection()
                .subscribe(subject,
                        queueGroup,
                        messageHandler,
                        SubscriptionOptions.Builder().deliverAllAvailable().build())
    }
}

