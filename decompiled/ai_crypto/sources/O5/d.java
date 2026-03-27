package O5;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ByteArrayOutputStream {
    public d(int i7) {
        super(i7);
    }

    public final byte[] h() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        r.e(buf, "buf");
        return buf;
    }
}
