package w0;

import android.content.Context;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: w0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2889g extends AbstractC2894l {
    /* JADX WARN: Illegal instructions before constructor call */
    public C2889g(Context context) {
        AbstractC2304t.f(context, "context");
        Object systemService = context.getSystemService((Class<Object>) AbstractC2887e.a());
        AbstractC2304t.e(systemService, "context.getSystemService…ementManager::class.java)");
        super(AbstractC2888f.a(systemService));
    }
}
