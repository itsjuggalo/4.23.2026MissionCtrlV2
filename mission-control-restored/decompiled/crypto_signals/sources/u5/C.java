package u5;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes.dex */
public interface C extends Closeable, Flushable {
    void c(long j4, C1250g c1250g);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
