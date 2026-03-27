package c5;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends P4.j implements Y4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13508a;

    public m(Object obj) {
        this.f13508a = obj;
    }

    @Override // Y4.h, java.util.concurrent.Callable
    public Object call() {
        return this.f13508a;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        lVar.b(S4.c.a());
        lVar.onSuccess(this.f13508a);
    }
}
