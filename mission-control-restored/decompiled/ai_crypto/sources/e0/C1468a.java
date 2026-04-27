package e0;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: e0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1468a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f13512a;

    public C1468a(boolean z7) {
        this.f13512a = new AtomicBoolean(z7);
    }

    public final boolean a() {
        return this.f13512a.get();
    }

    public final void b(boolean z7) {
        this.f13512a.set(z7);
    }
}
