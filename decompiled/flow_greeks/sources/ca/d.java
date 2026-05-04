package ca;

import aa.m3;
import aa.n3;
import aa.r2;
import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f3761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ga.h f3762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final da.a f3763c;

    public d(a7.g gVar, ga.h hVar, da.a aVar) {
        this.f3761a = gVar;
        this.f3762b = hVar;
        this.f3763c = aVar;
    }

    public aa.d a(bd.a aVar, Application application, r2 r2Var) {
        return new aa.d(aVar, this.f3761a, application, this.f3763c, r2Var);
    }

    public aa.n b(m3 m3Var, c9.d dVar) {
        return new aa.n(this.f3761a, m3Var, dVar);
    }

    public a7.g c() {
        return this.f3761a;
    }

    public ga.h d() {
        return this.f3762b;
    }

    public m3 e() {
        return new m3(this.f3761a);
    }

    public n3 f(m3 m3Var) {
        return new n3(m3Var);
    }
}
