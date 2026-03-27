package u7;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes2.dex */
public interface T extends Closeable, Flushable {
    void H(C2811d c2811d, long j8);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
