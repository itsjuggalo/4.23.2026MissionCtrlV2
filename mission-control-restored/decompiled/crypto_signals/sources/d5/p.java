package d5;

/* JADX INFO: loaded from: classes.dex */
public final class p extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f6000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f6001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f6003d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, I4.d dVar) {
        super(dVar);
        this.f6003d = qVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f6002c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.f6003d.c(null, this);
    }
}
