package org.fontys

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.autohead.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.cio.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.fontys.json.Session
import org.fontys.json.SettingsPatch
import java.util.*
import kotlin.time.Duration

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.application() {
    install(AutoHeadResponse)
    install(ContentNegotiation) {
        json(Json {
            encodeDefaults = false
        })
    }
    install(Sessions) {
        cookie<Session>("session") {
            cookie.maxAge = Duration.INFINITE
        }
    }

    routing {
        route("/api") {
            route("/settings") {
                patch<SettingsPatch> {
                    val session = call.sessions.getOrSet { Session(UUID.randomUUID().toString(), 0, 0, 0, 0, 0) }
                    val new = session.copy(
                        fetalHeartRate = it.fetalHeartRate,
                        fetalBloodPressure = it.fetalBloodPressure,
                        fetalBloodSaturation = it.fetalBloodSaturation,
                        umbilicalArteryBloodFlow = it.umbilicalArteryBloodFlow,
                        uterineContractions = it.uterineContractions
                    )
                    call.sessions.set(new)
                }
            }

            route("/sse") {
                get {
                    call.response.cacheControl(CacheControl.NoCache(null))
                    try {
                        withContext(Dispatchers.IO) {
                            call.respondTextWriter(contentType = ContentType.Text.EventStream) {
                                var index = 0
                                while (true) { // TODO: Exit when client disconnects
                                    val value = Random().nextFloat(10f)
                                    write("data: $index\n\n")
                                    flush()
                                    index++
                                    delay(250)
                                }
                            }
                        }
                    } catch (ignored: ChannelWriteException) { }
                }
            }
        }
    }
}
