package H;

import android.content.res.Configuration;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Configuration f3396b;

    public g(boolean z7) {
        this.f3395a = z7;
    }

    public final boolean a() {
        return this.f3395a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(boolean z7, Configuration newConfig) {
        this(z7);
        AbstractC2304t.f(newConfig, "newConfig");
        this.f3396b = newConfig;
    }
}
