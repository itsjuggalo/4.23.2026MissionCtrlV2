package G4;

/* JADX INFO: renamed from: G4.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0542n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f3085f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R0 f3086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0527f0 f3087b = AbstractC0529g0.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0527f0 f3088c = AbstractC0529g0.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0527f0 f3089d = AbstractC0529g0.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f3090e;

    /* JADX INFO: renamed from: G4.n$a */
    public class a implements b {
        @Override // G4.C0542n.b
        public C0542n a() {
            return new C0542n(R0.f2542a);
        }
    }

    /* JADX INFO: renamed from: G4.n$b */
    public interface b {
        C0542n a();
    }

    public C0542n(R0 r02) {
        this.f3086a = r02;
    }

    public void a(boolean z7) {
        (z7 ? this.f3088c : this.f3089d).a(1L);
    }

    public void b() {
        this.f3087b.a(1L);
        this.f3090e = this.f3086a.a();
    }
}
