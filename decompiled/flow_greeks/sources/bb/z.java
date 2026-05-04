package bb;

import bb.j;
import com.google.protobuf.c0;
import com.google.protobuf.e1;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import com.google.protobuf.z;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends com.google.protobuf.y implements v0 {
    private static final z DEFAULT_INSTANCE;
    public static final int END_AT_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 2;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORDER_BY_FIELD_NUMBER = 4;
    private static volatile e1 PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 1;
    public static final int START_AT_FIELD_NUMBER = 7;
    public static final int WHERE_FIELD_NUMBER = 3;
    private int bitField0_;
    private bb.j endAt_;
    private com.google.protobuf.z limit_;
    private int offset_;
    private j select_;
    private bb.j startAt_;
    private h where_;
    private c0.e from_ = com.google.protobuf.y.A();
    private c0.e orderBy_ = com.google.protobuf.y.A();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3253a;

        static {
            int[] iArr = new int[y.d.values().length];
            f3253a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3253a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3253a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3253a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3253a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3253a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3253a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y.a implements v0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(z.b bVar) {
            q();
            ((z) this.f7244b).z0((com.google.protobuf.z) bVar.n());
            return this;
        }

        public b B(j.b bVar) {
            q();
            ((z) this.f7244b).A0((bb.j) bVar.n());
            return this;
        }

        public b C(h hVar) {
            q();
            ((z) this.f7244b).B0(hVar);
            return this;
        }

        public b x(c.a aVar) {
            q();
            ((z) this.f7244b).g0((c) aVar.n());
            return this;
        }

        public b y(i iVar) {
            q();
            ((z) this.f7244b).h0(iVar);
            return this;
        }

        public b z(j.b bVar) {
            q();
            ((z) this.f7244b).y0((bb.j) bVar.n());
            return this;
        }

        public b() {
            super(z.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends com.google.protobuf.y implements v0 {
        public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
        public static final int COLLECTION_ID_FIELD_NUMBER = 2;
        private static final c DEFAULT_INSTANCE;
        private static volatile e1 PARSER;
        private boolean allDescendants_;
        private String collectionId_ = "";

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends y.a implements v0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a x(boolean z10) {
                q();
                ((c) this.f7244b).f0(z10);
                return this;
            }

            public a y(String str) {
                q();
                ((c) this.f7244b).g0(str);
                return this;
            }

            public a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            com.google.protobuf.y.V(c.class, cVar);
        }

        public static a e0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        public boolean c0() {
            return this.allDescendants_;
        }

        public String d0() {
            return this.collectionId_;
        }

        public final void f0(boolean z10) {
            this.allDescendants_ = z10;
        }

        public final void g0(String str) {
            str.getClass();
            this.collectionId_ = str;
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3253a[dVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0007", new Object[]{"collectionId_", "allDescendants_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    e1 e1Var = PARSER;
                    if (e1Var != null) {
                        return e1Var;
                    }
                    synchronized (c.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends com.google.protobuf.y implements v0 {
        private static final d DEFAULT_INSTANCE;
        public static final int FILTERS_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile e1 PARSER;
        private c0.e filters_ = com.google.protobuf.y.A();
        private int op_;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends y.a implements v0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a x(Iterable iterable) {
                q();
                ((d) this.f7244b).c0(iterable);
                return this;
            }

            public a y(b bVar) {
                q();
                ((d) this.f7244b).i0(bVar);
                return this;
            }

            public a() {
                super(d.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum b implements c0.a {
            OPERATOR_UNSPECIFIED(0),
            AND(1),
            OR(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final c0.b f3258f = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3260a;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class a implements c0.b {
            }

            b(int i10) {
                this.f3260a = i10;
            }

            public static b b(int i10) {
                if (i10 == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (i10 == 1) {
                    return AND;
                }
                if (i10 != 2) {
                    return null;
                }
                return OR;
            }

            @Override // com.google.protobuf.c0.a
            public final int d() {
                if (this != UNRECOGNIZED) {
                    return this.f3260a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            d dVar = new d();
            DEFAULT_INSTANCE = dVar;
            com.google.protobuf.y.V(d.class, dVar);
        }

        public static d e0() {
            return DEFAULT_INSTANCE;
        }

        public static a h0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        public final void c0(Iterable iterable) {
            d0();
            com.google.protobuf.a.k(iterable, this.filters_);
        }

        public final void d0() {
            c0.e eVar = this.filters_;
            if (eVar.m()) {
                return;
            }
            this.filters_ = com.google.protobuf.y.L(eVar);
        }

        public List f0() {
            return this.filters_;
        }

        public b g0() {
            b bVarB = b.b(this.op_);
            return bVarB == null ? b.UNRECOGNIZED : bVarB;
        }

        public final void i0(b bVar) {
            this.op_ = bVar.d();
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3253a[dVar.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002\u001b", new Object[]{"op_", "filters_", h.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    e1 e1Var = PARSER;
                    if (e1Var != null) {
                        return e1Var;
                    }
                    synchronized (d.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum e implements c0.a {
        DIRECTION_UNSPECIFIED(0),
        ASCENDING(1),
        DESCENDING(2),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c0.b f3265f = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3267a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements c0.b {
        }

        e(int i10) {
            this.f3267a = i10;
        }

        public static e b(int i10) {
            if (i10 == 0) {
                return DIRECTION_UNSPECIFIED;
            }
            if (i10 == 1) {
                return ASCENDING;
            }
            if (i10 != 2) {
                return null;
            }
            return DESCENDING;
        }

        @Override // com.google.protobuf.c0.a
        public final int d() {
            if (this != UNRECOGNIZED) {
                return this.f3267a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends com.google.protobuf.y implements v0 {
        private static final f DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int OP_FIELD_NUMBER = 2;
        private static volatile e1 PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private int bitField0_;
        private g field_;
        private int op_;
        private d0 value_;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends y.a implements v0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a x(g gVar) {
                q();
                ((f) this.f7244b).i0(gVar);
                return this;
            }

            public a y(b bVar) {
                q();
                ((f) this.f7244b).j0(bVar);
                return this;
            }

            public a z(d0 d0Var) {
                q();
                ((f) this.f7244b).k0(d0Var);
                return this;
            }

            public a() {
                super(f.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum b implements c0.a {
            OPERATOR_UNSPECIFIED(0),
            LESS_THAN(1),
            LESS_THAN_OR_EQUAL(2),
            GREATER_THAN(3),
            GREATER_THAN_OR_EQUAL(4),
            EQUAL(5),
            NOT_EQUAL(6),
            ARRAY_CONTAINS(7),
            IN(8),
            ARRAY_CONTAINS_ANY(9),
            NOT_IN(10),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final c0.b f3280n = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3282a;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class a implements c0.b {
            }

            b(int i10) {
                this.f3282a = i10;
            }

            public static b b(int i10) {
                switch (i10) {
                    case 0:
                        return OPERATOR_UNSPECIFIED;
                    case 1:
                        return LESS_THAN;
                    case 2:
                        return LESS_THAN_OR_EQUAL;
                    case 3:
                        return GREATER_THAN;
                    case 4:
                        return GREATER_THAN_OR_EQUAL;
                    case 5:
                        return EQUAL;
                    case 6:
                        return NOT_EQUAL;
                    case 7:
                        return ARRAY_CONTAINS;
                    case 8:
                        return IN;
                    case 9:
                        return ARRAY_CONTAINS_ANY;
                    case 10:
                        return NOT_IN;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.c0.a
            public final int d() {
                if (this != UNRECOGNIZED) {
                    return this.f3282a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            f fVar = new f();
            DEFAULT_INSTANCE = fVar;
            com.google.protobuf.y.V(f.class, fVar);
        }

        public static f d0() {
            return DEFAULT_INSTANCE;
        }

        public static a h0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i0(g gVar) {
            gVar.getClass();
            this.field_ = gVar;
            this.bitField0_ |= 1;
        }

        public g e0() {
            g gVar = this.field_;
            return gVar == null ? g.b0() : gVar;
        }

        public b f0() {
            b bVarB = b.b(this.op_);
            return bVarB == null ? b.UNRECOGNIZED : bVarB;
        }

        public d0 g0() {
            d0 d0Var = this.value_;
            return d0Var == null ? d0.o0() : d0Var;
        }

        public final void j0(b bVar) {
            this.op_ = bVar.d();
        }

        public final void k0(d0 d0Var) {
            d0Var.getClass();
            this.value_ = d0Var;
            this.bitField0_ |= 2;
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3253a[dVar.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003ဉ\u0001", new Object[]{"bitField0_", "field_", "op_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    e1 e1Var = PARSER;
                    if (e1Var != null) {
                        return e1Var;
                    }
                    synchronized (f.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends com.google.protobuf.y implements v0 {
        private static final g DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 2;
        private static volatile e1 PARSER;
        private String fieldPath_ = "";

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends y.a implements v0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a x(String str) {
                q();
                ((g) this.f7244b).e0(str);
                return this;
            }

            public a() {
                super(g.DEFAULT_INSTANCE);
            }
        }

        static {
            g gVar = new g();
            DEFAULT_INSTANCE = gVar;
            com.google.protobuf.y.V(g.class, gVar);
        }

        public static g b0() {
            return DEFAULT_INSTANCE;
        }

        public static a d0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        public String c0() {
            return this.fieldPath_;
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3253a[dVar.ordinal()]) {
                case 1:
                    return new g();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"fieldPath_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    e1 e1Var = PARSER;
                    if (e1Var != null) {
                        return e1Var;
                    }
                    synchronized (g.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h extends com.google.protobuf.y implements v0 {
        public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
        private static final h DEFAULT_INSTANCE;
        public static final int FIELD_FILTER_FIELD_NUMBER = 2;
        private static volatile e1 PARSER = null;
        public static final int UNARY_FILTER_FIELD_NUMBER = 3;
        private int filterTypeCase_ = 0;
        private Object filterType_;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends y.a implements v0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a x(d.a aVar) {
                q();
                ((h) this.f7244b).j0((d) aVar.n());
                return this;
            }

            public a y(f.a aVar) {
                q();
                ((h) this.f7244b).k0((f) aVar.n());
                return this;
            }

            public a z(k.a aVar) {
                q();
                ((h) this.f7244b).l0((k) aVar.n());
                return this;
            }

            public a() {
                super(h.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum b {
            COMPOSITE_FILTER(1),
            FIELD_FILTER(2),
            UNARY_FILTER(3),
            FILTERTYPE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3288a;

            b(int i10) {
                this.f3288a = i10;
            }

            public static b b(int i10) {
                if (i10 == 0) {
                    return FILTERTYPE_NOT_SET;
                }
                if (i10 == 1) {
                    return COMPOSITE_FILTER;
                }
                if (i10 == 2) {
                    return FIELD_FILTER;
                }
                if (i10 != 3) {
                    return null;
                }
                return UNARY_FILTER;
            }
        }

        static {
            h hVar = new h();
            DEFAULT_INSTANCE = hVar;
            com.google.protobuf.y.V(h.class, hVar);
        }

        public static h e0() {
            return DEFAULT_INSTANCE;
        }

        public static a i0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        public d d0() {
            return this.filterTypeCase_ == 1 ? (d) this.filterType_ : d.e0();
        }

        public f f0() {
            return this.filterTypeCase_ == 2 ? (f) this.filterType_ : f.d0();
        }

        public b g0() {
            return b.b(this.filterTypeCase_);
        }

        public k h0() {
            return this.filterTypeCase_ == 3 ? (k) this.filterType_ : k.c0();
        }

        public final void j0(d dVar) {
            dVar.getClass();
            this.filterType_ = dVar;
            this.filterTypeCase_ = 1;
        }

        public final void k0(f fVar) {
            fVar.getClass();
            this.filterType_ = fVar;
            this.filterTypeCase_ = 2;
        }

        public final void l0(k kVar) {
            kVar.getClass();
            this.filterType_ = kVar;
            this.filterTypeCase_ = 3;
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3253a[dVar.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"filterType_", "filterTypeCase_", d.class, f.class, k.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    e1 e1Var = PARSER;
                    if (e1Var != null) {
                        return e1Var;
                    }
                    synchronized (h.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i extends com.google.protobuf.y implements v0 {
        private static final i DEFAULT_INSTANCE;
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile e1 PARSER;
        private int bitField0_;
        private int direction_;
        private g field_;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends y.a implements v0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a x(e eVar) {
                q();
                ((i) this.f7244b).f0(eVar);
                return this;
            }

            public a y(g gVar) {
                q();
                ((i) this.f7244b).g0(gVar);
                return this;
            }

            public a() {
                super(i.DEFAULT_INSTANCE);
            }
        }

        static {
            i iVar = new i();
            DEFAULT_INSTANCE = iVar;
            com.google.protobuf.y.V(i.class, iVar);
        }

        public static a e0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g0(g gVar) {
            gVar.getClass();
            this.field_ = gVar;
            this.bitField0_ |= 1;
        }

        public e c0() {
            e eVarB = e.b(this.direction_);
            return eVarB == null ? e.UNRECOGNIZED : eVarB;
        }

        public g d0() {
            g gVar = this.field_;
            return gVar == null ? g.b0() : gVar;
        }

        public final void f0(e eVar) {
            this.direction_ = eVar.d();
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3253a[dVar.ordinal()]) {
                case 1:
                    return new i();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "field_", "direction_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    e1 e1Var = PARSER;
                    if (e1Var != null) {
                        return e1Var;
                    }
                    synchronized (i.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class j extends com.google.protobuf.y implements v0 {
        private static final j DEFAULT_INSTANCE;
        public static final int FIELDS_FIELD_NUMBER = 2;
        private static volatile e1 PARSER;
        private c0.e fields_ = com.google.protobuf.y.A();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends y.a implements v0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a() {
                super(j.DEFAULT_INSTANCE);
            }
        }

        static {
            j jVar = new j();
            DEFAULT_INSTANCE = jVar;
            com.google.protobuf.y.V(j.class, jVar);
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3253a[dVar.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", new Object[]{"fields_", g.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    e1 e1Var = PARSER;
                    if (e1Var != null) {
                        return e1Var;
                    }
                    synchronized (j.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class k extends com.google.protobuf.y implements v0 {
        private static final k DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile e1 PARSER;
        private int op_;
        private int operandTypeCase_ = 0;
        private Object operandType_;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends y.a implements v0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a x(g gVar) {
                q();
                ((k) this.f7244b).g0(gVar);
                return this;
            }

            public a y(b bVar) {
                q();
                ((k) this.f7244b).h0(bVar);
                return this;
            }

            public a() {
                super(k.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum b implements c0.a {
            OPERATOR_UNSPECIFIED(0),
            IS_NAN(2),
            IS_NULL(3),
            IS_NOT_NAN(4),
            IS_NOT_NULL(5),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final c0.b f3295h = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3297a;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class a implements c0.b {
            }

            b(int i10) {
                this.f3297a = i10;
            }

            public static b b(int i10) {
                if (i10 == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (i10 == 2) {
                    return IS_NAN;
                }
                if (i10 == 3) {
                    return IS_NULL;
                }
                if (i10 == 4) {
                    return IS_NOT_NAN;
                }
                if (i10 != 5) {
                    return null;
                }
                return IS_NOT_NULL;
            }

            @Override // com.google.protobuf.c0.a
            public final int d() {
                if (this != UNRECOGNIZED) {
                    return this.f3297a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            k kVar = new k();
            DEFAULT_INSTANCE = kVar;
            com.google.protobuf.y.V(k.class, kVar);
        }

        public static k c0() {
            return DEFAULT_INSTANCE;
        }

        public static a f0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g0(g gVar) {
            gVar.getClass();
            this.operandType_ = gVar;
            this.operandTypeCase_ = 2;
        }

        public g d0() {
            return this.operandTypeCase_ == 2 ? (g) this.operandType_ : g.b0();
        }

        public b e0() {
            b bVarB = b.b(this.op_);
            return bVarB == null ? b.UNRECOGNIZED : bVarB;
        }

        public final void h0(b bVar) {
            this.op_ = bVar.d();
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3253a[dVar.ordinal()]) {
                case 1:
                    return new k();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002<\u0000", new Object[]{"operandType_", "operandTypeCase_", "op_", g.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    e1 e1Var = PARSER;
                    if (e1Var != null) {
                        return e1Var;
                    }
                    synchronized (k.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    static {
        z zVar = new z();
        DEFAULT_INSTANCE = zVar;
        com.google.protobuf.y.V(z.class, zVar);
    }

    public static z k0() {
        return DEFAULT_INSTANCE;
    }

    public static b x0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public final void A0(bb.j jVar) {
        jVar.getClass();
        this.startAt_ = jVar;
        this.bitField0_ |= 4;
    }

    public final void B0(h hVar) {
        hVar.getClass();
        this.where_ = hVar;
        this.bitField0_ |= 2;
    }

    public final void g0(c cVar) {
        cVar.getClass();
        i0();
        this.from_.add(cVar);
    }

    public final void h0(i iVar) {
        iVar.getClass();
        j0();
        this.orderBy_.add(iVar);
    }

    public final void i0() {
        c0.e eVar = this.from_;
        if (eVar.m()) {
            return;
        }
        this.from_ = com.google.protobuf.y.L(eVar);
    }

    public final void j0() {
        c0.e eVar = this.orderBy_;
        if (eVar.m()) {
            return;
        }
        this.orderBy_ = com.google.protobuf.y.L(eVar);
    }

    public bb.j l0() {
        bb.j jVar = this.endAt_;
        return jVar == null ? bb.j.f0() : jVar;
    }

    public c m0(int i10) {
        return (c) this.from_.get(i10);
    }

    public int n0() {
        return this.from_.size();
    }

    public com.google.protobuf.z o0() {
        com.google.protobuf.z zVar = this.limit_;
        return zVar == null ? com.google.protobuf.z.b0() : zVar;
    }

    public i p0(int i10) {
        return (i) this.orderBy_.get(i10);
    }

    public int q0() {
        return this.orderBy_.size();
    }

    public bb.j r0() {
        bb.j jVar = this.startAt_;
        return jVar == null ? bb.j.f0() : jVar;
    }

    public h s0() {
        h hVar = this.where_;
        return hVar == null ? h.e0() : hVar;
    }

    public boolean t0() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean u0() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean v0() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean w0() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f3253a[dVar.ordinal()]) {
            case 1:
                return new z();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b\u0005ဉ\u0004\u0006\u0004\u0007ဉ\u0002\bဉ\u0003", new Object[]{"bitField0_", "select_", "from_", c.class, "where_", "orderBy_", i.class, "limit_", "offset_", "startAt_", "endAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (z.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new y.b(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final void y0(bb.j jVar) {
        jVar.getClass();
        this.endAt_ = jVar;
        this.bitField0_ |= 8;
    }

    public final void z0(com.google.protobuf.z zVar) {
        zVar.getClass();
        this.limit_ = zVar;
        this.bitField0_ |= 16;
    }
}
