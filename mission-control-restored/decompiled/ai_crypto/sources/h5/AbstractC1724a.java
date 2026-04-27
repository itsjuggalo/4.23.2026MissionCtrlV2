package h5;

import android.content.Context;
import android.util.Log;

/* JADX INFO: renamed from: h5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1724a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f14914a;

    public static Context a() {
        return f14914a;
    }

    public static void b(Context context) {
        Log.d("FLTFireContextHolder", "received application context.");
        f14914a = context;
    }
}
