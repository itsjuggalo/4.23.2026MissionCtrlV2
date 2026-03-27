package R5;

/* JADX INFO: loaded from: classes2.dex */
public class Q implements B5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.c f7218a;

    public Q(q6.c cVar) {
        this.f7218a = cVar;
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return Boolean.valueOf(S.g(this.f7218a, (q6.c) obj));
    }
}
