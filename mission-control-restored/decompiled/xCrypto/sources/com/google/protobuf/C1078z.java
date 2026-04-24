package com.google.protobuf;

import com.google.protobuf.AbstractC1077y;

/* JADX INFO: renamed from: com.google.protobuf.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1078z extends AbstractC1077y implements X {
    private static final C1078z DEFAULT_INSTANCE;
    private static volatile g0 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    /* JADX INFO: renamed from: com.google.protobuf.z$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11273a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f11273a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11273a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11273a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11273a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11273a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11273a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11273a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.z$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(int i4) {
            copyOnWrite();
            ((C1078z) this.instance).o(i4);
            return this;
        }

        public b() {
            super(C1078z.DEFAULT_INSTANCE);
        }
    }

    static {
        C1078z c1078z = new C1078z();
        DEFAULT_INSTANCE = c1078z;
        AbstractC1077y.registerDefaultInstance(C1078z.class, c1078z);
    }

    public static C1078z l() {
        return DEFAULT_INSTANCE;
    }

    public static b n() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f11273a[eVar.ordinal()]) {
            case 1:
                return new C1078z();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1078z.class) {
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

    public int m() {
        return this.value_;
    }

    public final void o(int i4) {
        this.value_ = i4;
    }
}
