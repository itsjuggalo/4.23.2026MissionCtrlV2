package aa;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m3 f527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f528b;

    public n(a7.g gVar, m3 m3Var, c9.d dVar) {
        this.f527a = m3Var;
        this.f528b = new AtomicBoolean(gVar.x());
        dVar.b(a7.b.class, new c9.b() { // from class: aa.m
            @Override // c9.b
            public final void handle(c9.a aVar) {
                n.a(this.f513a, aVar);
            }
        });
    }

    public static /* synthetic */ void a(n nVar, c9.a aVar) {
        nVar.getClass();
        nVar.f528b.set(((a7.b) aVar.a()).f306a);
    }

    public boolean b() {
        return d() ? this.f527a.c("auto_init", true) : c() ? this.f527a.b("firebase_inapp_messaging_auto_data_collection_enabled", true) : this.f528b.get();
    }

    public final boolean c() {
        return this.f527a.d("firebase_inapp_messaging_auto_data_collection_enabled");
    }

    public final boolean d() {
        return this.f527a.e("auto_init");
    }
}
