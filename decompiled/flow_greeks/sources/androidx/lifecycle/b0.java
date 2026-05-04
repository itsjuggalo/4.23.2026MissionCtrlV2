package androidx.lifecycle;

import androidx.lifecycle.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f2393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2394c;

    public b0(String key, z handle) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(handle, "handle");
        this.f2392a = key;
        this.f2393b = handle;
    }

    public final void a(k2.d registry, i lifecycle) {
        kotlin.jvm.internal.t.f(registry, "registry");
        kotlin.jvm.internal.t.f(lifecycle, "lifecycle");
        if (this.f2394c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f2394c = true;
        lifecycle.a(this);
        registry.h(this.f2392a, this.f2393b.c());
    }

    @Override // androidx.lifecycle.k
    public void b(m source, i.a event) {
        kotlin.jvm.internal.t.f(source, "source");
        kotlin.jvm.internal.t.f(event, "event");
        if (event == i.a.ON_DESTROY) {
            this.f2394c = false;
            source.getLifecycle().c(this);
        }
    }

    public final z c() {
        return this.f2393b;
    }

    public final boolean d() {
        return this.f2394c;
    }
}
