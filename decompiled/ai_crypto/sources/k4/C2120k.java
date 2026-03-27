package k4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.B0;
import com.google.protobuf.N;
import com.google.protobuf.O;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: k4.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2120k extends AbstractC1255y implements W {
    public static final int CREATE_TIME_FIELD_NUMBER = 3;
    private static final C2120k DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile f0 PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 4;
    private int bitField0_;
    private t0 createTime_;
    private O fields_ = O.e();
    private String name_ = "";
    private t0 updateTime_;

    /* JADX INFO: renamed from: k4.k$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18048a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18048a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18048a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18048a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18048a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18048a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18048a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18048a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.k$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b w(Map map) {
            q();
            ((C2120k) this.f12868b).f0().putAll(map);
            return this;
        }

        public b x(String str) {
            q();
            ((C2120k) this.f12868b).l0(str);
            return this;
        }

        public b y(t0 t0Var) {
            q();
            ((C2120k) this.f12868b).m0(t0Var);
            return this;
        }

        public b() {
            super(C2120k.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.k$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final N f18049a = N.d(B0.b.f12521k, "", B0.b.f12523m, C2105D.o0());
    }

    static {
        C2120k c2120k = new C2120k();
        DEFAULT_INSTANCE = c2120k;
        AbstractC1255y.V(C2120k.class, c2120k);
    }

    public static C2120k d0() {
        return DEFAULT_INSTANCE;
    }

    public static b k0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(String str) {
        str.getClass();
        this.name_ = str;
    }

    public Map e0() {
        return Collections.unmodifiableMap(i0());
    }

    public final Map f0() {
        return j0();
    }

    public String g0() {
        return this.name_;
    }

    public t0 h0() {
        t0 t0Var = this.updateTime_;
        return t0Var == null ? t0.c0() : t0Var;
    }

    public final O i0() {
        return this.fields_;
    }

    public final O j0() {
        if (!this.fields_.j()) {
            this.fields_ = this.fields_.m();
        }
        return this.fields_;
    }

    public final void m0(t0 t0Var) {
        t0Var.getClass();
        this.updateTime_ = t0Var;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18048a[dVar.ordinal()]) {
            case 1:
                return new C2120k();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u00022\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"bitField0_", "name_", "fields_", c.f18049a, "createTime_", "updateTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2120k.class) {
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
