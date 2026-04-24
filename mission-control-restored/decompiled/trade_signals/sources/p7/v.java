package p7;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import q7.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m7.e f22487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22488c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Object body, boolean z7, m7.e eVar) {
        super(null);
        AbstractC2304t.f(body, "body");
        this.f22486a = z7;
        this.f22487b = eVar;
        this.f22488c = body.toString();
        if (eVar != null && !eVar.isInline()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @Override // p7.E
    public String a() {
        return this.f22488c;
    }

    @Override // p7.E
    public boolean d() {
        return this.f22486a;
    }

    public final m7.e e() {
        return this.f22487b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return d() == vVar.d() && AbstractC2304t.b(a(), vVar.a());
    }

    public int hashCode() {
        return (Boolean.hashCode(d()) * 31) + a().hashCode();
    }

    @Override // p7.E
    public String toString() {
        if (!d()) {
            return a();
        }
        StringBuilder sb = new StringBuilder();
        e0.c(sb, a());
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }

    public /* synthetic */ v(Object obj, boolean z7, m7.e eVar, int i8, AbstractC2296k abstractC2296k) {
        this(obj, z7, (i8 & 4) != 0 ? null : eVar);
    }
}
