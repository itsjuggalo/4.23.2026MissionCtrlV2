package M2;

/* JADX INFO: renamed from: M2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0434n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f2507f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R0 f2508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0419f0 f2509b = AbstractC0421g0.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0419f0 f2510c = AbstractC0421g0.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0419f0 f2511d = AbstractC0421g0.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f2512e;

    /* JADX INFO: renamed from: M2.n$a */
    public class a implements b {
        @Override // M2.C0434n.b
        public C0434n a() {
            return new C0434n(R0.f1954a);
        }
    }

    /* JADX INFO: renamed from: M2.n$b */
    public interface b {
        C0434n a();
    }

    public C0434n(R0 r02) {
        this.f2508a = r02;
    }

    public void a(boolean z4) {
        if (z4) {
            this.f2510c.add(1L);
        } else {
            this.f2511d.add(1L);
        }
    }

    public void b() {
        this.f2509b.add(1L);
        this.f2512e = this.f2508a.a();
    }
}
