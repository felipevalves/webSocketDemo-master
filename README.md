### WebSocket
![image](https://user-images.githubusercontent.com/61691394/189927854-fb3ff330-de6e-4d3c-ae4b-f6d968f8fe83.png)

Websocket
```
ws://www.example.com/
wss://www.example.com/
```
### OkHttp WebSocket
```
implementation 'com.squareup.okhttp3:okhttp:3.12.1'
```

```
client = new OkHttpClient.Builder()
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build();
request = new Request.Builder().url(url).build();
client.newWebSocket(request, createListener());
```
createListener
```
private WebSocketListener createListener() {
    return new WebSocketListener() {
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            Log.d(TAG, "open:" + response.toString());
            mWebSocket = webSocket;
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);
        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            super.onMessage(webSocket, bytes);
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            super.onFailure(webSocket, t, response);
        }
    };
}
```

```
mWebSocket.send(text);
mWebSocket.send(byteString);
```





