package io.flutter.plugins.sharedpreferences;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
class MessagesAsyncPigeonCodec extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b8, ByteBuffer buffer) {
        AbstractC2304t.f(buffer, "buffer");
        if (b8 == -127) {
            Long l8 = (Long) readValue(buffer);
            if (l8 != null) {
                return StringListLookupResultType.Companion.ofRaw((int) l8.longValue());
            }
            return null;
        }
        if (b8 == -126) {
            Object value = readValue(buffer);
            List<? extends Object> list = value instanceof List ? (List) value : null;
            if (list != null) {
                return SharedPreferencesPigeonOptions.Companion.fromList(list);
            }
            return null;
        }
        if (b8 != -125) {
            return super.readValueOfType(b8, buffer);
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
        Object list;
        AbstractC2304t.f(stream, "stream");
        if (obj instanceof StringListLookupResultType) {
            stream.write(129);
            list = Integer.valueOf(((StringListLookupResultType) obj).getRaw());
        } else if (obj instanceof SharedPreferencesPigeonOptions) {
            stream.write(130);
            list = ((SharedPreferencesPigeonOptions) obj).toList();
        } else if (!(obj instanceof StringListResult)) {
            super.writeValue(stream, obj);
            return;
        } else {
            stream.write(131);
            list = ((StringListResult) obj).toList();
        }
        writeValue(stream, list);
    }
}
