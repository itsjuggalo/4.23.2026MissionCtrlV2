package f2;

import Z1.k;
import com.google.android.gms.common.internal.I;

/* JADX INFO: renamed from: f2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0596b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f6424b;

    public C0596b(String str, k kVar) {
        I.d(str);
        this.f6423a = str;
        this.f6424b = kVar;
    }

    public static C0596b a(C0595a c0595a) {
        I.g(c0595a);
        return new C0596b(c0595a.f6420a, null);
    }
}
