package D4;

import u4.C1230l;
import u4.L;

/* JADX INFO: loaded from: classes.dex */
public final class f implements L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L f292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f293c;

    public /* synthetic */ f(b bVar, L l6, int i) {
        this.f291a = i;
        this.f293c = bVar;
        this.f292b = l6;
    }

    @Override // u4.L
    public final void a(C1230l c1230l) {
        switch (this.f291a) {
            case 0:
                this.f292b.a(c1230l);
                ((g) this.f293c).f295b.a(c1230l);
                break;
            default:
                s sVar = (s) this.f293c;
                sVar.f332d = c1230l;
                if (!sVar.f331c) {
                    this.f292b.a(c1230l);
                }
                break;
        }
    }
}
