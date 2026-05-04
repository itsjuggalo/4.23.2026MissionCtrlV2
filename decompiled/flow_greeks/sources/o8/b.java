package o8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j8.l f17604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j8.i f17605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e8.c f17606c;

    public b(j8.i iVar, e8.c cVar, j8.l lVar) {
        this.f17605b = iVar;
        this.f17604a = lVar;
        this.f17606c = cVar;
    }

    @Override // o8.e
    public void a() {
        this.f17605b.c(this.f17606c);
    }

    public j8.l b() {
        return this.f17604a;
    }

    @Override // o8.e
    public String toString() {
        return b() + ":CANCEL";
    }
}
