package a5;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Y extends V4.o {
    @Override // V4.o
    public Object g(byte b7, ByteBuffer buffer) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        if (b7 != -127) {
            return super.g(b7, buffer);
        }
        Object objF = f(buffer);
        List list = objF instanceof List ? (List) objF : null;
        if (list != null) {
            return C0904a.f6369c.a(list);
        }
        return null;
    }

    @Override // V4.o
    public void p(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.r.f(stream, "stream");
        if (!(obj instanceof C0904a)) {
            super.p(stream, obj);
        } else {
            stream.write(129);
            p(stream, ((C0904a) obj).a());
        }
    }
}
