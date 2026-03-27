package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.g0;
import java.util.List;
import p2.p;

/* JADX INFO: renamed from: p2.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1699E extends AbstractC1077y implements InterfaceC1700F {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final C1699E DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile g0 PARSER = null;
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
    private C.i updateTransforms_ = AbstractC1077y.emptyProtobufList();

    /* JADX INFO: renamed from: p2.E$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14022a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14022a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14022a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14022a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14022a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14022a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14022a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14022a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.E$b */
    public static final class b extends AbstractC1077y.a implements InterfaceC1700F {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(p.c cVar) {
            copyOnWrite();
            ((C1699E) this.instance).q(cVar);
            return this;
        }

        public b g(v vVar) {
            copyOnWrite();
            ((C1699E) this.instance).H(vVar);
            return this;
        }

        public b h(String str) {
            copyOnWrite();
            ((C1699E) this.instance).I(str);
            return this;
        }

        public b i(k kVar) {
            copyOnWrite();
            ((C1699E) this.instance).J(kVar);
            return this;
        }

        public b j(n nVar) {
            copyOnWrite();
            ((C1699E) this.instance).K(nVar);
            return this;
        }

        public b k(String str) {
            copyOnWrite();
            ((C1699E) this.instance).L(str);
            return this;
        }

        public b() {
            super(C1699E.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: p2.E$c */
    public enum c {
        UPDATE(1),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14029a;

        c(int i4) {
            this.f14029a = i4;
        }

        public static c c(int i4) {
            if (i4 == 0) {
                return OPERATION_NOT_SET;
            }
            if (i4 == 1) {
                return UPDATE;
            }
            if (i4 == 2) {
                return DELETE;
            }
            if (i4 == 5) {
                return VERIFY;
            }
            if (i4 != 6) {
                return null;
            }
            return TRANSFORM;
        }
    }

    static {
        C1699E c1699e = new C1699E();
        DEFAULT_INSTANCE = c1699e;
        AbstractC1077y.registerDefaultInstance(C1699E.class, c1699e);
    }

    public static b E() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b F(C1699E c1699e) {
        return (b) DEFAULT_INSTANCE.createBuilder(c1699e);
    }

    public static C1699E G(byte[] bArr) {
        return (C1699E) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public boolean A() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean B() {
        return this.operationCase_ == 6;
    }

    public boolean C() {
        return this.operationCase_ == 1;
    }

    public boolean D() {
        return (this.bitField0_ & 1) != 0;
    }

    public final void H(v vVar) {
        vVar.getClass();
        this.currentDocument_ = vVar;
        this.bitField0_ |= 2;
    }

    public final void I(String str) {
        str.getClass();
        this.operationCase_ = 2;
        this.operation_ = str;
    }

    public final void J(k kVar) {
        kVar.getClass();
        this.operation_ = kVar;
        this.operationCase_ = 1;
    }

    public final void K(n nVar) {
        nVar.getClass();
        this.updateMask_ = nVar;
        this.bitField0_ |= 1;
    }

    public final void L(String str) {
        str.getClass();
        this.operationCase_ = 5;
        this.operation_ = str;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14022a[eVar.ordinal()]) {
            case 1:
                return new C1699E();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003ဉ\u0000\u0004ဉ\u0001\u0005Ȼ\u0000\u0006<\u0000\u0007\u001b", new Object[]{"operation_", "operationCase_", "bitField0_", k.class, "updateMask_", "currentDocument_", p.class, "updateTransforms_", p.c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1699E.class) {
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

    public final void q(p.c cVar) {
        cVar.getClass();
        r();
        this.updateTransforms_.add(cVar);
    }

    public final void r() {
        C.i iVar = this.updateTransforms_;
        if (iVar.e()) {
            return;
        }
        this.updateTransforms_ = AbstractC1077y.mutableCopy(iVar);
    }

    public v s() {
        v vVar = this.currentDocument_;
        return vVar == null ? v.n() : vVar;
    }

    public String t() {
        return this.operationCase_ == 2 ? (String) this.operation_ : "";
    }

    public c u() {
        return c.c(this.operationCase_);
    }

    public p v() {
        return this.operationCase_ == 6 ? (p) this.operation_ : p.k();
    }

    public k w() {
        return this.operationCase_ == 1 ? (k) this.operation_ : k.n();
    }

    public n x() {
        n nVar = this.updateMask_;
        return nVar == null ? n.n() : nVar;
    }

    public List y() {
        return this.updateTransforms_;
    }

    public String z() {
        return this.operationCase_ == 5 ? (String) this.operation_ : "";
    }
}
