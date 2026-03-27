package p4;

import Z3.v;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: p4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0907b extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0907b f9061d = new C0907b();

    @Override // Z3.v
    public final Object f(byte b3, ByteBuffer byteBuffer) {
        if (b3 != -127) {
            return super.f(b3, byteBuffer);
        }
        Object objE = e(byteBuffer);
        if (objE == null) {
            return null;
        }
        return EnumC0908c.values()[((Long) objE).intValue()];
    }

    @Override // Z3.v
    public final void k(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        if (!(obj instanceof EnumC0908c)) {
            super.k(byteArrayOutputStream, obj);
        } else {
            byteArrayOutputStream.write(129);
            k(byteArrayOutputStream, obj == null ? null : Integer.valueOf(((EnumC0908c) obj).f9063a));
        }
    }
}
