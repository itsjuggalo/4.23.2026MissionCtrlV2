package Z3;

import c4.InterfaceC1143b;

/* JADX INFO: loaded from: classes.dex */
public final class C implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f5846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f5847b;

    public C(D5.a aVar, D5.a aVar2) {
        this.f5846a = aVar;
        this.f5847b = aVar2;
    }

    public static C a(D5.a aVar, D5.a aVar2) {
        return new C(aVar, aVar2);
    }

    public static com.google.firebase.sessions.j c(J j7, L l7) {
        return new com.google.firebase.sessions.j(j7, l7);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.google.firebase.sessions.j get() {
        return c((J) this.f5846a.get(), (L) this.f5847b.get());
    }
}
