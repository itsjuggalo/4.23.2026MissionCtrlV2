package P0;

import android.content.Context;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class n implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f6274b = new n();

    @Override // P0.l
    public float a(Context context) {
        AbstractC2304t.f(context, "context");
        return context.getResources().getDisplayMetrics().density;
    }
}
