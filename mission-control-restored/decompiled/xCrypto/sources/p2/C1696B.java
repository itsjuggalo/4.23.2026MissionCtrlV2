package p2;

import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import com.google.protobuf.u0;
import java.util.List;
import z2.C2007a;

/* JADX INFO: renamed from: p2.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1696B extends AbstractC1077y implements X {
    public static final int CAUSE_FIELD_NUMBER = 3;
    private static final C1696B DEFAULT_INSTANCE;
    private static volatile g0 PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private C2007a cause_;
    private u0 readTime_;
    private int targetChangeType_;
    private int targetIdsMemoizedSerializedSize = -1;
    private C.g targetIds_ = AbstractC1077y.emptyIntList();
    private AbstractC1062i resumeToken_ = AbstractC1062i.f11025b;

    /* JADX INFO: renamed from: p2.B$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13996a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f13996a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13996a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13996a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13996a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13996a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13996a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13996a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.B$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C1696B.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: p2.B$c */
    public enum c implements C.c {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final C.d f14003h = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14005a;

        /* JADX INFO: renamed from: p2.B$c$a */
        public class a implements C.d {
            @Override // com.google.protobuf.C.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i4) {
                return c.c(i4);
            }
        }

        c(int i4) {
            this.f14005a = i4;
        }

        public static c c(int i4) {
            if (i4 == 0) {
                return NO_CHANGE;
            }
            if (i4 == 1) {
                return ADD;
            }
            if (i4 == 2) {
                return REMOVE;
            }
            if (i4 == 3) {
                return CURRENT;
            }
            if (i4 != 4) {
                return null;
            }
            return RESET;
        }

        @Override // com.google.protobuf.C.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.f14005a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        C1696B c1696b = new C1696B();
        DEFAULT_INSTANCE = c1696b;
        AbstractC1077y.registerDefaultInstance(C1696B.class, c1696b);
    }

    public static C1696B l() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f13996a[eVar.ordinal()]) {
            case 1:
                return new C1696B();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0000\u0001\f\u0002'\u0003ဉ\u0000\u0004\n\u0006ဉ\u0001", new Object[]{"bitField0_", "targetChangeType_", "targetIds_", "cause_", "resumeToken_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1696B.class) {
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

    public u0 getReadTime() {
        u0 u0Var = this.readTime_;
        return u0Var == null ? u0.m() : u0Var;
    }

    public AbstractC1062i getResumeToken() {
        return this.resumeToken_;
    }

    public C2007a k() {
        C2007a c2007a = this.cause_;
        return c2007a == null ? C2007a.l() : c2007a;
    }

    public c m() {
        c cVarC = c.c(this.targetChangeType_);
        return cVarC == null ? c.UNRECOGNIZED : cVarC;
    }

    public int n() {
        return this.targetIds_.size();
    }

    public List o() {
        return this.targetIds_;
    }
}
