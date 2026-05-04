package bb;

import bb.p;
import com.google.protobuf.c0;
import com.google.protobuf.e1;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends com.google.protobuf.y implements v0 {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final e0 DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile e1 PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    public static final int UPDATE_TRANSFORMS_FIELD_NUMBER = 7;
    public static final int VERIFY_FIELD_NUMBER = 5;
    private int bitField0_;
    private v currentDocument_;
    private Object operation_;
    private n updateMask_;
    private int operationCase_ = 0;
    private c0.e updateTransforms_ = com.google.protobuf.y.A();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3186a;

        static {
            int[] iArr = new int[y.d.values().length];
            f3186a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3186a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3186a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3186a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3186a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3186a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3186a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y.a implements v0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(k kVar) {
            q();
            ((e0) this.f7244b).z0(kVar);
            return this;
        }

        public b B(n nVar) {
            q();
            ((e0) this.f7244b).A0(nVar);
            return this;
        }

        public b C(String str) {
            q();
            ((e0) this.f7244b).B0(str);
            return this;
        }

        public b x(p.c cVar) {
            q();
            ((e0) this.f7244b).g0(cVar);
            return this;
        }

        public b y(v vVar) {
            q();
            ((e0) this.f7244b).x0(vVar);
            return this;
        }

        public b z(String str) {
            q();
            ((e0) this.f7244b).y0(str);
            return this;
        }

        public b() {
            super(e0.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c {
        UPDATE(1),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3193a;

        c(int i10) {
            this.f3193a = i10;
        }

        public static c b(int i10) {
            if (i10 == 0) {
                return OPERATION_NOT_SET;
            }
            if (i10 == 1) {
                return UPDATE;
            }
            if (i10 == 2) {
                return DELETE;
            }
            if (i10 == 5) {
                return VERIFY;
            }
            if (i10 != 6) {
                return null;
            }
            return TRANSFORM;
        }
    }

    static {
        e0 e0Var = new e0();
        DEFAULT_INSTANCE = e0Var;
        com.google.protobuf.y.V(e0.class, e0Var);
    }

    public static b u0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static b v0(e0 e0Var) {
        return (b) DEFAULT_INSTANCE.v(e0Var);
    }

    public static e0 w0(byte[] bArr) {
        return (e0) com.google.protobuf.y.R(DEFAULT_INSTANCE, bArr);
    }

    public final void A0(n nVar) {
        nVar.getClass();
        this.updateMask_ = nVar;
        this.bitField0_ |= 1;
    }

    public final void B0(String str) {
        str.getClass();
        this.operationCase_ = 5;
        this.operation_ = str;
    }

    public final void g0(p.c cVar) {
        cVar.getClass();
        h0();
        this.updateTransforms_.add(cVar);
    }

    public final void h0() {
        c0.e eVar = this.updateTransforms_;
        if (eVar.m()) {
            return;
        }
        this.updateTransforms_ = com.google.protobuf.y.L(eVar);
    }

    public v i0() {
        v vVar = this.currentDocument_;
        return vVar == null ? v.d0() : vVar;
    }

    public String j0() {
        return this.operationCase_ == 2 ? (String) this.operation_ : "";
    }

    public c k0() {
        return c.b(this.operationCase_);
    }

    public p l0() {
        return this.operationCase_ == 6 ? (p) this.operation_ : p.a0();
    }

    public k m0() {
        return this.operationCase_ == 1 ? (k) this.operation_ : k.d0();
    }

    public n n0() {
        n nVar = this.updateMask_;
        return nVar == null ? n.d0() : nVar;
    }

    public List o0() {
        return this.updateTransforms_;
    }

    public String p0() {
        return this.operationCase_ == 5 ? (String) this.operation_ : "";
    }

    public boolean q0() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean r0() {
        return this.operationCase_ == 6;
    }

    public boolean s0() {
        return this.operationCase_ == 1;
    }

    public boolean t0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final void x0(v vVar) {
        vVar.getClass();
        this.currentDocument_ = vVar;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f3186a[dVar.ordinal()]) {
            case 1:
                return new e0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003ဉ\u0000\u0004ဉ\u0001\u0005Ȼ\u0000\u0006<\u0000\u0007\u001b", new Object[]{"operation_", "operationCase_", "bitField0_", k.class, "updateMask_", "currentDocument_", p.class, "updateTransforms_", p.c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (e0.class) {
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

    public final void y0(String str) {
        str.getClass();
        this.operationCase_ = 2;
        this.operation_ = str;
    }

    public final void z0(k kVar) {
        kVar.getClass();
        this.operation_ = kVar;
        this.operationCase_ = 1;
    }
}
