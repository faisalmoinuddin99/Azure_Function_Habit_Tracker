package com.habit_tracker.habit_tracker.azurefunction

import com.microsoft.azure.functions.ExecutionContext
import com.microsoft.azure.functions.HttpMethod
import com.microsoft.azure.functions.HttpRequestMessage
import com.microsoft.azure.functions.HttpResponseMessage
import com.microsoft.azure.functions.HttpStatus
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.HttpTrigger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.function.context.FunctionCatalog
import org.springframework.stereotype.Component
import java.util.Optional
import java.util.function.Function

@Component
class AzureFunctionHandler {

    @Autowired
    private lateinit var functionCatalog: FunctionCatalog

    @FunctionName("upperCaseFunction")
    fun callUpperCase(
        @HttpTrigger(
            name = "req",
            methods = [HttpMethod.GET, HttpMethod.POST],
            authLevel = AuthorizationLevel.ANONYMOUS
        ) request: HttpRequestMessage<Optional<String>>,
        context: ExecutionContext
    )
            : HttpResponseMessage {
        val input = request.body.orElse("Hello World")
        val uppercase = functionCatalog.lookup<Function<String, String>>("uppercase")
        val result = uppercase.apply(input)

        return request
            .createResponseBuilder(HttpStatus.OK)
            .body(result)
            .build()
    }
}