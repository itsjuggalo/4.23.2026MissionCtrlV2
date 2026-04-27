package okhttp3.internal.cache;

import java.io.EOFException;
import java.io.IOException;
import u5.C1250g;
import u5.o;

/* JADX INFO: loaded from: classes.dex */
class FaultHidingSink extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8834a;

    @Override // u5.o, u5.C
    public final void c(long j4, C1250g c1250g) throws EOFException {
        if (!this.f8834a) {
            throw null;
        }
        c1250g.t(j4);
    }

    @Override // u5.o, u5.C, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f8834a) {
            return;
        }
        try {
            super.close();
        } catch (IOException unused) {
            this.f8834a = true;
            d();
        }
    }

    @Override // u5.o, u5.C, java.io.Flushable
    public final void flush() {
        if (this.f8834a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException unused) {
            this.f8834a = true;
            d();
        }
    }

    public void d() {
    }
}
