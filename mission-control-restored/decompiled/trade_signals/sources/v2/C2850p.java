package v2;

/* JADX INFO: renamed from: v2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2850p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2837c f23769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f23771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23772d;

    /* JADX INFO: renamed from: v2.p$a */
    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC2837c f23773a;

        public a(AbstractC2837c abstractC2837c) {
            this.f23773a = abstractC2837c;
        }
    }

    /* JADX INFO: renamed from: v2.p$b */
    public interface b {
    }

    public C2850p(b bVar) {
        this(bVar, false, AbstractC2837c.c(), Integer.MAX_VALUE);
    }

    public static C2850p a(char c8) {
        return b(AbstractC2837c.b(c8));
    }

    public static C2850p b(AbstractC2837c abstractC2837c) {
        AbstractC2848n.n(abstractC2837c);
        return new C2850p(new a(abstractC2837c));
    }

    public C2850p c() {
        return d(AbstractC2837c.e());
    }

    public C2850p d(AbstractC2837c abstractC2837c) {
        AbstractC2848n.n(abstractC2837c);
        return new C2850p(this.f23771c, this.f23770b, abstractC2837c, this.f23772d);
    }

    public C2850p(b bVar, boolean z7, AbstractC2837c abstractC2837c, int i8) {
        this.f23771c = bVar;
        this.f23770b = z7;
        this.f23769a = abstractC2837c;
        this.f23772d = i8;
    }
}
