package i5;

import V4.a;
import android.util.Log;
import i5.F;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class F {

    public interface a {

        /* JADX INFO: renamed from: i5.F$a$a, reason: collision with other inner class name */
        public class C0254a implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16300a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16301b;

            public C0254a(ArrayList arrayList, a.e eVar) {
                this.f16300a = arrayList;
                this.f16301b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16301b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(f fVar) {
                this.f16300a.add(0, fVar);
                this.f16301b.a(this.f16300a);
            }
        }

        public class b implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16302a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16303b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f16302a = arrayList;
                this.f16303b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16303b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(byte[] bArr) {
                this.f16302a.add(0, bArr);
                this.f16303b.a(this.f16302a);
            }
        }

        public class c implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16304a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16305b;

            public c(ArrayList arrayList, a.e eVar) {
                this.f16304a = arrayList;
                this.f16305b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16305b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f16304a.add(0, str);
                this.f16305b.a(this.f16304a);
            }
        }

        public class d implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16306a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16307b;

            public d(ArrayList arrayList, a.e eVar) {
                this.f16306a = arrayList;
                this.f16307b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16307b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f16306a.add(0, str);
                this.f16307b.a(this.f16306a);
            }
        }

        public class e implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16308a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16309b;

            public e(ArrayList arrayList, a.e eVar) {
                this.f16308a = arrayList;
                this.f16309b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16309b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f16308a.add(0, str);
                this.f16309b.a(this.f16308a);
            }
        }

        public class f implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16310a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16311b;

            public f(ArrayList arrayList, a.e eVar) {
                this.f16310a = arrayList;
                this.f16311b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16311b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f16310a.add(0, str);
                this.f16311b.a(this.f16310a);
            }
        }

        public class g implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16312a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16313b;

            public g(ArrayList arrayList, a.e eVar) {
                this.f16312a = arrayList;
                this.f16313b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16313b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(d dVar) {
                this.f16312a.add(0, dVar);
                this.f16313b.a(this.f16312a);
            }
        }

        public class h implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16314a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16315b;

            public h(ArrayList arrayList, a.e eVar) {
                this.f16314a = arrayList;
                this.f16315b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16315b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Map map) {
                this.f16314a.add(0, map);
                this.f16315b.a(this.f16314a);
            }
        }

        public class i implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16316a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16317b;

            public i(ArrayList arrayList, a.e eVar) {
                this.f16316a = arrayList;
                this.f16317b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16317b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Map map) {
                this.f16316a.add(0, map);
                this.f16317b.a(this.f16316a);
            }
        }

        public class j implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16318a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16319b;

            public j(ArrayList arrayList, a.e eVar) {
                this.f16318a = arrayList;
                this.f16319b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16319b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Map map) {
                this.f16318a.add(0, map);
                this.f16319b.a(this.f16318a);
            }
        }

        public class k implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16320a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16321b;

            public k(ArrayList arrayList, a.e eVar) {
                this.f16320a = arrayList;
                this.f16321b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16321b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(i iVar) {
                this.f16320a.add(0, iVar);
                this.f16321b.a(this.f16320a);
            }
        }

        public class l implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16322a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16323b;

            public l(ArrayList arrayList, a.e eVar) {
                this.f16322a = arrayList;
                this.f16323b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16323b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f16322a.add(0, null);
                this.f16323b.a(this.f16322a);
            }
        }

        public class m implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16324a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16325b;

            public m(ArrayList arrayList, a.e eVar) {
                this.f16324a = arrayList;
                this.f16325b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16325b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f16324a.add(0, null);
                this.f16325b.a(this.f16324a);
            }
        }

        public class n implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16326a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16327b;

            public n(ArrayList arrayList, a.e eVar) {
                this.f16326a = arrayList;
                this.f16327b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16327b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f16326a.add(0, null);
                this.f16327b.a(this.f16326a);
            }
        }

        public class o implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16328a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16329b;

            public o(ArrayList arrayList, a.e eVar) {
                this.f16328a = arrayList;
                this.f16329b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16329b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f16328a.add(0, null);
                this.f16329b.a(this.f16328a);
            }
        }

        public class p implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16330a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16331b;

            public p(ArrayList arrayList, a.e eVar) {
                this.f16330a = arrayList;
                this.f16331b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16331b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f16330a.add(0, null);
                this.f16331b.a(this.f16330a);
            }
        }

        public class q implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16332a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16333b;

            public q(ArrayList arrayList, a.e eVar) {
                this.f16332a = arrayList;
                this.f16333b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16333b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f16332a.add(0, str);
                this.f16333b.a(this.f16332a);
            }
        }

        public class r implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16334a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16335b;

            public r(ArrayList arrayList, a.e eVar) {
                this.f16334a = arrayList;
                this.f16335b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16335b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(d dVar) {
                this.f16334a.add(0, dVar);
                this.f16335b.a(this.f16334a);
            }
        }

        public class s implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f16336a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f16337b;

            public s(ArrayList arrayList, a.e eVar) {
                this.f16336a = arrayList;
                this.f16337b = eVar;
            }

            @Override // i5.F.k
            public void b(Throwable th) {
                this.f16337b.a(F.a(th));
            }

            @Override // i5.F.k
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(f fVar) {
                this.f16336a.add(0, fVar);
                this.f16337b.a(this.f16336a);
            }
        }

        static /* synthetic */ void A(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            aVar.T((h) arrayList.get(0), (i) arrayList.get(1), new r(new ArrayList(), eVar));
        }

        static /* synthetic */ void D(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            i iVar = (i) arrayList2.get(1);
            Number number = (Number) arrayList2.get(2);
            aVar.l(hVar, iVar, number == null ? null : Long.valueOf(number.longValue()), new b(arrayList, eVar));
        }

        static /* synthetic */ void H(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            Number number = (Number) arrayList2.get(2);
            aVar.x(hVar, str, number == null ? null : Long.valueOf(number.longValue()), new o(arrayList, eVar));
        }

        static /* synthetic */ void I(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            i iVar = (i) arrayList2.get(1);
            String str = (String) arrayList2.get(2);
            g gVar = (g) arrayList2.get(3);
            Number number = (Number) arrayList2.get(4);
            aVar.E(hVar, iVar, str, gVar, number == null ? null : Long.valueOf(number.longValue()), new e(arrayList, eVar));
        }

        static /* synthetic */ void L(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            aVar.z((h) arrayList.get(0), (i) arrayList.get(1), new p(new ArrayList(), eVar));
        }

        static /* synthetic */ void P(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            i iVar = (i) arrayList2.get(1);
            String str = (String) arrayList2.get(2);
            Number number = (Number) arrayList2.get(3);
            g gVar = (g) arrayList2.get(4);
            Number number2 = (Number) arrayList2.get(5);
            aVar.B(hVar, iVar, str, number == null ? null : Long.valueOf(number.longValue()), gVar, number2 == null ? null : Long.valueOf(number2.longValue()), new d(arrayList, eVar));
        }

        static /* synthetic */ void R(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            Number number = (Number) arrayList2.get(1);
            aVar.S(hVar, number == null ? null : Long.valueOf(number.longValue()), new m(arrayList, eVar));
        }

        static /* synthetic */ void U(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            aVar.X((h) arrayList.get(0), (i) arrayList.get(1), (g) arrayList.get(2), new g(new ArrayList(), eVar));
        }

        static /* synthetic */ void W(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            Number number = (Number) arrayList2.get(1);
            aVar.o(hVar, number == null ? null : Long.valueOf(number.longValue()), new n(arrayList, eVar));
        }

        static V4.h a() {
            return b.f16338d;
        }

        static /* synthetic */ void b(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            Number number = (Number) arrayList2.get(1);
            aVar.b0(hVar, number == null ? null : Long.valueOf(number.longValue()), new i(arrayList, eVar));
        }

        static /* synthetic */ void c(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            aVar.N((h) arrayList.get(0), (i) arrayList.get(1), (e) arrayList.get(2), new s(new ArrayList(), eVar));
        }

        static void d(V4.b bVar, final a aVar) {
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.getReferencebyPath", a());
            if (aVar != null) {
                aVar2.e(new a.d() { // from class: i5.m
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.f(this.f16425a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.setMaxOperationRetryTime", a());
            if (aVar != null) {
                aVar3.e(new a.d() { // from class: i5.n
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.k(this.f16426a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.setMaxUploadRetryTime", a());
            if (aVar != null) {
                aVar4.e(new a.d() { // from class: i5.o
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.R(this.f16427a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.setMaxDownloadRetryTime", a());
            if (aVar != null) {
                aVar5.e(new a.d() { // from class: i5.p
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.W(this.f16428a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            V4.a aVar6 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.useStorageEmulator", a());
            if (aVar != null) {
                aVar6.e(new a.d() { // from class: i5.q
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.H(this.f16429a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            V4.a aVar7 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referenceDelete", a());
            if (aVar != null) {
                aVar7.e(new a.d() { // from class: i5.r
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.L(this.f16430a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            V4.a aVar8 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referenceGetDownloadURL", a());
            if (aVar != null) {
                aVar8.e(new a.d() { // from class: i5.s
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.q(this.f16431a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            V4.a aVar9 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referenceGetMetaData", a());
            if (aVar != null) {
                aVar9.e(new a.d() { // from class: i5.t
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.A(this.f16432a, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
            V4.a aVar10 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referenceList", a());
            if (aVar != null) {
                aVar10.e(new a.d() { // from class: i5.u
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.c(this.f16433a, obj, eVar);
                    }
                });
            } else {
                aVar10.e(null);
            }
            V4.a aVar11 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referenceListAll", a());
            if (aVar != null) {
                aVar11.e(new a.d() { // from class: i5.v
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.h(this.f16434a, obj, eVar);
                    }
                });
            } else {
                aVar11.e(null);
            }
            V4.a aVar12 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referenceGetData", a());
            if (aVar != null) {
                aVar12.e(new a.d() { // from class: i5.w
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.D(this.f16435a, obj, eVar);
                    }
                });
            } else {
                aVar12.e(null);
            }
            V4.a aVar13 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referencePutData", a());
            if (aVar != null) {
                aVar13.e(new a.d() { // from class: i5.x
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.r(this.f16436a, obj, eVar);
                    }
                });
            } else {
                aVar13.e(null);
            }
            V4.a aVar14 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referencePutString", a());
            if (aVar != null) {
                aVar14.e(new a.d() { // from class: i5.y
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.P(this.f16437a, obj, eVar);
                    }
                });
            } else {
                aVar14.e(null);
            }
            V4.a aVar15 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referencePutFile", a());
            if (aVar != null) {
                aVar15.e(new a.d() { // from class: i5.z
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.I(this.f16438a, obj, eVar);
                    }
                });
            } else {
                aVar15.e(null);
            }
            V4.a aVar16 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referenceDownloadFile", a());
            if (aVar != null) {
                aVar16.e(new a.d() { // from class: i5.A
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.g0(this.f16295a, obj, eVar);
                    }
                });
            } else {
                aVar16.e(null);
            }
            V4.a aVar17 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.referenceUpdateMetadata", a());
            if (aVar != null) {
                aVar17.e(new a.d() { // from class: i5.B
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.U(this.f16296a, obj, eVar);
                    }
                });
            } else {
                aVar17.e(null);
            }
            V4.a aVar18 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.taskPause", a());
            if (aVar != null) {
                aVar18.e(new a.d() { // from class: i5.C
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.m(this.f16297a, obj, eVar);
                    }
                });
            } else {
                aVar18.e(null);
            }
            V4.a aVar19 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.taskResume", a());
            if (aVar != null) {
                aVar19.e(new a.d() { // from class: i5.D
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.b(this.f16298a, obj, eVar);
                    }
                });
            } else {
                aVar19.e(null);
            }
            V4.a aVar20 = new V4.a(bVar, "dev.flutter.pigeon.firebase_storage_platform_interface.FirebaseStorageHostApi.taskCancel", a());
            if (aVar != null) {
                aVar20.e(new a.d() { // from class: i5.E
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        F.a.v(this.f16299a, obj, eVar);
                    }
                });
            } else {
                aVar20.e(null);
            }
        }

        static /* synthetic */ void f(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            aVar.J((h) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new k(new ArrayList(), eVar));
        }

        static /* synthetic */ void g0(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            i iVar = (i) arrayList2.get(1);
            String str = (String) arrayList2.get(2);
            Number number = (Number) arrayList2.get(3);
            aVar.f0(hVar, iVar, str, number == null ? null : Long.valueOf(number.longValue()), new f(arrayList, eVar));
        }

        static /* synthetic */ void h(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            aVar.i((h) arrayList.get(0), (i) arrayList.get(1), new C0254a(new ArrayList(), eVar));
        }

        static /* synthetic */ void k(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            Number number = (Number) arrayList2.get(1);
            aVar.e(hVar, number == null ? null : Long.valueOf(number.longValue()), new l(arrayList, eVar));
        }

        static /* synthetic */ void m(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            Number number = (Number) arrayList2.get(1);
            aVar.G(hVar, number == null ? null : Long.valueOf(number.longValue()), new h(arrayList, eVar));
        }

        static /* synthetic */ void q(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            aVar.F((h) arrayList.get(0), (i) arrayList.get(1), new q(new ArrayList(), eVar));
        }

        static /* synthetic */ void r(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            i iVar = (i) arrayList2.get(1);
            byte[] bArr = (byte[]) arrayList2.get(2);
            g gVar = (g) arrayList2.get(3);
            Number number = (Number) arrayList2.get(4);
            aVar.e0(hVar, iVar, bArr, gVar, number == null ? null : Long.valueOf(number.longValue()), new c(arrayList, eVar));
        }

        static /* synthetic */ void v(a aVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            h hVar = (h) arrayList2.get(0);
            Number number = (Number) arrayList2.get(1);
            aVar.y(hVar, number == null ? null : Long.valueOf(number.longValue()), new j(arrayList, eVar));
        }

        void B(h hVar, i iVar, String str, Long l7, g gVar, Long l8, k kVar);

        void E(h hVar, i iVar, String str, g gVar, Long l7, k kVar);

        void F(h hVar, i iVar, k kVar);

        void G(h hVar, Long l7, k kVar);

        void J(h hVar, String str, String str2, k kVar);

        void N(h hVar, i iVar, e eVar, k kVar);

        void S(h hVar, Long l7, k kVar);

        void T(h hVar, i iVar, k kVar);

        void X(h hVar, i iVar, g gVar, k kVar);

        void b0(h hVar, Long l7, k kVar);

        void e(h hVar, Long l7, k kVar);

        void e0(h hVar, i iVar, byte[] bArr, g gVar, Long l7, k kVar);

        void f0(h hVar, i iVar, String str, Long l7, k kVar);

        void i(h hVar, i iVar, k kVar);

        void l(h hVar, i iVar, Long l7, k kVar);

        void o(h hVar, Long l7, k kVar);

        void x(h hVar, String str, Long l7, k kVar);

        void y(h hVar, Long l7, k kVar);

        void z(h hVar, i iVar, k kVar);
    }

    public static class b extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f16338d = new b();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            switch (b7) {
                case -128:
                    return d.a((ArrayList) f(byteBuffer));
                case -127:
                    return e.a((ArrayList) f(byteBuffer));
                case -126:
                    return f.a((ArrayList) f(byteBuffer));
                case -125:
                    return g.a((ArrayList) f(byteBuffer));
                case -124:
                    return h.a((ArrayList) f(byteBuffer));
                case -123:
                    return i.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b7, byteBuffer);
            }
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof d) {
                byteArrayOutputStream.write(128);
                p(byteArrayOutputStream, ((d) obj).c());
                return;
            }
            if (obj instanceof e) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, ((e) obj).f());
                return;
            }
            if (obj instanceof f) {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, ((f) obj).e());
                return;
            }
            if (obj instanceof g) {
                byteArrayOutputStream.write(131);
                p(byteArrayOutputStream, ((g) obj).n());
            } else if (obj instanceof h) {
                byteArrayOutputStream.write(132);
                p(byteArrayOutputStream, ((h) obj).g());
            } else if (!(obj instanceof i)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(133);
                p(byteArrayOutputStream, ((i) obj).f());
            }
        }
    }

    public static class c extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f16340b;

        public c(String str, String str2, Object obj) {
            super(str2);
            this.f16339a = str;
            this.f16340b = obj;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map f16341a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Map f16342a;

            public d a() {
                d dVar = new d();
                dVar.b(this.f16342a);
                return dVar;
            }

            public a b(Map map) {
                this.f16342a = map;
                return this;
            }
        }

        public static d a(ArrayList arrayList) {
            d dVar = new d();
            dVar.b((Map) arrayList.get(0));
            return dVar;
        }

        public void b(Map map) {
            this.f16341a = map;
        }

        public ArrayList c() {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.f16341a);
            return arrayList;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f16343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16344b;

        public static e a(ArrayList arrayList) {
            Long lValueOf;
            e eVar = new e();
            Object obj = arrayList.get(0);
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            eVar.d(lValueOf);
            eVar.e((String) arrayList.get(1));
            return eVar;
        }

        public Long b() {
            return this.f16343a;
        }

        public String c() {
            return this.f16344b;
        }

        public void d(Long l7) {
            if (l7 == null) {
                throw new IllegalStateException("Nonnull field \"maxResults\" is null.");
            }
            this.f16343a = l7;
        }

        public void e(String str) {
            this.f16344b = str;
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f16343a);
            arrayList.add(this.f16344b);
            return arrayList;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f16345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f16347c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f16348a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f16349b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List f16350c;

            public f a() {
                f fVar = new f();
                fVar.b(this.f16348a);
                fVar.c(this.f16349b);
                fVar.d(this.f16350c);
                return fVar;
            }

            public a b(List list) {
                this.f16348a = list;
                return this;
            }

            public a c(String str) {
                this.f16349b = str;
                return this;
            }

            public a d(List list) {
                this.f16350c = list;
                return this;
            }
        }

        public static f a(ArrayList arrayList) {
            f fVar = new f();
            fVar.b((List) arrayList.get(0));
            fVar.c((String) arrayList.get(1));
            fVar.d((List) arrayList.get(2));
            return fVar;
        }

        public void b(List list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"items\" is null.");
            }
            this.f16345a = list;
        }

        public void c(String str) {
            this.f16346b = str;
        }

        public void d(List list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"prefixs\" is null.");
            }
            this.f16347c = list;
        }

        public ArrayList e() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f16345a);
            arrayList.add(this.f16346b);
            arrayList.add(this.f16347c);
            return arrayList;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f16354d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f16355e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map f16356f;

        public static g a(ArrayList arrayList) {
            g gVar = new g();
            gVar.h((String) arrayList.get(0));
            gVar.i((String) arrayList.get(1));
            gVar.j((String) arrayList.get(2));
            gVar.k((String) arrayList.get(3));
            gVar.l((String) arrayList.get(4));
            gVar.m((Map) arrayList.get(5));
            return gVar;
        }

        public String b() {
            return this.f16351a;
        }

        public String c() {
            return this.f16352b;
        }

        public String d() {
            return this.f16353c;
        }

        public String e() {
            return this.f16354d;
        }

        public String f() {
            return this.f16355e;
        }

        public Map g() {
            return this.f16356f;
        }

        public void h(String str) {
            this.f16351a = str;
        }

        public void i(String str) {
            this.f16352b = str;
        }

        public void j(String str) {
            this.f16353c = str;
        }

        public void k(String str) {
            this.f16354d = str;
        }

        public void l(String str) {
            this.f16355e = str;
        }

        public void m(Map map) {
            this.f16356f = map;
        }

        public ArrayList n() {
            ArrayList arrayList = new ArrayList(6);
            arrayList.add(this.f16351a);
            arrayList.add(this.f16352b);
            arrayList.add(this.f16353c);
            arrayList.add(this.f16354d);
            arrayList.add(this.f16355e);
            arrayList.add(this.f16356f);
            return arrayList;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16359c;

        public static h a(ArrayList arrayList) {
            h hVar = new h();
            hVar.d((String) arrayList.get(0));
            hVar.f((String) arrayList.get(1));
            hVar.e((String) arrayList.get(2));
            return hVar;
        }

        public String b() {
            return this.f16357a;
        }

        public String c() {
            return this.f16359c;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appName\" is null.");
            }
            this.f16357a = str;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"bucket\" is null.");
            }
            this.f16359c = str;
        }

        public void f(String str) {
            this.f16358b = str;
        }

        public ArrayList g() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f16357a);
            arrayList.add(this.f16358b);
            arrayList.add(this.f16359c);
            return arrayList;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16362c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f16363a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f16364b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f16365c;

            public i a() {
                i iVar = new i();
                iVar.c(this.f16363a);
                iVar.d(this.f16364b);
                iVar.e(this.f16365c);
                return iVar;
            }

            public a b(String str) {
                this.f16363a = str;
                return this;
            }

            public a c(String str) {
                this.f16364b = str;
                return this;
            }

            public a d(String str) {
                this.f16365c = str;
                return this;
            }
        }

        public static i a(ArrayList arrayList) {
            i iVar = new i();
            iVar.c((String) arrayList.get(0));
            iVar.d((String) arrayList.get(1));
            iVar.e((String) arrayList.get(2));
            return iVar;
        }

        public String b() {
            return this.f16361b;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"bucket\" is null.");
            }
            this.f16360a = str;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"fullPath\" is null.");
            }
            this.f16361b = str;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            this.f16362c = str;
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f16360a);
            arrayList.add(this.f16361b);
            arrayList.add(this.f16362c);
            return arrayList;
        }
    }

    public enum j {
        PAUSED(0),
        RUNNING(1),
        SUCCESS(2),
        CANCELED(3),
        ERROR(4);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16372a;

        j(int i7) {
            this.f16372a = i7;
        }
    }

    public interface k {
        void a(Object obj);

        void b(Throwable th);
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        if (th instanceof c) {
            c cVar = (c) th;
            arrayList.add(cVar.f16339a);
            arrayList.add(cVar.getMessage());
            arrayList.add(cVar.f16340b);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
