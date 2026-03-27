package a6;

import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class M implements K {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f10077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H6.f f10078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H6.h f10079d;

    public M(Map states) {
        AbstractC2304t.f(states, "states");
        this.f10077b = states;
        H6.f fVar = new H6.f("Java nullability annotation states");
        this.f10078c = fVar;
        H6.h hVarD = fVar.d(new L(this));
        AbstractC2304t.e(hVarD, "createMemoizedFunctionWithNullableValues(...)");
        this.f10079d = hVarD;
    }

    public static final Object c(M m8, q6.c cVar) {
        AbstractC2304t.c(cVar);
        return q6.e.a(cVar, m8.f10077b);
    }

    @Override // a6.K
    public Object a(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return this.f10079d.invoke(fqName);
    }
}
