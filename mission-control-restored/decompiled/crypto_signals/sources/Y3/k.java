package Y3;

import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f3666c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f3668b;

    public k(DisplayMetrics displayMetrics) {
        int i = f3666c;
        f3666c = i + 1;
        this.f3667a = i;
        this.f3668b = displayMetrics;
    }
}
