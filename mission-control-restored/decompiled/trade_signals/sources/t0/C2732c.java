package t0;

import B5.k;
import android.content.Context;
import android.util.Log;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: t0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2732c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2732c f23290a = new C2732c();

    public final Object a(Context context, String tag, k manager) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(tag, "tag");
        AbstractC2304t.f(manager, "manager");
        try {
            return manager.invoke(context);
        } catch (NoClassDefFoundError unused) {
            Log.d(tag, "Unable to find adservices code, check manifest for uses-library tag, versionS=" + C2731b.f23287a.b());
            return null;
        }
    }
}
