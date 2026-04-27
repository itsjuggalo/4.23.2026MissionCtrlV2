package okhttp3.internal.cache;

import java.io.EOFException;
import java.io.IOException;
import w6.AbstractC2799l;
import w6.C2792e;
import w6.X;

/* JADX INFO: loaded from: classes2.dex */
class FaultHidingSink extends AbstractC2799l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20756b;

    public FaultHidingSink(X x7) {
        super(x7);
    }

    @Override // w6.AbstractC2799l, w6.X
    public void L(C2792e c2792e, long j7) throws EOFException {
        if (this.f20756b) {
            c2792e.skip(j7);
            return;
        }
        try {
            super.L(c2792e, j7);
        } catch (IOException e7) {
            this.f20756b = true;
            h(e7);
        }
    }

    @Override // w6.AbstractC2799l, w6.X, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f20756b) {
            return;
        }
        try {
            super.close();
        } catch (IOException e7) {
            this.f20756b = true;
            h(e7);
        }
    }

    @Override // w6.AbstractC2799l, w6.X, java.io.Flushable
    public void flush() {
        if (this.f20756b) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e7) {
            this.f20756b = true;
            h(e7);
        }
    }

    public void h(IOException iOException) {
    }
}
