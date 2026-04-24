package io.flutter.embedding.engine.systemchannels;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KeyboardChannel {
    public final MethodChannel channel;
    private KeyboardMethodHandler keyboardMethodHandler;
    public final MethodChannel.MethodCallHandler parsingMethodHandler;

    public interface KeyboardMethodHandler {
        Map<Long, Long> getKeyboardState();
    }

    public KeyboardChannel(BinaryMessenger binaryMessenger) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.KeyboardChannel.1
            Map<Long, Long> pressedState = new HashMap();

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (KeyboardChannel.this.keyboardMethodHandler != null) {
                    String str = methodCall.method;
                    str.hashCode();
                    if (!str.equals("getKeyboardState")) {
                        result.notImplemented();
                        return;
                    } else {
                        try {
                            this.pressedState = KeyboardChannel.this.keyboardMethodHandler.getKeyboardState();
                        } catch (IllegalStateException e8) {
                            result.error("error", e8.getMessage(), null);
                        }
                    }
                }
                result.success(this.pressedState);
            }
        };
        this.parsingMethodHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter/keyboard", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    public void setKeyboardMethodHandler(KeyboardMethodHandler keyboardMethodHandler) {
        this.keyboardMethodHandler = keyboardMethodHandler;
    }
}
