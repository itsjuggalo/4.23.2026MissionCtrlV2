package k4;

import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;
import java.util.List;
import u4.C2753a;

/* JADX INFO: renamed from: k4.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2103B extends AbstractC1255y implements W {
    public static final int CAUSE_FIELD_NUMBER = 3;
    private static final C2103B DEFAULT_INSTANCE;
    private static volatile f0 PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private C2753a cause_;
    private t0 readTime_;
    private int targetChangeType_;
    private int targetIdsMemoizedSerializedSize = -1;
    private C.d targetIds_ = AbstractC1255y.z();
    private AbstractC1240i resumeToken_ = AbstractC1240i.f12650b;

    /* JADX INFO: renamed from: k4.B$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17995a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f17995a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17995a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17995a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17995a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17995a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17995a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17995a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.B$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C2103B.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.B$c */
    public enum c implements C.a {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final C.b f18002h = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18004a;

        /* JADX INFO: renamed from: k4.B$c$a */
        public class a implements C.b {
        }

        c(int i7) {
            this.f18004a = i7;
        }

        public static c b(int i7) {
            if (i7 == 0) {
                return NO_CHANGE;
            }
            if (i7 == 1) {
                return ADD;
            }
            if (i7 == 2) {
                return REMOVE;
            }
            if (i7 == 3) {
                return CURRENT;
            }
            if (i7 != 4) {
                return null;
            }
            return RESET;
        }

        @Override // com.google.protobuf.C.a
        public final int d() {
            if (this != UNRECOGNIZED) {
                return this.f18004a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        C2103B c2103b = new C2103B();
        DEFAULT_INSTANCE = c2103b;
        AbstractC1255y.V(C2103B.class, c2103b);
    }

    public static C2103B b0() {
        return DEFAULT_INSTANCE;
    }

    public C2753a a0() {
        C2753a c2753a = this.cause_;
        return c2753a == null ? C2753a.b0() : c2753a;
    }

    public t0 c0() {
        t0 t0Var = this.readTime_;
        return t0Var == null ? t0.c0() : t0Var;
    }

    public AbstractC1240i d0() {
        return this.resumeToken_;
    }

    public c e0() {
        c cVarB = c.b(this.targetChangeType_);
        return cVarB == null ? c.UNRECOGNIZED : cVarB;
    }

    public int f0() {
        return this.targetIds_.size();
    }

    public List g0() {
        return this.targetIds_;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f17995a[dVar.ordinal()]) {
            case 1:
                return new C2103B();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0000\u0001\f\u0002'\u0003ဉ\u0000\u0004\n\u0006ဉ\u0001", new Object[]{"bitField0_", "targetChangeType_", "targetIds_", "cause_", "resumeToken_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2103B.class) {
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
