package le;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends e0 implements ve.v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f15606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f15607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15608d;

    public c0(Class reflectType) {
        kotlin.jvm.internal.t.f(reflectType, "reflectType");
        this.f15606b = reflectType;
        this.f15607c = dd.r.k();
    }

    @Override // le.e0
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public Class Q() {
        return this.f15606b;
    }

    @Override // ve.d
    public Collection getAnnotations() {
        return this.f15607c;
    }

    @Override // ve.v
    public ce.l getType() {
        if (kotlin.jvm.internal.t.b(Q(), Void.TYPE)) {
            return null;
        }
        return of.e.c(Q().getName()).k();
    }

    @Override // ve.d
    public boolean n() {
        return this.f15608d;
    }
}
