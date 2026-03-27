package r4;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.AbstractC1481u;
import com.google.protobuf.K;
import com.google.protobuf.S;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AbstractC1480t implements K {
    private static final e DEFAULT_INSTANCE;
    public static final int EXPIRATION_EPOCH_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    public static final int MESSAGES_FIELD_NUMBER = 1;
    private static volatile S PARSER;
    private long expirationEpochTimestampMillis_;
    private AbstractC1481u.d messages_ = AbstractC1480t.x();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22918a;

        static {
            int[] iArr = new int[AbstractC1480t.d.values().length];
            f22918a = iArr;
            try {
                iArr[AbstractC1480t.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22918a[AbstractC1480t.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22918a[AbstractC1480t.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22918a[AbstractC1480t.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22918a[AbstractC1480t.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22918a[AbstractC1480t.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22918a[AbstractC1480t.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1480t.a implements K {
        public b() {
            super(e.DEFAULT_INSTANCE);
        }

        public b x(long j8) {
            r();
            ((e) this.f16577b).Y(j8);
            return this;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        AbstractC1480t.N(e.class, eVar);
    }

    public static e T() {
        return DEFAULT_INSTANCE;
    }

    public static b W() {
        return (b) DEFAULT_INSTANCE.s();
    }

    public static S X() {
        return DEFAULT_INSTANCE.j();
    }

    public long U() {
        return this.expirationEpochTimestampMillis_;
    }

    public List V() {
        return this.messages_;
    }

    public final void Y(long j8) {
        this.expirationEpochTimestampMillis_ = j8;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f22918a[dVar.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002", new Object[]{"messages_", q4.c.class, "expirationEpochTimestampMillis_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (e.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1480t.b(DEFAULT_INSTANCE);
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
