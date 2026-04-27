package D1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f277b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f278a;

    static {
        d dVar = new d();
        dVar.f278a = null;
        f277b = dVar;
    }

    public static c a(Context context) {
        c cVar;
        d dVar = f277b;
        synchronized (dVar) {
            try {
                if (dVar.f278a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    dVar.f278a = new c(context);
                }
                cVar = dVar.f278a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }
}
