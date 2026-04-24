package f0;

import androidx.datastore.preferences.protobuf.AbstractC1099a;
import androidx.datastore.preferences.protobuf.AbstractC1117t;
import androidx.datastore.preferences.protobuf.AbstractC1118u;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.S;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AbstractC1117t implements K {
    private static final g DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private AbstractC1118u.b strings_ = AbstractC1117t.t();

    public static final class a extends AbstractC1117t.a implements K {
        public a() {
            super(g.DEFAULT_INSTANCE);
        }

        public a s(Iterable iterable) {
            m();
            ((g) this.f11417b).Q(iterable);
            return this;
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        AbstractC1117t.L(g.class, gVar);
    }

    public static g S() {
        return DEFAULT_INSTANCE;
    }

    public static a U() {
        return (a) DEFAULT_INSTANCE.p();
    }

    public final void Q(Iterable iterable) {
        R();
        AbstractC1099a.a(iterable, this.strings_);
    }

    public final void R() {
        AbstractC1118u.b bVar = this.strings_;
        if (bVar.m()) {
            return;
        }
        this.strings_ = AbstractC1117t.F(bVar);
    }

    public List T() {
        return this.strings_;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1117t
    public final Object s(AbstractC1117t.d dVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f17356a[dVar.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return new a(eVar);
            case 3:
                return AbstractC1117t.H(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (g.class) {
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
