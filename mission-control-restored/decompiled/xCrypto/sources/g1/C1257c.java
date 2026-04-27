package g1;

import X0.k;
import a1.p;
import a1.u;
import b1.InterfaceC0861e;
import b1.m;
import h1.x;
import i1.InterfaceC1297d;
import j1.InterfaceC1562b;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: renamed from: g1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1257c implements InterfaceC1259e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f11905f = Logger.getLogger(u.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f11906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f11907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0861e f11908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC1297d f11909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC1562b f11910e;

    public C1257c(Executor executor, InterfaceC0861e interfaceC0861e, x xVar, InterfaceC1297d interfaceC1297d, InterfaceC1562b interfaceC1562b) {
        this.f11907b = executor;
        this.f11908c = interfaceC0861e;
        this.f11906a = xVar;
        this.f11909d = interfaceC1297d;
        this.f11910e = interfaceC1562b;
    }

    public static /* synthetic */ Object b(C1257c c1257c, p pVar, a1.i iVar) {
        c1257c.f11909d.n(pVar, iVar);
        c1257c.f11906a.b(pVar, 1);
        return null;
    }

    public static /* synthetic */ void c(final C1257c c1257c, final p pVar, k kVar, a1.i iVar) {
        c1257c.getClass();
        try {
            m mVarA = c1257c.f11908c.a(pVar.b());
            if (mVarA == null) {
                String str = String.format("Transport backend '%s' is not registered", pVar.b());
                f11905f.warning(str);
                kVar.a(new IllegalArgumentException(str));
            } else {
                final a1.i iVarA = mVarA.a(iVar);
                c1257c.f11910e.f(new InterfaceC1562b.a() { // from class: g1.b
                    @Override // j1.InterfaceC1562b.a
                    public final Object a() {
                        return C1257c.b(this.f11902a, pVar, iVarA);
                    }
                });
                kVar.a(null);
            }
        } catch (Exception e4) {
            f11905f.warning("Error scheduling event " + e4.getMessage());
            kVar.a(e4);
        }
    }

    @Override // g1.InterfaceC1259e
    public void a(final p pVar, final a1.i iVar, final k kVar) {
        this.f11907b.execute(new Runnable() { // from class: g1.a
            @Override // java.lang.Runnable
            public final void run() {
                C1257c.c(this.f11898a, pVar, kVar, iVar);
            }
        });
    }
}
