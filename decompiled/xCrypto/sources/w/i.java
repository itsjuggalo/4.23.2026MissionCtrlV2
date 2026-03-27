package w;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Configuration f15384b;

    public i(boolean z4) {
        this.f15383a = z4;
    }

    public final boolean a() {
        return this.f15383a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(boolean z4, Configuration newConfig) {
        this(z4);
        kotlin.jvm.internal.r.f(newConfig, "newConfig");
        this.f15384b = newConfig;
    }
}
