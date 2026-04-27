package l0;

import android.content.Context;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class g extends l {
    /* JADX WARN: Illegal instructions before constructor call */
    public g(Context context) {
        r.f(context, "context");
        Object systemService = context.getSystemService((Class<Object>) e.a());
        r.e(systemService, "context.getSystemService…ementManager::class.java)");
        super(f.a(systemService));
    }
}
