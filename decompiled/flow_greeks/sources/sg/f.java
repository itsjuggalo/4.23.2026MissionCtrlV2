package sg;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final void a(gd.i iVar, Throwable th) {
        Iterator it = e.a().iterator();
        while (it.hasNext()) {
            try {
                ((ng.l0) it.next()).o(iVar, th);
            } catch (Throwable th2) {
                e.b(ng.m0.b(th, th2));
            }
        }
        try {
            cd.e.a(th, new g(iVar));
        } catch (Throwable unused) {
        }
        e.b(th);
    }
}
