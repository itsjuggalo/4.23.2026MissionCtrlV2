package O;

/* JADX INFO: renamed from: O.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0196t extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0197u f2287c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0196t(C0197u c0197u, I4.d dVar) {
        super(dVar);
        this.f2287c = c0197u;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f2285a = obj;
        this.f2286b |= Integer.MIN_VALUE;
        return this.f2287c.c(null, this);
    }
}
