package fe;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i0 extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f9486b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(List underlyingPropertyNamesToTypes) {
        super(null);
        kotlin.jvm.internal.t.f(underlyingPropertyNamesToTypes, "underlyingPropertyNamesToTypes");
        this.f9485a = underlyingPropertyNamesToTypes;
        Map mapT = dd.o0.t(c());
        if (mapT.size() != c().size()) {
            throw new IllegalArgumentException("Some properties have the same names");
        }
        this.f9486b = mapT;
    }

    @Override // fe.q1
    public boolean a(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        return this.f9486b.containsKey(name);
    }

    public List c() {
        return this.f9485a;
    }

    public String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + c() + ')';
    }
}
