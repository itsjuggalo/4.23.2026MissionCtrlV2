package B0;

import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void a(String str, int i8) {
        Trace.beginAsyncSection(str, i8);
    }

    public static void b(String str, int i8) {
        Trace.endAsyncSection(str, i8);
    }

    public static boolean c() {
        return Trace.isEnabled();
    }
}
