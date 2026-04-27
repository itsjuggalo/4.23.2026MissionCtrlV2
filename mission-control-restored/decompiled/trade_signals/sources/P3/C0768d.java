package P3;

import N3.C0712d;
import N3.C0732n;
import N3.S0;
import N3.n1;
import N3.o1;
import android.app.Application;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: P3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0768d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G2.f f6397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T3.h f6398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Q3.a f6399c;

    public C0768d(G2.f fVar, T3.h hVar, Q3.a aVar) {
        this.f6397a = fVar;
        this.f6398b = hVar;
        this.f6399c = aVar;
    }

    public C0712d a(InterfaceC2426a interfaceC2426a, Application application, S0 s02) {
        return new C0712d(interfaceC2426a, this.f6397a, application, this.f6399c, s02);
    }

    public C0732n b(n1 n1Var, A3.d dVar) {
        return new C0732n(this.f6397a, n1Var, dVar);
    }

    public G2.f c() {
        return this.f6397a;
    }

    public T3.h d() {
        return this.f6398b;
    }

    public n1 e() {
        return new n1(this.f6397a);
    }

    public o1 f(n1 n1Var) {
        return new o1(n1Var);
    }
}
