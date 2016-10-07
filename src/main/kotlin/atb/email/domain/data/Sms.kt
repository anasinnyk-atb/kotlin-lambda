package atb.email.domain.data

data class Sms (
        val template: String,
        val to: String,
        val from: String?,
        val brand: String?,
        val variables: Map<String, Any>?
) {}
