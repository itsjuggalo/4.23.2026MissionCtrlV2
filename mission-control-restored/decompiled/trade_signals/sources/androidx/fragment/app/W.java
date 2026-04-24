package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class W extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f11707b = new StringBuilder(128);

    public W(String str) {
        this.f11706a = str;
    }

    public final void a() {
        if (this.f11707b.length() > 0) {
            Log.d(this.f11706a, this.f11707b.toString());
            StringBuilder sb = this.f11707b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            char c8 = cArr[i8 + i10];
            if (c8 == '\n') {
                a();
            } else {
                this.f11707b.append(c8);
            }
        }
    }
}
