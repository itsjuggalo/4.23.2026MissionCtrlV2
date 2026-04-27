package n2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import java.util.List;

/* JADX INFO: renamed from: n2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1632a extends AbstractC1077y implements X {
    private static final C1632a DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g0 PARSER = null;
    public static final int QUERY_SCOPE_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 4;
    private int queryScope_;
    private int state_;
    private String name_ = "";
    private C.i fields_ = AbstractC1077y.emptyProtobufList();

    /* JADX INFO: renamed from: n2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0211a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13633a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f13633a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13633a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13633a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13633a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13633a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13633a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13633a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: n2.a$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(C0211a c0211a) {
            this();
        }

        public b f(c.b bVar) {
            copyOnWrite();
            ((C1632a) this.instance).m((c) bVar.build());
            return this;
        }

        public b g(d dVar) {
            copyOnWrite();
            ((C1632a) this.instance).r(dVar);
            return this;
        }

        public b() {
            super(C1632a.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: n2.a$c */
    public static final class c extends AbstractC1077y implements X {
        public static final int ARRAY_CONFIG_FIELD_NUMBER = 3;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int ORDER_FIELD_NUMBER = 2;
        private static volatile g0 PARSER;
        private Object valueMode_;
        private int valueModeCase_ = 0;
        private String fieldPath_ = "";

        /* JADX INFO: renamed from: n2.a$c$a, reason: collision with other inner class name */
        public enum EnumC0212a implements C.c {
            ARRAY_CONFIG_UNSPECIFIED(0),
            CONTAINS(1),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final C.d f13637e = new C0213a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f13639a;

            /* JADX INFO: renamed from: n2.a$c$a$a, reason: collision with other inner class name */
            public class C0213a implements C.d {
                @Override // com.google.protobuf.C.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0212a a(int i4) {
                    return EnumC0212a.c(i4);
                }
            }

            EnumC0212a(int i4) {
                this.f13639a = i4;
            }

            public static EnumC0212a c(int i4) {
                if (i4 == 0) {
                    return ARRAY_CONFIG_UNSPECIFIED;
                }
                if (i4 != 1) {
                    return null;
                }
                return CONTAINS;
            }

            @Override // com.google.protobuf.C.c
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.f13639a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: renamed from: n2.a$c$b */
        public static final class b extends AbstractC1077y.a implements X {
            public /* synthetic */ b(C0211a c0211a) {
                this();
            }

            public b f(EnumC0212a enumC0212a) {
                copyOnWrite();
                ((c) this.instance).r(enumC0212a);
                return this;
            }

            public b g(String str) {
                copyOnWrite();
                ((c) this.instance).s(str);
                return this;
            }

            public b h(EnumC0214c enumC0214c) {
                copyOnWrite();
                ((c) this.instance).t(enumC0214c);
                return this;
            }

            public b() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: renamed from: n2.a$c$c, reason: collision with other inner class name */
        public enum EnumC0214c implements C.c {
            ORDER_UNSPECIFIED(0),
            ASCENDING(1),
            DESCENDING(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C.d f13644f = new C0215a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f13646a;

            /* JADX INFO: renamed from: n2.a$c$c$a, reason: collision with other inner class name */
            public class C0215a implements C.d {
                @Override // com.google.protobuf.C.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0214c a(int i4) {
                    return EnumC0214c.c(i4);
                }
            }

            EnumC0214c(int i4) {
                this.f13646a = i4;
            }

            public static EnumC0214c c(int i4) {
                if (i4 == 0) {
                    return ORDER_UNSPECIFIED;
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
                    return this.f13646a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: renamed from: n2.a$c$d */
        public enum d {
            ORDER(2),
            ARRAY_CONFIG(3),
            VALUEMODE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f13651a;

            d(int i4) {
                this.f13651a = i4;
            }

            public static d c(int i4) {
                if (i4 == 0) {
                    return VALUEMODE_NOT_SET;
                }
                if (i4 == 2) {
                    return ORDER;
                }
                if (i4 != 3) {
                    return null;
                }
                return ARRAY_CONFIG;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            AbstractC1077y.registerDefaultInstance(c.class, cVar);
        }

        public static b q() {
            return (b) DEFAULT_INSTANCE.createBuilder();
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            C0211a c0211a = null;
            switch (C0211a.f13633a[eVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new b(c0211a);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003?\u0000", new Object[]{"valueMode_", "valueModeCase_", "fieldPath_"});
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

        public String n() {
            return this.fieldPath_;
        }

        public EnumC0214c o() {
            if (this.valueModeCase_ != 2) {
                return EnumC0214c.ORDER_UNSPECIFIED;
            }
            EnumC0214c enumC0214cC = EnumC0214c.c(((Integer) this.valueMode_).intValue());
            return enumC0214cC == null ? EnumC0214c.UNRECOGNIZED : enumC0214cC;
        }

        public d p() {
            return d.c(this.valueModeCase_);
        }

        public final void r(EnumC0212a enumC0212a) {
            this.valueMode_ = Integer.valueOf(enumC0212a.getNumber());
            this.valueModeCase_ = 3;
        }

        public final void s(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        public final void t(EnumC0214c enumC0214c) {
            this.valueMode_ = Integer.valueOf(enumC0214c.getNumber());
            this.valueModeCase_ = 2;
        }
    }

    /* JADX INFO: renamed from: n2.a$d */
    public enum d implements C.c {
        QUERY_SCOPE_UNSPECIFIED(0),
        COLLECTION(1),
        COLLECTION_GROUP(2),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C.d f13656f = new C0216a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13658a;

        /* JADX INFO: renamed from: n2.a$d$a, reason: collision with other inner class name */
        public class C0216a implements C.d {
            @Override // com.google.protobuf.C.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i4) {
                return d.c(i4);
            }
        }

        d(int i4) {
            this.f13658a = i4;
        }

        public static d c(int i4) {
            if (i4 == 0) {
                return QUERY_SCOPE_UNSPECIFIED;
            }
            if (i4 == 1) {
                return COLLECTION;
            }
            if (i4 != 2) {
                return null;
            }
            return COLLECTION_GROUP;
        }

        @Override // com.google.protobuf.C.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.f13658a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        C1632a c1632a = new C1632a();
        DEFAULT_INSTANCE = c1632a;
        AbstractC1077y.registerDefaultInstance(C1632a.class, c1632a);
    }

    public static b p() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static C1632a q(byte[] bArr) {
        return (C1632a) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        C0211a c0211a = null;
        switch (C0211a.f13633a[eVar.ordinal()]) {
            case 1:
                return new C1632a();
            case 2:
                return new b(c0211a);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\f\u0003\u001b\u0004\f", new Object[]{"name_", "queryScope_", "fields_", c.class, "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1632a.class) {
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

    public final void m(c cVar) {
        cVar.getClass();
        n();
        this.fields_.add(cVar);
    }

    public final void n() {
        C.i iVar = this.fields_;
        if (iVar.e()) {
            return;
        }
        this.fields_ = AbstractC1077y.mutableCopy(iVar);
    }

    public List o() {
        return this.fields_;
    }

    public final void r(d dVar) {
        this.queryScope_ = dVar.getNumber();
    }
}
