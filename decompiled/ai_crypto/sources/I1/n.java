package I1;

import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2943a;

    public static final n c(o oVar) {
        String strB = oVar.b();
        n nVar = new n();
        if (strB != null) {
            nVar.f2943a = AbstractC1207s.e(strB);
        }
        return nVar;
    }

    public final n a(String str) {
        this.f2943a = AbstractC1207s.e(str);
        return this;
    }

    public final o b() {
        return new o(this.f2943a);
    }
}
