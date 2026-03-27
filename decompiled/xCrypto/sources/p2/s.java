package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C0;
import com.google.protobuf.O;
import com.google.protobuf.P;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class s extends AbstractC1077y implements X {
    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final s DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile g0 PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private Object targetChange_;
    private int targetChangeCase_ = 0;
    private P labels_ = P.e();
    private String database_ = "";

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14077a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14077a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14077a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14077a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14077a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14077a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14077a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14077a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(Map map) {
            copyOnWrite();
            ((s) this.instance).p().putAll(map);
            return this;
        }

        public b g(C1695A c1695a) {
            copyOnWrite();
            ((s) this.instance).s(c1695a);
            return this;
        }

        public b h(String str) {
            copyOnWrite();
            ((s) this.instance).t(str);
            return this;
        }

        public b i(int i4) {
            copyOnWrite();
            ((s) this.instance).u(i4);
            return this;
        }

        public b() {
            super(s.DEFAULT_INSTANCE);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final O f14078a;

        static {
            C0.b bVar = C0.b.f10899k;
            f14078a = O.d(bVar, "", bVar, "");
        }
    }

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        AbstractC1077y.registerDefaultInstance(s.class, sVar);
    }

    public static s o() {
        return DEFAULT_INSTANCE;
    }

    public static b r() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        str.getClass();
        this.database_ = str;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14077a[eVar.ordinal()]) {
            case 1:
                return new s();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002<\u0000\u00037\u0000\u00042", new Object[]{"targetChange_", "targetChangeCase_", "database_", C1695A.class, "labels_", c.f14078a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (s.class) {
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

    public final Map p() {
        return q();
    }

    public final P q() {
        if (!this.labels_.i()) {
            this.labels_ = this.labels_.l();
        }
        return this.labels_;
    }

    public final void s(C1695A c1695a) {
        c1695a.getClass();
        this.targetChange_ = c1695a;
        this.targetChangeCase_ = 2;
    }

    public final void u(int i4) {
        this.targetChangeCase_ = 3;
        this.targetChange_ = Integer.valueOf(i4);
    }
}
