package i4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import java.util.List;

/* JADX INFO: renamed from: i4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1979a extends AbstractC1255y implements W {
    private static final C1979a DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile f0 PARSER = null;
    public static final int QUERY_SCOPE_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 4;
    private int queryScope_;
    private int state_;
    private String name_ = "";
    private C.e fields_ = AbstractC1255y.A();

    /* JADX INFO: renamed from: i4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0248a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16269a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f16269a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16269a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16269a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16269a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16269a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16269a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16269a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: i4.a$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(C0248a c0248a) {
            this();
        }

        public b w(c.b bVar) {
            q();
            ((C1979a) this.f12868b).c0((c) bVar.n());
            return this;
        }

        public b x(d dVar) {
            q();
            ((C1979a) this.f12868b).h0(dVar);
            return this;
        }

        public b() {
            super(C1979a.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: i4.a$c */
    public static final class c extends AbstractC1255y implements W {
        public static final int ARRAY_CONFIG_FIELD_NUMBER = 3;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int ORDER_FIELD_NUMBER = 2;
        private static volatile f0 PARSER;
        private Object valueMode_;
        private int valueModeCase_ = 0;
        private String fieldPath_ = "";

        /* JADX INFO: renamed from: i4.a$c$a, reason: collision with other inner class name */
        public enum EnumC0249a implements C.a {
            ARRAY_CONFIG_UNSPECIFIED(0),
            CONTAINS(1),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final C.b f16273e = new C0250a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f16275a;

            /* JADX INFO: renamed from: i4.a$c$a$a, reason: collision with other inner class name */
            public class C0250a implements C.b {
            }

            EnumC0249a(int i7) {
                this.f16275a = i7;
            }

            @Override // com.google.protobuf.C.a
            public final int d() {
                if (this != UNRECOGNIZED) {
                    return this.f16275a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: renamed from: i4.a$c$b */
        public static final class b extends AbstractC1255y.a implements W {
            public /* synthetic */ b(C0248a c0248a) {
                this();
            }

            public b w(EnumC0249a enumC0249a) {
                q();
                ((c) this.f12868b).h0(enumC0249a);
                return this;
            }

            public b x(String str) {
                q();
                ((c) this.f12868b).i0(str);
                return this;
            }

            public b y(EnumC0251c enumC0251c) {
                q();
                ((c) this.f12868b).j0(enumC0251c);
                return this;
            }

            public b() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: renamed from: i4.a$c$c, reason: collision with other inner class name */
        public enum EnumC0251c implements C.a {
            ORDER_UNSPECIFIED(0),
            ASCENDING(1),
            DESCENDING(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C.b f16280f = new C0252a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f16282a;

            /* JADX INFO: renamed from: i4.a$c$c$a, reason: collision with other inner class name */
            public class C0252a implements C.b {
            }

            EnumC0251c(int i7) {
                this.f16282a = i7;
            }

            public static EnumC0251c b(int i7) {
                if (i7 == 0) {
                    return ORDER_UNSPECIFIED;
                }
                if (i7 == 1) {
                    return ASCENDING;
                }
                if (i7 != 2) {
                    return null;
                }
                return DESCENDING;
            }

            @Override // com.google.protobuf.C.a
            public final int d() {
                if (this != UNRECOGNIZED) {
                    return this.f16282a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: renamed from: i4.a$c$d */
        public enum d {
            ORDER(2),
            ARRAY_CONFIG(3),
            VALUEMODE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f16287a;

            d(int i7) {
                this.f16287a = i7;
            }

            public static d b(int i7) {
                if (i7 == 0) {
                    return VALUEMODE_NOT_SET;
                }
                if (i7 == 2) {
                    return ORDER;
                }
                if (i7 != 3) {
                    return null;
                }
                return ARRAY_CONFIG;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            AbstractC1255y.V(c.class, cVar);
        }

        public static b g0() {
            return (b) DEFAULT_INSTANCE.u();
        }

        public String d0() {
            return this.fieldPath_;
        }

        public EnumC0251c e0() {
            if (this.valueModeCase_ != 2) {
                return EnumC0251c.ORDER_UNSPECIFIED;
            }
            EnumC0251c enumC0251cB = EnumC0251c.b(((Integer) this.valueMode_).intValue());
            return enumC0251cB == null ? EnumC0251c.UNRECOGNIZED : enumC0251cB;
        }

        public d f0() {
            return d.b(this.valueModeCase_);
        }

        public final void h0(EnumC0249a enumC0249a) {
            this.valueMode_ = Integer.valueOf(enumC0249a.d());
            this.valueModeCase_ = 3;
        }

        public final void i0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        public final void j0(EnumC0251c enumC0251c) {
            this.valueMode_ = Integer.valueOf(enumC0251c.d());
            this.valueModeCase_ = 2;
        }

        @Override // com.google.protobuf.AbstractC1255y
        public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
            C0248a c0248a = null;
            switch (C0248a.f16269a[dVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new b(c0248a);
                case 3:
                    return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003?\u0000", new Object[]{"valueMode_", "valueModeCase_", "fieldPath_"});
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

    /* JADX INFO: renamed from: i4.a$d */
    public enum d implements C.a {
        QUERY_SCOPE_UNSPECIFIED(0),
        COLLECTION(1),
        COLLECTION_GROUP(2),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C.b f16292f = new C0253a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16294a;

        /* JADX INFO: renamed from: i4.a$d$a, reason: collision with other inner class name */
        public class C0253a implements C.b {
        }

        d(int i7) {
            this.f16294a = i7;
        }

        @Override // com.google.protobuf.C.a
        public final int d() {
            if (this != UNRECOGNIZED) {
                return this.f16294a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        C1979a c1979a = new C1979a();
        DEFAULT_INSTANCE = c1979a;
        AbstractC1255y.V(C1979a.class, c1979a);
    }

    public static b f0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static C1979a g0(byte[] bArr) {
        return (C1979a) AbstractC1255y.R(DEFAULT_INSTANCE, bArr);
    }

    public final void c0(c cVar) {
        cVar.getClass();
        d0();
        this.fields_.add(cVar);
    }

    public final void d0() {
        C.e eVar = this.fields_;
        if (eVar.f()) {
            return;
        }
        this.fields_ = AbstractC1255y.L(eVar);
    }

    public List e0() {
        return this.fields_;
    }

    public final void h0(d dVar) {
        this.queryScope_ = dVar.d();
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        C0248a c0248a = null;
        switch (C0248a.f16269a[dVar.ordinal()]) {
            case 1:
                return new C1979a();
            case 2:
                return new b(c0248a);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\f\u0003\u001b\u0004\f", new Object[]{"name_", "queryScope_", "fields_", c.class, "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C1979a.class) {
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
