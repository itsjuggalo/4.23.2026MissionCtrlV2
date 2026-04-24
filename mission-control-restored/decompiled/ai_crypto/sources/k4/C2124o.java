package k4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;
import java.util.List;

/* JADX INFO: renamed from: k4.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2124o extends AbstractC1255y implements W {
    private static final C2124o DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile f0 PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private t0 readTime_;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private String document_ = "";
    private C.d removedTargetIds_ = AbstractC1255y.z();

    /* JADX INFO: renamed from: k4.o$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18053a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18053a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18053a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18053a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18053a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18053a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18053a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18053a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.o$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C2124o.DEFAULT_INSTANCE);
        }
    }

    static {
        C2124o c2124o = new C2124o();
        DEFAULT_INSTANCE = c2124o;
        AbstractC1255y.V(C2124o.class, c2124o);
    }

    public static C2124o a0() {
        return DEFAULT_INSTANCE;
    }

    public String b0() {
        return this.document_;
    }

    public List c0() {
        return this.removedTargetIds_;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18053a[dVar.ordinal()]) {
            case 1:
                return new C2124o();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0001\u0000\u0001Ȉ\u0002'\u0004ဉ\u0000", new Object[]{"bitField0_", "document_", "removedTargetIds_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2124o.class) {
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
