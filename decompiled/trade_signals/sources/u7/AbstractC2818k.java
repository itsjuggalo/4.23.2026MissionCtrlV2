package u7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u7.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2818k implements V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f23675a;

    public AbstractC2818k(V delegate) {
        AbstractC2304t.f(delegate, "delegate");
        this.f23675a = delegate;
    }

    @Override // u7.V, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f23675a.close();
    }

    @Override // u7.V
    public long o0(C2811d sink, long j8) {
        AbstractC2304t.f(sink, "sink");
        return this.f23675a.o0(sink, j8);
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f23675a + ')';
    }
}
