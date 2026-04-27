package w4;

import java.io.Closeable;
import x4.C1410f;

/* JADX INFO: renamed from: w4.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1349l implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1410f f11308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final I0 f11309b;

    public C1349l(C1410f c1410f, I0 i02) {
        this.f11308a = c1410f;
        this.f11309b = i02;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11308a.close();
    }
}
