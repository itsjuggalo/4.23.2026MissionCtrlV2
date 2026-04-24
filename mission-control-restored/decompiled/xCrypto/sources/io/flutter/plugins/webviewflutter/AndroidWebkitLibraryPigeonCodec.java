package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
class AndroidWebkitLibraryPigeonCodec extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b4, ByteBuffer buffer) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        if (b4 == -127) {
            Long l4 = (Long) readValue(buffer);
            if (l4 == null) {
                return null;
            }
            return FileChooserMode.Companion.ofRaw((int) l4.longValue());
        }
        if (b4 == -126) {
            Long l5 = (Long) readValue(buffer);
            if (l5 == null) {
                return null;
            }
            return ConsoleMessageLevel.Companion.ofRaw((int) l5.longValue());
        }
        if (b4 == -125) {
            Long l6 = (Long) readValue(buffer);
            if (l6 == null) {
                return null;
            }
            return OverScrollMode.Companion.ofRaw((int) l6.longValue());
        }
        if (b4 == -124) {
            Long l7 = (Long) readValue(buffer);
            if (l7 == null) {
                return null;
            }
            return SslErrorType.Companion.ofRaw((int) l7.longValue());
        }
        if (b4 != -123) {
            return super.readValueOfType(b4, buffer);
        }
        Long l8 = (Long) readValue(buffer);
        if (l8 == null) {
            return null;
        }
        return MixedContentMode.Companion.ofRaw((int) l8.longValue());
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.r.f(stream, "stream");
        if (obj instanceof FileChooserMode) {
            stream.write(129);
            writeValue(stream, Integer.valueOf(((FileChooserMode) obj).getRaw()));
            return;
        }
        if (obj instanceof ConsoleMessageLevel) {
            stream.write(130);
            writeValue(stream, Integer.valueOf(((ConsoleMessageLevel) obj).getRaw()));
            return;
        }
        if (obj instanceof OverScrollMode) {
            stream.write(131);
            writeValue(stream, Integer.valueOf(((OverScrollMode) obj).getRaw()));
        } else if (obj instanceof SslErrorType) {
            stream.write(132);
            writeValue(stream, Integer.valueOf(((SslErrorType) obj).getRaw()));
        } else if (!(obj instanceof MixedContentMode)) {
            super.writeValue(stream, obj);
        } else {
            stream.write(133);
            writeValue(stream, Integer.valueOf(((MixedContentMode) obj).getRaw()));
        }
    }
}
