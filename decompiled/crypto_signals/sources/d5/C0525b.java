package d5;

/* JADX INFO: renamed from: d5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0525b extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c5.s f5958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f5959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f5960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5961d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0525b(c cVar, K4.c cVar2) {
        super(cVar2);
        this.f5960c = cVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f5959b = obj;
        this.f5961d |= Integer.MIN_VALUE;
        return this.f5960c.b(null, this);
    }
}
