package br.com.poc.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import javax.inject.Singleton


@Singleton
class ObjectMapperInitializer : BeanCreatedEventListener<ObjectMapper> {

    override fun onCreated(event: BeanCreatedEvent<ObjectMapper>): ObjectMapper {
        val bean: ObjectMapper = event.bean
        bean.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return bean
    }
}