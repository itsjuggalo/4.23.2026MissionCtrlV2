package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.X;
import com.google.protobuf.g0;

/* JADX INFO: loaded from: classes.dex */
public final class t extends AbstractC1077y implements X {
    private static final t DEFAULT_INSTANCE;
    public static final int DOCUMENT_CHANGE_FIELD_NUMBER = 3;
    public static final int DOCUMENT_DELETE_FIELD_NUMBER = 4;
    public static final int DOCUMENT_REMOVE_FIELD_NUMBER = 6;
    public static final int FILTER_FIELD_NUMBER = 5;
    private static volatile g0 PARSER = null;
    public static final int TARGET_CHANGE_FIELD_NUMBER = 2;
    private int responseTypeCase_ = 0;
    private Object responseType_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14079a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14079a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14079a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14079a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14079a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14079a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14079a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14079a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(t.DEFAULT_INSTANCE);
        }
    }

    public enum c {
        TARGET_CHANGE(2),
        DOCUMENT_CHANGE(3),
        DOCUMENT_DELETE(4),
        DOCUMENT_REMOVE(6),
        FILTER(5),
        RESPONSETYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14087a;

        c(int i4) {
            this.f14087a = i4;
        }

        public static c c(int i4) {
            if (i4 == 0) {
                return RESPONSETYPE_NOT_SET;
            }
            if (i4 == 2) {
                return TARGET_CHANGE;
            }
            if (i4 == 3) {
                return DOCUMENT_CHANGE;
            }
            if (i4 == 4) {
                return DOCUMENT_DELETE;
            }
            if (i4 == 5) {
                return FILTER;
            }
            if (i4 != 6) {
                return null;
            }
            return DOCUMENT_REMOVE;
        }
    }

    static {
        t tVar = new t();
        DEFAULT_INSTANCE = tVar;
        AbstractC1077y.registerDefaultInstance(t.class, tVar);
    }

    public static t k() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14079a[eVar.ordinal()]) {
            case 1:
                return new t();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0002\u0006\u0005\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"responseType_", "responseTypeCase_", C1696B.class, l.class, m.class, q.class, o.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (t.class) {
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

    public l l() {
        return this.responseTypeCase_ == 3 ? (l) this.responseType_ : l.k();
    }

    public m m() {
        return this.responseTypeCase_ == 4 ? (m) this.responseType_ : m.k();
    }

    public o n() {
        return this.responseTypeCase_ == 6 ? (o) this.responseType_ : o.k();
    }

    public q o() {
        return this.responseTypeCase_ == 5 ? (q) this.responseType_ : q.l();
    }

    public c p() {
        return c.c(this.responseTypeCase_);
    }

    public C1696B q() {
        return this.responseTypeCase_ == 2 ? (C1696B) this.responseType_ : C1696B.l();
    }
}
