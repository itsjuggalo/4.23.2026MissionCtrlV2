package w6;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes2.dex */
public interface X extends Closeable, Flushable {
    void L(C2792e c2792e, long j7);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    a0 f();

    void flush();
}
