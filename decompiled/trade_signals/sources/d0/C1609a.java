package d0;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: d0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1609a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f16696a;

    public C1609a(boolean z7) {
        this.f16696a = new AtomicBoolean(z7);
    }

    public final boolean a() {
        return this.f16696a.get();
    }

    public final void b(boolean z7) {
        this.f16696a.set(z7);
    }
}
