package K3;

/* JADX INFO: loaded from: classes.dex */
public final class r implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f4765a;

    public r(q qVar) {
        this.f4765a = qVar;
    }

    public static r a(q qVar) {
        return new r(qVar);
    }

    public static H3.k c(q qVar) {
        return (H3.k) G3.d.d(qVar.a());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public H3.k get() {
        return c(this.f4765a);
    }
}
