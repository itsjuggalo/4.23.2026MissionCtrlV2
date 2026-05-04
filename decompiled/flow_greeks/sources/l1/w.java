package l1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final pd.o f15259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ng.x f15260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i0 f15261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final gd.i f15262d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pd.o transform, ng.x ack, i0 i0Var, gd.i callerContext) {
            super(null);
            kotlin.jvm.internal.t.f(transform, "transform");
            kotlin.jvm.internal.t.f(ack, "ack");
            kotlin.jvm.internal.t.f(callerContext, "callerContext");
            this.f15259a = transform;
            this.f15260b = ack;
            this.f15261c = i0Var;
            this.f15262d = callerContext;
        }

        public final ng.x a() {
            return this.f15260b;
        }

        public final gd.i b() {
            return this.f15262d;
        }

        public i0 c() {
            return this.f15261c;
        }

        public final pd.o d() {
            return this.f15259a;
        }
    }

    public /* synthetic */ w(kotlin.jvm.internal.k kVar) {
        this();
    }

    public w() {
    }
}
