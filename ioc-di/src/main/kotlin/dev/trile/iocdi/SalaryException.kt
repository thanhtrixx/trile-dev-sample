package dev.trile.iocdi

import dev.trile.iocdi.ErrorType

class SalaryException(val codeType: ErrorType, message: String?) : Exception(message)
