package i0;

import android.content.Context;
import android.util.Log;
import i3.k;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: i0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1287c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1287c f12172a = new C1287c();

    public final Object a(Context context, String tag, k manager) {
        r.f(context, "context");
        r.f(tag, "tag");
        r.f(manager, "manager");
        try {
            return manager.invoke(context);
        } catch (NoClassDefFoundError unused) {
            Log.d(tag, "Unable to find adservices code, check manifest for uses-library tag, versionS=" + C1286b.f12169a.b());
            return null;
        }
    }
}
