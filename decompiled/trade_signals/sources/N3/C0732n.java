package N3;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: N3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0732n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n1 f5713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f5714b;

    public C0732n(G2.f fVar, n1 n1Var, A3.d dVar) {
        this.f5713a = n1Var;
        this.f5714b = new AtomicBoolean(fVar.x());
        dVar.a(G2.b.class, new A3.b() { // from class: N3.m
            @Override // A3.b
            public final void handle(A3.a aVar) {
                this.f5709a.e(aVar);
            }
        });
    }

    public boolean b() {
        return d() ? this.f5713a.c("auto_init", true) : c() ? this.f5713a.b("firebase_inapp_messaging_auto_data_collection_enabled", true) : this.f5714b.get();
    }

    public final boolean c() {
        return this.f5713a.d("firebase_inapp_messaging_auto_data_collection_enabled");
    }

    public final boolean d() {
        return this.f5713a.e("auto_init");
    }

    public final /* synthetic */ void e(A3.a aVar) {
        this.f5714b.set(((G2.b) aVar.a()).f2163a);
    }
}
