package d1;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f16789a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f16790b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f16791c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f16792d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f16793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f16794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f16795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final U0.g f16796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f16797i;

    public static class a extends l {
        @Override // d1.l
        public g a(int i8, int i9, int i10, int i11) {
            return g.QUALITY;
        }

        @Override // d1.l
        public float b(int i8, int i9, int i10, int i11) {
            if (Math.min(i9 / i11, i8 / i10) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    public static class b extends l {
        @Override // d1.l
        public g a(int i8, int i9, int i10, int i11) {
            return g.MEMORY;
        }

        @Override // d1.l
        public float b(int i8, int i9, int i10, int i11) {
            int iCeil = (int) Math.ceil(Math.max(i9 / i11, i8 / i10));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    public static class c extends l {
        @Override // d1.l
        public g a(int i8, int i9, int i10, int i11) {
            return b(i8, i9, i10, i11) == 1.0f ? g.QUALITY : l.f16791c.a(i8, i9, i10, i11);
        }

        @Override // d1.l
        public float b(int i8, int i9, int i10, int i11) {
            return Math.min(1.0f, l.f16791c.b(i8, i9, i10, i11));
        }
    }

    public static class d extends l {
        @Override // d1.l
        public g a(int i8, int i9, int i10, int i11) {
            return g.QUALITY;
        }

        @Override // d1.l
        public float b(int i8, int i9, int i10, int i11) {
            return Math.max(i10 / i8, i11 / i9);
        }
    }

    public static class e extends l {
        @Override // d1.l
        public g a(int i8, int i9, int i10, int i11) {
            return l.f16797i ? g.QUALITY : g.MEMORY;
        }

        @Override // d1.l
        public float b(int i8, int i9, int i10, int i11) {
            if (l.f16797i) {
                return Math.min(i10 / i8, i11 / i9);
            }
            if (Math.max(i9 / i11, i8 / i10) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    public static class f extends l {
        @Override // d1.l
        public g a(int i8, int i9, int i10, int i11) {
            return g.QUALITY;
        }

        @Override // d1.l
        public float b(int i8, int i9, int i10, int i11) {
            return 1.0f;
        }
    }

    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        f16793e = dVar;
        f16794f = new f();
        f16795g = dVar;
        f16796h = U0.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f16797i = true;
    }

    public abstract g a(int i8, int i9, int i10, int i11);

    public abstract float b(int i8, int i9, int i10, int i11);
}
