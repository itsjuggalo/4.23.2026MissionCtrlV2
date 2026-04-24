package k4;

import com.google.protobuf.AbstractC1229a;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import java.util.List;

/* JADX INFO: renamed from: k4.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2119j extends AbstractC1255y implements W {
    public static final int BEFORE_FIELD_NUMBER = 2;
    private static final C2119j DEFAULT_INSTANCE;
    private static volatile f0 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean before_;
    private C.e values_ = AbstractC1255y.A();

    /* JADX INFO: renamed from: k4.j$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18047a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18047a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18047a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18047a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18047a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18047a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18047a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18047a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.j$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b w(Iterable iterable) {
            q();
            ((C2119j) this.f12868b).c0(iterable);
            return this;
        }

        public b x(boolean z7) {
            q();
            ((C2119j) this.f12868b).h0(z7);
            return this;
        }

        public b() {
            super(C2119j.DEFAULT_INSTANCE);
        }
    }

    static {
        C2119j c2119j = new C2119j();
        DEFAULT_INSTANCE = c2119j;
        AbstractC1255y.V(C2119j.class, c2119j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(Iterable iterable) {
        d0();
        AbstractC1229a.k(iterable, this.values_);
    }

    private void d0() {
        C.e eVar = this.values_;
        if (eVar.f()) {
            return;
        }
        this.values_ = AbstractC1255y.L(eVar);
    }

    public static C2119j f0() {
        return DEFAULT_INSTANCE;
    }

    public static b g0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public boolean e0() {
        return this.before_;
    }

    public List g() {
        return this.values_;
    }

    public final void h0(boolean z7) {
        this.before_ = z7;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18047a[dVar.ordinal()]) {
            case 1:
                return new C2119j();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"values_", C2105D.class, "before_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2119j.class) {
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
