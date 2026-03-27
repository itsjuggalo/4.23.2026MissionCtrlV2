package K3;

import L3.a0;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H3.e f1372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1373c;

    public /* synthetic */ o(Object obj, boolean z4, H3.e eVar, int i4, AbstractC1585j abstractC1585j) {
        this(obj, z4, (i4 & 4) != 0 ? null : eVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return i() == oVar.i() && kotlin.jvm.internal.r.b(f(), oVar.f());
    }

    @Override // K3.w
    public String f() {
        return this.f1373c;
    }

    public int hashCode() {
        return (Boolean.hashCode(i()) * 31) + f().hashCode();
    }

    @Override // K3.w
    public boolean i() {
        return this.f1371a;
    }

    public final H3.e k() {
        return this.f1372b;
    }

    @Override // K3.w
    public String toString() {
        if (!i()) {
            return f();
        }
        StringBuilder sb = new StringBuilder();
        a0.c(sb, f());
        String string = sb.toString();
        kotlin.jvm.internal.r.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Object body, boolean z4, H3.e eVar) {
        super(null);
        kotlin.jvm.internal.r.f(body, "body");
        this.f1371a = z4;
        this.f1372b = eVar;
        this.f1373c = body.toString();
        if (eVar != null && !eVar.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
