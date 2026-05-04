package bb;

import com.google.protobuf.c0;
import com.google.protobuf.e1;
import com.google.protobuf.y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends com.google.protobuf.y implements c {
    private static final b DEFAULT_INSTANCE;
    private static volatile e1 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private c0.e values_ = com.google.protobuf.y.A();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3152a;

        static {
            int[] iArr = new int[y.d.values().length];
            f3152a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3152a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3152a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3152a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3152a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3152a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3152a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: bb.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0055b extends y.a implements c {
        public /* synthetic */ C0055b(a aVar) {
            this();
        }

        public int A() {
            return ((b) this.f7244b).i0();
        }

        public C0055b B(int i10) {
            q();
            ((b) this.f7244b).k0(i10);
            return this;
        }

        @Override // bb.c
        public List h() {
            return Collections.unmodifiableList(((b) this.f7244b).h());
        }

        public C0055b x(Iterable iterable) {
            q();
            ((b) this.f7244b).d0(iterable);
            return this;
        }

        public C0055b y(d0 d0Var) {
            q();
            ((b) this.f7244b).e0(d0Var);
            return this;
        }

        public d0 z(int i10) {
            return ((b) this.f7244b).h0(i10);
        }

        public C0055b() {
            super(b.DEFAULT_INSTANCE);
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        com.google.protobuf.y.V(b.class, bVar);
    }

    public static b g0() {
        return DEFAULT_INSTANCE;
    }

    public static C0055b j0() {
        return (C0055b) DEFAULT_INSTANCE.u();
    }

    public final void d0(Iterable iterable) {
        f0();
        com.google.protobuf.a.k(iterable, this.values_);
    }

    public final void e0(d0 d0Var) {
        d0Var.getClass();
        f0();
        this.values_.add(d0Var);
    }

    public final void f0() {
        c0.e eVar = this.values_;
        if (eVar.m()) {
            return;
        }
        this.values_ = com.google.protobuf.y.L(eVar);
    }

    @Override // bb.c
    public List h() {
        return this.values_;
    }

    public d0 h0(int i10) {
        return (d0) this.values_.get(i10);
    }

    public int i0() {
        return this.values_.size();
    }

    public final void k0(int i10) {
        f0();
        this.values_.remove(i10);
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f3152a[dVar.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return new C0055b(aVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", d0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (b.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new y.b(DEFAULT_INSTANCE);
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
}
