package o;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f21803a;

    static {
        f21803a = Build.VERSION.SDK_INT >= 27;
    }

    public static boolean a(View view) {
        return view.getLayoutDirection() == 1;
    }
}
