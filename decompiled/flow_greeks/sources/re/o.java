package re;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public of.c f19869a;

    @Override // re.n
    public fe.e a(ve.g javaClass) {
        t.f(javaClass, "javaClass");
        return b().b(javaClass);
    }

    public final of.c b() {
        of.c cVar = this.f19869a;
        if (cVar != null) {
            return cVar;
        }
        t.s("resolver");
        return null;
    }

    public final void c(of.c cVar) {
        t.f(cVar, "<set-?>");
        this.f19869a = cVar;
    }
}
