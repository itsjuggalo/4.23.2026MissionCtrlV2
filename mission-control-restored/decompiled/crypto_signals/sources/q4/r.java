package q4;

/* JADX INFO: loaded from: classes.dex */
public final class r extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0957m f9367c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C0957m c0957m, I4.d dVar) {
        super(dVar);
        this.f9367c = c0957m;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f9365a = obj;
        this.f9366b |= Integer.MIN_VALUE;
        return this.f9367c.c(null, this);
    }
}
