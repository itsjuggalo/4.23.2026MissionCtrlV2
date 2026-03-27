package U4;

import V4.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f5116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public V4.j f5117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j.d f5118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j.c f5121g;

    public class b implements j.c {
        public b() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            String str = iVar.f5332a;
            Object obj = iVar.f5333b;
            str.hashCode();
            if (!str.equals(com.amazon.a.a.o.b.au)) {
                if (!str.equals("put")) {
                    dVar.c();
                    return;
                }
                t.this.f5116b = (byte[]) obj;
                dVar.a(null);
                return;
            }
            t.this.f5120f = true;
            if (!t.this.f5119e) {
                t tVar = t.this;
                if (tVar.f5115a) {
                    tVar.f5118d = dVar;
                    return;
                }
            }
            t tVar2 = t.this;
            dVar.a(tVar2.i(tVar2.f5116b));
        }
    }

    public t(M4.a aVar, boolean z7) {
        this(new V4.j(aVar, "flutter/restoration", V4.p.f5347b), z7);
    }

    public void g() {
        this.f5116b = null;
    }

    public byte[] h() {
        return this.f5116b;
    }

    public final Map i(byte[] bArr) {
        HashMap map = new HashMap();
        map.put("enabled", Boolean.TRUE);
        map.put("data", bArr);
        return map;
    }

    public void j(byte[] bArr) {
        this.f5119e = true;
        j.d dVar = this.f5118d;
        if (dVar != null) {
            dVar.a(i(bArr));
            this.f5118d = null;
            this.f5116b = bArr;
        } else if (this.f5120f) {
            this.f5117c.d("push", i(bArr), new a(bArr));
        } else {
            this.f5116b = bArr;
        }
    }

    public t(V4.j jVar, boolean z7) {
        this.f5119e = false;
        this.f5120f = false;
        b bVar = new b();
        this.f5121g = bVar;
        this.f5117c = jVar;
        this.f5115a = z7;
        jVar.e(bVar);
    }

    public class a implements j.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f5122a;

        public a(byte[] bArr) {
            this.f5122a = bArr;
        }

        @Override // V4.j.d
        public void a(Object obj) {
            t.this.f5116b = this.f5122a;
        }

        @Override // V4.j.d
        public void b(String str, String str2, Object obj) {
            J4.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // V4.j.d
        public void c() {
        }
    }
}
