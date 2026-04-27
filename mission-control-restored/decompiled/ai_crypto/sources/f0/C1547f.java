package f0;

import androidx.datastore.preferences.protobuf.AbstractC0948t;
import androidx.datastore.preferences.protobuf.C;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.k0;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: f0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1547f extends AbstractC0948t implements K {
    private static final C1547f DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private D preferences_ = D.e();

    /* JADX INFO: renamed from: f0.f$a */
    public static final class a extends AbstractC0948t.a implements K {
        public /* synthetic */ a(AbstractC1546e abstractC1546e) {
            this();
        }

        public a q(String str, h hVar) {
            str.getClass();
            hVar.getClass();
            l();
            ((C1547f) this.f7605b).Q().put(str, hVar);
            return this;
        }

        public a() {
            super(C1547f.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: f0.f$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C f14036a = C.d(k0.b.f7495k, "", k0.b.f7497m, h.Z());
    }

    static {
        C1547f c1547f = new C1547f();
        DEFAULT_INSTANCE = c1547f;
        AbstractC0948t.L(C1547f.class, c1547f);
    }

    public static a U() {
        return (a) DEFAULT_INSTANCE.p();
    }

    public static C1547f V(InputStream inputStream) {
        return (C1547f) AbstractC0948t.J(DEFAULT_INSTANCE, inputStream);
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

    @Override // androidx.datastore.preferences.protobuf.AbstractC0948t
    public final Object s(AbstractC0948t.d dVar, Object obj, Object obj2) {
        AbstractC1546e abstractC1546e = null;
        switch (AbstractC1546e.f14035a[dVar.ordinal()]) {
            case 1:
                return new C1547f();
            case 2:
                return new a(abstractC1546e);
            case 3:
                return AbstractC0948t.H(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f14036a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (C1547f.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC0948t.b(DEFAULT_INSTANCE);
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
