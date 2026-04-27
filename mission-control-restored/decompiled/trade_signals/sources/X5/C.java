package X5;

import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import z6.EnumC3021e;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends E implements h6.v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f9393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f9394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9395d;

    public C(Class reflectType) {
        AbstractC2304t.f(reflectType, "reflectType");
        this.f9393b = reflectType;
        this.f9394c = AbstractC2595q.i();
    }

    @Override // X5.E
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public Class R() {
        return this.f9393b;
    }

    @Override // h6.InterfaceC1895d
    public Collection getAnnotations() {
        return this.f9394c;
    }

    @Override // h6.v
    public O5.l getType() {
        if (AbstractC2304t.b(R(), Void.TYPE)) {
            return null;
        }
        return EnumC3021e.g(R().getName()).l();
    }

    @Override // h6.InterfaceC1895d
    public boolean i() {
        return this.f9395d;
    }
}
