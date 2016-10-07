import com.fasterxml.jackson.databind.ObjectMapper
import com.amazonaws.services.lambda.runtime.events.SNSEvent
import java.io.File

fun main(args: Array<String>) {
    val r: SNSEvent = ObjectMapper().readValue(File("event.json"), SNSEvent::class.java)
    println(r.records.first().sns.message)
}
