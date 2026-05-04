package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.b;
import ga.h;
import gd.i;
import ua.b0;
import ua.g0;
import ua.l;
import ua.m0;
import ua.o0;
import ua.r0;
import ua.s;
import ua.s0;
import ua.u0;
import xa.k;
import xa.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f6554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f6555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public i f6556c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a7.g f6557d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public h f6558e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public fa.b f6559f;

        public b() {
        }

        @Override // com.google.firebase.sessions.b.a
        public com.google.firebase.sessions.b build() {
            wa.d.a(this.f6554a, Context.class);
            wa.d.a(this.f6555b, i.class);
            wa.d.a(this.f6556c, i.class);
            wa.d.a(this.f6557d, a7.g.class);
            wa.d.a(this.f6558e, h.class);
            wa.d.a(this.f6559f, fa.b.class);
            return new c(this.f6554a, this.f6555b, this.f6556c, this.f6557d, this.f6558e, this.f6559f);
        }

        @Override // com.google.firebase.sessions.b.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b f(Context context) {
            this.f6554a = (Context) wa.d.b(context);
            return this;
        }

        @Override // com.google.firebase.sessions.b.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b a(i iVar) {
            this.f6555b = (i) wa.d.b(iVar);
            return this;
        }

        @Override // com.google.firebase.sessions.b.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public b b(i iVar) {
            this.f6556c = (i) wa.d.b(iVar);
            return this;
        }

        @Override // com.google.firebase.sessions.b.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public b e(a7.g gVar) {
            this.f6557d = (a7.g) wa.d.b(gVar);
            return this;
        }

        @Override // com.google.firebase.sessions.b.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public b d(h hVar) {
            this.f6558e = (h) wa.d.b(hVar);
            return this;
        }

        @Override // com.google.firebase.sessions.b.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public b c(fa.b bVar) {
            this.f6559f = (fa.b) wa.d.b(bVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements com.google.firebase.sessions.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f6560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public wa.e f6561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public wa.e f6562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public wa.e f6563d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public wa.e f6564e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public wa.e f6565f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public wa.e f6566g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public wa.e f6567h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public wa.e f6568i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public wa.e f6569j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public wa.e f6570k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public wa.e f6571l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public wa.e f6572m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public wa.e f6573n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public wa.e f6574o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public wa.e f6575p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public wa.e f6576q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public wa.e f6577r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public wa.e f6578s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public wa.e f6579t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public wa.e f6580u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public wa.e f6581v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public wa.e f6582w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public wa.e f6583x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public wa.e f6584y;

        @Override // com.google.firebase.sessions.b
        public l a() {
            return (l) this.f6584y.get();
        }

        @Override // com.google.firebase.sessions.b
        public s0 b() {
            return (s0) this.f6582w.get();
        }

        public final void c(Context context, i iVar, i iVar2, a7.g gVar, h hVar, fa.b bVar) {
            this.f6561b = wa.c.a(gVar);
            wa.b bVarA = wa.c.a(context);
            this.f6562c = bVarA;
            this.f6563d = wa.a.a(xa.c.a(bVarA));
            this.f6564e = wa.a.a(f.a());
            this.f6565f = wa.c.a(hVar);
            this.f6566g = wa.a.a(com.google.firebase.sessions.c.b(this.f6561b));
            wa.b bVarA2 = wa.c.a(iVar2);
            this.f6567h = bVarA2;
            this.f6568i = wa.a.a(xa.f.a(this.f6566g, bVarA2));
            this.f6569j = wa.c.a(iVar);
            wa.e eVarA = wa.a.a(d.a(this.f6562c, this.f6567h));
            this.f6570k = eVarA;
            wa.e eVarA2 = wa.a.a(n.a(this.f6569j, this.f6564e, eVarA));
            this.f6571l = eVarA2;
            wa.e eVarA3 = wa.a.a(xa.g.a(this.f6564e, this.f6565f, this.f6566g, this.f6568i, eVarA2));
            this.f6572m = eVarA3;
            this.f6573n = wa.a.a(k.a(this.f6563d, eVarA3));
            wa.e eVarA4 = wa.a.a(g.a());
            this.f6574o = eVarA4;
            this.f6575p = wa.a.a(o0.a(this.f6564e, eVarA4));
            wa.b bVarA3 = wa.c.a(bVar);
            this.f6576q = bVarA3;
            wa.e eVarA5 = wa.a.a(ua.i.a(bVarA3));
            this.f6577r = eVarA5;
            this.f6578s = wa.a.a(m0.a(this.f6561b, this.f6565f, this.f6573n, eVarA5, this.f6569j));
            wa.e eVarA6 = wa.a.a(g0.a(this.f6575p));
            this.f6579t = eVarA6;
            this.f6580u = wa.a.a(e.a(this.f6562c, this.f6567h, eVarA6));
            wa.e eVarA7 = wa.a.a(b0.a(this.f6562c, this.f6574o));
            this.f6581v = eVarA7;
            wa.e eVarA8 = wa.a.a(u0.a(this.f6573n, this.f6575p, this.f6578s, this.f6564e, this.f6580u, eVarA7, this.f6569j));
            this.f6582w = eVarA8;
            wa.e eVarA9 = wa.a.a(r0.a(eVarA8));
            this.f6583x = eVarA9;
            this.f6584y = wa.a.a(s.a(this.f6561b, this.f6573n, this.f6569j, eVarA9));
        }

        public c(Context context, i iVar, i iVar2, a7.g gVar, h hVar, fa.b bVar) {
            this.f6560a = this;
            c(context, iVar, iVar2, gVar, hVar, bVar);
        }
    }

    public static b.a a() {
        return new b();
    }
}
