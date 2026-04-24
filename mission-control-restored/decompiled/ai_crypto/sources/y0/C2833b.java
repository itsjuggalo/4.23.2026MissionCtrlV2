package y0;

import Q5.k;
import android.content.Context;
import android.util.Log;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: y0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2833b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2833b f25456a = new C2833b();

    public final Object a(Context context, String tag, k manager) {
        r.f(context, "context");
        r.f(tag, "tag");
        r.f(manager, "manager");
        try {
            return manager.invoke(context);
        } catch (NoClassDefFoundError unused) {
            Log.d(tag, "Unable to find adservices code, check manifest for uses-library tag, versionS=" + C2832a.f25453a.b());
            return null;
        }
    }
}
