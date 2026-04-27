package androidx.lifecycle;

import androidx.lifecycle.AbstractC0846i;

/* JADX INFO: loaded from: classes.dex */
public final class C implements InterfaceC0848k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A f7625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7626c;

    public C(String key, A handle) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(handle, "handle");
        this.f7624a = key;
        this.f7625b = handle;
    }

    @Override // androidx.lifecycle.InterfaceC0848k
    public void a(InterfaceC0850m source, AbstractC0846i.a event) {
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(event, "event");
        if (event == AbstractC0846i.a.ON_DESTROY) {
            this.f7626c = false;
            source.getLifecycle().c(this);
        }
    }

    public final void b(o0.d registry, AbstractC0846i lifecycle) {
        kotlin.jvm.internal.r.f(registry, "registry");
        kotlin.jvm.internal.r.f(lifecycle, "lifecycle");
        if (this.f7626c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f7626c = true;
        lifecycle.a(this);
        registry.h(this.f7624a, this.f7625b.c());
    }

    public final A c() {
        return this.f7625b;
    }

    public final boolean d() {
        return this.f7626c;
    }
}
