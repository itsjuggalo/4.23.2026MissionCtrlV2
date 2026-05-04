package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f2338b = new StringBuilder(128);

    public v0(String str) {
        this.f2337a = str;
    }

    public final void b() {
        if (this.f2338b.length() > 0) {
            Log.d(this.f2337a, this.f2338b.toString());
            StringBuilder sb2 = this.f2338b;
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        b();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                b();
            } else {
                this.f2338b.append(c10);
            }
        }
    }
}
