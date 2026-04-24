package P2;

import S3.a;
import U2.o;
import e4.InterfaceC1669a;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S3.a f6365a;

    public l(S3.a aVar) {
        this.f6365a = aVar;
    }

    public static /* synthetic */ void b(e eVar, S3.b bVar) {
        ((InterfaceC1669a) bVar.get()).a("firebase", eVar);
        g.f().b("Registering RemoteConfig Rollouts subscriber");
    }

    public void c(o oVar) {
        if (oVar == null) {
            g.f().k("Didn't successfully register with UserMetadata for rollouts listener");
        } else {
            final e eVar = new e(oVar);
            this.f6365a.a(new a.InterfaceC0108a() { // from class: P2.k
                @Override // S3.a.InterfaceC0108a
                public final void a(S3.b bVar) {
                    l.b(eVar, bVar);
                }
            });
        }
    }
}
