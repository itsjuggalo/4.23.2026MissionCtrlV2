package androidx.fragment.app;

import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class W extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f7411b = new StringBuilder(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);

    public W(String str) {
        this.f7410a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e();
    }

    public final void e() {
        if (this.f7411b.length() > 0) {
            Log.d(this.f7410a, this.f7411b.toString());
            StringBuilder sb = this.f7411b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        e();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            char c4 = cArr[i4 + i6];
            if (c4 == '\n') {
                e();
            } else {
                this.f7411b.append(c4);
            }
        }
    }
}
