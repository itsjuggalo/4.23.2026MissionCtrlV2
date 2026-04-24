package p5;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: p5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2386b extends V4.o {
    @Override // V4.o
    public Object g(byte b7, ByteBuffer buffer) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        if (b7 == -127) {
            Long l7 = (Long) f(buffer);
            if (l7 == null) {
                return null;
            }
            return EnumC2401d0.f21852b.a((int) l7.longValue());
        }
        if (b7 == -126) {
            Long l8 = (Long) f(buffer);
            if (l8 == null) {
                return null;
            }
            return U.f21713b.a((int) l8.longValue());
        }
        if (b7 == -125) {
            Long l9 = (Long) f(buffer);
            if (l9 == null) {
                return null;
            }
            return EnumC2480p0.f21937b.a((int) l9.longValue());
        }
        if (b7 != -124) {
            return super.g(b7, buffer);
        }
        Long l10 = (Long) f(buffer);
        if (l10 == null) {
            return null;
        }
        return W3.f21747b.a((int) l10.longValue());
    }

    @Override // V4.o
    public void p(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.r.f(stream, "stream");
        if (obj instanceof EnumC2401d0) {
            stream.write(129);
            p(stream, Integer.valueOf(((EnumC2401d0) obj).b()));
            return;
        }
        if (obj instanceof U) {
            stream.write(130);
            p(stream, Integer.valueOf(((U) obj).b()));
        } else if (obj instanceof EnumC2480p0) {
            stream.write(131);
            p(stream, Integer.valueOf(((EnumC2480p0) obj).b()));
        } else if (!(obj instanceof W3)) {
            super.p(stream, obj);
        } else {
            stream.write(132);
            p(stream, Integer.valueOf(((W3) obj).b()));
        }
    }
}
