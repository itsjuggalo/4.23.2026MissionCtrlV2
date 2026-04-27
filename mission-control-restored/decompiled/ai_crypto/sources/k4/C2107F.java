package k4;

import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.B0;
import com.google.protobuf.C;
import com.google.protobuf.N;
import com.google.protobuf.O;
import com.google.protobuf.W;
import com.google.protobuf.f0;

/* JADX INFO: renamed from: k4.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2107F extends AbstractC1255y implements W {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final C2107F DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 5;
    private static volatile f0 PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 2;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 4;
    public static final int WRITES_FIELD_NUMBER = 3;
    private O labels_ = O.e();
    private String database_ = "";
    private String streamId_ = "";
    private C.e writes_ = AbstractC1255y.A();
    private AbstractC1240i streamToken_ = AbstractC1240i.f12650b;

    /* JADX INFO: renamed from: k4.F$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18029a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18029a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18029a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18029a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18029a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18029a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18029a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18029a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.F$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b w(C2106E c2106e) {
            q();
            ((C2107F) this.f12868b).d0(c2106e);
            return this;
        }

        public b x(String str) {
            q();
            ((C2107F) this.f12868b).h0(str);
            return this;
        }

        public b y(AbstractC1240i abstractC1240i) {
            q();
            ((C2107F) this.f12868b).i0(abstractC1240i);
            return this;
        }

        public b() {
            super(C2107F.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.F$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final N f18030a;

        static {
            B0.b bVar = B0.b.f12521k;
            f18030a = N.d(bVar, "", bVar, "");
        }
    }

    static {
        C2107F c2107f = new C2107F();
        DEFAULT_INSTANCE = c2107f;
        AbstractC1255y.V(C2107F.class, c2107f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(C2106E c2106e) {
        c2106e.getClass();
        e0();
        this.writes_.add(c2106e);
    }

    private void e0() {
        C.e eVar = this.writes_;
        if (eVar.f()) {
            return;
        }
        this.writes_ = AbstractC1255y.L(eVar);
    }

    public static C2107F f0() {
        return DEFAULT_INSTANCE;
    }

    public static b g0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(String str) {
        str.getClass();
        this.database_ = str;
    }

    public final void i0(AbstractC1240i abstractC1240i) {
        abstractC1240i.getClass();
        this.streamToken_ = abstractC1240i;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18029a[dVar.ordinal()]) {
            case 1:
                return new C2107F();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004\n\u00052", new Object[]{"database_", "streamId_", "writes_", C2106E.class, "streamToken_", "labels_", c.f18030a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2107F.class) {
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
