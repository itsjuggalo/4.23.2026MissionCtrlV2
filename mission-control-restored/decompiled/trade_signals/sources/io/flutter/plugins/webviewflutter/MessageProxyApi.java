package io.flutter.plugins.webviewflutter;

import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class MessageProxyApi extends PigeonApiAndroidMessage {
    public MessageProxyApi(AndroidWebkitLibraryPigeonProxyApiRegistrar androidWebkitLibraryPigeonProxyApiRegistrar) {
        super(androidWebkitLibraryPigeonProxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiAndroidMessage
    public void sendToTarget(Message message) {
        message.sendToTarget();
    }
}
