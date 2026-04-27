package w6;

import Z5.C0796c;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 {
    public static final byte[] a(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        byte[] bytes = str.getBytes(C0796c.f6018b);
        kotlin.jvm.internal.r.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final ReentrantLock b() {
        return new ReentrantLock();
    }

    public static final String c(byte[] bArr) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        return new String(bArr, C0796c.f6018b);
    }
}
