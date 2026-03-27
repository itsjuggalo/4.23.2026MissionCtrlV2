package k4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import java.util.List;
import k4.C2125p;

/* JADX INFO: renamed from: k4.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2106E extends AbstractC1255y implements W {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final C2106E DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile f0 PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    public static final int UPDATE_TRANSFORMS_FIELD_NUMBER = 7;
    public static final int VERIFY_FIELD_NUMBER = 5;
    private int bitField0_;
    private C2131v currentDocument_;
    private Object operation_;
    private C2123n updateMask_;
    private int operationCase_ = 0;
    private C.e updateTransforms_ = AbstractC1255y.A();

    /* JADX INFO: renamed from: k4.E$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18021a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18021a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18021a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18021a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18021a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18021a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18021a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18021a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.E$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(C2123n c2123n) {
            q();
            ((C2106E) this.f12868b).A0(c2123n);
            return this;
        }

        public b B(String str) {
            q();
            ((C2106E) this.f12868b).B0(str);
            return this;
        }

        public b w(C2125p.c cVar) {
            q();
            ((C2106E) this.f12868b).g0(cVar);
            return this;
        }

        public b x(C2131v c2131v) {
            q();
            ((C2106E) this.f12868b).x0(c2131v);
            return this;
        }

        public b y(String str) {
            q();
            ((C2106E) this.f12868b).y0(str);
            return this;
        }

        public b z(C2120k c2120k) {
            q();
            ((C2106E) this.f12868b).z0(c2120k);
            return this;
        }

        public b() {
            super(C2106E.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.E$c */
    public enum c {
        UPDATE(1),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18028a;

        c(int i7) {
            this.f18028a = i7;
        }

        public static c b(int i7) {
            if (i7 == 0) {
                return OPERATION_NOT_SET;
            }
            if (i7 == 1) {
                return UPDATE;
            }
            if (i7 == 2) {
                return DELETE;
            }
            if (i7 == 5) {
                return VERIFY;
            }
            if (i7 != 6) {
                return null;
            }
            return TRANSFORM;
        }
    }

    static {
        C2106E c2106e = new C2106E();
        DEFAULT_INSTANCE = c2106e;
        AbstractC1255y.V(C2106E.class, c2106e);
    }

    public static b u0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static b v0(C2106E c2106e) {
        return (b) DEFAULT_INSTANCE.v(c2106e);
    }

    public static C2106E w0(byte[] bArr) {
        return (C2106E) AbstractC1255y.R(DEFAULT_INSTANCE, bArr);
    }

    public final void A0(C2123n c2123n) {
        c2123n.getClass();
        this.updateMask_ = c2123n;
        this.bitField0_ |= 1;
    }

    public final void B0(String str) {
        str.getClass();
        this.operationCase_ = 5;
        this.operation_ = str;
    }

    public final void g0(C2125p.c cVar) {
        cVar.getClass();
        h0();
        this.updateTransforms_.add(cVar);
    }

    public final void h0() {
        C.e eVar = this.updateTransforms_;
        if (eVar.f()) {
            return;
        }
        this.updateTransforms_ = AbstractC1255y.L(eVar);
    }

    public C2131v i0() {
        C2131v c2131v = this.currentDocument_;
        return c2131v == null ? C2131v.d0() : c2131v;
    }

    public String j0() {
        return this.operationCase_ == 2 ? (String) this.operation_ : "";
    }

    public c k0() {
        return c.b(this.operationCase_);
    }

    public C2125p l0() {
        return this.operationCase_ == 6 ? (C2125p) this.operation_ : C2125p.a0();
    }

    public C2120k m0() {
        return this.operationCase_ == 1 ? (C2120k) this.operation_ : C2120k.d0();
    }

    public C2123n n0() {
        C2123n c2123n = this.updateMask_;
        return c2123n == null ? C2123n.d0() : c2123n;
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

    public final void x0(C2131v c2131v) {
        c2131v.getClass();
        this.currentDocument_ = c2131v;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18021a[dVar.ordinal()]) {
            case 1:
                return new C2106E();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003ဉ\u0000\u0004ဉ\u0001\u0005Ȼ\u0000\u0006<\u0000\u0007\u001b", new Object[]{"operation_", "operationCase_", "bitField0_", C2120k.class, "updateMask_", "currentDocument_", C2125p.class, "updateTransforms_", C2125p.c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2106E.class) {
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

    public final void y0(String str) {
        str.getClass();
        this.operationCase_ = 2;
        this.operation_ = str;
    }

    public final void z0(C2120k c2120k) {
        c2120k.getClass();
        this.operation_ = c2120k;
        this.operationCase_ = 1;
    }
}
