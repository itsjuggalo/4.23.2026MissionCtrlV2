package V;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f5274a;

    public b(boolean z4) {
        this.f5274a = new AtomicBoolean(z4);
    }

    public final boolean a() {
        return this.f5274a.get();
    }

    public final void b(boolean z4) {
        this.f5274a.set(z4);
    }
}
