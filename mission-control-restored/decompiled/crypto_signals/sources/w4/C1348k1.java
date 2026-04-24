package w4;

import u4.AbstractC1240w;
import u4.EnumC1229k;

/* JADX INFO: renamed from: w4.k1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1348k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1240w f11304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EnumC1229k f11305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1339h1 f11306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11307d;

    public C1348k1(AbstractC1240w abstractC1240w, C1339h1 c1339h1) {
        EnumC1229k enumC1229k = EnumC1229k.f10452d;
        this.f11307d = false;
        this.f11304a = abstractC1240w;
        this.f11305b = enumC1229k;
        this.f11306c = c1339h1;
    }

    public static void a(C1348k1 c1348k1, EnumC1229k enumC1229k) {
        c1348k1.f11305b = enumC1229k;
        if (enumC1229k == EnumC1229k.f10450b || enumC1229k == EnumC1229k.f10451c) {
            c1348k1.f11307d = true;
        } else if (enumC1229k == EnumC1229k.f10452d) {
            c1348k1.f11307d = false;
        }
    }
}
