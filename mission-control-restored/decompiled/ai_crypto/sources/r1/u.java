package r1;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import o1.C2291c;
import o1.InterfaceC2298j;
import o1.InterfaceC2299k;
import r1.i;

/* JADX INFO: loaded from: classes.dex */
public class u implements t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile v f22441e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B1.a f22442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B1.a f22443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x1.e f22444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y1.r f22445d;

    public u(B1.a aVar, B1.a aVar2, x1.e eVar, y1.r rVar, y1.v vVar) {
        this.f22442a = aVar;
        this.f22443b = aVar2;
        this.f22444c = eVar;
        this.f22445d = rVar;
        vVar.c();
    }

    public static u c() {
        v vVar = f22441e;
        if (vVar != null) {
            return vVar.i();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(C2291c.b("proto"));
    }

    public static void f(Context context) {
        if (f22441e == null) {
            synchronized (u.class) {
                try {
                    if (f22441e == null) {
                        f22441e = AbstractC2577e.a().b(context).a();
                    }
                } finally {
                }
            }
        }
    }

    @Override // r1.t
    public void a(o oVar, InterfaceC2299k interfaceC2299k) {
        this.f22444c.a(oVar.f().f(oVar.c().d()), b(oVar), interfaceC2299k);
    }

    public final i b(o oVar) {
        i.a aVarG = i.a().i(this.f22442a.a()).o(this.f22443b.a()).n(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a());
        if (oVar.c().e() != null && oVar.c().e().a() != null) {
            aVarG.l(oVar.c().e().a());
        }
        oVar.c().b();
        return aVarG.d();
    }

    public y1.r e() {
        return this.f22445d;
    }

    public InterfaceC2298j g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.b()).a(), this);
    }
}
