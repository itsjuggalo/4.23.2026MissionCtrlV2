package R5;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class I extends r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7205b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(List underlyingPropertyNamesToTypes) {
        super(null);
        AbstractC2304t.f(underlyingPropertyNamesToTypes, "underlyingPropertyNamesToTypes");
        this.f7204a = underlyingPropertyNamesToTypes;
        Map mapU = p5.M.u(c());
        if (mapU.size() != c().size()) {
            throw new IllegalArgumentException("Some properties have the same names".toString());
        }
        this.f7205b = mapU;
    }

    @Override // R5.r0
    public boolean a(q6.f name) {
        AbstractC2304t.f(name, "name");
        return this.f7205b.containsKey(name);
    }

    public List c() {
        return this.f7204a;
    }

    public String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + c() + ')';
    }
}
