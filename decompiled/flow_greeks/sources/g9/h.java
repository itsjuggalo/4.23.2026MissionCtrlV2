package g9;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h implements d9.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f10222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d9.r f10223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f10224c = false;

    public h(Executor executor, d9.r rVar) {
        this.f10222a = executor;
        this.f10223b = rVar;
    }

    public static /* synthetic */ void b(h hVar, Object obj, com.google.firebase.firestore.f fVar) {
        if (hVar.f10224c) {
            return;
        }
        hVar.f10223b.a(obj, fVar);
    }

    @Override // d9.r
    public void a(final Object obj, final com.google.firebase.firestore.f fVar) {
        this.f10222a.execute(new Runnable() { // from class: g9.g
            @Override // java.lang.Runnable
            public final void run() {
                h.b(this.f10208a, obj, fVar);
            }
        });
    }

    public void c() {
        this.f10224c = true;
    }
}
