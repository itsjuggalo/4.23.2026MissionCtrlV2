package q4;

/* JADX INFO: loaded from: classes.dex */
public final class x extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0957m f9391c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(C0957m c0957m, I4.d dVar) {
        super(dVar);
        this.f9391c = c0957m;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f9389a = obj;
        this.f9390b |= Integer.MIN_VALUE;
        return this.f9391c.c(null, this);
    }
}
