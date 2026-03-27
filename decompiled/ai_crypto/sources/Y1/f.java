package Y1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f5640b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f5641a = null;

    public static e a(Context context) {
        return f5640b.b(context);
    }

    public final synchronized e b(Context context) {
        try {
            if (this.f5641a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f5641a = new e(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f5641a;
    }
}
