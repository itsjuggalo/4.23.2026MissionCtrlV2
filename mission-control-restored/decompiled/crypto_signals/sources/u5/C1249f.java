package u5;

import java.io.Closeable;

/* JADX INFO: renamed from: u5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1249f implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1250g f10524a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f10524a == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.f10524a = null;
    }
}
