package g3;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ByteArrayOutputStream {
    public d(int i4) {
        super(i4);
    }

    public final byte[] e() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        r.e(buf, "buf");
        return buf;
    }
}
