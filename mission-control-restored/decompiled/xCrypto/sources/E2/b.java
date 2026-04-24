package E2;

import C2.C;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements e {
    @Override // E2.e
    public C b() {
        return new C(k(), l());
    }

    @Override // E2.e
    public boolean c() {
        return Boolean.TRUE.equals(a("noResult"));
    }

    @Override // E2.e
    public Integer d() {
        return (Integer) a("transactionId");
    }

    @Override // E2.e
    public boolean e() {
        return g("transactionId") && d() == null;
    }

    @Override // E2.e
    public Boolean h() {
        return i("inTransaction");
    }

    public final Boolean i(String str) {
        Object objA = a(str);
        if (objA instanceof Boolean) {
            return (Boolean) objA;
        }
        return null;
    }

    public boolean j() {
        return Boolean.TRUE.equals(a("continueOnError"));
    }

    public final String k() {
        return (String) a("sql");
    }

    public final List l() {
        return (List) a("arguments");
    }

    public String toString() {
        return f() + " " + k() + " " + l();
    }
}
