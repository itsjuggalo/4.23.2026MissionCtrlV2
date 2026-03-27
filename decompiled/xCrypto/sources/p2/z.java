package p2;

import com.google.protobuf.AbstractC1050a;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.C1078z;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import java.util.List;
import p2.C1713j;

/* JADX INFO: loaded from: classes.dex */
public final class z extends AbstractC1077y implements X {
    private static final z DEFAULT_INSTANCE;
    public static final int END_AT_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 2;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORDER_BY_FIELD_NUMBER = 4;
    private static volatile g0 PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 1;
    public static final int START_AT_FIELD_NUMBER = 7;
    public static final int WHERE_FIELD_NUMBER = 3;
    private int bitField0_;
    private C1713j endAt_;
    private C1078z limit_;
    private int offset_;
    private j select_;
    private C1713j startAt_;
    private h where_;
    private C.i from_ = AbstractC1077y.emptyProtobufList();
    private C.i orderBy_ = AbstractC1077y.emptyProtobufList();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14099a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14099a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14099a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14099a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14099a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14099a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14099a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14099a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(c.a aVar) {
            copyOnWrite();
            ((z) this.instance).q((c) aVar.build());
            return this;
        }

        public b g(i iVar) {
            copyOnWrite();
            ((z) this.instance).r(iVar);
            return this;
        }

        public b h(C1713j.b bVar) {
            copyOnWrite();
            ((z) this.instance).I((C1713j) bVar.build());
            return this;
        }

        public b i(C1078z.b bVar) {
            copyOnWrite();
            ((z) this.instance).J((C1078z) bVar.build());
            return this;
        }

        public b j(C1713j.b bVar) {
            copyOnWrite();
            ((z) this.instance).K((C1713j) bVar.build());
            return this;
        }

        public b k(h hVar) {
            copyOnWrite();
            ((z) this.instance).L(hVar);
            return this;
        }

