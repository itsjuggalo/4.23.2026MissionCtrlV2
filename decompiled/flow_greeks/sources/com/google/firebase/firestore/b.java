package com.google.firebase.firestore;

import bb.d0;
import com.google.firebase.firestore.a;
import com.google.firebase.firestore.d;
import java.util.Map;
import java.util.Objects;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d9.c f6136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f6137b;

    public b(d9.c cVar, Map map) {
        x.b(cVar);
        this.f6136a = cVar;
        this.f6137b = map;
    }

    public final Object a(Object obj, a aVar, Class cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new RuntimeException("AggregateField '" + aVar.c() + "' is not a " + cls.getName());
    }

    public long b(a.c cVar) {
        Long lH = h(cVar);
        if (lH != null) {
            return lH.longValue();
        }
        throw new IllegalArgumentException("RunAggregationQueryResponse alias " + cVar.c() + " is null");
    }

    public Double c(a.b bVar) {
        return f(bVar);
    }

    public Object d(a aVar) {
        return g(aVar);
    }

    public long e() {
        return b(a.b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6136a.equals(bVar.f6136a) && this.f6137b.equals(bVar.f6137b);
    }

    public Double f(a aVar) {
        Number number = (Number) i(aVar, Number.class);
        if (number != null) {
            return Double.valueOf(number.doubleValue());
        }
        return null;
    }

    public final Object g(a aVar) {
        if (this.f6137b.containsKey(aVar.c())) {
            return new m(this.f6136a.d().f6193b, d.a.f6147d).f((d0) this.f6137b.get(aVar.c()));
        }
        throw new IllegalArgumentException("'" + aVar.e() + "(" + aVar.d() + ")' was not requested in the aggregation query.");
    }

    public Long h(a aVar) {
        Number number = (Number) i(aVar, Number.class);
        if (number != null) {
            return Long.valueOf(number.longValue());
        }
        return null;
    }

    public int hashCode() {
        return Objects.hash(this.f6136a, this.f6137b);
    }

    public final Object i(a aVar, Class cls) {
        return a(g(aVar), aVar, cls);
    }
}
