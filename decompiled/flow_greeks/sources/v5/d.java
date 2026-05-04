package v5;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f23139b = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f23140a = null;

    public static c a(Context context) {
        return f23139b.b(context);
    }

    public final synchronized c b(Context context) {
        try {
            if (this.f23140a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f23140a = new c(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f23140a;
    }
}
