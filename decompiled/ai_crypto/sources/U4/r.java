package U4;

import V4.j;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f5084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f5085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f5086c;

    public class a implements j.c {
        public a() {
        }

        private void a(V4.i iVar, j.d dVar) {
            try {
                r.this.f5085b.b(((Integer) iVar.b()).intValue());
                dVar.a(null);
            } catch (IllegalStateException e7) {
                dVar.b("error", r.c(e7), null);
            }
        }

        private void b(V4.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                r.this.f5085b.f(new b(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null));
                dVar.a(null);
            } catch (IllegalStateException e7) {
                dVar.b("error", r.c(e7), null);
            }
        }

        private void c(V4.i iVar, j.d dVar) {
            try {
                r.this.f5085b.c(((Integer) ((Map) iVar.b()).get(DiagnosticsEntry.ID_KEY)).intValue());
                dVar.a(null);
            } catch (IllegalStateException e7) {
                dVar.b("error", r.c(e7), null);
            }
        }

        private void e(V4.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                r.this.f5085b.a(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.a(null);
            } catch (IllegalStateException e7) {
                dVar.b("error", r.c(e7), null);
            }
        }

        private void f(V4.i iVar, j.d dVar) {
            j.d dVar2;
            List list = (List) iVar.b();
            try {
                r.this.f5085b.e(new c(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar2 = dVar;
            } catch (IllegalStateException e7) {
                e = e7;
                dVar2 = dVar;
            }
            try {
                dVar2.a(null);
            } catch (IllegalStateException e8) {
                e = e8;
                dVar2.b("error", r.c(e), null);
            }
        }

        public final void d(V4.i iVar, j.d dVar) {
            dVar.a(Boolean.valueOf(r.this.f5085b.d()));
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            if (r.this.f5085b == null) {
            }
            J4.b.f("PlatformViewsChannel2", "Received '" + iVar.f5332a + "' message.");
            String str = iVar.f5332a;
            str.hashCode();
            switch (str) {
                case "create":
                    b(iVar, dVar);
                    break;
                case "clearFocus":
                    a(iVar, dVar);
                    break;
                case "touch":
                    f(iVar, dVar);
                    break;
                case "setDirection":
                    e(iVar, dVar);
                    break;
                case "isSurfaceControlEnabled":
                    d(iVar, dVar);
                    break;
                case "dispose":
                    c(iVar, dVar);
                    break;
                default:
                    dVar.c();
                    break;
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f5090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f5091d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f5092e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ByteBuffer f5093f;

        public b(int i7, String str, double d7, double d8, int i8, ByteBuffer byteBuffer) {
            this.f5088a = i7;
            this.f5089b = str;
            this.f5090c = d7;
            this.f5091d = d8;
            this.f5092e = i8;
            this.f5093f = byteBuffer;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Number f5095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Number f5096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f5098e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f5099f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Object f5100g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f5101h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f5102i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float f5103j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f5104k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f5105l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f5106m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f5107n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f5108o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final long f5109p;

        public c(int i7, Number number, Number number2, int i8, int i9, Object obj, Object obj2, int i10, int i11, float f7, float f8, int i12, int i13, int i14, int i15, long j7) {
            this.f5094a = i7;
            this.f5095b = number;
            this.f5096c = number2;
            this.f5097d = i8;
            this.f5098e = i9;
            this.f5099f = obj;
            this.f5100g = obj2;
            this.f5101h = i10;
            this.f5102i = i11;
            this.f5103j = f7;
            this.f5104k = f8;
            this.f5105l = i12;
            this.f5106m = i13;
            this.f5107n = i14;
            this.f5108o = i15;
            this.f5109p = j7;
        }
    }

    public interface d {
        void a(int i7, int i8);

        void b(int i7);

        void c(int i7);

        boolean d();

        void e(c cVar);

        void f(b bVar);
    }

    public r(M4.a aVar) {
        a aVar2 = new a();
        this.f5086c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/platform_views_2", V4.p.f5347b);
        this.f5084a = jVar;
        jVar.e(aVar2);
    }

    public static String c(Exception exc) {
        return J4.b.d(exc);
    }

    public void d(int i7) {
        V4.j jVar = this.f5084a;
        if (jVar == null) {
            return;
        }
        jVar.c("viewFocused", Integer.valueOf(i7));
    }

    public void e(d dVar) {
        this.f5085b = dVar;
    }
}
