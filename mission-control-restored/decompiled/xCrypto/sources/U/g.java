package U;

import androidx.datastore.preferences.protobuf.AbstractC0788a;
import androidx.datastore.preferences.protobuf.AbstractC0806t;
import androidx.datastore.preferences.protobuf.AbstractC0807u;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.S;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AbstractC0806t implements K {
    private static final g DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private AbstractC0807u.b strings_ = AbstractC0806t.p();

    public static final class a extends AbstractC0806t.a implements K {
        public /* synthetic */ a(e eVar) {
            this();
        }

        public a m(Iterable iterable) {
            h();
            ((g) this.f7197b).M(iterable);
            return this;
        }

        public a() {
            super(g.DEFAULT_INSTANCE);
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        AbstractC0806t.H(g.class, gVar);
    }

    public static g O() {
        return DEFAULT_INSTANCE;
    }

    public static a Q() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public final void M(Iterable iterable) {
        N();
        AbstractC0788a.b(iterable, this.strings_);
    }

    public final void N() {
        AbstractC0807u.b bVar = this.strings_;
        if (bVar.e()) {
            return;
        }
        this.strings_ = AbstractC0806t.B(bVar);
    }

    public List P() {
        return this.strings_;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0806t
    public final Object o(AbstractC0806t.d dVar, Object obj, Object obj2) {
        S bVar;
        e eVar = null;
        switch (e.f5235a[dVar.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return new a(eVar);
            case 3:
                return AbstractC0806t.D(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S s4 = PARSER;
                if (s4 != null) {
                    return s4;
                }
                synchronized (g.class) {
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
