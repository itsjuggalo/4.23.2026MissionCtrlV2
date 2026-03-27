package K3;

/* JADX INFO: loaded from: classes.dex */
public final class s implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f4766a;

    public s(q qVar) {
        this.f4766a = qVar;
    }

    public static s a(q qVar) {
        return new s(qVar);
    }

    public static R3.i c(q qVar) {
        return (R3.i) G3.d.d(qVar.b());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public R3.i get() {
        return c(this.f4766a);
    }
}
