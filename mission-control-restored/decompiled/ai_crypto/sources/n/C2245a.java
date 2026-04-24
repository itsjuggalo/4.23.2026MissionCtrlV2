package n;

import android.content.Context;
import android.content.res.Configuration;

/* JADX INFO: renamed from: n.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2245a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19006a;

    public C2245a(Context context) {
        this.f19006a = context;
    }

    public static C2245a a(Context context) {
        return new C2245a(context);
    }

    public int b() {
        return this.f19006a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        Configuration configuration = this.f19006a.getResources().getConfiguration();
        int i7 = configuration.screenWidthDp;
        int i8 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i7 > 600) {
            return 5;
        }
        if (i7 > 960 && i8 > 720) {
            return 5;
        }
        if (i7 > 720 && i8 > 960) {
            return 5;
        }
        if (i7 >= 500) {
            return 4;
        }
        if (i7 > 640 && i8 > 480) {
            return 4;
        }
        if (i7 <= 480 || i8 <= 640) {
            return i7 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean d() {
        return true;
    }
}
