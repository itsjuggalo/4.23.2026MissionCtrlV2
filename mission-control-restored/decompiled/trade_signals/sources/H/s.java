package H;

import android.content.res.Configuration;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Configuration f3546b;

    public s(boolean z7) {
        this.f3545a = z7;
    }

    public final boolean a() {
        return this.f3545a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(boolean z7, Configuration newConfig) {
        this(z7);
        AbstractC2304t.f(newConfig, "newConfig");
        this.f3546b = newConfig;
    }
}
