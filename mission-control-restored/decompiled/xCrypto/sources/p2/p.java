package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import java.util.List;
import p2.C1705b;

/* JADX INFO: loaded from: classes.dex */
public final class p extends AbstractC1077y implements X {
    private static final p DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile g0 PARSER;
    private String document_ = "";
    private C.i fieldTransforms_ = AbstractC1077y.emptyProtobufList();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14055a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14055a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14055a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14055a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14055a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14055a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14055a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14055a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(p.DEFAULT_INSTANCE);
        }
    }

    public static final class c extends AbstractC1077y implements X {
        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile g0 PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private Object transformType_;
        private int transformTypeCase_ = 0;
        private String fieldPath_ = "";

        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(C1705b.C0224b c0224b) {
                copyOnWrite();
                ((c) this.instance).w((C1705b) c0224b.build());
                return this;
            }

            public a g(String str) {
                copyOnWrite();
                ((c) this.instance).x(str);
                return this;
            }

            public a h(C1698D c1698d) {
                copyOnWrite();
                ((c) this.instance).y(c1698d);
                return this;
            }

            public a i(C1705b.C0224b c0224b) {
                copyOnWrite();
                ((c) this.instance).z((C1705b) c0224b.build());
                return this;
            }

            public a j(b bVar) {
                copyOnWrite();
                ((c) this.instance).A(bVar);
                return this;
            }

            public a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        public enum b implements C.c {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final C.d f14059e = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f14061a;

            public class a implements C.d {
                @Override // com.google.protobuf.C.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public b a(int i4) {
                    return b.c(i4);
                }
            }

            b(int i4) {
                this.f14061a = i4;
            }

            public static b c(int i4) {
                if (i4 == 0) {
                    return SERVER_VALUE_UNSPECIFIED;
                }
                if (i4 != 1) {
                    return null;
                }
                return REQUEST_TIME;
            }

            @Override // com.google.protobuf.C.c
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f14061a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: renamed from: p2.p$c$c, reason: collision with other inner class name */
        public enum EnumC0225c {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f14070a;

            EnumC0225c(int i4) {
                this.f14070a = i4;
            }

            public static EnumC0225c c(int i4) {
                if (i4 == 0) {
                    return TRANSFORMTYPE_NOT_SET;
                }
                switch (i4) {
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
            AbstractC1077y.registerDefaultInstance(c.class, cVar);
        }

        public static a v() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        public final void A(b bVar) {
            this.transformType_ = Integer.valueOf(bVar.getNumber());
            this.transformTypeCase_ = 2;
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14055a[eVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"transformType_", "transformTypeCase_", "fieldPath_", C1698D.class, C1698D.class, C1698D.class, C1705b.class, C1705b.class});
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

        public C1705b p() {
            return this.transformTypeCase_ == 6 ? (C1705b) this.transformType_ : C1705b.q();
        }

        public String q() {
            return this.fieldPath_;
        }

        public C1698D r() {
            return this.transformTypeCase_ == 3 ? (C1698D) this.transformType_ : C1698D.y();
        }

        public C1705b s() {
            return this.transformTypeCase_ == 7 ? (C1705b) this.transformType_ : C1705b.q();
        }

        public b t() {
            if (this.transformTypeCase_ != 2) {
                return b.SERVER_VALUE_UNSPECIFIED;
            }
            b bVarC = b.c(((Integer) this.transformType_).intValue());
            return bVarC == null ? b.UNRECOGNIZED : bVarC;
        }

        public EnumC0225c u() {
            return EnumC0225c.c(this.transformTypeCase_);
        }

        public final void w(C1705b c1705b) {
            c1705b.getClass();
            this.transformType_ = c1705b;
            this.transformTypeCase_ = 6;
        }

        public final void y(C1698D c1698d) {
            c1698d.getClass();
            this.transformType_ = c1698d;
            this.transformTypeCase_ = 3;
        }

        public final void z(C1705b c1705b) {
            c1705b.getClass();
            this.transformType_ = c1705b;
            this.transformTypeCase_ = 7;
        }
    }

    static {
        p pVar = new p();
        DEFAULT_INSTANCE = pVar;
        AbstractC1077y.registerDefaultInstance(p.class, pVar);
    }

    public static p k() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14055a[eVar.ordinal()]) {
            case 1:
                return new p();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"document_", "fieldTransforms_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (p.class) {
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

    public List l() {
        return this.fieldTransforms_;
    }
}
