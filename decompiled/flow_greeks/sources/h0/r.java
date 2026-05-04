package h0;

import android.content.res.Configuration;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Configuration f10919b;

    public r(boolean z10) {
        this.f10918a = z10;
    }

    public final boolean a() {
        return this.f10918a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(boolean z10, Configuration newConfig) {
        this(z10);
        kotlin.jvm.internal.t.f(newConfig, "newConfig");
        this.f10919b = newConfig;
    }
}
