package br.com.poc.publisher

import br.com.poc.connection.NatsConnection
import com.fasterxml.jackson.databind.ObjectMapper
import javax.inject.Singleton

@Singleton
class NatsPublisher(private val connection: NatsConnection,
                    private val mapper: ObjectMapper) {

    fun <T> publish(subject :String, body :T){
        val json = mapper.writeValueAsString(body)
        connection.createConnection().publish(subject, json.encodeToByteArray())
    }
}