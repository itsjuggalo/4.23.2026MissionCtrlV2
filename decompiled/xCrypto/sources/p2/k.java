package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C0;
import com.google.protobuf.O;
import com.google.protobuf.P;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import com.google.protobuf.u0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k extends AbstractC1077y implements X {
    public static final int CREATE_TIME_FIELD_NUMBER = 3;
    private static final k DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g0 PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 4;
    private int bitField0_;
    private u0 createTime_;
    private P fields_ = P.e();
    private String name_ = "";
    private u0 updateTime_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14049a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14049a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14049a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14049a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14049a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14049a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14049a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14049a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
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
            ((k) this.instance).p().putAll(map);
            return this;
        }

        public b g(String str) {
            copyOnWrite();
            ((k) this.instance).setName(str);
            return this;
        }

        public b h(u0 u0Var) {
            copyOnWrite();
            ((k) this.instance).v(u0Var);
            return this;
        }

        public b() {
            super(k.DEFAULT_INSTANCE);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final O f14050a = O.d(C0.b.f10899k, "", C0.b.f10901m, C1698D.y());
    }

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        AbstractC1077y.registerDefaultInstance(k.class, kVar);
    }

    public static k n() {
        return DEFAULT_INSTANCE;
    }

    public static b t() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b u(k kVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(kVar);
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14049a[eVar.ordinal()]) {
            case 1:
                return new k();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u00022\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"bitField0_", "name_", "fields_", c.f14050a, "createTime_", "updateTime_"});
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

    public String getName() {
        return this.name_;
    }

    public Map o() {
        return Collections.unmodifiableMap(r());
    }

    public final Map p() {
        return s();
    }

    public u0 q() {
        u0 u0Var = this.updateTime_;
        return u0Var == null ? u0.m() : u0Var;
    }

    public final P r() {
        return this.fields_;
    }

    public final P s() {
        if (!this.fields_.i()) {
            this.fields_ = this.fields_.l();
        }
        return this.fields_;
    }

    public final void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    public final void v(u0 u0Var) {
        u0Var.getClass();
        this.updateTime_ = u0Var;
        this.bitField0_ |= 2;
    }
}
