package le;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import le.e0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends e0 implements ve.c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WildcardType f15625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f15626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15627d;

    public h0(WildcardType reflectType) {
        kotlin.jvm.internal.t.f(reflectType, "reflectType");
        this.f15625b = reflectType;
        this.f15626c = dd.r.k();
    }

    @Override // ve.c0
    public boolean I() {
        kotlin.jvm.internal.t.e(Q().getUpperBounds(), "getUpperBounds(...)");
        return !kotlin.jvm.internal.t.b(dd.n.D(r0), Object.class);
    }

    @Override // ve.c0
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public e0 B() {
        Type[] upperBounds = Q().getUpperBounds();
        Type[] lowerBounds = Q().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + Q());
        }
        if (lowerBounds.length == 1) {
            e0.a aVar = e0.f15612a;
            kotlin.jvm.internal.t.c(lowerBounds);
            Object objN0 = dd.n.n0(lowerBounds);
            kotlin.jvm.internal.t.e(objN0, "single(...)");
            return aVar.a((Type) objN0);
        }
        if (upperBounds.length == 1) {
            kotlin.jvm.internal.t.c(upperBounds);
            Type type = (Type) dd.n.n0(upperBounds);
            if (!kotlin.jvm.internal.t.b(type, Object.class)) {
                e0.a aVar2 = e0.f15612a;
                kotlin.jvm.internal.t.c(type);
                return aVar2.a(type);
            }
        }
        return null;
    }

    @Override // le.e0
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public WildcardType Q() {
        return this.f15625b;
    }

    @Override // ve.d
    public Collection getAnnotations() {
        return this.f15626c;
    }

    @Override // ve.d
    public boolean n() {
        return this.f15627d;
    }
}
