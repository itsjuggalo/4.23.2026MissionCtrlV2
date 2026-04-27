package m;

import android.content.Context;
import android.content.res.Configuration;

/* JADX INFO: renamed from: m.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2339a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21176a;

    public C2339a(Context context) {
        this.f21176a = context;
    }

    public static C2339a a(Context context) {
        return new C2339a(context);
    }

    public int b() {
        return this.f21176a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        Configuration configuration = this.f21176a.getResources().getConfiguration();
        int i8 = configuration.screenWidthDp;
        int i9 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i8 > 600) {
            return 5;
        }
        if (i8 > 960 && i9 > 720) {
            return 5;
        }
        if (i8 > 720 && i9 > 960) {
            return 5;
        }
        if (i8 >= 500) {
            return 4;
        }
        if (i8 > 640 && i9 > 480) {
            return 4;
        }
        if (i8 <= 480 || i9 <= 640) {
            return i8 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean d() {
        return true;
    }
}
