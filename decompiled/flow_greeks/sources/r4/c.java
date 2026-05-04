package r4;

import i4.k;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import l4.p;
import l4.u;
import m4.m;
import s4.x;
import u4.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f19302f = Logger.getLogger(u.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f19303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f19304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m4.e f19305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t4.d f19306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u4.b f19307e;

    public c(Executor executor, m4.e eVar, x xVar, t4.d dVar, u4.b bVar) {
        this.f19304b = executor;
        this.f19305c = eVar;
        this.f19303a = xVar;
        this.f19306d = dVar;
        this.f19307e = bVar;
    }

    public static /* synthetic */ Object b(c cVar, p pVar, l4.i iVar) {
        cVar.f19306d.t(pVar, iVar);
        cVar.f19303a.b(pVar, 1);
        return null;
    }

    public static /* synthetic */ void c(final c cVar, final p pVar, k kVar, l4.i iVar) {
        cVar.getClass();
        try {
            m mVarA = cVar.f19305c.a(pVar.b());
            if (mVarA == null) {
                String str = String.format("Transport backend '%s' is not registered", pVar.b());
                f19302f.warning(str);
                kVar.a(new IllegalArgumentException(str));
            } else {
                final l4.i iVarB = mVarA.b(iVar);
                cVar.f19307e.e(new b.a() { // from class: r4.b
                    @Override // u4.b.a
                    public final Object a() {
                        return c.b(this.f19299a, pVar, iVarB);
                    }
                });
                kVar.a(null);
            }
        } catch (Exception e10) {
            f19302f.warning("Error scheduling event " + e10.getMessage());
            kVar.a(e10);
        }
    }

    @Override // r4.e
    public void a(final p pVar, final l4.i iVar, final k kVar) {
        this.f19304b.execute(new Runnable() { // from class: r4.a
            @Override // java.lang.Runnable
            public final void run() {
                c.c(this.f19295a, pVar, kVar, iVar);
            }
        });
    }
}
