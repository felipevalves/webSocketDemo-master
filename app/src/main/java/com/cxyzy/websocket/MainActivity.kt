package com.cxyzy.websocket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity(), MessageListener {
    //   private val serverUrl = "wss://websocket-echo.glitch.me"
    private val serverUrl = "ws://10.2.10.48:8081/wms/websocket"
//    private val serverUrl = "wss://demo.piesocket.com/v3/channel_1?api_key=VCXCEuvhGcBDP7XhiJJUDvR1e1D3eiVjgZ9VRiaV&notify_self"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WebSocketManager.init(serverUrl, this)
        connectBtn.setOnClickListener {
            thread {
                kotlin.run {
                    WebSocketManager.connect()
                }
            }
        }
        clientSendBtn.setOnClickListener {
            if (WebSocketManager.sendMessage("Local Time: " + LocalDateTime.now() )) {
                addText("My Text \n")
            }
        }
        closeConnectionBtn.setOnClickListener {
            WebSocketManager.close()
        }
    }

    override fun onConnectSuccess() {
        addText("onConnectSuccess\n")
    }

    override fun onConnectFailed() {
        addText("onConnectFailed\n")
    }

    override fun onClose() {
        addText("onClose\n")
    }

    override fun onMessage(text: String?) {
        addText("onMessage：$text\n")
    }

    private fun addText(text: String?) {
        runOnUiThread {
            contentEt.text.append(text)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        WebSocketManager.close()
    }
}
