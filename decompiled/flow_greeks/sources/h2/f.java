package h2;

import android.content.Context;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends h {
    /* JADX WARN: Illegal instructions before constructor call */
    public f(Context context) {
        t.f(context, "context");
        Object systemService = context.getSystemService((Class<Object>) d.a());
        t.e(systemService, "context.getSystemService…ementManager::class.java)");
        super(e.a(systemService));
    }
}
