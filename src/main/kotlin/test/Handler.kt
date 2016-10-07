package test

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.SNSEvent

class Handler: RequestHandler<SNSEvent, String> {
    override fun handleRequest(input: SNSEvent, context: Context): String {
        context.logger.log(input.records.first().sns.message)
        return input.records.first().sns.message
    }
}
