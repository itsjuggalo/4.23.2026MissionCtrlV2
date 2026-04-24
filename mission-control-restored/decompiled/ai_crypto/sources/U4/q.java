package U4;

import U4.q;
import V4.j;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f5046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f5047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f5048c;

    public class a implements j.c {
        public a() {
        }

        public static /* synthetic */ void e(j.d dVar, c cVar) {
            if (cVar == null) {
                dVar.b("error", "Failed to resize the platform view", null);
                return;
            }
            HashMap map = new HashMap();
            map.put("width", Double.valueOf(cVar.f5050a));
            map.put("height", Double.valueOf(cVar.f5051b));
            dVar.a(map);
        }

        public final void b(V4.i iVar, j.d dVar) {
            try {
                q.this.f5047b.b(((Integer) iVar.b()).intValue());
                dVar.a(null);
            } catch (IllegalStateException e7) {
                dVar.b("error", q.c(e7), null);
            }
        }

        public final void c(V4.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            boolean z7 = false;
            boolean z8 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            ByteBuffer byteBufferWrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (z8) {
                    q.this.f5047b.e(new d(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), d.a.HYBRID_ONLY, byteBufferWrap));
                    dVar.a(null);
                    return;
                }
                if (map.containsKey("hybridFallback") && ((Boolean) map.get("hybridFallback")).booleanValue()) {
                    z7 = true;
                }
                long jH = q.this.f5047b.h(new d(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z7 ? d.a.TEXTURE_WITH_HYBRID_FALLBACK : d.a.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBufferWrap));
                if (jH != -2) {
                    dVar.a(Long.valueOf(jH));
                } else {
                    if (!z7) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                    dVar.a(null);
                }
            } catch (IllegalStateException e7) {
                dVar.b("error", q.c(e7), null);
            }
        }

        public final void d(V4.i iVar, j.d dVar) {
            try {
                q.this.f5047b.c(((Integer) ((Map) iVar.b()).get(DiagnosticsEntry.ID_KEY)).intValue());
                dVar.a(null);
            } catch (IllegalStateException e7) {
                dVar.b("error", q.c(e7), null);
            }
        }

        public final void f(V4.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                q.this.f5047b.i(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                dVar.a(null);
            } catch (IllegalStateException e7) {
                dVar.b("error", q.c(e7), null);
            }
        }

        public final void g(V4.i iVar, final j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                q.this.f5047b.g(new e(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new b() { // from class: U4.p
                    @Override // U4.q.b
                    public final void a(q.c cVar) {
                        q.a.e(dVar, cVar);
                    }
                });
            } catch (IllegalStateException e7) {
                dVar.b("error", q.c(e7), null);
            }
        }

        public final void h(V4.i iVar, j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                q.this.f5047b.a(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.a(null);
            } catch (IllegalStateException e7) {
                dVar.b("error", q.c(e7), null);
            }
        }

        public final void i(V4.i iVar, j.d dVar) {
            try {
                q.this.f5047b.d(((Boolean) iVar.b()).booleanValue());
                dVar.a(null);
            } catch (IllegalStateException e7) {
                dVar.b("error", q.c(e7), null);
            }
        }

        public final void j(V4.i iVar, j.d dVar) {
            j.d dVar2;
            List list = (List) iVar.b();
            try {
                q.this.f5047b.f(new f(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar2 = dVar;
            } catch (IllegalStateException e7) {
                e = e7;
                dVar2 = dVar;
            }
            try {
                dVar2.a(null);
            } catch (IllegalStateException e8) {
                e = e8;
                dVar2.b("error", q.c(e), null);
            }
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            if (q.this.f5047b == null) {
            }
            J4.b.f("PlatformViewsChannel", "Received '" + iVar.f5332a + "' message.");
            String str = iVar.f5332a;
            str.hashCode();
            switch (str) {
                case "create":
                    c(iVar, dVar);
                    break;
                case "offset":
                    f(iVar, dVar);
                    break;
                case "resize":
                    g(iVar, dVar);
                    break;
                case "clearFocus":
                    b(iVar, dVar);
                    break;
                case "synchronizeToNativeViewHierarchy":
                    i(iVar, dVar);
                    break;
                case "touch":
                    j(iVar, dVar);
                    break;
                case "setDirection":
                    h(iVar, dVar);
                    break;
                case "dispose":
                    d(iVar, dVar);
                    break;
                default:
                    dVar.c();
                    break;
            }
        }
    }

    public interface b {
        void a(c cVar);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5051b;

        public c(int i7, int i8) {
            this.f5050a = i7;
            this.f5051b = i8;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f5054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f5055d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f5056e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final double f5057f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f5058g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a f5059h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ByteBuffer f5060i;

        public enum a {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public d(int i7, String str, double d7, double d8, double d9, double d10, int i8, a aVar, ByteBuffer byteBuffer) {
            this.f5052a = i7;
            this.f5053b = str;
            this.f5056e = d7;
            this.f5057f = d8;
            this.f5054c = d9;
            this.f5055d = d10;
            this.f5058g = i8;
            this.f5059h = aVar;
            this.f5060i = byteBuffer;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f5066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f5067c;

        public e(int i7, double d7, double d8) {
            this.f5065a = i7;
            this.f5066b = d7;
            this.f5067c = d8;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Number f5069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Number f5070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f5072e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f5073f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Object f5074g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f5075h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f5076i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float f5077j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f5078k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f5079l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f5080m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f5081n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f5082o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final long f5083p;

        public f(int i7, Number number, Number number2, int i8, int i9, Object obj, Object obj2, int i10, int i11, float f7, float f8, int i12, int i13, int i14, int i15, long j7) {
            this.f5068a = i7;
            this.f5069b = number;
            this.f5070c = number2;
            this.f5071d = i8;
            this.f5072e = i9;
            this.f5073f = obj;
            this.f5074g = obj2;
            this.f5075h = i10;
            this.f5076i = i11;
            this.f5077j = f7;
            this.f5078k = f8;
            this.f5079l = i12;
            this.f5080m = i13;
            this.f5081n = i14;
            this.f5082o = i15;
            this.f5083p = j7;
        }
    }

    public interface g {
        void a(int i7, int i8);

        void b(int i7);

        void c(int i7);

        void d(boolean z7);

        void e(d dVar);

        void f(f fVar);

        void g(e eVar, b bVar);

        long h(d dVar);

        void i(int i7, double d7, double d8);
    }

    public q(M4.a aVar) {
        a aVar2 = new a();
        this.f5048c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/platform_views", V4.p.f5347b);
        this.f5046a = jVar;
        jVar.e(aVar2);
    }

    public static String c(Exception exc) {
        return J4.b.d(exc);
    }

    public void d(int i7) {
        V4.j jVar = this.f5046a;
        if (jVar == null) {
            return;
        }
        jVar.c("viewFocused", Integer.valueOf(i7));
    }

    public void e(g gVar) {
        this.f5047b = gVar;
    }
}
