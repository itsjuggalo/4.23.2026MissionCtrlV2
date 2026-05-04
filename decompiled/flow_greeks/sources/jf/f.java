package jf;

/* JADX INFO: loaded from: classes3.dex */
public class f implements pd.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fe.a f14321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.a f14322b;

    public f(fe.a aVar, fe.a aVar2) {
        this.f14321a = aVar;
        this.f14322b = aVar2;
    }

    @Override // pd.o
    public Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(g.i(this.f14321a, this.f14322b, (fe.m) obj, (fe.m) obj2));
    }
}
