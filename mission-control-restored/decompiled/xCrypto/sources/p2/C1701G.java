package p2;

import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.C0;
import com.google.protobuf.O;
import com.google.protobuf.P;
import com.google.protobuf.X;
import com.google.protobuf.g0;

/* JADX INFO: renamed from: p2.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1701G extends AbstractC1077y implements X {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final C1701G DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 5;
    private static volatile g0 PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 2;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 4;
    public static final int WRITES_FIELD_NUMBER = 3;
    private P labels_ = P.e();
    private String database_ = "";
    private String streamId_ = "";
    private C.i writes_ = AbstractC1077y.emptyProtobufList();
    private AbstractC1062i streamToken_ = AbstractC1062i.f11025b;

    /* JADX INFO: renamed from: p2.G$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14030a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14030a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14030a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14030a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14030a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14030a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14030a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14030a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.G$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(C1699E c1699e) {
            copyOnWrite();
            ((C1701G) this.instance).addWrites(c1699e);
            return this;
        }

        public b g(String str) {
            copyOnWrite();
            ((C1701G) this.instance).p(str);
            return this;
        }

        public b h(AbstractC1062i abstractC1062i) {
            copyOnWrite();
            ((C1701G) this.instance).q(abstractC1062i);
            return this;
        }

        public b() {
            super(C1701G.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: p2.G$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final O f14031a;

        static {
            C0.b bVar = C0.b.f10899k;
            f14031a = O.d(bVar, "", bVar, "");
        }
    }

    static {
        C1701G c1701g = new C1701G();
        DEFAULT_INSTANCE = c1701g;
        AbstractC1077y.registerDefaultInstance(C1701G.class, c1701g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(C1699E c1699e) {
        c1699e.getClass();
        ensureWritesIsMutable();
        this.writes_.add(c1699e);
    }

    private void ensureWritesIsMutable() {
        C.i iVar = this.writes_;
        if (iVar.e()) {
            return;
        }
        this.writes_ = AbstractC1077y.mutableCopy(iVar);
    }

    public static C1701G n() {
        return DEFAULT_INSTANCE;
    }

    public static b o() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        str.getClass();
        this.database_ = str;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14030a[eVar.ordinal()]) {
            case 1:
                return new C1701G();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004\n\u00052", new Object[]{"database_", "streamId_", "writes_", C1699E.class, "streamToken_", "labels_", c.f14031a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1701G.class) {
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

    public final void q(AbstractC1062i abstractC1062i) {
        abstractC1062i.getClass();
        this.streamToken_ = abstractC1062i;
    }
}
