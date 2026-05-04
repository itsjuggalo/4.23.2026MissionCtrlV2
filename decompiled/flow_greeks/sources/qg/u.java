package qg;

import sg.d0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f19203a = new d0("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f19204b = new d0("PENDING");

    public static final o a(Object obj) {
        if (obj == null) {
            obj = rg.m.f19904a;
        }
        return new t(obj);
    }

    public static final d d(s sVar, gd.i iVar, int i10, pg.a aVar) {
        return (((i10 < 0 || i10 >= 2) && i10 != -2) || aVar != pg.a.f18622b) ? r.a(sVar, iVar, i10, aVar) : sVar;
    }
}
