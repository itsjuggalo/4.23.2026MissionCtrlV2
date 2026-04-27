package F;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Configuration f1711b;

    public i(boolean z7) {
        this.f1710a = z7;
    }

    public final boolean a() {
        return this.f1710a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(boolean z7, Configuration newConfig) {
        this(z7);
        kotlin.jvm.internal.r.f(newConfig, "newConfig");
        this.f1711b = newConfig;
    }
}
