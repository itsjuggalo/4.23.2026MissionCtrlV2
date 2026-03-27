package I3;

import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;
import k4.C2106E;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AbstractC1255y implements W {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    private static final e DEFAULT_INSTANCE;
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile f0 PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private int batchId_;
    private int bitField0_;
    private t0 localWriteTime_;
    private C.e writes_ = AbstractC1255y.A();
    private C.e baseWrites_ = AbstractC1255y.A();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3030a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f3030a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3030a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3030a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3030a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3030a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3030a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3030a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b w(C2106E c2106e) {
            q();
            ((e) this.f12868b).e0(c2106e);
            return this;
        }

        public b x(C2106E c2106e) {
            q();
            ((e) this.f12868b).f0(c2106e);
            return this;
        }

        public b y(int i7) {
            q();
            ((e) this.f12868b).r0(i7);
            return this;
        }

        public b z(t0 t0Var) {
            q();
            ((e) this.f12868b).s0(t0Var);
            return this;
        }

        public b() {
            super(e.DEFAULT_INSTANCE);
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        AbstractC1255y.V(e.class, eVar);
    }

    public static b o0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static e p0(AbstractC1240i abstractC1240i) {
        return (e) AbstractC1255y.P(DEFAULT_INSTANCE, abstractC1240i);
    }

    public static e q0(byte[] bArr) {
        return (e) AbstractC1255y.R(DEFAULT_INSTANCE, bArr);
    }

    public final void e0(C2106E c2106e) {
        c2106e.getClass();
        g0();
        this.baseWrites_.add(c2106e);
    }

    public final void f0(C2106E c2106e) {
        c2106e.getClass();
        h0();
        this.writes_.add(c2106e);
    }

    public final void g0() {
        C.e eVar = this.baseWrites_;
        if (eVar.f()) {
            return;
        }
        this.baseWrites_ = AbstractC1255y.L(eVar);
    }

    public final void h0() {
        C.e eVar = this.writes_;
        if (eVar.f()) {
            return;
        }
        this.writes_ = AbstractC1255y.L(eVar);
    }

    public C2106E i0(int i7) {
        return (C2106E) this.baseWrites_.get(i7);
    }

    public int j0() {
        return this.baseWrites_.size();
    }

    public int k0() {
        return this.batchId_;
    }

    public t0 l0() {
        t0 t0Var = this.localWriteTime_;
        return t0Var == null ? t0.c0() : t0Var;
    }

    public C2106E m0(int i7) {
        return (C2106E) this.writes_.get(i7);
    }

    public int n0() {
        return this.writes_.size();
    }

    public final void r0(int i7) {
        this.batchId_ = i7;
    }

    public final void s0(t0 t0Var) {
        t0Var.getClass();
        this.localWriteTime_ = t0Var;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f3030a[dVar.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003ဉ\u0000\u0004\u001b", new Object[]{"bitField0_", "batchId_", "writes_", C2106E.class, "localWriteTime_", "baseWrites_", C2106E.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (e.class) {
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
