package androidx.lifecycle;

import androidx.lifecycle.AbstractC0963i;

/* JADX INFO: loaded from: classes.dex */
public final class B implements InterfaceC0965k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f7721a;

    public B(E provider) {
        kotlin.jvm.internal.r.f(provider, "provider");
        this.f7721a = provider;
    }

    @Override // androidx.lifecycle.InterfaceC0965k
    public void a(InterfaceC0967m source, AbstractC0963i.a event) {
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(event, "event");
        if (event == AbstractC0963i.a.ON_CREATE) {
            source.a().c(this);
            this.f7721a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
