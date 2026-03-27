package H2;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H2.b f2609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f2611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2612d;

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ H2.b f2613a;

        public a(H2.b bVar) {
            this.f2613a = bVar;
        }
    }

    public interface b {
    }

    public o(b bVar) {
        this(bVar, false, H2.b.c(), a.e.API_PRIORITY_OTHER);
    }

    public static o a(char c7) {
        return b(H2.b.b(c7));
    }

    public static o b(H2.b bVar) {
        m.n(bVar);
        return new o(new a(bVar));
    }

    public o c() {
        return d(H2.b.e());
    }

    public o d(H2.b bVar) {
        m.n(bVar);
        return new o(this.f2611c, this.f2610b, bVar, this.f2612d);
    }

    public o(b bVar, boolean z7, H2.b bVar2, int i7) {
        this.f2611c = bVar;
        this.f2610b = z7;
        this.f2609a = bVar2;
        this.f2612d = i7;
    }
}
