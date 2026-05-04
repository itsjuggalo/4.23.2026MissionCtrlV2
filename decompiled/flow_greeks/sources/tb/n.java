package tb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f21539f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f21540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f21541b = f1.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e1 f21542c = f1.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e1 f21543d = f1.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f21544e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements b {
        @Override // tb.n.b
        public n a() {
            return new n(q2.f21623a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        n a();
    }

    public n(q2 q2Var) {
        this.f21540a = q2Var;
    }

    public void a(boolean z10) {
        if (z10) {
            this.f21542c.add(1L);
        } else {
            this.f21543d.add(1L);
        }
    }

    public void b() {
        this.f21541b.add(1L);
        this.f21544e = this.f21540a.a();
    }
}
