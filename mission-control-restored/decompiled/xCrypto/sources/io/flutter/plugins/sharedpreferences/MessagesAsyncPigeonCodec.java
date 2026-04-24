package io.flutter.plugins.sharedpreferences;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class MessagesAsyncPigeonCodec extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b4, ByteBuffer buffer) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        if (b4 == -127) {
            Long l4 = (Long) readValue(buffer);
            if (l4 != null) {
                return StringListLookupResultType.Companion.ofRaw((int) l4.longValue());
            }
            return null;
        }
        if (b4 == -126) {
            Object value = readValue(buffer);
            List<? extends Object> list = value instanceof List ? (List) value : null;
            if (list != null) {
                return SharedPreferencesPigeonOptions.Companion.fromList(list);
            }
            return null;
        }
        if (b4 != -125) {
            return super.readValueOfType(b4, buffer);
        }
        Object value2 = readValue(buffer);
        List<? extends Object> list2 = value2 instanceof List ? (List) value2 : null;
        if (list2 != null) {
            return StringListResult.Companion.fromList(list2);
        }
        return null;
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.r.f(stream, "stream");
        if (obj instanceof StringListLookupResultType) {
            stream.write(129);
            writeValue(stream, Long.valueOf(((StringListLookupResultType) obj).getRaw()));
        } else if (obj instanceof SharedPreferencesPigeonOptions) {
            stream.write(130);
            writeValue(stream, ((SharedPreferencesPigeonOptions) obj).toList());
        } else if (!(obj instanceof StringListResult)) {
            super.writeValue(stream, obj);
        } else {
            stream.write(131);
            writeValue(stream, ((StringListResult) obj).toList());
        }
    }
}
