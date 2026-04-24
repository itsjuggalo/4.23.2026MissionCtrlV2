package p2;

import com.google.protobuf.AbstractC1050a;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.g0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: p2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1705b extends AbstractC1077y implements InterfaceC1706c {
    private static final C1705b DEFAULT_INSTANCE;
    private static volatile g0 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private C.i values_ = AbstractC1077y.emptyProtobufList();

    /* JADX INFO: renamed from: p2.b$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14036a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14036a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14036a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14036a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14036a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14036a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14036a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14036a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.b$b, reason: collision with other inner class name */
    public static final class C0224b extends AbstractC1077y.a implements InterfaceC1706c {
        public /* synthetic */ C0224b(a aVar) {
            this();
        }

        @Override // p2.InterfaceC1706c
        public List a() {
            return Collections.unmodifiableList(((C1705b) this.instance).a());
        }

        public C0224b f(Iterable iterable) {
            copyOnWrite();
            ((C1705b) this.instance).n(iterable);
            return this;
        }

        public C0224b g(C1698D c1698d) {
            copyOnWrite();
            ((C1705b) this.instance).o(c1698d);
            return this;
        }

        public C1698D h(int i4) {
            return ((C1705b) this.instance).r(i4);
        }

        public int i() {
            return ((C1705b) this.instance).s();
        }

        public C0224b j(int i4) {
            copyOnWrite();
            ((C1705b) this.instance).u(i4);
            return this;
        }

        public C0224b() {
            super(C1705b.DEFAULT_INSTANCE);
        }
    }

    static {
        C1705b c1705b = new C1705b();
        DEFAULT_INSTANCE = c1705b;
        AbstractC1077y.registerDefaultInstance(C1705b.class, c1705b);
    }

    public static C1705b q() {
        return DEFAULT_INSTANCE;
    }

    public static C0224b t() {
        return (C0224b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // p2.InterfaceC1706c
    public List a() {
        return this.values_;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14036a[eVar.ordinal()]) {
            case 1:
                return new C1705b();
            case 2:
                return new C0224b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", C1698D.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1705b.class) {
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

    public final void n(Iterable iterable) {
        p();
        AbstractC1050a.addAll(iterable, (List) this.values_);
    }

    public final void o(C1698D c1698d) {
        c1698d.getClass();
        p();
        this.values_.add(c1698d);
    }

    public final void p() {
        C.i iVar = this.values_;
        if (iVar.e()) {
            return;
        }
        this.values_ = AbstractC1077y.mutableCopy(iVar);
    }

    public C1698D r(int i4) {
        return (C1698D) this.values_.get(i4);
    }

    public int s() {
        return this.values_.size();
    }

    public final void u(int i4) {
        p();
        this.values_.remove(i4);
    }
}
