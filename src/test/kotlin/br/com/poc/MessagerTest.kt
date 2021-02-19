package br.com.poc
import br.com.poc.connection.NatsConnection
import br.com.poc.consumer.NatsConsumer
import br.com.poc.publisher.NatsPublisher
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.nats.streaming.Message
import io.nats.streaming.MessageHandler
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

@MicronautTest
class MessagerTest {

    @Inject
    private lateinit var publisher : NatsPublisher

    @Inject
    private lateinit var subscriber1 : NatsConsumer

    @Inject
    private lateinit var subscriber2 : NatsConsumer

    @Inject
    private lateinit var mapper :ObjectMapper

    @Inject
    private lateinit var connection: NatsConnection



    @Test
    @Order(1)
    fun testPublisher(){
        val carro = Carro("Opala", 1122, LocalDateTime.now(), LocalDate.now())
        publisher.publish("foo", carro)
        Thread.sleep(5000)
        connection.createConnection().close()
    }

    @Test
    @Order(3)
    fun testCosnumer(){
        subscriber1.listen("foo", null, MessageHandler { msg : Message ->
            val carro : Carro = mapper.readValue(String(msg.data), Carro::class.java)
            println("----------------------------Consumer 1------------------------------------------")
            println(carro.nome)
            println(carro.placa)
            println(carro.data)
            println(carro.dataHora)
            println("----------------------------------------------------------------------")
        })

        subscriber2.listen("foo", null, MessageHandler { msg : Message ->
            val carro : Carro = mapper.readValue(String(msg.data), Carro::class.java)
            println("------------------------------Consumer 2----------------------------------------")
            println(carro.nome)
            println(carro.placa)
            println(carro.data)
            println(carro.dataHora)
            println("----------------------------------------------------------------------")
        })
    }
}
