package s2;

import android.content.Context;

/* JADX INFO: renamed from: s2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2689d {
    public static InterfaceC2688c a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return new C2693h(new C2698m(context));
    }
}
