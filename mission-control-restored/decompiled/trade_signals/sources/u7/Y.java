package u7;

import V6.C0977c;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Y {
    public static final byte[] a(String str) {
        AbstractC2304t.f(str, "<this>");
        byte[] bytes = str.getBytes(C0977c.f8956b);
        AbstractC2304t.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final ReentrantLock b() {
        return new ReentrantLock();
    }

    public static final String c(byte[] bArr) {
        AbstractC2304t.f(bArr, "<this>");
        return new String(bArr, C0977c.f8956b);
    }
}
