package br.com.poc

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class Carro(
        var nome: String?,
        var placa :Int?,
        var dataHora: LocalDateTime?,
        var data: LocalDate?
)