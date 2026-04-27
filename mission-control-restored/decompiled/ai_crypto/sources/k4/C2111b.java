package k4;

import com.google.protobuf.AbstractC1229a;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.f0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: k4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2111b extends AbstractC1255y implements InterfaceC2112c {
    private static final C2111b DEFAULT_INSTANCE;
    private static volatile f0 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private C.e values_ = AbstractC1255y.A();

    /* JADX INFO: renamed from: k4.b$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18035a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18035a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18035a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18035a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18035a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18035a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18035a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18035a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.b$b, reason: collision with other inner class name */
    public static final class C0290b extends AbstractC1255y.a implements InterfaceC2112c {
        public /* synthetic */ C0290b(a aVar) {
            this();
        }

        public C0290b A(int i7) {
            q();
            ((C2111b) this.f12868b).k0(i7);
            return this;
        }

        @Override // k4.InterfaceC2112c
        public List g() {
            return Collections.unmodifiableList(((C2111b) this.f12868b).g());
        }

        public C0290b w(Iterable iterable) {
            q();
            ((C2111b) this.f12868b).d0(iterable);
            return this;
        }

        public C0290b x(C2105D c2105d) {
            q();
            ((C2111b) this.f12868b).e0(c2105d);
            return this;
        }

        public C2105D y(int i7) {
            return ((C2111b) this.f12868b).h0(i7);
        }

        public int z() {
            return ((C2111b) this.f12868b).i0();
        }

        public C0290b() {
            super(C2111b.DEFAULT_INSTANCE);
        }
    }

    static {
        C2111b c2111b = new C2111b();
        DEFAULT_INSTANCE = c2111b;
        AbstractC1255y.V(C2111b.class, c2111b);
    }

    public static C2111b g0() {
        return DEFAULT_INSTANCE;
    }

    public static C0290b j0() {
        return (C0290b) DEFAULT_INSTANCE.u();
    }

    public final void d0(Iterable iterable) {
        f0();
        AbstractC1229a.k(iterable, this.values_);
    }

    public final void e0(C2105D c2105d) {
        c2105d.getClass();
        f0();
        this.values_.add(c2105d);
    }

    public final void f0() {
        C.e eVar = this.values_;
        if (eVar.f()) {
            return;
        }
        this.values_ = AbstractC1255y.L(eVar);
    }

    @Override // k4.InterfaceC2112c
    public List g() {
        return this.values_;
    }

    public C2105D h0(int i7) {
        return (C2105D) this.values_.get(i7);
    }

    public int i0() {
        return this.values_.size();
    }

    public final void k0(int i7) {
        f0();
        this.values_.remove(i7);
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18035a[dVar.ordinal()]) {
            case 1:
                return new C2111b();
            case 2:
                return new C0290b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", C2105D.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2111b.class) {
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
