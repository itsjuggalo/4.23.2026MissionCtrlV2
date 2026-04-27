package Z;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class Y extends Writer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f3796b = new StringBuilder(128);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3795a = "FragmentManager";

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d();
    }

    public final void d() {
        StringBuilder sb = this.f3796b;
        if (sb.length() > 0) {
            Log.d(this.f3795a, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        d();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            char c6 = cArr[i + i7];
            if (c6 == '\n') {
                d();
            } else {
                this.f3796b.append(c6);
            }
        }
    }
}
