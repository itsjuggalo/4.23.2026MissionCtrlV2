package q4;

/* JADX INFO: renamed from: q4.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0956l extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0957m f9347c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0956l(C0957m c0957m, I4.d dVar) {
        super(dVar);
        this.f9347c = c0957m;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f9345a = obj;
        this.f9346b |= Integer.MIN_VALUE;
        return this.f9347c.c(null, this);
    }
}
