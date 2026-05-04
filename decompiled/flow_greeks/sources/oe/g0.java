package oe;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f17969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f17970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f17971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cd.k f17972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17973e;

    public g0(o0 globalLevel, o0 o0Var, Map userDefinedLevelForSpecificAnnotation) {
        kotlin.jvm.internal.t.f(globalLevel, "globalLevel");
        kotlin.jvm.internal.t.f(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.f17969a = globalLevel;
        this.f17970b = o0Var;
        this.f17971c = userDefinedLevelForSpecificAnnotation;
        this.f17972d = cd.l.b(new f0(this));
        o0 o0Var2 = o0.f18046c;
        this.f17973e = globalLevel == o0Var2 && o0Var == o0Var2 && userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    public static final String[] b(g0 g0Var) {
        List listC = dd.q.c();
        listC.add(g0Var.f17969a.b());
        o0 o0Var = g0Var.f17970b;
        if (o0Var != null) {
            listC.add("under-migration:" + o0Var.b());
        }
        for (Map.Entry entry : g0Var.f17971c.entrySet()) {
            listC.add('@' + entry.getKey() + ':' + ((o0) entry.getValue()).b());
        }
        return (String[]) dd.q.a(listC).toArray(new String[0]);
    }

    public final o0 c() {
        return this.f17969a;
    }

    public final o0 d() {
        return this.f17970b;
    }

    public final Map e() {
        return this.f17971c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f17969a == g0Var.f17969a && this.f17970b == g0Var.f17970b && kotlin.jvm.internal.t.b(this.f17971c, g0Var.f17971c);
    }

    public final boolean f() {
        return this.f17973e;
    }

    public int hashCode() {
        int iHashCode = this.f17969a.hashCode() * 31;
        o0 o0Var = this.f17970b;
        return ((iHashCode + (o0Var == null ? 0 : o0Var.hashCode())) * 31) + this.f17971c.hashCode();
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f17969a + ", migrationLevel=" + this.f17970b + ", userDefinedLevelForSpecificAnnotation=" + this.f17971c + ')';
    }

    public /* synthetic */ g0(o0 o0Var, o0 o0Var2, Map map, int i10, kotlin.jvm.internal.k kVar) {
        this(o0Var, (i10 & 2) != 0 ? null : o0Var2, (i10 & 4) != 0 ? dd.o0.h() : map);
    }
}
