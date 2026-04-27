package s6;

import kotlin.jvm.internal.AbstractC2148j;
import t6.a0;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.e f23059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23060c;

    public /* synthetic */ o(Object obj, boolean z7, p6.e eVar, int i7, AbstractC2148j abstractC2148j) {
        this(obj, z7, (i7 & 4) != 0 ? null : eVar);
    }

    @Override // s6.w
    public String a() {
        return this.f23060c;
    }

    @Override // s6.w
    public boolean c() {
        return this.f23058a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return c() == oVar.c() && kotlin.jvm.internal.r.b(a(), oVar.a());
    }

    public final p6.e g() {
        return this.f23059b;
    }

    public int hashCode() {
        return (Boolean.hashCode(c()) * 31) + a().hashCode();
    }

    @Override // s6.w
    public String toString() {
        if (!c()) {
            return a();
        }
        StringBuilder sb = new StringBuilder();
        a0.c(sb, a());
        String string = sb.toString();
        kotlin.jvm.internal.r.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Object body, boolean z7, p6.e eVar) {
        super(null);
        kotlin.jvm.internal.r.f(body, "body");
        this.f23058a = z7;
        this.f23059b = eVar;
        this.f23060c = body.toString();
        if (eVar != null && !eVar.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
