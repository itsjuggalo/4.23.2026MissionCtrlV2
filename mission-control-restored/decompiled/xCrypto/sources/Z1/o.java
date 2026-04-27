package Z1;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z1.b f5984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f5986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5987d;

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Z1.b f5988a;

        public a(Z1.b bVar) {
            this.f5988a = bVar;
        }
    }

    public interface b {
    }

    public o(b bVar) {
        this(bVar, false, Z1.b.c(), Integer.MAX_VALUE);
    }

    public static o a(char c4) {
        return b(Z1.b.b(c4));
    }

    public static o b(Z1.b bVar) {
        m.n(bVar);
        return new o(new a(bVar));
    }

    public o c() {
        return d(Z1.b.e());
    }

    public o d(Z1.b bVar) {
        m.n(bVar);
        return new o(this.f5986c, this.f5985b, bVar, this.f5987d);
    }

    public o(b bVar, boolean z4, Z1.b bVar2, int i4) {
        this.f5986c = bVar;
        this.f5985b = z4;
        this.f5984a = bVar2;
        this.f5987d = i4;
    }
}
