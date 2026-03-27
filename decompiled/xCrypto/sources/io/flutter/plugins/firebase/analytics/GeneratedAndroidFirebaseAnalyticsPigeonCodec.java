package io.flutter.plugins.firebase.analytics;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class GeneratedAndroidFirebaseAnalyticsPigeonCodec extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b4, ByteBuffer buffer) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        if (b4 != -127) {
            return super.readValueOfType(b4, buffer);
        }
        Object value = readValue(buffer);
        List<? extends Object> list = value instanceof List ? (List) value : null;
        if (list != null) {
            return AnalyticsEvent.Companion.fromList(list);
        }
        return null;
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.r.f(stream, "stream");
        if (!(obj instanceof AnalyticsEvent)) {
            super.writeValue(stream, obj);
        } else {
            stream.write(129);
            writeValue(stream, ((AnalyticsEvent) obj).toList());
        }
    }
}
