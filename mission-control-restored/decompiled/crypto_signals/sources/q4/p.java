package q4;

/* JADX INFO: loaded from: classes.dex */
public final class p extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d5.q f9360c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(d5.q qVar, I4.d dVar) {
        super(dVar);
        this.f9360c = qVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f9358a = obj;
        this.f9359b |= Integer.MIN_VALUE;
        return this.f9360c.c(null, this);
    }
}
