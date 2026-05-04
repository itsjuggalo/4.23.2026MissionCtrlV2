package l9;

import bb.e0;
import com.google.protobuf.c0;
import com.google.protobuf.e1;
import com.google.protobuf.i;
import com.google.protobuf.s1;
import com.google.protobuf.v0;
import com.google.protobuf.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends y implements v0 {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    private static final e DEFAULT_INSTANCE;
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile e1 PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private int batchId_;
    private int bitField0_;
    private s1 localWriteTime_;
    private c0.e writes_ = y.A();
    private c0.e baseWrites_ = y.A();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15585a;

        static {
            int[] iArr = new int[y.d.values().length];
            f15585a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15585a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15585a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15585a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15585a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15585a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15585a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y.a implements v0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(s1 s1Var) {
            q();
            ((e) this.f7244b).s0(s1Var);
            return this;
        }

        public b x(e0 e0Var) {
            q();
            ((e) this.f7244b).e0(e0Var);
            return this;
        }

        public b y(e0 e0Var) {
            q();
            ((e) this.f7244b).f0(e0Var);
            return this;
        }

        public b z(int i10) {
            q();
            ((e) this.f7244b).r0(i10);
            return this;
        }

        public b() {
            super(e.DEFAULT_INSTANCE);
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        y.V(e.class, eVar);
    }

    public static b o0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static e p0(i iVar) {
        return (e) y.P(DEFAULT_INSTANCE, iVar);
    }

    public static e q0(byte[] bArr) {
        return (e) y.R(DEFAULT_INSTANCE, bArr);
    }

    public final void e0(e0 e0Var) {
        e0Var.getClass();
        g0();
        this.baseWrites_.add(e0Var);
    }

    public final void f0(e0 e0Var) {
        e0Var.getClass();
        h0();
        this.writes_.add(e0Var);
    }

    public final void g0() {
        c0.e eVar = this.baseWrites_;
        if (eVar.m()) {
            return;
        }
        this.baseWrites_ = y.L(eVar);
    }

    public final void h0() {
        c0.e eVar = this.writes_;
        if (eVar.m()) {
            return;
        }
        this.writes_ = y.L(eVar);
    }

    public e0 i0(int i10) {
        return (e0) this.baseWrites_.get(i10);
    }

    public int j0() {
        return this.baseWrites_.size();
    }

    public int k0() {
        return this.batchId_;
    }

    public s1 l0() {
        s1 s1Var = this.localWriteTime_;
        return s1Var == null ? s1.c0() : s1Var;
    }

    public e0 m0(int i10) {
        return (e0) this.writes_.get(i10);
    }

    public int n0() {
        return this.writes_.size();
    }

    public final void r0(int i10) {
        this.batchId_ = i10;
    }

    public final void s0(s1 s1Var) {
        s1Var.getClass();
        this.localWriteTime_ = s1Var;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f15585a[dVar.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new b(aVar);
            case 3:
                return y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003ဉ\u0000\u0004\u001b", new Object[]{"bitField0_", "batchId_", "writes_", e0.class, "localWriteTime_", "baseWrites_", e0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (e.class) {
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
