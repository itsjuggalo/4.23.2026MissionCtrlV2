package q4;

/* JADX INFO: loaded from: classes.dex */
public final class v extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0957m f9384c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(C0957m c0957m, I4.d dVar) {
        super(dVar);
        this.f9384c = c0957m;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f9382a = obj;
        this.f9383b |= Integer.MIN_VALUE;
        return this.f9384c.c(null, this);
    }
}
