package androidx.lifecycle;

import androidx.lifecycle.AbstractC1157i;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class B implements InterfaceC1159k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f11919a;

    public B(E provider) {
        AbstractC2304t.f(provider, "provider");
        this.f11919a = provider;
    }

    @Override // androidx.lifecycle.InterfaceC1159k
    public void b(InterfaceC1161m source, AbstractC1157i.a event) {
        AbstractC2304t.f(source, "source");
        AbstractC2304t.f(event, "event");
        if (event == AbstractC1157i.a.ON_CREATE) {
            source.getLifecycle().c(this);
            this.f11919a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
