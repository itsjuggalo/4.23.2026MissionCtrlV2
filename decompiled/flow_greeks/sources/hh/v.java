package hh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v {
    public static final byte[] a(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        byte[] bytes = str.getBytes(kg.c.f14857b);
        kotlin.jvm.internal.t.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        return new String(bArr, kg.c.f14857b);
    }
}
