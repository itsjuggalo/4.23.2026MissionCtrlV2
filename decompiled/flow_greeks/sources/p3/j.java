package p3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f18250a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f18251b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f18252c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f18253d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f18254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f18255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j f18256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g3.g f18257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f18258i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends j {
        @Override // p3.j
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // p3.j
        public float b(int i10, int i11, int i12, int i13) {
            if (Math.min(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends j {
        @Override // p3.j
        public g a(int i10, int i11, int i12, int i13) {
            return g.MEMORY;
        }

        @Override // p3.j
        public float b(int i10, int i11, int i12, int i13) {
            int iCeil = (int) Math.ceil(Math.max(i11 / i13, i10 / i12));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends j {
        @Override // p3.j
        public g a(int i10, int i11, int i12, int i13) {
            return b(i10, i11, i12, i13) == 1.0f ? g.QUALITY : j.f18252c.a(i10, i11, i12, i13);
        }

        @Override // p3.j
        public float b(int i10, int i11, int i12, int i13) {
            return Math.min(1.0f, j.f18252c.b(i10, i11, i12, i13));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends j {
        @Override // p3.j
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // p3.j
        public float b(int i10, int i11, int i12, int i13) {
            return Math.max(i12 / i10, i13 / i11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends j {
        @Override // p3.j
        public g a(int i10, int i11, int i12, int i13) {
            return j.f18258i ? g.QUALITY : g.MEMORY;
        }

        @Override // p3.j
        public float b(int i10, int i11, int i12, int i13) {
            if (j.f18258i) {
                return Math.min(i12 / i10, i13 / i11);
            }
            if (Math.max(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f extends j {
        @Override // p3.j
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // p3.j
        public float b(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        f18254e = dVar;
        f18255f = new f();
        f18256g = dVar;
        f18257h = g3.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f18258i = true;
    }

    public abstract g a(int i10, int i11, int i12, int i13);

    public abstract float b(int i10, int i11, int i12, int i13);
}
