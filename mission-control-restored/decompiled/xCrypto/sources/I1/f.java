package I1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f852b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f853a = null;

    public static e a(Context context) {
        return f852b.b(context);
    }

    public final synchronized e b(Context context) {
        try {
            if (this.f853a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f853a = new e(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f853a;
    }
}
