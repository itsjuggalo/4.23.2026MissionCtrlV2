package T2;

import K2.C0061l;
import N1.C0094g0;
import N2.C0160i;
import N2.Q;
import N2.S;
import a.AbstractC0284a;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s1.C0994k;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class v implements io.flutter.plugin.platform.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3011d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f3012f;

    @Override // io.flutter.plugin.platform.g
    public void a(int i, int i6) {
        this.f3008a = i;
        this.f3009b = i6;
        SurfaceTexture surfaceTexture = (SurfaceTexture) this.e;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i, i6);
        }
    }

    @Override // io.flutter.plugin.platform.g
    public long b() {
        return ((io.flutter.embedding.engine.renderer.i) this.f3011d).f7050a;
    }

    public void c(String str) {
        String strC = AbstractC1024h.c("Could not reach Cloud Firestore backend. ", str, "\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.");
        if (!this.f3010c) {
            AbstractC0284a.f(1, "OnlineStateTracker", "%s", strC);
        } else {
            AbstractC0284a.f(2, "OnlineStateTracker", "%s", strC);
            this.f3010c = false;
        }
    }

    public void d(int i) {
        boolean z6;
        A.c cVar;
        if (i != this.f3008a) {
            this.f3008a = i;
            N2.J jE = ((N2.B) ((E.l) ((C0061l) this.f3012f).f944b).f365b).e();
            jE.a("handleOnlineStateChange");
            ArrayList arrayList = new ArrayList();
            Iterator it = jE.f1934c.entrySet().iterator();
            while (true) {
                z6 = false;
                if (!it.hasNext()) {
                    break;
                }
                Q q6 = ((N2.G) ((Map.Entry) it.next()).getValue()).f1929c;
                Object obj = null;
                if (q6.f1971c && i == 3) {
                    q6.f1971c = false;
                    cVar = q6.a(new C0094g0(q6.f1972d, new Q3.h(10), q6.f1974g, false), null, false);
                } else {
                    cVar = new A.c(12, obj, Collections.EMPTY_LIST);
                }
                D1.b.w("OnlineState should not affect limbo documents.", ((List) cVar.f8c).isEmpty(), new Object[0]);
                S s6 = (S) cVar.f7b;
                if (s6 != null) {
                    arrayList.add(s6);
                }
            }
            jE.f1942m.b(arrayList);
            t1.n nVar = jE.f1942m;
            nVar.f9907a = i;
            Iterator it2 = ((HashMap) nVar.f9909c).values().iterator();
            while (it2.hasNext()) {
                for (N2.F f6 : ((C0160i) it2.next()).f2005a) {
                    f6.e = i;
                    S s7 = f6.f1926f;
                    if (s7 != null && !f6.f1925d && f6.d(s7, i)) {
                        f6.c(f6.f1926f);
                        z6 = true;
                    }
                }
            }
            if (z6) {
                nVar.c();
            }
        }
    }

    public void e(int i) {
        C0994k c0994k = (C0994k) this.f3011d;
        if (c0994k != null) {
            c0994k.C();
            this.f3011d = null;
        }
        this.f3009b = 0;
        if (i == 2) {
            this.f3010c = false;
        }
        d(i);
    }

    @Override // io.flutter.plugin.platform.g
    public int getHeight() {
        return this.f3009b;
    }

    @Override // io.flutter.plugin.platform.g
    public Surface getSurface() {
        Surface surface = (Surface) this.f3012f;
        if (surface == null || this.f3010c) {
            if (surface != null) {
                surface.release();
                this.f3012f = null;
            }
            this.f3012f = new Surface((SurfaceTexture) this.e);
            this.f3010c = false;
        }
        SurfaceTexture surfaceTexture = (SurfaceTexture) this.e;
        if (surfaceTexture == null || surfaceTexture.isReleased()) {
            return null;
        }
        return (Surface) this.f3012f;
    }

    @Override // io.flutter.plugin.platform.g
    public int getWidth() {
        return this.f3008a;
    }

    @Override // io.flutter.plugin.platform.g
    public void release() {
        this.e = null;
        Surface surface = (Surface) this.f3012f;
        if (surface != null) {
            surface.release();
            this.f3012f = null;
        }
    }
}
