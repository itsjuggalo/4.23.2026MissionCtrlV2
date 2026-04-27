package b6;

/* JADX INFO: renamed from: b6.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1095t0 extends AbstractC1081m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q5.k f9092a;

    public C1095t0(Q5.k kVar) {
        this.f9092a = kVar;
    }

    @Override // b6.AbstractC1083n
    public void a(Throwable th) {
        this.f9092a.invoke(th);
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return E5.E.f1657a;
    }

    public String toString() {
        return "InvokeOnCancel[" + P.a(this.f9092a) + '@' + P.b(this) + ']';
    }
}
