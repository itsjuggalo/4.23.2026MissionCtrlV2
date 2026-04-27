package k4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;

/* JADX INFO: renamed from: k4.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2131v extends AbstractC1255y implements W {
    private static final C2131v DEFAULT_INSTANCE;
    public static final int EXISTS_FIELD_NUMBER = 1;
    private static volatile f0 PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 2;
    private int conditionTypeCase_ = 0;
    private Object conditionType_;

    /* JADX INFO: renamed from: k4.v$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18089a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18089a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18089a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18089a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18089a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18089a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18089a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18089a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.v$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b w(boolean z7) {
            q();
            ((C2131v) this.f12868b).h0(z7);
            return this;
        }

        public b x(t0 t0Var) {
            q();
            ((C2131v) this.f12868b).i0(t0Var);
            return this;
        }

        public b() {
            super(C2131v.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.v$c */
    public enum c {
        EXISTS(1),
        UPDATE_TIME(2),
        CONDITIONTYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18094a;

        c(int i7) {
            this.f18094a = i7;
        }

        public static c b(int i7) {
            if (i7 == 0) {
                return CONDITIONTYPE_NOT_SET;
            }
            if (i7 == 1) {
                return EXISTS;
            }
            if (i7 != 2) {
                return null;
            }
            return UPDATE_TIME;
        }
    }

    static {
        C2131v c2131v = new C2131v();
        DEFAULT_INSTANCE = c2131v;
        AbstractC1255y.V(C2131v.class, c2131v);
    }

    public static C2131v d0() {
        return DEFAULT_INSTANCE;
    }

    public static b g0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(t0 t0Var) {
        t0Var.getClass();
        this.conditionType_ = t0Var;
        this.conditionTypeCase_ = 2;
    }

    public c c0() {
        return c.b(this.conditionTypeCase_);
    }

    public boolean e0() {
        if (this.conditionTypeCase_ == 1) {
            return ((Boolean) this.conditionType_).booleanValue();
        }
        return false;
    }

    public t0 f0() {
        return this.conditionTypeCase_ == 2 ? (t0) this.conditionType_ : t0.c0();
    }

    public final void h0(boolean z7) {
        this.conditionTypeCase_ = 1;
        this.conditionType_ = Boolean.valueOf(z7);
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18089a[dVar.ordinal()]) {
            case 1:
                return new C2131v();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001:\u0000\u0002<\u0000", new Object[]{"conditionType_", "conditionTypeCase_", t0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2131v.class) {
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
