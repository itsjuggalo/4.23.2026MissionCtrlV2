package g0;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: g0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1630b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f14241a;

    public C1630b(boolean z7) {
        this.f14241a = new AtomicBoolean(z7);
    }

    public final boolean a() {
        return this.f14241a.get();
    }

    public final void b(boolean z7) {
        this.f14241a.set(z7);
    }
}
