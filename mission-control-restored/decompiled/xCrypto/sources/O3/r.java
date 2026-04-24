package O3;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes3.dex */
public interface r extends Closeable, Flushable {
    void c0(d dVar, long j4);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
