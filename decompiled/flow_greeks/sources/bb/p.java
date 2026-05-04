package bb;

import bb.b;
import com.google.protobuf.c0;
import com.google.protobuf.e1;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends com.google.protobuf.y implements v0 {
    private static final p DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile e1 PARSER;
    private String document_ = "";
    private c0.e fieldTransforms_ = com.google.protobuf.y.A();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3209a;

        static {
            int[] iArr = new int[y.d.values().length];
            f3209a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3209a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3209a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3209a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3209a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3209a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3209a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y.a implements v0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(p.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends com.google.protobuf.y implements v0 {
        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile e1 PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private Object transformType_;
        private int transformTypeCase_ = 0;
        private String fieldPath_ = "";

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends y.a implements v0 {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a A(b.C0055b c0055b) {
                q();
                ((c) this.f7244b).p0((bb.b) c0055b.n());
                return this;
            }

            public a B(b bVar) {
                q();
                ((c) this.f7244b).q0(bVar);
                return this;
            }

            public a x(b.C0055b c0055b) {
                q();
                ((c) this.f7244b).m0((bb.b) c0055b.n());
                return this;
            }

            public a y(String str) {
                q();
                ((c) this.f7244b).n0(str);
                return this;
            }

            public a z(d0 d0Var) {
                q();
                ((c) this.f7244b).o0(d0Var);
                return this;
            }

            public a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum b implements c0.a {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final c0.b f3213e = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3215a;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class a implements c0.b {
            }

            b(int i10) {
                this.f3215a = i10;
            }

            public static b b(int i10) {
                if (i10 == 0) {
                    return SERVER_VALUE_UNSPECIFIED;
                }
                if (i10 != 1) {
                    return null;
                }
                return REQUEST_TIME;
            }

            @Override // com.google.protobuf.c0.a
            public final int d() {
                if (this != UNRECOGNIZED) {
                    return this.f3215a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: renamed from: bb.p$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum EnumC0056c {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3224a;

            EnumC0056c(int i10) {
                this.f3224a = i10;
            }

            public static EnumC0056c b(int i10) {
                if (i10 == 0) {
                    return TRANSFORMTYPE_NOT_SET;
                }
                switch (i10) {
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
            com.google.protobuf.y.V(c.class, cVar);
        }

        public static a l0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        public bb.b f0() {
            return this.transformTypeCase_ == 6 ? (bb.b) this.transformType_ : bb.b.g0();
        }

        public String g0() {
            return this.fieldPath_;
        }

        public d0 h0() {
            return this.transformTypeCase_ == 3 ? (d0) this.transformType_ : d0.o0();
        }

        public bb.b i0() {
            return this.transformTypeCase_ == 7 ? (bb.b) this.transformType_ : bb.b.g0();
        }

        public b j0() {
            if (this.transformTypeCase_ != 2) {
                return b.SERVER_VALUE_UNSPECIFIED;
            }
            b bVarB = b.b(((Integer) this.transformType_).intValue());
            return bVarB == null ? b.UNRECOGNIZED : bVarB;
        }

        public EnumC0056c k0() {
            return EnumC0056c.b(this.transformTypeCase_);
        }

        public final void m0(bb.b bVar) {
            bVar.getClass();
            this.transformType_ = bVar;
            this.transformTypeCase_ = 6;
        }

        public final void o0(d0 d0Var) {
            d0Var.getClass();
            this.transformType_ = d0Var;
            this.transformTypeCase_ = 3;
        }

        public final void p0(bb.b bVar) {
            bVar.getClass();
            this.transformType_ = bVar;
            this.transformTypeCase_ = 7;
        }

        public final void q0(b bVar) {
            this.transformType_ = Integer.valueOf(bVar.d());
            this.transformTypeCase_ = 2;
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3209a[dVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"transformType_", "transformTypeCase_", "fieldPath_", d0.class, d0.class, d0.class, bb.b.class, bb.b.class});
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

    static {
        p pVar = new p();
        DEFAULT_INSTANCE = pVar;
        com.google.protobuf.y.V(p.class, pVar);
    }

    public static p a0() {
        return DEFAULT_INSTANCE;
    }

    public List b0() {
        return this.fieldTransforms_;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f3209a[dVar.ordinal()]) {
            case 1:
                return new p();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"document_", "fieldTransforms_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (p.class) {
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
