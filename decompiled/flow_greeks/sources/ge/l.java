package ge;

import fe.g1;
import java.util.Map;
import kotlin.jvm.internal.t;
import xf.c1;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ce.i f10561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ef.c f10562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f10563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cd.k f10565e;

    public l(ce.i builtIns, ef.c fqName, Map allValueArguments, boolean z10) {
        t.f(builtIns, "builtIns");
        t.f(fqName, "fqName");
        t.f(allValueArguments, "allValueArguments");
        this.f10561a = builtIns;
        this.f10562b = fqName;
        this.f10563c = allValueArguments;
        this.f10564d = z10;
        this.f10565e = cd.l.a(cd.n.f3864b, new k(this));
    }

    public static final c1 c(l lVar) {
        return lVar.f10561a.p(lVar.e()).s();
    }

    @Override // ge.c
    public Map a() {
        return this.f10563c;
    }

    @Override // ge.c
    public ef.c e() {
        return this.f10562b;
    }

    @Override // ge.c
    public r0 getType() {
        Object value = this.f10565e.getValue();
        t.e(value, "getValue(...)");
        return (r0) value;
    }

    @Override // ge.c
    public g1 j() {
        g1 NO_SOURCE = g1.f9483a;
        t.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    public /* synthetic */ l(ce.i iVar, ef.c cVar, Map map, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this(iVar, cVar, map, (i10 & 8) != 0 ? false : z10);
    }
}