        public b() {
            super(z.DEFAULT_INSTANCE);
        }
    }

    public static final class c extends AbstractC1077y implements X {
        public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
        public static final int COLLECTION_ID_FIELD_NUMBER = 2;
        private static final c DEFAULT_INSTANCE;
        private static volatile g0 PARSER;
        private boolean allDescendants_;
        private String collectionId_ = "";

        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(boolean z4) {
                copyOnWrite();
                ((c) this.instance).p(z4);
                return this;
            }

            public a g(String str) {
                copyOnWrite();
                ((c) this.instance).q(str);
                return this;
            }

            public a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            AbstractC1077y.registerDefaultInstance(c.class, cVar);
        }

        public static a o() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14099a[eVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0007", new Object[]{"collectionId_", "allDescendants_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g0 g0Var = PARSER;
                    if (g0Var != null) {
                        return g0Var;
                    }
                    synchronized (c.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

        public boolean m() {
            return this.allDescendants_;
        }

        public String n() {
            return this.collectionId_;
        }

        public final void p(boolean z4) {
            this.allDescendants_ = z4;
        }

        public final void q(String str) {
            str.getClass();
            this.collectionId_ = str;
        }
    }

    public static final class d extends AbstractC1077y implements X {
        private static final d DEFAULT_INSTANCE;
        public static final int FILTERS_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile g0 PARSER;
        private C.i filters_ = AbstractC1077y.emptyProtobufList();
        private int op_;

        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(Iterable iterable) {
                copyOnWrite();
                ((d) this.instance).m(iterable);
                return this;
            }

            public a g(b bVar) {
                copyOnWrite();
                ((d) this.instance).s(bVar);
                return this;
            }

            public a() {
                super(d.DEFAULT_INSTANCE);
            }
        }

        public enum b implements C.c {
            OPERATOR_UNSPECIFIED(0),
            AND(1),
            OR(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C.d f14104f = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f14106a;

            public class a implements C.d {
                @Override // com.google.protobuf.C.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public b a(int i4) {
                    return b.c(i4);
                }
            }

            b(int i4) {
                this.f14106a = i4;
            }

            public static b c(int i4) {
                if (i4 == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (i4 == 1) {
                    return AND;
                }
                if (i4 != 2) {
                    return null;
                }
                return OR;
            }

            @Override // com.google.protobuf.C.c
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f14106a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            d dVar = new d();
            DEFAULT_INSTANCE = dVar;
            AbstractC1077y.registerDefaultInstance(d.class, dVar);
        }

        public static d o() {
            return DEFAULT_INSTANCE;
        }

        public static a r() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14099a[eVar.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002\u001b", new Object[]{"op_", "filters_", h.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g0 g0Var = PARSER;
                    if (g0Var != null) {
                        return g0Var;
                    }
                    synchronized (d.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

        public final void m(Iterable iterable) {
            n();
            AbstractC1050a.addAll(iterable, (List) this.filters_);
        }

        public final void n() {
            C.i iVar = this.filters_;
            if (iVar.e()) {
                return;
            }
            this.filters_ = AbstractC1077y.mutableCopy(iVar);
        }

        public List p() {
            return this.filters_;
        }

        public b q() {
            b bVarC = b.c(this.op_);
            return bVarC == null ? b.UNRECOGNIZED : bVarC;
        }

        public final void s(b bVar) {
            this.op_ = bVar.getNumber();
        }
    }

    public enum e implements C.c {
        DIRECTION_UNSPECIFIED(0),
        ASCENDING(1),
        DESCENDING(2),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C.d f14111f = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14113a;

        public class a implements C.d {
            @Override // com.google.protobuf.C.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e a(int i4) {
                return e.c(i4);
            }
        }

        e(int i4) {
            this.f14113a = i4;
        }

        public static e c(int i4) {
            if (i4 == 0) {
                return DIRECTION_UNSPECIFIED;
            }
            if (i4 == 1) {
                return ASCENDING;
            }
            if (i4 != 2) {
                return null;
            }
            return DESCENDING;
        }

        @Override // com.google.protobuf.C.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.f14113a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class f extends AbstractC1077y implements X {
        private static final f DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int OP_FIELD_NUMBER = 2;
        private static volatile g0 PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private int bitField0_;
        private g field_;
        private int op_;
        private C1698D value_;

        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(g gVar) {
                copyOnWrite();
                ((f) this.instance).s(gVar);
                return this;
            }

            public a g(b bVar) {
                copyOnWrite();
                ((f) this.instance).t(bVar);
                return this;
            }

            public a h(C1698D c1698d) {
                copyOnWrite();
                ((f) this.instance).u(c1698d);
                return this;
            }

            public a() {
                super(f.DEFAULT_INSTANCE);
            }
        }

        public enum b implements C.c {
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
            public static final C.d f14126n = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f14128a;

            public class a implements C.d {
                @Override // com.google.protobuf.C.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public b a(int i4) {
                    return b.c(i4);
                }
            }

            b(int i4) {
                this.f14128a = i4;
            }

            public static b c(int i4) {
                switch (i4) {
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

            @Override // com.google.protobuf.C.c
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f14128a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            f fVar = new f();
            DEFAULT_INSTANCE = fVar;
            AbstractC1077y.registerDefaultInstance(f.class, fVar);
        }

        public static f n() {
            return DEFAULT_INSTANCE;
        }

        public static a r() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(g gVar) {
            gVar.getClass();
            this.field_ = gVar;
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14099a[eVar.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003ဉ\u0001", new Object[]{"bitField0_", "field_", "op_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g0 g0Var = PARSER;
                    if (g0Var != null) {
                        return g0Var;
                    }
                    synchronized (f.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

        public g o() {
            g gVar = this.field_;
            return gVar == null ? g.l() : gVar;
        }

        public b p() {
            b bVarC = b.c(this.op_);
            return bVarC == null ? b.UNRECOGNIZED : bVarC;
        }

        public C1698D q() {
            C1698D c1698d = this.value_;
            return c1698d == null ? C1698D.y() : c1698d;
        }

        public final void t(b bVar) {
            this.op_ = bVar.getNumber();
        }

        public final void u(C1698D c1698d) {
            c1698d.getClass();
            this.value_ = c1698d;
            this.bitField0_ |= 2;
        }
    }

    public static final class g extends AbstractC1077y implements X {
        private static final g DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 2;
        private static volatile g0 PARSER;
        private String fieldPath_ = "";

        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(String str) {
                copyOnWrite();
                ((g) this.instance).o(str);
                return this;
            }

            public a() {
                super(g.DEFAULT_INSTANCE);
            }
        }

        static {
            g gVar = new g();
            DEFAULT_INSTANCE = gVar;
            AbstractC1077y.registerDefaultInstance(g.class, gVar);
        }

        public static g l() {
            return DEFAULT_INSTANCE;
        }

        public static a n() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14099a[eVar.ordinal()]) {
                case 1:
                    return new g();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"fieldPath_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g0 g0Var = PARSER;
                    if (g0Var != null) {
                        return g0Var;
                    }
                    synchronized (g.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

        public String m() {
            return this.fieldPath_;
        }
    }

    public static final class h extends AbstractC1077y implements X {
        public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
        private static final h DEFAULT_INSTANCE;
        public static final int FIELD_FILTER_FIELD_NUMBER = 2;
        private static volatile g0 PARSER = null;
        public static final int UNARY_FILTER_FIELD_NUMBER = 3;
        private int filterTypeCase_ = 0;
        private Object filterType_;

        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(d.a aVar) {
                copyOnWrite();
                ((h) this.instance).t((d) aVar.build());
                return this;
            }

            public a g(f.a aVar) {
                copyOnWrite();
                ((h) this.instance).u((f) aVar.build());
                return this;
            }

            public a h(k.a aVar) {
                copyOnWrite();
                ((h) this.instance).v((k) aVar.build());
                return this;
            }

            public a() {
                super(h.DEFAULT_INSTANCE);
            }
        }

        public enum b {
            COMPOSITE_FILTER(1),
            FIELD_FILTER(2),
            UNARY_FILTER(3),
            FILTERTYPE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f14134a;

            b(int i4) {
                this.f14134a = i4;
            }

            public static b c(int i4) {
                if (i4 == 0) {
                    return FILTERTYPE_NOT_SET;
                }
                if (i4 == 1) {
                    return COMPOSITE_FILTER;
                }
                if (i4 == 2) {
                    return FIELD_FILTER;
                }
                if (i4 != 3) {
                    return null;
                }
                return UNARY_FILTER;
            }
        }

        static {
            h hVar = new h();
            DEFAULT_INSTANCE = hVar;
            AbstractC1077y.registerDefaultInstance(h.class, hVar);
        }

        public static h o() {
            return DEFAULT_INSTANCE;
        }

        public static a s() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14099a[eVar.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"filterType_", "filterTypeCase_", d.class, f.class, k.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g0 g0Var = PARSER;
                    if (g0Var != null) {
                        return g0Var;
                    }
                    synchronized (h.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

        public d n() {
            return this.filterTypeCase_ == 1 ? (d) this.filterType_ : d.o();
        }

        public f p() {
            return this.filterTypeCase_ == 2 ? (f) this.filterType_ : f.n();
        }

        public b q() {
            return b.c(this.filterTypeCase_);
        }

        public k r() {
            return this.filterTypeCase_ == 3 ? (k) this.filterType_ : k.m();
        }

        public final void t(d dVar) {
            dVar.getClass();
            this.filterType_ = dVar;
            this.filterTypeCase_ = 1;
        }

        public final void u(f fVar) {
            fVar.getClass();
            this.filterType_ = fVar;
            this.filterTypeCase_ = 2;
        }

        public final void v(k kVar) {
            kVar.getClass();
            this.filterType_ = kVar;
            this.filterTypeCase_ = 3;
        }
    }

    public static final class i extends AbstractC1077y implements X {
        private static final i DEFAULT_INSTANCE;
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile g0 PARSER;
        private int bitField0_;
        private int direction_;
        private g field_;

        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(e eVar) {
                copyOnWrite();
                ((i) this.instance).p(eVar);
                return this;
            }

            public a g(g gVar) {
                copyOnWrite();
                ((i) this.instance).q(gVar);
                return this;
            }

            public a() {
                super(i.DEFAULT_INSTANCE);
            }
        }

        static {
            i iVar = new i();
            DEFAULT_INSTANCE = iVar;
            AbstractC1077y.registerDefaultInstance(i.class, iVar);
        }

        public static a o() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(g gVar) {
            gVar.getClass();
            this.field_ = gVar;
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14099a[eVar.ordinal()]) {
                case 1:
                    return new i();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "field_", "direction_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g0 g0Var = PARSER;
                    if (g0Var != null) {
                        return g0Var;
                    }
                    synchronized (i.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

        public e m() {
            e eVarC = e.c(this.direction_);
            return eVarC == null ? e.UNRECOGNIZED : eVarC;
        }

        public g n() {
            g gVar = this.field_;
            return gVar == null ? g.l() : gVar;
        }

        public final void p(e eVar) {
            this.direction_ = eVar.getNumber();
        }
    }

    public static final class j extends AbstractC1077y implements X {
        private static final j DEFAULT_INSTANCE;
        public static final int FIELDS_FIELD_NUMBER = 2;
        private static volatile g0 PARSER;
        private C.i fields_ = AbstractC1077y.emptyProtobufList();

        public static final class a extends AbstractC1077y.a implements X {
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
            AbstractC1077y.registerDefaultInstance(j.class, jVar);
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14099a[eVar.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", new Object[]{"fields_", g.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g0 g0Var = PARSER;
                    if (g0Var != null) {
                        return g0Var;
                    }
                    synchronized (j.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

    public static final class k extends AbstractC1077y implements X {
        private static final k DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile g0 PARSER;
        private int op_;
        private int operandTypeCase_ = 0;
        private Object operandType_;

        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(g gVar) {
                copyOnWrite();
                ((k) this.instance).q(gVar);
                return this;
            }

            public a g(b bVar) {
                copyOnWrite();
                ((k) this.instance).r(bVar);
                return this;
            }

            public a() {
                super(k.DEFAULT_INSTANCE);
            }
        }

        public enum b implements C.c {
            OPERATOR_UNSPECIFIED(0),
            IS_NAN(2),
            IS_NULL(3),
            IS_NOT_NAN(4),
            IS_NOT_NULL(5),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final C.d f14141h = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f14143a;

            public class a implements C.d {
                @Override // com.google.protobuf.C.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public b a(int i4) {
                    return b.c(i4);
                }
            }

            b(int i4) {
                this.f14143a = i4;
            }

            public static b c(int i4) {
                if (i4 == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (i4 == 2) {
                    return IS_NAN;
                }
                if (i4 == 3) {
                    return IS_NULL;
                }
                if (i4 == 4) {
                    return IS_NOT_NAN;
                }
                if (i4 != 5) {
                    return null;
                }
                return IS_NOT_NULL;
            }

            @Override // com.google.protobuf.C.c
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f14143a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            k kVar = new k();
            DEFAULT_INSTANCE = kVar;
            AbstractC1077y.registerDefaultInstance(k.class, kVar);
        }

        public static k m() {
            return DEFAULT_INSTANCE;
        }

        public static a p() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(g gVar) {
            gVar.getClass();
            this.operandType_ = gVar;
            this.operandTypeCase_ = 2;
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14099a[eVar.ordinal()]) {
                case 1:
                    return new k();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002<\u0000", new Object[]{"operandType_", "operandTypeCase_", "op_", g.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g0 g0Var = PARSER;
                    if (g0Var != null) {
                        return g0Var;
                    }
                    synchronized (k.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

        public g n() {
            return this.operandTypeCase_ == 2 ? (g) this.operandType_ : g.l();
        }

        public b o() {
            b bVarC = b.c(this.op_);
            return bVarC == null ? b.UNRECOGNIZED : bVarC;
        }

        public final void r(b bVar) {
            this.op_ = bVar.getNumber();
        }
    }

    static {
        z zVar = new z();
        DEFAULT_INSTANCE = zVar;
        AbstractC1077y.registerDefaultInstance(z.class, zVar);
    }

    public static b H() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static z u() {
        return DEFAULT_INSTANCE;
    }

    public int A() {
        return this.orderBy_.size();
    }

    public C1713j B() {
        C1713j c1713j = this.startAt_;
        return c1713j == null ? C1713j.p() : c1713j;
    }

    public h C() {
        h hVar = this.where_;
        return hVar == null ? h.o() : hVar;
    }

    public boolean D() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean E() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean F() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean G() {
        return (this.bitField0_ & 2) != 0;
    }

    public final void I(C1713j c1713j) {
        c1713j.getClass();
        this.endAt_ = c1713j;
        this.bitField0_ |= 8;
    }

    public final void J(C1078z c1078z) {
        c1078z.getClass();
        this.limit_ = c1078z;
        this.bitField0_ |= 16;
    }

    public final void K(C1713j c1713j) {
        c1713j.getClass();
        this.startAt_ = c1713j;
        this.bitField0_ |= 4;
    }

    public final void L(h hVar) {
        hVar.getClass();
        this.where_ = hVar;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14099a[eVar.ordinal()]) {
            case 1:
                return new z();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b\u0005ဉ\u0004\u0006\u0004\u0007ဉ\u0002\bဉ\u0003", new Object[]{"bitField0_", "select_", "from_", c.class, "where_", "orderBy_", i.class, "limit_", "offset_", "startAt_", "endAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (z.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

    public final void q(c cVar) {
        cVar.getClass();
        s();
        this.from_.add(cVar);
    }

    public final void r(i iVar) {
        iVar.getClass();
        t();
        this.orderBy_.add(iVar);
    }

    public final void s() {
        C.i iVar = this.from_;
        if (iVar.e()) {
            return;
        }
        this.from_ = AbstractC1077y.mutableCopy(iVar);
    }

    public final void t() {
        C.i iVar = this.orderBy_;
        if (iVar.e()) {
            return;
        }
        this.orderBy_ = AbstractC1077y.mutableCopy(iVar);
    }

    public C1713j v() {
        C1713j c1713j = this.endAt_;
        return c1713j == null ? C1713j.p() : c1713j;
    }

    public c w(int i4) {
        return (c) this.from_.get(i4);
    }

    public int x() {
        return this.from_.size();
    }

    public C1078z y() {
        C1078z c1078z = this.limit_;
        return c1078z == null ? C1078z.l() : c1078z;
    }

    public i z(int i4) {
        return (i) this.orderBy_.get(i4);
    }
}
