package W2;

import Q2.m;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class b extends V2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f5389b;

    public b(String str, m mVar) {
        AbstractC1207s.e(str);
        this.f5388a = str;
        this.f5389b = mVar;
    }

    public static b c(V2.a aVar) {
        AbstractC1207s.k(aVar);
        return new b(aVar.b(), null);
    }

    public static b d(m mVar) {
        return new b("eyJlcnJvciI6IlVOS05PV05fRVJST1IifQ==", (m) AbstractC1207s.k(mVar));
    }

    @Override // V2.b
    public Exception a() {
        return this.f5389b;
    }

    @Override // V2.b
    public String b() {
        return this.f5388a;
    }
}
