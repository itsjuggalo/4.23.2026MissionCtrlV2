package aa;

import java.util.Date;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.c f386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f387b;

    public b(b7.c cVar, Executor executor) {
        this.f386a = cVar;
        this.f387b = executor;
    }

    public static /* synthetic */ void a(b bVar, q9.m mVar) {
        bVar.getClass();
        try {
            h2.a("Updating active experiment: " + mVar.toString());
            bVar.f386a.o(new b7.b(mVar.b0(), mVar.g0(), mVar.e0(), new Date(mVar.c0()), mVar.f0(), mVar.d0()));
        } catch (b7.a e10) {
            h2.b("Unable to set experiment as active with ABT, missing analytics?\n" + e10.getMessage());
        }
    }

    public void b(final q9.m mVar) {
        this.f387b.execute(new Runnable() { // from class: aa.a
            @Override // java.lang.Runnable
            public final void run() {
                b.a(this.f379a, mVar);
            }
        });
    }
}
