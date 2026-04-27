package P3;

import N3.O0;

/* JADX INFO: loaded from: classes.dex */
public class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public O0 f6372a;

    public E(O0 o02) {
        this.f6372a = o02;
    }

    public final /* synthetic */ void b(final P4.g gVar) {
        this.f6372a.a(new O0.a() { // from class: P3.D
        });
    }

    public U4.a c() {
        U4.a aVarC = P4.f.e(new P4.h() { // from class: P3.C
            @Override // P4.h
            public final void a(P4.g gVar) {
                this.f6370a.b(gVar);
            }
        }, P4.a.BUFFER).C();
        aVarC.K();
        return aVarC;
    }

    public O0 d() {
        return this.f6372a;
    }
}
