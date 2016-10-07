package atb.email.lambda.sms.command.sns

import atb.email.domain.data.Sms
import atb.email.lambda.sms.command.api.Handler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.SNSEvent
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper

class Handler: RequestHandler<SNSEvent, Int> {
    override fun handleRequest(input: SNSEvent, context: Context): Int {
        try {
            return Handler().handleRequest(convertSNStoAPI(input), context)
        } catch (e: JsonProcessingException) {
            return 422
        }
    }

    private fun convertSNStoAPI(sns: SNSEvent): Sms {
        return ObjectMapper().readValue(sns.records.first().sns.message, Sms::class.java)
    }
}
