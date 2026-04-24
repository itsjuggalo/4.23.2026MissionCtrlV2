package f0;

import androidx.datastore.preferences.protobuf.AbstractC1117t;
import androidx.datastore.preferences.protobuf.C;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.k0;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends AbstractC1117t implements K {
    private static final f DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private D preferences_ = D.e();

    public static final class a extends AbstractC1117t.a implements K {
        public a() {
            super(f.DEFAULT_INSTANCE);
        }

        public a s(String str, h hVar) {
            str.getClass();
            hVar.getClass();
            m();
            ((f) this.f11417b).Q().put(str, hVar);
            return this;
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C f17357a = C.d(k0.b.f11307k, "", k0.b.f11309m, h.Z());
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        AbstractC1117t.L(f.class, fVar);
    }

    public static a U() {
        return (a) DEFAULT_INSTANCE.p();
    }

    public static f V(InputStream inputStream) {
        return (f) AbstractC1117t.J(DEFAULT_INSTANCE, inputStream);
    }

    public final Map Q() {
        return S();
    }

    public Map R() {
        return Collections.unmodifiableMap(T());
    }

    public final D S() {
        if (!this.preferences_.j()) {
            this.preferences_ = this.preferences_.m();
        }
        return this.preferences_;
    }

    public final D T() {
        return this.preferences_;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1117t
    public final Object s(AbstractC1117t.d dVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f17356a[dVar.ordinal()]) {
            case 1:
                return new f();
            case 2:
                return new a(eVar);
            case 3:
                return AbstractC1117t.H(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f17357a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (f.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1117t.b(DEFAULT_INSTANCE);
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
