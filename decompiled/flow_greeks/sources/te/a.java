package te;

import dd.t0;
import dd.v0;
import fe.l1;
import java.util.Set;
import kotlin.jvm.internal.t;
import xf.c1;
import xf.g0;
import xf.h2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h2 f21896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f21897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f21898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f21899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set f21900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c1 f21901i;

    public /* synthetic */ a(h2 h2Var, c cVar, boolean z10, boolean z11, Set set, c1 c1Var, int i10, kotlin.jvm.internal.k kVar) {
        this(h2Var, (i10 & 2) != 0 ? c.f21902a : cVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? null : set, (i10 & 32) != 0 ? null : c1Var);
    }

    public static /* synthetic */ a f(a aVar, h2 h2Var, c cVar, boolean z10, boolean z11, Set set, c1 c1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            h2Var = aVar.f21896d;
        }
        if ((i10 & 2) != 0) {
            cVar = aVar.f21897e;
        }
        if ((i10 & 4) != 0) {
            z10 = aVar.f21898f;
        }
        if ((i10 & 8) != 0) {
            z11 = aVar.f21899g;
        }
        if ((i10 & 16) != 0) {
            set = aVar.f21900h;
        }
        if ((i10 & 32) != 0) {
            c1Var = aVar.f21901i;
        }
        Set set2 = set;
        c1 c1Var2 = c1Var;
        return aVar.e(h2Var, cVar, z10, z11, set2, c1Var2);
    }

    @Override // xf.g0
    public c1 a() {
        return this.f21901i;
    }

    @Override // xf.g0
    public h2 b() {
        return this.f21896d;
    }

    @Override // xf.g0
    public Set c() {
        return this.f21900h;
    }

    public final a e(h2 howThisTypeIsUsed, c flexibility, boolean z10, boolean z11, Set set, c1 c1Var) {
        t.f(howThisTypeIsUsed, "howThisTypeIsUsed");
        t.f(flexibility, "flexibility");
        return new a(howThisTypeIsUsed, flexibility, z10, z11, set, c1Var);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return t.b(aVar.a(), a()) && aVar.b() == b() && aVar.f21897e == this.f21897e && aVar.f21898f == this.f21898f && aVar.f21899g == this.f21899g;
    }

    public final c g() {
        return this.f21897e;
    }

    public final boolean h() {
        return this.f21899g;
    }

    @Override // xf.g0
    public int hashCode() {
        c1 c1VarA = a();
        int iHashCode = c1VarA != null ? c1VarA.hashCode() : 0;
        int iHashCode2 = iHashCode + (iHashCode * 31) + b().hashCode();
        int iHashCode3 = iHashCode2 + (iHashCode2 * 31) + this.f21897e.hashCode();
        int i10 = iHashCode3 + (iHashCode3 * 31) + (this.f21898f ? 1 : 0);
        return i10 + (i10 * 31) + (this.f21899g ? 1 : 0);
    }

    public final boolean i() {
        return this.f21898f;
    }

    public final a j(boolean z10) {
        return f(this, null, null, z10, false, null, null, 59, null);
    }

    public a k(c1 c1Var) {
        return f(this, null, null, false, false, null, c1Var, 31, null);
    }

    public final a l(c flexibility) {
        t.f(flexibility, "flexibility");
        return f(this, null, flexibility, false, false, null, null, 61, null);
    }

    @Override // xf.g0
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a d(l1 typeParameter) {
        t.f(typeParameter, "typeParameter");
        return f(this, null, null, false, false, c() != null ? v0.m(c(), typeParameter) : t0.c(typeParameter), null, 47, null);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f21896d + ", flexibility=" + this.f21897e + ", isRaw=" + this.f21898f + ", isForAnnotationParameter=" + this.f21899g + ", visitedTypeParameters=" + this.f21900h + ", defaultType=" + this.f21901i + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(h2 howThisTypeIsUsed, c flexibility, boolean z10, boolean z11, Set set, c1 c1Var) {
        super(howThisTypeIsUsed, set, c1Var);
        t.f(howThisTypeIsUsed, "howThisTypeIsUsed");
        t.f(flexibility, "flexibility");
        this.f21896d = howThisTypeIsUsed;
        this.f21897e = flexibility;
        this.f21898f = z10;
        this.f21899g = z11;
        this.f21900h = set;
        this.f21901i = c1Var;
    }
}
