package d2;

import android.os.Build;

/* JADX INFO: renamed from: d2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1619a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16839a;

    static {
        f16839a = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }
}
