package d5;

/* JADX INFO: loaded from: classes.dex */
public final class n extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f5993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f5994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f5995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5996d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, I4.d dVar) {
        super(dVar);
        this.f5995c = oVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f5994b = obj;
        this.f5996d |= Integer.MIN_VALUE;
        return this.f5995c.c(null, this);
    }
}
