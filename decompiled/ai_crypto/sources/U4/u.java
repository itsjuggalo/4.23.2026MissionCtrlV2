package U4;

import V4.j;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f5125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f5126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f5127c;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            if (u.this.f5126b == null) {
                J4.b.f("ScribeChannel", "No ScribeMethodHandler registered. Scribe call not handled.");
            }
            String str = iVar.f5332a;
            J4.b.f("ScribeChannel", "Received '" + str + "' message.");
            str.hashCode();
            switch (str) {
                case "Scribe.isFeatureAvailable":
                    u.this.e(iVar, dVar);
                    break;
                case "Scribe.startStylusHandwriting":
                    u.this.h(iVar, dVar);
                    break;
                case "Scribe.isStylusHandwritingAvailable":
                    u.this.f(iVar, dVar);
                    break;
                default:
                    dVar.c();
                    break;
            }
        }
    }

    public interface b {
        void a();

        boolean b();

        boolean c();
    }

    public u(M4.a aVar) {
        a aVar2 = new a();
        this.f5127c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/scribe", V4.f.f5331a);
        this.f5125a = jVar;
        jVar.e(aVar2);
    }

    public final void e(V4.i iVar, j.d dVar) {
        try {
            dVar.a(Boolean.valueOf(this.f5126b.c()));
        } catch (IllegalStateException e7) {
            dVar.b("error", e7.getMessage(), null);
        }
    }

    public final void f(V4.i iVar, j.d dVar) {
        if (Build.VERSION.SDK_INT < 34) {
            dVar.b("error", "Requires API level 34 or higher.", null);
            return;
        }
        try {
            dVar.a(Boolean.valueOf(this.f5126b.b()));
        } catch (IllegalStateException e7) {
            dVar.b("error", e7.getMessage(), null);
        }
    }

    public void g(b bVar) {
        this.f5126b = bVar;
    }

    public final void h(V4.i iVar, j.d dVar) {
        if (Build.VERSION.SDK_INT < 33) {
            dVar.b("error", "Requires API level 33 or higher.", null);
            return;
        }
        try {
            this.f5126b.a();
            dVar.a(null);
        } catch (IllegalStateException e7) {
            dVar.b("error", e7.getMessage(), null);
        }
    }
}
