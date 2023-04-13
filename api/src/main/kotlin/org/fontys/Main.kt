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
import kotlinx.coroutines.delay
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
                    /*var id = call.request.cookies["ID"]
                if (id == null) {
                    id = UUID.randomUUID().toString()
                    call.response.cookies.append("ID", id)
                }*/
                    val session = call.sessions.get<Session>()


                    // TODO: Change actual settings
                }
            }

            route("/sse") {
                get {
                    call.response.cacheControl(CacheControl.NoCache(null))
                    try {
                        call.respondTextWriter(contentType = ContentType.Text.EventStream) {
                            while (true) { // TODO: Exit when client disconnects
                                val value = Random().nextFloat(10f)
                                write("data: $value\n\n")
                                flush()
                                delay(250)
                            }
                        }
                    } catch (ignored: ChannelWriteException) { }
                }
            }
        }
    }
}
