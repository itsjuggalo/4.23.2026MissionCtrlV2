package nd;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends ByteArrayOutputStream {
    public d(int i10) {
        super(i10);
    }

    public final byte[] b() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        t.e(buf, "buf");
        return buf;
    }
}
