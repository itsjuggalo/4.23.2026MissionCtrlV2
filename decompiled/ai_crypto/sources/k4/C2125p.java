package k4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import java.util.List;
import k4.C2111b;

/* JADX INFO: renamed from: k4.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2125p extends AbstractC1255y implements W {
    private static final C2125p DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile f0 PARSER;
    private String document_ = "";
    private C.e fieldTransforms_ = AbstractC1255y.A();

    /* JADX INFO: renamed from: k4.p$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18054a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18054a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18054a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18054a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18054a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18054a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18054a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18054a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.p$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C2125p.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.p$c */
    public static final class c extends AbstractC1255y implements W {
        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile f0 PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private Object transformType_;
        private int transformTypeCase_ = 0;
        private String fieldPath_ = "";

        /* JADX INFO: renamed from: k4.p$c$a */
        public static final class a extends AbstractC1255y.a implements W {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a A(b bVar) {
                q();
                ((c) this.f12868b).q0(bVar);
                return this;
            }

            public a w(C2111b.C0290b c0290b) {
                q();
                ((c) this.f12868b).m0((C2111b) c0290b.n());
                return this;
            }

            public a x(String str) {
                q();
                ((c) this.f12868b).n0(str);
                return this;
            }

            public a y(C2105D c2105d) {
                q();
                ((c) this.f12868b).o0(c2105d);
                return this;
            }

            public a z(C2111b.C0290b c0290b) {
                q();
                ((c) this.f12868b).p0((C2111b) c0290b.n());
                return this;
            }

            public a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: renamed from: k4.p$c$b */
        public enum b implements C.a {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final C.b f18058e = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f18060a;

            /* JADX INFO: renamed from: k4.p$c$b$a */
            public class a implements C.b {
            }

            b(int i7) {
                this.f18060a = i7;
            }

            public static b b(int i7) {
                if (i7 == 0) {
                    return SERVER_VALUE_UNSPECIFIED;
                }
                if (i7 != 1) {
                    return null;
                }
                return REQUEST_TIME;
            }

            @Override // com.google.protobuf.C.a
            public final int d() {
                if (this != UNRECOGNIZED) {
                    return this.f18060a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: renamed from: k4.p$c$c, reason: collision with other inner class name */
        public enum EnumC0291c {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f18069a;

            EnumC0291c(int i7) {
                this.f18069a = i7;
            }

            public static EnumC0291c b(int i7) {
                if (i7 == 0) {
                    return TRANSFORMTYPE_NOT_SET;
                }
                switch (i7) {
                    case 2:
                        return SET_TO_SERVER_VALUE;
                    case 3:
                        return INCREMENT;
                    case 4:
                        return MAXIMUM;
                    case 5:
                        return MINIMUM;
                    case 6:
                        return APPEND_MISSING_ELEMENTS;
                    case 7:
                        return REMOVE_ALL_FROM_ARRAY;
                    default:
                        return null;
                }
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            AbstractC1255y.V(c.class, cVar);
        }

        public static a l0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        public C2111b f0() {
            return this.transformTypeCase_ == 6 ? (C2111b) this.transformType_ : C2111b.g0();
        }

        public String g0() {
            return this.fieldPath_;
        }

        public C2105D h0() {
            return this.transformTypeCase_ == 3 ? (C2105D) this.transformType_ : C2105D.o0();
        }

        public C2111b i0() {
            return this.transformTypeCase_ == 7 ? (C2111b) this.transformType_ : C2111b.g0();
        }

        public b j0() {
            if (this.transformTypeCase_ != 2) {
                return b.SERVER_VALUE_UNSPECIFIED;
            }
            b bVarB = b.b(((Integer) this.transformType_).intValue());
            return bVarB == null ? b.UNRECOGNIZED : bVarB;
        }

        public EnumC0291c k0() {
            return EnumC0291c.b(this.transformTypeCase_);
        }

        public final void m0(C2111b c2111b) {
            c2111b.getClass();
            this.transformType_ = c2111b;
            this.transformTypeCase_ = 6;
        }

        public final void o0(C2105D c2105d) {
            c2105d.getClass();
            this.transformType_ = c2105d;
            this.transformTypeCase_ = 3;
        }

        public final void p0(C2111b c2111b) {
            c2111b.getClass();
            this.transformType_ = c2111b;
            this.transformTypeCase_ = 7;
        }

        public final void q0(b bVar) {
            this.transformType_ = Integer.valueOf(bVar.d());
            this.transformTypeCase_ = 2;
        }

        @Override // com.google.protobuf.AbstractC1255y
        public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f18054a[dVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"transformType_", "transformTypeCase_", "fieldPath_", C2105D.class, C2105D.class, C2105D.class, C2111b.class, C2111b.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    f0 bVar = PARSER;
                    if (bVar == null) {
                        synchronized (c.class) {
                            try {
                                bVar = PARSER;
                                if (bVar == null) {
                                    bVar = new AbstractC1255y.b(DEFAULT_INSTANCE);
                                    PARSER = bVar;
                                }
                            } finally {
                            }
                            break;
                        }
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
        C2125p c2125p = new C2125p();
        DEFAULT_INSTANCE = c2125p;
        AbstractC1255y.V(C2125p.class, c2125p);
    }

    public static C2125p a0() {
        return DEFAULT_INSTANCE;
    }

    public List b0() {
        return this.fieldTransforms_;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18054a[dVar.ordinal()]) {
            case 1:
                return new C2125p();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"document_", "fieldTransforms_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2125p.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1255y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } finally {
                        }
                        break;
                    }
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
