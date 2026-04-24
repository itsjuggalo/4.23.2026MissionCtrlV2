package androidx.lifecycle;

import androidx.lifecycle.AbstractC0963i;

/* JADX INFO: loaded from: classes.dex */
public final class C implements InterfaceC0965k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A f7723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7724c;

    public C(String key, A handle) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(handle, "handle");
        this.f7722a = key;
        this.f7723b = handle;
    }

    @Override // androidx.lifecycle.InterfaceC0965k
    public void a(InterfaceC0967m source, AbstractC0963i.a event) {
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(event, "event");
        if (event == AbstractC0963i.a.ON_DESTROY) {
            this.f7724c = false;
            source.a().c(this);
        }
    }

    public final void b(F0.d registry, AbstractC0963i lifecycle) {
        kotlin.jvm.internal.r.f(registry, "registry");
        kotlin.jvm.internal.r.f(lifecycle, "lifecycle");
        if (this.f7724c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f7724c = true;
        lifecycle.a(this);
        registry.h(this.f7722a, this.f7723b.c());
    }

    public final A c() {
        return this.f7723b;
    }

    public final boolean d() {
        return this.f7724c;
    }
}
