package p2;

import com.google.protobuf.AbstractC1050a;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import java.util.List;

/* JADX INFO: renamed from: p2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1713j extends AbstractC1077y implements X {
    public static final int BEFORE_FIELD_NUMBER = 2;
    private static final C1713j DEFAULT_INSTANCE;
    private static volatile g0 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean before_;
    private C.i values_ = AbstractC1077y.emptyProtobufList();

    /* JADX INFO: renamed from: p2.j$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14048a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14048a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14048a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14048a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14048a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14048a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14048a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14048a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.j$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(Iterable iterable) {
            copyOnWrite();
            ((C1713j) this.instance).m(iterable);
            return this;
        }

        public b g(boolean z4) {
            copyOnWrite();
            ((C1713j) this.instance).r(z4);
            return this;
        }

        public b() {
            super(C1713j.DEFAULT_INSTANCE);
        }
    }

    static {
        C1713j c1713j = new C1713j();
        DEFAULT_INSTANCE = c1713j;
        AbstractC1077y.registerDefaultInstance(C1713j.class, c1713j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Iterable iterable) {
        n();
        AbstractC1050a.addAll(iterable, (List) this.values_);
    }

    private void n() {
        C.i iVar = this.values_;
        if (iVar.e()) {
            return;
        }
        this.values_ = AbstractC1077y.mutableCopy(iVar);
    }

    public static C1713j p() {
        return DEFAULT_INSTANCE;
    }

    public static b q() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public List a() {
        return this.values_;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14048a[eVar.ordinal()]) {
            case 1:
                return new C1713j();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"values_", C1698D.class, "before_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1713j.class) {
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

    public boolean o() {
        return this.before_;
    }

    public final void r(boolean z4) {
        this.before_ = z4;
    }
}
