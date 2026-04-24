package X5;

import h6.InterfaceC1904m;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends AbstractC0992h implements InterfaceC1904m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Enum f9448c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(q6.f fVar, Enum value) {
        super(fVar, null);
        AbstractC2304t.f(value, "value");
        this.f9448c = value;
    }

    @Override // h6.InterfaceC1904m
    public q6.b b() {
        Class<?> enclosingClass = this.f9448c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        AbstractC2304t.c(enclosingClass);
        return AbstractC0990f.e(enclosingClass);
    }

    @Override // h6.InterfaceC1904m
    public q6.f d() {
        return q6.f.l(this.f9448c.name());
    }
}
