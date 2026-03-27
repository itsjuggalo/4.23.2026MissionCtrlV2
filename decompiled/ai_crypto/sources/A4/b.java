package A4;

import java.util.List;
import y4.C;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements e {
    @Override // A4.e
    public C d() {
        return new C(m(), n());
    }

    @Override // A4.e
    public boolean e() {
        return Boolean.TRUE.equals(c("noResult"));
    }

    @Override // A4.e
    public Integer f() {
        return (Integer) c("transactionId");
    }

    @Override // A4.e
    public boolean g() {
        return i("transactionId") && f() == null;
    }

    @Override // A4.e
    public Boolean j() {
        return k("inTransaction");
    }

    public final Boolean k(String str) {
        Object objC = c(str);
        if (objC instanceof Boolean) {
            return (Boolean) objC;
        }
        return null;
    }

    public boolean l() {
        return Boolean.TRUE.equals(c("continueOnError"));
    }

    public final String m() {
        return (String) c("sql");
    }

    public final List n() {
        return (List) c("arguments");
    }

    public String toString() {
        return h() + " " + m() + " " + n();
    }
}
