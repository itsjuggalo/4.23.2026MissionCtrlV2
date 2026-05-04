package za;

import com.google.protobuf.c0;
import com.google.protobuf.e1;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends y implements v0 {
    private static final a DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile e1 PARSER = null;
    public static final int QUERY_SCOPE_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 4;
    private int queryScope_;
    private int state_;
    private String name_ = "";
    private c0.e fields_ = y.A();

    /* JADX INFO: renamed from: za.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class C0480a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25619a;

        static {
            int[] iArr = new int[y.d.values().length];
            f25619a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25619a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25619a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25619a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25619a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25619a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25619a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y.a implements v0 {
        public /* synthetic */ b(C0480a c0480a) {
            this();
        }

        public b x(c.b bVar) {
            q();
            ((a) this.f7244b).c0((c) bVar.n());
            return this;
        }

        public b y(d dVar) {
            q();
            ((a) this.f7244b).h0(dVar);
            return this;
        }

        public b() {
            super(a.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends y implements v0 {
        public static final int ARRAY_CONFIG_FIELD_NUMBER = 3;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int ORDER_FIELD_NUMBER = 2;
        private static volatile e1 PARSER;
        private Object valueMode_;
        private int valueModeCase_ = 0;
        private String fieldPath_ = "";

        /* JADX INFO: renamed from: za.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum EnumC0481a implements c0.a {
            ARRAY_CONFIG_UNSPECIFIED(0),
            CONTAINS(1),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final c0.b f25623e = new C0482a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f25625a;

            /* JADX INFO: renamed from: za.a$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class C0482a implements c0.b {
            }

            EnumC0481a(int i10) {
                this.f25625a = i10;
            }

            @Override // com.google.protobuf.c0.a
            public final int d() {
                if (this != UNRECOGNIZED) {
                    return this.f25625a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends y.a implements v0 {
            public /* synthetic */ b(C0480a c0480a) {
                this();
            }

            public b x(EnumC0481a enumC0481a) {
                q();
                ((c) this.f7244b).h0(enumC0481a);
                return this;
            }

            public b y(String str) {
                q();
                ((c) this.f7244b).i0(str);
                return this;
            }

            public b z(EnumC0483c enumC0483c) {
                q();
                ((c) this.f7244b).j0(enumC0483c);
                return this;
            }

            public b() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: renamed from: za.a$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum EnumC0483c implements c0.a {
            ORDER_UNSPECIFIED(0),
            ASCENDING(1),
            DESCENDING(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final c0.b f25630f = new C0484a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f25632a;

            /* JADX INFO: renamed from: za.a$c$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class C0484a implements c0.b {
            }

            EnumC0483c(int i10) {
                this.f25632a = i10;
            }

            public static EnumC0483c b(int i10) {
                if (i10 == 0) {
                    return ORDER_UNSPECIFIED;
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
                    return this.f25632a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum d {
            ORDER(2),
            ARRAY_CONFIG(3),
            VALUEMODE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f25637a;

            d(int i10) {
                this.f25637a = i10;
            }

            public static d b(int i10) {
                if (i10 == 0) {
                    return VALUEMODE_NOT_SET;
                }
                if (i10 == 2) {
                    return ORDER;
                }
                if (i10 != 3) {
                    return null;
                }
                return ARRAY_CONFIG;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            y.V(c.class, cVar);
        }

        public static b g0() {
            return (b) DEFAULT_INSTANCE.u();
        }

        public String d0() {
            return this.fieldPath_;
        }

        public EnumC0483c e0() {
            if (this.valueModeCase_ != 2) {
                return EnumC0483c.ORDER_UNSPECIFIED;
            }
            EnumC0483c enumC0483cB = EnumC0483c.b(((Integer) this.valueMode_).intValue());
            return enumC0483cB == null ? EnumC0483c.UNRECOGNIZED : enumC0483cB;
        }

        public d f0() {
            return d.b(this.valueModeCase_);
        }

        public final void h0(EnumC0481a enumC0481a) {
            this.valueMode_ = Integer.valueOf(enumC0481a.d());
            this.valueModeCase_ = 3;
        }

        public final void i0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        public final void j0(EnumC0483c enumC0483c) {
            this.valueMode_ = Integer.valueOf(enumC0483c.d());
            this.valueModeCase_ = 2;
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            C0480a c0480a = null;
            switch (C0480a.f25619a[dVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new b(c0480a);
                case 3:
                    return y.N(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003?\u0000", new Object[]{"valueMode_", "valueModeCase_", "fieldPath_"});
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
    public enum d implements c0.a {
        QUERY_SCOPE_UNSPECIFIED(0),
        COLLECTION(1),
        COLLECTION_GROUP(2),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c0.b f25642f = new C0485a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f25644a;

        /* JADX INFO: renamed from: za.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0485a implements c0.b {
        }

        d(int i10) {
            this.f25644a = i10;
        }

        @Override // com.google.protobuf.c0.a
        public final int d() {
            if (this != UNRECOGNIZED) {
                return this.f25644a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        y.V(a.class, aVar);
    }

    public static b f0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static a g0(byte[] bArr) {
        return (a) y.R(DEFAULT_INSTANCE, bArr);
    }

    public final void c0(c cVar) {
        cVar.getClass();
        d0();
        this.fields_.add(cVar);
    }

    public final void d0() {
        c0.e eVar = this.fields_;
        if (eVar.m()) {
            return;
        }
        this.fields_ = y.L(eVar);
    }

    public List e0() {
        return this.fields_;
    }

    public final void h0(d dVar) {
        this.queryScope_ = dVar.d();
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        C0480a c0480a = null;
        switch (C0480a.f25619a[dVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(c0480a);
            case 3:
                return y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\f\u0003\u001b\u0004\f", new Object[]{"name_", "queryScope_", "fields_", c.class, "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (a.class) {
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
