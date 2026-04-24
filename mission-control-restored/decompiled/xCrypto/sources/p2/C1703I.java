package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import com.google.protobuf.u0;

/* JADX INFO: renamed from: p2.I, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1703I extends AbstractC1077y implements X {
    private static final C1703I DEFAULT_INSTANCE;
    private static volatile g0 PARSER = null;
    public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
    public static final int UPDATE_TIME_FIELD_NUMBER = 1;
    private int bitField0_;
    private C.i transformResults_ = AbstractC1077y.emptyProtobufList();
    private u0 updateTime_;

    /* JADX INFO: renamed from: p2.I$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14033a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14033a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14033a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14033a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14033a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14033a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14033a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14033a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.I$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C1703I.DEFAULT_INSTANCE);
        }
    }

    static {
        C1703I c1703i = new C1703I();
        DEFAULT_INSTANCE = c1703i;
        AbstractC1077y.registerDefaultInstance(C1703I.class, c1703i);
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14033a[eVar.ordinal()]) {
            case 1:
                return new C1703I();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "updateTime_", "transformResults_", C1698D.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1703I.class) {
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

    public C1698D k(int i4) {
        return (C1698D) this.transformResults_.get(i4);
    }

    public int l() {
        return this.transformResults_.size();
    }

    public u0 m() {
        u0 u0Var = this.updateTime_;
        return u0Var == null ? u0.m() : u0Var;
    }
}
