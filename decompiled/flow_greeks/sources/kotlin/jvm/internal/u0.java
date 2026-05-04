package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u0 implements wd.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14954a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.jvm.internal.u0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final /* synthetic */ class C0259a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14955a;

            static {
                int[] iArr = new int[wd.t.values().length];
                try {
                    iArr[wd.t.f23912a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[wd.t.f23913b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[wd.t.f23914c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f14955a = iArr;
            }
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        public final String a(wd.r typeParameter) {
            t.f(typeParameter, "typeParameter");
            StringBuilder sb2 = new StringBuilder();
            int i10 = C0259a.f14955a[typeParameter.o().ordinal()];
            if (i10 == 1) {
                cd.h0 h0Var = cd.h0.f3852a;
            } else if (i10 == 2) {
                sb2.append("in ");
            } else {
                if (i10 != 3) {
                    throw new cd.o();
                }
                sb2.append("out ");
            }
            sb2.append(typeParameter.getName());
            return sb2.toString();
        }

        public a() {
        }
    }
}
