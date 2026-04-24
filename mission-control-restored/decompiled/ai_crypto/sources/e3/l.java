package e3;

import N3.a;
import j3.C2059o;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N3.a f13608a;

    public l(N3.a aVar) {
        this.f13608a = aVar;
    }

    public static /* synthetic */ void b(C1476e c1476e, N3.b bVar) {
        android.support.v4.media.session.b.a(bVar.get());
        throw null;
    }

    public void c(C2059o c2059o) {
        if (c2059o == null) {
            C1478g.f().k("Didn't successfully register with UserMetadata for rollouts listener");
        } else {
            final C1476e c1476e = new C1476e(c2059o);
            this.f13608a.a(new a.InterfaceC0058a() { // from class: e3.k
                @Override // N3.a.InterfaceC0058a
                public final void a(N3.b bVar) {
                    l.b(c1476e, bVar);
                }
            });
        }
    }
}
