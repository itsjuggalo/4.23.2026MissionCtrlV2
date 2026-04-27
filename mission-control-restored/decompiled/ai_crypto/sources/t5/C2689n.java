package t5;

/* JADX INFO: renamed from: t5.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2689n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f24058f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R0 f24059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2674f0 f24060b = AbstractC2676g0.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2674f0 f24061c = AbstractC2676g0.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2674f0 f24062d = AbstractC2676g0.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f24063e;

    /* JADX INFO: renamed from: t5.n$a */
    public class a implements b {
        @Override // t5.C2689n.b
        public C2689n a() {
            return new C2689n(R0.f23505a);
        }
    }

    /* JADX INFO: renamed from: t5.n$b */
    public interface b {
        C2689n a();
    }

    public C2689n(R0 r02) {
        this.f24059a = r02;
    }

    public void a(boolean z7) {
        if (z7) {
            this.f24061c.a(1L);
        } else {
            this.f24062d.a(1L);
        }
    }

    public void b() {
        this.f24060b.a(1L);
        this.f24063e = this.f24059a.a();
    }
}
