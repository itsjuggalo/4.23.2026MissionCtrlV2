package m5;

import V4.a;
import V4.o;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import m5.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    public interface a {
        static V4.h a() {
            return b.f18990d;
        }

        static void c(V4.b bVar, a aVar) {
            t(bVar, "", aVar);
        }

        static /* synthetic */ void e(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, aVar.s((c) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = h.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void g(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, aVar.d());
            } catch (Throwable th) {
                arrayList = h.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void k(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, aVar.i());
            } catch (Throwable th) {
                arrayList = h.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void o(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, aVar.m());
            } catch (Throwable th) {
                arrayList = h.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void r(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, aVar.n());
            } catch (Throwable th) {
                arrayList = h.a(th);
            }
            eVar.a(arrayList);
        }

        static void t(V4.b bVar, String str, final a aVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getTemporaryPath" + str2, a(), bVar.c());
            if (aVar != null) {
                aVar2.e(new a.d() { // from class: m5.a
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        h.a.x(this.f18983a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getApplicationSupportPath" + str2, a(), bVar.c());
            if (aVar != null) {
                aVar3.e(new a.d() { // from class: m5.b
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        h.a.u(this.f18984a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getApplicationDocumentsPath" + str2, a(), bVar.c());
            if (aVar != null) {
                aVar4.e(new a.d() { // from class: m5.c
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        h.a.r(this.f18985a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(bVar, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getApplicationCachePath" + str2, a(), bVar.c());
            if (aVar != null) {
                aVar5.e(new a.d() { // from class: m5.d
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        h.a.o(this.f18986a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            V4.a aVar6 = new V4.a(bVar, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getExternalStoragePath" + str2, a(), bVar.c());
            if (aVar != null) {
                aVar6.e(new a.d() { // from class: m5.e
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        h.a.k(this.f18987a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            V4.a aVar7 = new V4.a(bVar, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getExternalCachePaths" + str2, a(), bVar.c());
            if (aVar != null) {
                aVar7.e(new a.d() { // from class: m5.f
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        h.a.g(this.f18988a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            V4.a aVar8 = new V4.a(bVar, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getExternalStoragePaths" + str2, a(), bVar.c());
            if (aVar != null) {
                aVar8.e(new a.d() { // from class: m5.g
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        h.a.e(this.f18989a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
        }

        static /* synthetic */ void u(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, aVar.q());
            } catch (Throwable th) {
                arrayList = h.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void x(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, aVar.l());
            } catch (Throwable th) {
                arrayList = h.a(th);
            }
            eVar.a(arrayList);
        }

        List d();

        String i();

        String l();

        String m();

        String n();

        String q();

        List s(c cVar);
    }

    public static class b extends o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f18990d = new b();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            if (b7 != -127) {
                return super.g(b7, byteBuffer);
            }
            Object objF = f(byteBuffer);
            if (objF == null) {
                return null;
            }
            return c.values()[((Long) objF).intValue()];
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (!(obj instanceof c)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, obj == null ? null : Integer.valueOf(((c) obj).f19003a));
            }
        }
    }

    public enum c {
        ROOT(0),
        MUSIC(1),
        PODCASTS(2),
        RINGTONES(3),
        ALARMS(4),
        NOTIFICATIONS(5),
        PICTURES(6),
        MOVIES(7),
        DOWNLOADS(8),
        DCIM(9),
        DOCUMENTS(10);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19003a;

        c(int i7) {
            this.f19003a = i7;
        }
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }
}
