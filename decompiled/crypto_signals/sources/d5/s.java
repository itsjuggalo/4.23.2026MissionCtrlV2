package d5;

/* JADX INFO: loaded from: classes.dex */
public final class s extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f6012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o f6015d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(o oVar, I4.d dVar) {
        super(dVar);
        this.f6015d = oVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f6013b = obj;
        this.f6014c |= Integer.MIN_VALUE;
        return this.f6015d.c(null, this);
    }
}
