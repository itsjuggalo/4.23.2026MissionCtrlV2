package P4;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ByteArrayOutputStream {
    public byte[] d() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public byte[] f() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        j.d(buf, "buf");
        return buf;
    }
}
