package m;

import android.content.Context;
import android.content.res.Configuration;

/* JADX INFO: renamed from: m.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1592a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13444a;

    public C1592a(Context context) {
        this.f13444a = context;
    }

    public static C1592a a(Context context) {
        return new C1592a(context);
    }

    public int b() {
        return this.f13444a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        Configuration configuration = this.f13444a.getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        int i5 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i4 > 600) {
            return 5;
        }
        if (i4 > 960 && i5 > 720) {
            return 5;
        }
        if (i4 > 720 && i5 > 960) {
            return 5;
        }
        if (i4 >= 500) {
            return 4;
        }
        if (i4 > 640 && i5 > 480) {
            return 4;
        }
        if (i4 <= 480 || i5 <= 640) {
            return i4 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean d() {
        return true;
    }
}
