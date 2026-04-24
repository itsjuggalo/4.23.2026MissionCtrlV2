package l3;

/* JADX INFO: loaded from: classes.dex */
public final class q extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f8140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8141c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(s sVar, K4.c cVar) {
        super(cVar);
        this.f8140b = sVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f8139a = obj;
        this.f8141c |= Integer.MIN_VALUE;
        return this.f8140b.c(null, this);
    }
}
