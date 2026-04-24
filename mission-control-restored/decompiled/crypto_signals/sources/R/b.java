package R;

/* JADX INFO: loaded from: classes.dex */
public final class b extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f2744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f2746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2747d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, K4.c cVar2) {
        super(cVar2);
        this.f2746c = cVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f2745b = obj;
        this.f2747d |= Integer.MIN_VALUE;
        return this.f2746c.a(null, this);
    }
}
