package d5;

/* JADX INFO: loaded from: classes.dex */
public final class i extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f5975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f5977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5978d;
    public f e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, I4.d dVar) {
        super(dVar);
        this.f5977c = jVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f5975a = obj;
        this.f5976b |= Integer.MIN_VALUE;
        return this.f5977c.e(null, this);
    }
}
