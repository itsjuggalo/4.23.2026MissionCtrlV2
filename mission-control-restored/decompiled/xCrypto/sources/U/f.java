package U;

import androidx.datastore.preferences.protobuf.AbstractC0806t;
import androidx.datastore.preferences.protobuf.C;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.k0;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends AbstractC0806t implements K {
    private static final f DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private D preferences_ = D.e();

    public static final class a extends AbstractC0806t.a implements K {
        public /* synthetic */ a(e eVar) {
            this();
        }

        public a m(String str, h hVar) {
            str.getClass();
            hVar.getClass();
            h();
            ((f) this.f7197b).M().put(str, hVar);
            return this;
        }

        public a() {
            super(f.DEFAULT_INSTANCE);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C f5236a = C.d(k0.b.f7087k, "", k0.b.f7089m, h.V());
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        AbstractC0806t.H(f.class, fVar);
    }

    public static a Q() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public static f R(InputStream inputStream) {
        return (f) AbstractC0806t.F(DEFAULT_INSTANCE, inputStream);
    }

    public final Map M() {
        return O();
    }

    public Map N() {
        return Collections.unmodifiableMap(P());
    }

    public final D O() {
        if (!this.preferences_.i()) {
            this.preferences_ = this.preferences_.l();
        }
        return this.preferences_;
    }

    public final D P() {
        return this.preferences_;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0806t
    public final Object o(AbstractC0806t.d dVar, Object obj, Object obj2) {
        S bVar;
        e eVar = null;
        switch (e.f5235a[dVar.ordinal()]) {
            case 1:
                return new f();
            case 2:
                return new a(eVar);
            case 3:
                return AbstractC0806t.D(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f5236a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S s4 = PARSER;
                if (s4 != null) {
                    return s4;
                }
                synchronized (f.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC0806t.b(DEFAULT_INSTANCE);
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
