package m0;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class V extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f18687b = new StringBuilder(128);

    public V(String str) {
        this.f18686a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        h();
    }

    public final void h() {
        if (this.f18687b.length() > 0) {
            Log.d(this.f18686a, this.f18687b.toString());
            StringBuilder sb = this.f18687b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            char c7 = cArr[i7 + i9];
            if (c7 == '\n') {
                h();
            } else {
                this.f18687b.append(c7);
            }
        }
    }
}
