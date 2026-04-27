package androidx.lifecycle;

import androidx.lifecycle.AbstractC1157i;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class C implements InterfaceC1159k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A f11921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11922c;

    public C(String key, A handle) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(handle, "handle");
        this.f11920a = key;
        this.f11921b = handle;
    }

    public final void a(z0.d registry, AbstractC1157i lifecycle) {
        AbstractC2304t.f(registry, "registry");
        AbstractC2304t.f(lifecycle, "lifecycle");
        if (!(!this.f11922c)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f11922c = true;
        lifecycle.a(this);
        registry.h(this.f11920a, this.f11921b.c());
    }

    @Override // androidx.lifecycle.InterfaceC1159k
    public void b(InterfaceC1161m source, AbstractC1157i.a event) {
        AbstractC2304t.f(source, "source");
        AbstractC2304t.f(event, "event");
        if (event == AbstractC1157i.a.ON_DESTROY) {
            this.f11922c = false;
            source.getLifecycle().c(this);
        }
    }

    public final A c() {
        return this.f11921b;
    }

    public final boolean d() {
        return this.f11922c;
    }
}
