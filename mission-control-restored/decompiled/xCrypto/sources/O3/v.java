package O3;

import r3.C1756c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {
    public static final byte[] a(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        byte[] bytes = str.getBytes(C1756c.f14563b);
        kotlin.jvm.internal.r.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        return new String(bArr, C1756c.f14563b);
    }
}
