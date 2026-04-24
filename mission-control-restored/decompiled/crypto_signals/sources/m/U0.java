package m;

import N1.C0094g0;
import N1.C0149z;
import a1.InterfaceC0286b;
import android.content.Context;
import f1.InterfaceC0587c;
import f1.InterfaceC0588d;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicMarkableReference;
import r2.C0969d;
import s1.C0994k;
import s2.C1005h;

/* JADX INFO: loaded from: classes.dex */
public final class U0 implements W3.b, InterfaceC0286b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f8309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f8311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f8312d = new C0094g0(this, false);
    public Object e = new C0094g0(this, true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f8313f = new A.k(6, (byte) 0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f8314k = new AtomicMarkableReference(null, false);

    public U0(String str, w2.c cVar, C0969d c0969d) {
        this.f8311c = str;
        this.f8309a = new C1005h(cVar);
        this.f8310b = c0969d;
    }

    public void a(Z3.s sVar) {
        ((HashSet) this.f8312d).add(sVar);
    }

    public void b(Z3.s sVar) {
        ((HashSet) this.f8312d).remove(sVar);
    }

    @Override // F4.a
    public Object get() {
        return new e1.j((Context) ((a1.c) this.f8309a).f4051a, (Z0.f) ((F4.a) this.f8310b).get(), (InterfaceC0588d) ((F4.a) this.f8311c).get(), (e1.d) ((C0994k) this.f8312d).get(), (Executor) ((F4.a) this.e).get(), (g1.c) ((F4.a) this.f8313f).get(), new N1.A(23), new C0149z(23), (InterfaceC0587c) ((F4.a) this.f8314k).get());
    }
}
