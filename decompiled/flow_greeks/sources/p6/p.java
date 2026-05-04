package p6;

import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f18329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f18331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18332d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f18333a;

        public a(c cVar) {
            this.f18333a = cVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
    }

    public p(b bVar) {
        this(bVar, false, c.c(), a.e.API_PRIORITY_OTHER);
    }

    public static p a(char c10) {
        return b(c.b(c10));
    }

    public static p b(c cVar) {
        n.n(cVar);
        return new p(new a(cVar));
    }

    public p c() {
        return d(c.e());
    }

    public p d(c cVar) {
        n.n(cVar);
        return new p(this.f18331c, this.f18330b, cVar, this.f18332d);
    }

    public p(b bVar, boolean z10, c cVar, int i10) {
        this.f18331c = bVar;
        this.f18330b = z10;
        this.f18329a = cVar;
        this.f18332d = i10;
    }
}
