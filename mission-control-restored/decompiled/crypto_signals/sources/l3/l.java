package l3;

/* JADX INFO: loaded from: classes.dex */
public final class l extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f8128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f8130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8131d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, K4.c cVar) {
        super(cVar);
        this.f8130c = mVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f8129b = obj;
        this.f8131d |= Integer.MIN_VALUE;
        return this.f8130c.b(this);
    }
}
