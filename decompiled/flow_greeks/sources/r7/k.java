package r7;

import fa.a;
import w7.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.a f19383a;

    public k(fa.a aVar) {
        this.f19383a = aVar;
    }

    public static /* synthetic */ void a(e eVar, fa.b bVar) {
        ((sa.a) bVar.get()).a("firebase", eVar);
        g.f().b("Registering RemoteConfig Rollouts subscriber");
    }

    public void b(o oVar) {
        if (oVar == null) {
            g.f().k("Didn't successfully register with UserMetadata for rollouts listener");
        } else {
            final e eVar = new e(oVar);
            this.f19383a.a(new a.InterfaceC0174a() { // from class: r7.j
                @Override // fa.a.InterfaceC0174a
                public final void a(fa.b bVar) {
                    k.a(eVar, bVar);
                }
            });
        }
    }
}
