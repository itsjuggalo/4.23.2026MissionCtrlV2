package l9;

import bb.a0;
import com.google.protobuf.e1;
import com.google.protobuf.i;
import com.google.protobuf.s1;
import com.google.protobuf.v0;
import com.google.protobuf.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends y implements v0 {
    private static final c DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile e1 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private s1 lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private s1 snapshotVersion_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private i resumeToken_ = i.f6998b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15578a;

        static {
            int[] iArr = new int[y.d.values().length];
            f15578a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15578a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15578a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15578a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15578a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15578a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15578a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y.a implements v0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(long j10) {
            q();
            ((c) this.f7244b).v0(j10);
            return this;
        }

        public b B(a0.d dVar) {
            q();
            ((c) this.f7244b).w0(dVar);
            return this;
        }

        public b C(i iVar) {
            q();
            ((c) this.f7244b).x0(iVar);
            return this;
        }

        public b D(s1 s1Var) {
            q();
            ((c) this.f7244b).y0(s1Var);
            return this;
        }

        public b E(int i10) {
            q();
            ((c) this.f7244b).z0(i10);
            return this;
        }

        public b x() {
            q();
            ((c) this.f7244b).i0();
            return this;
        }

        public b y(a0.c cVar) {
            q();
            ((c) this.f7244b).t0(cVar);
            return this;
        }

        public b z(s1 s1Var) {
            q();
            ((c) this.f7244b).u0(s1Var);
            return this;
        }

        public b() {
            super(c.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: l9.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0277c {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15583a;

        EnumC0277c(int i10) {
            this.f15583a = i10;
        }

        public static EnumC0277c b(int i10) {
            if (i10 == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (i10 == 5) {
                return QUERY;
            }
            if (i10 != 6) {
                return null;
            }
            return DOCUMENTS;
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        y.V(c.class, cVar);
    }

    public static b r0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static c s0(byte[] bArr) {
        return (c) y.R(DEFAULT_INSTANCE, bArr);
    }

    public final void i0() {
        this.lastLimboFreeSnapshotVersion_ = null;
        this.bitField0_ &= -3;
    }

    public a0.c j0() {
        return this.targetTypeCase_ == 6 ? (a0.c) this.targetType_ : a0.c.d0();
    }

    public s1 k0() {
        s1 s1Var = this.lastLimboFreeSnapshotVersion_;
        return s1Var == null ? s1.c0() : s1Var;
    }

    public long l0() {
        return this.lastListenSequenceNumber_;
    }

    public a0.d m0() {
        return this.targetTypeCase_ == 5 ? (a0.d) this.targetType_ : a0.d.c0();
    }

    public i n0() {
        return this.resumeToken_;
    }

    public s1 o0() {
        s1 s1Var = this.snapshotVersion_;
        return s1Var == null ? s1.c0() : s1Var;
    }

    public int p0() {
        return this.targetId_;
    }

    public EnumC0277c q0() {
        return EnumC0277c.b(this.targetTypeCase_);
    }

    public final void t0(a0.c cVar) {
        cVar.getClass();
        this.targetType_ = cVar;
        this.targetTypeCase_ = 6;
    }

    public final void u0(s1 s1Var) {
        s1Var.getClass();
        this.lastLimboFreeSnapshotVersion_ = s1Var;
        this.bitField0_ |= 2;
    }

    public final void v0(long j10) {
        this.lastListenSequenceNumber_ = j10;
    }

    public final void w0(a0.d dVar) {
        dVar.getClass();
        this.targetType_ = dVar;
        this.targetTypeCase_ = 5;
    }

    public final void x0(i iVar) {
        iVar.getClass();
        this.resumeToken_ = iVar;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f15578a[dVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new b(aVar);
            case 3:
                return y.N(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003\n\u0004\u0002\u0005<\u0000\u0006<\u0000\u0007ဉ\u0001", new Object[]{"targetType_", "targetTypeCase_", "bitField0_", "targetId_", "snapshotVersion_", "resumeToken_", "lastListenSequenceNumber_", a0.d.class, a0.c.class, "lastLimboFreeSnapshotVersion_"});
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

    public final void y0(s1 s1Var) {
        s1Var.getClass();
        this.snapshotVersion_ = s1Var;
        this.bitField0_ |= 1;
    }

    public final void z0(int i10) {
        this.targetId_ = i10;
    }
}
