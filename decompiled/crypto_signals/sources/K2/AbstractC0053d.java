package K2;

import java.util.Objects;

/* JADX INFO: renamed from: K2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0053d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0069u f911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f913c;

    public AbstractC0053d(C0069u c0069u, String str) {
        String str2;
        this.f911a = c0069u;
        this.f912b = str;
        StringBuilder sbN = a3.d.n(str);
        if (c0069u == null) {
            str2 = "";
        } else {
            str2 = "_" + c0069u;
        }
        sbN.append(str2);
        this.f913c = sbN.toString();
    }

    public final String a() {
        C0069u c0069u = this.f911a;
        return c0069u == null ? "" : c0069u.f972a.c();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC0053d)) {
            return false;
        }
        AbstractC0053d abstractC0053d = (AbstractC0053d) obj;
        C0069u c0069u = this.f911a;
        return (c0069u == null || abstractC0053d.f911a == null) ? c0069u == null && abstractC0053d.f911a == null : this.f912b.equals(abstractC0053d.f912b) && a().equals(abstractC0053d.a());
    }

    public final int hashCode() {
        return Objects.hash(this.f912b, a());
    }
}
