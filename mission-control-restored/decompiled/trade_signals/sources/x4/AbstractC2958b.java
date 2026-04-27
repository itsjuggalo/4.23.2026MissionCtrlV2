package x4;

import java.util.List;
import v4.C2865E;

/* JADX INFO: renamed from: x4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2958b implements e {
    @Override // x4.e
    public C2865E b() {
        return new C2865E(k(), l());
    }

    @Override // x4.e
    public boolean c() {
        return Boolean.TRUE.equals(a("noResult"));
    }

    @Override // x4.e
    public Integer d() {
        return (Integer) a("transactionId");
    }

    @Override // x4.e
    public boolean e() {
        return g("transactionId") && d() == null;
    }

    @Override // x4.e
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
