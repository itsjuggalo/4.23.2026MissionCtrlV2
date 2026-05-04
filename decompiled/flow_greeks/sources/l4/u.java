package l4;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import l4.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u implements t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile v f15420e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v4.a f15421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v4.a f15422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r4.e f15423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s4.r f15424d;

    public u(v4.a aVar, v4.a aVar2, r4.e eVar, s4.r rVar, s4.v vVar) {
        this.f15421a = aVar;
        this.f15422b = aVar2;
        this.f15423c = eVar;
        this.f15424d = rVar;
        vVar.c();
    }

    public static u c() {
        v vVar = f15420e;
        if (vVar != null) {
            return vVar.c();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(i4.c.b("proto"));
    }

    public static void f(Context context) {
        if (f15420e == null) {
            synchronized (u.class) {
                try {
                    if (f15420e == null) {
                        f15420e = e.a().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // l4.t
    public void a(o oVar, i4.k kVar) {
        this.f15423c.a(oVar.f().f(oVar.c().d()), b(oVar), kVar);
    }

    public final i b(o oVar) {
        i.a aVarG = i.a().i(this.f15421a.a()).o(this.f15422b.a()).n(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a());
        if (oVar.c().e() != null && oVar.c().e().a() != null) {
            aVarG.l(oVar.c().e().a());
        }
        oVar.c().b();
        return aVarG.d();
    }

    public s4.r e() {
        return this.f15424d;
    }

    public i4.j g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
