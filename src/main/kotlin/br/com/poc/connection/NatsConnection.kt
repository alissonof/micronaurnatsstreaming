package br.com.poc.connection

import io.micronaut.context.annotation.Value
import io.nats.streaming.Options
import io.nats.streaming.StreamingConnection
import io.nats.streaming.StreamingConnectionFactory
import javax.inject.Singleton

@Singleton
class NatsConnection {

    @Value("\${nats.connection.host}")
    private lateinit var host :String

    @Value("\${nats.connection.port}")
    private var port :Int = 4222

    @Value("\${nats.connection.user}")
    private lateinit var user :String

    @Value("\${nats.connection.password}")
    private lateinit var password :String

    @Value("\${nats.connection.client-id}")
    private lateinit var clientId :String

    @Value("\${nats.connection.cluster-id}")
    private lateinit var clusterId :String

    private var connnection :StreamingConnection? = null

    fun  createConnection() :StreamingConnection{
        connnection?.let { return it }
        connnection = createNatConnection()
        return connnection!!
    }

    private fun createNatConnection() :StreamingConnection{
        val options = Options.Builder().natsUrl("nats://$user:$password@$host:$port").clusterId(clusterId).clientId(clientId).build()
        val cf = StreamingConnectionFactory(options)
        val sc = cf.createConnection()
        return sc
    }
}