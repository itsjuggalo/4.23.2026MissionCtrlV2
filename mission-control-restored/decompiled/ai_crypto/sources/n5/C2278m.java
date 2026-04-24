package n5;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: renamed from: n5.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2278m extends V4.o {
    @Override // V4.o
    public Object g(byte b7, ByteBuffer buffer) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        if (b7 == -127) {
            Long l7 = (Long) f(buffer);
            if (l7 != null) {
                return K.f19848b.a((int) l7.longValue());
            }
            return null;
        }
        if (b7 == -126) {
            Object objF = f(buffer);
            List list = objF instanceof List ? (List) objF : null;
            if (list != null) {
                return H.f19718c.a(list);
            }
            return null;
        }
        if (b7 != -125) {
            return super.g(b7, buffer);
        }
        Object objF2 = f(buffer);
        List list2 = objF2 instanceof List ? (List) objF2 : null;
        if (list2 != null) {
            return M.f19855c.a(list2);
        }
        return null;
    }

    @Override // V4.o
    public void p(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.r.f(stream, "stream");
        if (obj instanceof K) {
            stream.write(129);
            p(stream, Integer.valueOf(((K) obj).b()));
        } else if (obj instanceof H) {
            stream.write(130);
            p(stream, ((H) obj).b());
        } else if (!(obj instanceof M)) {
            super.p(stream, obj);
        } else {
            stream.write(131);
            p(stream, ((M) obj).a());
        }
    }
}
