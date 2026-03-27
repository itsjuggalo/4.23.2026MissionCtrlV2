package k2;

import java.util.Set;

/* JADX INFO: renamed from: k2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0770p implements J2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f7867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J2.c f7868b;

    public C0770p(Set set, J2.c cVar) {
        this.f7867a = set;
        this.f7868b = cVar;
    }

    @Override // J2.c
    public final void a(J2.a aVar) {
        if (this.f7867a.contains(Z1.b.class)) {
            this.f7868b.a(aVar);
            return;
        }
        throw new G4.e("Attempting to publish an undeclared event " + aVar + ".");
    }
}
