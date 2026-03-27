package X5;

import X5.E;
import h6.InterfaceC1890C;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class H extends E implements InterfaceC1890C {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WildcardType f9403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f9404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9405d;

    public H(WildcardType reflectType) {
        AbstractC2304t.f(reflectType, "reflectType");
        this.f9403b = reflectType;
        this.f9404c = AbstractC2595q.i();
    }

    @Override // h6.InterfaceC1890C
    public boolean J() {
        AbstractC2304t.e(R().getUpperBounds(), "getUpperBounds(...)");
        return !AbstractC2304t.b(AbstractC2592n.D(r0), Object.class);
    }

    @Override // h6.InterfaceC1890C
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public E A() {
        Type[] upperBounds = R().getUpperBounds();
        Type[] lowerBounds = R().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + R());
        }
        if (lowerBounds.length == 1) {
            E.a aVar = E.f9397a;
            AbstractC2304t.c(lowerBounds);
            Object objY = AbstractC2592n.Y(lowerBounds);
            AbstractC2304t.e(objY, "single(...)");
            return aVar.a((Type) objY);
        }
        if (upperBounds.length == 1) {
            AbstractC2304t.c(upperBounds);
            Type type = (Type) AbstractC2592n.Y(upperBounds);
            if (!AbstractC2304t.b(type, Object.class)) {
                E.a aVar2 = E.f9397a;
                AbstractC2304t.c(type);
                return aVar2.a(type);
            }
        }
        return null;
    }

    @Override // X5.E
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public WildcardType R() {
        return this.f9403b;
    }

    @Override // h6.InterfaceC1895d
    public Collection getAnnotations() {
        return this.f9404c;
    }

    @Override // h6.InterfaceC1895d
    public boolean i() {
        return this.f9405d;
    }
}
