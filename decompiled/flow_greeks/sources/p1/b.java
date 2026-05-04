package p1;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f18175a;

    public b(boolean z10) {
        this.f18175a = new AtomicBoolean(z10);
    }

    public final boolean a() {
        return this.f18175a.get();
    }

    public final void b(boolean z10) {
        this.f18175a.set(z10);
    }
}
