package f0;

import androidx.datastore.preferences.protobuf.AbstractC0930a;
import androidx.datastore.preferences.protobuf.AbstractC0948t;
import androidx.datastore.preferences.protobuf.AbstractC0949u;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.S;
import java.util.List;

/* JADX INFO: renamed from: f0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1548g extends AbstractC0948t implements K {
    private static final C1548g DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private AbstractC0949u.b strings_ = AbstractC0948t.t();

    /* JADX INFO: renamed from: f0.g$a */
    public static final class a extends AbstractC0948t.a implements K {
        public /* synthetic */ a(AbstractC1546e abstractC1546e) {
            this();
        }

        public a q(Iterable iterable) {
            l();
            ((C1548g) this.f7605b).Q(iterable);
            return this;
        }

        public a() {
            super(C1548g.DEFAULT_INSTANCE);
        }
    }

    static {
        C1548g c1548g = new C1548g();
        DEFAULT_INSTANCE = c1548g;
        AbstractC0948t.L(C1548g.class, c1548g);
    }

    public static C1548g S() {
        return DEFAULT_INSTANCE;
    }

    public static a U() {
        return (a) DEFAULT_INSTANCE.p();
    }

    public final void Q(Iterable iterable) {
        R();
        AbstractC0930a.e(iterable, this.strings_);
    }

    public final void R() {
        AbstractC0949u.b bVar = this.strings_;
        if (bVar.f()) {
            return;
        }
        this.strings_ = AbstractC0948t.F(bVar);
    }

    public List T() {
        return this.strings_;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0948t
    public final Object s(AbstractC0948t.d dVar, Object obj, Object obj2) {
        AbstractC1546e abstractC1546e = null;
        switch (AbstractC1546e.f14035a[dVar.ordinal()]) {
            case 1:
                return new C1548g();
            case 2:
                return new a(abstractC1546e);
            case 3:
                return AbstractC0948t.H(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (C1548g.class) {
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
