package d5;

import P4.o;
import P4.q;
import d5.l;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends o implements Y4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16961a;

    public j(Object obj) {
        this.f16961a = obj;
    }

    @Override // Y4.h, java.util.concurrent.Callable
    public Object call() {
        return this.f16961a;
    }

    @Override // P4.o
    public void s(q qVar) {
        l.a aVar = new l.a(qVar, this.f16961a);
        qVar.b(aVar);
        aVar.run();
    }
}
