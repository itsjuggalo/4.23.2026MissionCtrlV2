package z5;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: z5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3016d extends ByteArrayOutputStream {
    public C3016d(int i8) {
        super(i8);
    }

    public final byte[] a() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        AbstractC2304t.e(buf, "buf");
        return buf;
    }
}
