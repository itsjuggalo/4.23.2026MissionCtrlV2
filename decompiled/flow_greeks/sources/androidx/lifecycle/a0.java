package androidx.lifecycle;

import androidx.lifecycle.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f2384a;

    public a0(d0 provider) {
        kotlin.jvm.internal.t.f(provider, "provider");
        this.f2384a = provider;
    }

    @Override // androidx.lifecycle.k
    public void b(m source, i.a event) {
        kotlin.jvm.internal.t.f(source, "source");
        kotlin.jvm.internal.t.f(event, "event");
        if (event == i.a.ON_CREATE) {
            source.getLifecycle().c(this);
            this.f2384a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
