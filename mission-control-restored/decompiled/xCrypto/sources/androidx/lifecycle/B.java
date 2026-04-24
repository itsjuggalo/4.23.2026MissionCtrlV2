package androidx.lifecycle;

import androidx.lifecycle.AbstractC0846i;

/* JADX INFO: loaded from: classes.dex */
public final class B implements InterfaceC0848k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f7623a;

    public B(E provider) {
        kotlin.jvm.internal.r.f(provider, "provider");
        this.f7623a = provider;
    }

    @Override // androidx.lifecycle.InterfaceC0848k
    public void a(InterfaceC0850m source, AbstractC0846i.a event) {
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(event, "event");
        if (event == AbstractC0846i.a.ON_CREATE) {
            source.getLifecycle().c(this);
            this.f7623a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
