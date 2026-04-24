package t3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class r extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f10253a;

    public r(s sVar) {
        this.f10253a = sVar;
    }

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() != 9) {
            return this.f10253a.b(aVar);
        }
        aVar.x();
        return null;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.m();
        } else {
            this.f10253a.c(bVar, obj);
        }
    }

    public final String toString() {
        return "NullSafeTypeAdapter[" + this.f10253a + "]";
    }
}
