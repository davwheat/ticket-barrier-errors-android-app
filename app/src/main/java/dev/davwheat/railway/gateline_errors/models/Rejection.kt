package dev.davwheat.railway.gateline_errors.models

data class Rejection(
    val code: String,
    val textCode: String?,
    val definition: String,
    val helpText: String,
    val action: ActionByStaff = ActionByStaff.NONE,
    val laymansReason: String? = null,
) {
    val integerCode: Int = code.toInt()
    val actionByStaff = action.toString()
}
