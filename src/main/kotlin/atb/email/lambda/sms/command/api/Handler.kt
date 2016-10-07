package atb.email.lambda.sms.command.api

import atb.email.domain.data.Sms
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import org.apache.log4j.Logger

class Handler: RequestHandler<Sms, Int> {
    val log: Logger = Logger.getLogger(Handler::class)

    override fun handleRequest(sms: Sms, context: Context): Int {
        try {
            log.debug(sms.toString())
            return 201
        } catch (e: Exception) {
            return 400
        }
    }
}
