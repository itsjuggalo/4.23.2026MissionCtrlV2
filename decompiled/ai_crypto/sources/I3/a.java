package I3;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import k4.C2120k;

/* JADX INFO: loaded from: classes.dex */
public final class a extends AbstractC1255y implements W {
    private static final a DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 2;
    public static final int HAS_COMMITTED_MUTATIONS_FIELD_NUMBER = 4;
    public static final int NO_DOCUMENT_FIELD_NUMBER = 1;
    private static volatile f0 PARSER = null;
    public static final int UNKNOWN_DOCUMENT_FIELD_NUMBER = 3;
    private int documentTypeCase_ = 0;
    private Object documentType_;
    private boolean hasCommittedMutations_;

    /* JADX INFO: renamed from: I3.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0035a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3015a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f3015a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3015a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3015a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3015a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3015a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3015a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3015a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(C0035a c0035a) {
            this();
        }

        public b w(C2120k c2120k) {
            q();
            ((a) this.f12868b).l0(c2120k);
            return this;
        }

        public b x(boolean z7) {
            q();
            ((a) this.f12868b).m0(z7);
            return this;
        }

        public b y(I3.b bVar) {
            q();
            ((a) this.f12868b).n0(bVar);
            return this;
        }

        public b z(d dVar) {
            q();
            ((a) this.f12868b).o0(dVar);
            return this;
        }

        public b() {
            super(a.DEFAULT_INSTANCE);
        }
    }

    public enum c {
        NO_DOCUMENT(1),
        DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        DOCUMENTTYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3021a;

        c(int i7) {
            this.f3021a = i7;
        }

        public static c b(int i7) {
            if (i7 == 0) {
                return DOCUMENTTYPE_NOT_SET;
            }
            if (i7 == 1) {
                return NO_DOCUMENT;
            }
            if (i7 == 2) {
                return DOCUMENT;
            }
            if (i7 != 3) {
                return null;
            }
            return UNKNOWN_DOCUMENT;
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        AbstractC1255y.V(a.class, aVar);
    }

    public static b j0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static a k0(byte[] bArr) {
        return (a) AbstractC1255y.R(DEFAULT_INSTANCE, bArr);
    }

    public C2120k e0() {
        return this.documentTypeCase_ == 2 ? (C2120k) this.documentType_ : C2120k.d0();
    }

    public c f0() {
        return c.b(this.documentTypeCase_);
    }

    public boolean g0() {
        return this.hasCommittedMutations_;
    }

    public I3.b h0() {
        return this.documentTypeCase_ == 1 ? (I3.b) this.documentType_ : I3.b.c0();
    }

    public d i0() {
        return this.documentTypeCase_ == 3 ? (d) this.documentType_ : d.c0();
    }

    public final void l0(C2120k c2120k) {
        c2120k.getClass();
        this.documentType_ = c2120k;
        this.documentTypeCase_ = 2;
    }

    public final void m0(boolean z7) {
        this.hasCommittedMutations_ = z7;
    }

    public final void n0(I3.b bVar) {
        bVar.getClass();
        this.documentType_ = bVar;
        this.documentTypeCase_ = 1;
    }

    public final void o0(d dVar) {
        dVar.getClass();
        this.documentType_ = dVar;
        this.documentTypeCase_ = 3;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        C0035a c0035a = null;
        switch (C0035a.f3015a[dVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(c0035a);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004\u0007", new Object[]{"documentType_", "documentTypeCase_", I3.b.class, C2120k.class, d.class, "hasCommittedMutations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (a.class) {
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
