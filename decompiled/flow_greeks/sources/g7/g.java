package g7;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f10103a;

    public g(Context context, String str) {
        s.k(context);
        s.e(str);
        this.f10103a = context.getSharedPreferences(String.format("com.google.firebase.appcheck.debug.store.%s", str), 0);
    }

    public String a() {
        return this.f10103a.getString("com.google.firebase.appcheck.debug.DEBUG_SECRET", null);
    }

    public void b(String str) {
        this.f10103a.edit().putString("com.google.firebase.appcheck.debug.DEBUG_SECRET", str).apply();
    }
}
