package net.formula97.webapps.gae.testbootlinapp1.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

@RestController
class MainController {

    @GetMapping("/")
    fun createRandom(): Item {
        val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS")
        val currentDateTime: String = sdf.format(Date())

        val digest = MessageDigest.getInstance("SHA-256")
        val result = digest.digest(currentDateTime.toByteArray())
        val sha256 = String.format(Locale.getDefault(), "%040x", BigInteger(1, result))

        return Item(currentDateTime, sha256)
    }
}