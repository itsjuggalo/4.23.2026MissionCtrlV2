package t3;

/* JADX INFO: renamed from: t3.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1840t0 extends AbstractC1826m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i3.k f15034a;

    public C1840t0(i3.k kVar) {
        this.f15034a = kVar;
    }

    @Override // t3.AbstractC1828n
    public void a(Throwable th) {
        this.f15034a.invoke(th);
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return W2.E.f5463a;
    }

    public String toString() {
        return "InvokeOnCancel[" + P.a(this.f15034a) + '@' + P.b(this) + ']';
    }
}
