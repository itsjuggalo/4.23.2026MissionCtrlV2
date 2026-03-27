package H3;

import K3.q;
import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f3660a;

    public a(Application application) {
        this.f3660a = application;
    }

    public I3.c a(k kVar, R3.i iVar) {
        return J3.c.a().b(new q(iVar, kVar, this.f3660a)).a().c();
    }

    public I3.c b(k kVar, R3.i iVar) {
        return J3.c.a().b(new q(iVar, kVar, this.f3660a)).a().b();
    }

    public I3.c c(k kVar, R3.i iVar) {
        return J3.c.a().b(new q(iVar, kVar, this.f3660a)).a().a();
    }

    public I3.c d(k kVar, R3.i iVar) {
        return J3.c.a().b(new q(iVar, kVar, this.f3660a)).a().d();
    }
}
