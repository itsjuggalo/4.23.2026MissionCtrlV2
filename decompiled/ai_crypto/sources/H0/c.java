package H0;

import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void a(String str, int i7) {
        Trace.beginAsyncSection(str, i7);
    }

    public static void b(String str, int i7) {
        Trace.endAsyncSection(str, i7);
    }

    public static boolean c() {
        return Trace.isEnabled();
    }
}
