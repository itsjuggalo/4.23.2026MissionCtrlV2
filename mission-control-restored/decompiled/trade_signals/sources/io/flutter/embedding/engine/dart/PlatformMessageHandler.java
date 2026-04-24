package io.flutter.embedding.engine.dart;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface PlatformMessageHandler {
    void handleMessageFromDart(String str, ByteBuffer byteBuffer, int i8, long j8);

    void handlePlatformMessageResponse(int i8, ByteBuffer byteBuffer);
}
