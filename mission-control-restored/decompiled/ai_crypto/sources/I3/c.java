package I3;

import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;
import k4.C2102A;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AbstractC1255y implements W {
    private static final c DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile f0 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private t0 lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private t0 snapshotVersion_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private AbstractC1240i resumeToken_ = AbstractC1240i.f12650b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3023a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f3023a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3023a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3023a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3023a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3023a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3023a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3023a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(C2102A.d dVar) {
            q();
            ((c) this.f12868b).w0(dVar);
            return this;
        }

        public b B(AbstractC1240i abstractC1240i) {
            q();
            ((c) this.f12868b).x0(abstractC1240i);
            return this;
        }

        public b C(t0 t0Var) {
            q();
            ((c) this.f12868b).y0(t0Var);
            return this;
        }

        public b D(int i7) {
            q();
            ((c) this.f12868b).z0(i7);
            return this;
        }

        public b w() {
            q();
            ((c) this.f12868b).i0();
            return this;
        }

        public b x(C2102A.c cVar) {
            q();
            ((c) this.f12868b).t0(cVar);
            return this;
        }

        public b y(t0 t0Var) {
            q();
            ((c) this.f12868b).u0(t0Var);
            return this;
        }

        public b z(long j7) {
            q();
            ((c) this.f12868b).v0(j7);
            return this;
        }

        public b() {
            super(c.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: I3.c$c, reason: collision with other inner class name */
    public enum EnumC0037c {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3028a;

        EnumC0037c(int i7) {
            this.f3028a = i7;
        }

        public static EnumC0037c b(int i7) {
            if (i7 == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (i7 == 5) {
                return QUERY;
            }
            if (i7 != 6) {
                return null;
            }
            return DOCUMENTS;
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        AbstractC1255y.V(c.class, cVar);
    }

    public static b r0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static c s0(byte[] bArr) {
        return (c) AbstractC1255y.R(DEFAULT_INSTANCE, bArr);
    }

    public final void i0() {
        this.lastLimboFreeSnapshotVersion_ = null;
        this.bitField0_ &= -3;
    }

    public C2102A.c j0() {
        return this.targetTypeCase_ == 6 ? (C2102A.c) this.targetType_ : C2102A.c.d0();
    }

    public t0 k0() {
        t0 t0Var = this.lastLimboFreeSnapshotVersion_;
        return t0Var == null ? t0.c0() : t0Var;
    }

    public long l0() {
        return this.lastListenSequenceNumber_;
    }

    public C2102A.d m0() {
        return this.targetTypeCase_ == 5 ? (C2102A.d) this.targetType_ : C2102A.d.c0();
    }

    public AbstractC1240i n0() {
        return this.resumeToken_;
    }

    public t0 o0() {
        t0 t0Var = this.snapshotVersion_;
        return t0Var == null ? t0.c0() : t0Var;
    }

    public int p0() {
        return this.targetId_;
    }

    public EnumC0037c q0() {
        return EnumC0037c.b(this.targetTypeCase_);
    }

    public final void t0(C2102A.c cVar) {
        cVar.getClass();
        this.targetType_ = cVar;
        this.targetTypeCase_ = 6;
    }

    public final void u0(t0 t0Var) {
        t0Var.getClass();
        this.lastLimboFreeSnapshotVersion_ = t0Var;
        this.bitField0_ |= 2;
    }

    public final void v0(long j7) {
        this.lastListenSequenceNumber_ = j7;
    }

    public final void w0(C2102A.d dVar) {
        dVar.getClass();
        this.targetType_ = dVar;
        this.targetTypeCase_ = 5;
    }

    public final void x0(AbstractC1240i abstractC1240i) {
        abstractC1240i.getClass();
        this.resumeToken_ = abstractC1240i;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f3023a[dVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003\n\u0004\u0002\u0005<\u0000\u0006<\u0000\u0007ဉ\u0001", new Object[]{"targetType_", "targetTypeCase_", "bitField0_", "targetId_", "snapshotVersion_", "resumeToken_", "lastListenSequenceNumber_", C2102A.d.class, C2102A.c.class, "lastLimboFreeSnapshotVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (c.class) {
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

    public final void y0(t0 t0Var) {
        t0Var.getClass();
        this.snapshotVersion_ = t0Var;
        this.bitField0_ |= 1;
    }

    public final void z0(int i7) {
        this.targetId_ = i7;
    }
}
