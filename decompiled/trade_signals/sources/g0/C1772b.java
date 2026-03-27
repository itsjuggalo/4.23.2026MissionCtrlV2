package g0;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: g0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1772b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f17965a;

    public C1772b(boolean z7) {
        this.f17965a = new AtomicBoolean(z7);
    }

    public final boolean a() {
        return this.f17965a.get();
    }

    public final void b(boolean z7) {
        this.f17965a.set(z7);
    }
}
