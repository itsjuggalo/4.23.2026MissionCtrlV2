package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
class AndroidWebkitLibraryPigeonCodec extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b8, ByteBuffer buffer) {
        AbstractC2304t.f(buffer, "buffer");
        if (b8 == -127) {
            Long l8 = (Long) readValue(buffer);
            if (l8 == null) {
                return null;
            }
            return FileChooserMode.Companion.ofRaw((int) l8.longValue());
        }
        if (b8 == -126) {
            Long l9 = (Long) readValue(buffer);
            if (l9 == null) {
                return null;
            }
            return ConsoleMessageLevel.Companion.ofRaw((int) l9.longValue());
        }
        if (b8 == -125) {
            Long l10 = (Long) readValue(buffer);
            if (l10 == null) {
                return null;
            }
            return OverScrollMode.Companion.ofRaw((int) l10.longValue());
        }
        if (b8 != -124) {
            return super.readValueOfType(b8, buffer);
        }
        Long l11 = (Long) readValue(buffer);
        if (l11 == null) {
            return null;
        }
        return SslErrorType.Companion.ofRaw((int) l11.longValue());
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        int raw;
        AbstractC2304t.f(stream, "stream");
        if (obj instanceof FileChooserMode) {
            stream.write(129);
            raw = ((FileChooserMode) obj).getRaw();
        } else if (obj instanceof ConsoleMessageLevel) {
            stream.write(130);
            raw = ((ConsoleMessageLevel) obj).getRaw();
        } else if (obj instanceof OverScrollMode) {
            stream.write(131);
            raw = ((OverScrollMode) obj).getRaw();
        } else if (!(obj instanceof SslErrorType)) {
            super.writeValue(stream, obj);
            return;
        } else {
            stream.write(132);
            raw = ((SslErrorType) obj).getRaw();
        }
        writeValue(stream, Integer.valueOf(raw));
    }
}
