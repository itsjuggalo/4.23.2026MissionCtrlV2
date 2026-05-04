package u7;

import android.app.ApplicationExitInfo;
import android.content.Context;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f22353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a8.e f22354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b8.b f22355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w7.f f22356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w7.o f22357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f22358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v7.i f22359g;

    public r0(y yVar, a8.e eVar, b8.b bVar, w7.f fVar, w7.o oVar, h0 h0Var, v7.i iVar) {
        this.f22353a = yVar;
        this.f22354b = eVar;
        this.f22355c = bVar;
        this.f22356d = fVar;
        this.f22357e = oVar;
        this.f22358f = h0Var;
        this.f22359g = iVar;
    }

    public static /* synthetic */ void a(r0 r0Var, f0.e.d dVar, w7.c cVar, boolean z10) {
        r0Var.getClass();
        r7.g.f().b("disk worker: log non-fatal event to persistence");
        r0Var.f22354b.w(dVar, cVar.b(), z10);
    }

    public static f0.a h(ApplicationExitInfo applicationExitInfo) {
        String strI = null;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                strI = i(traceInputStream);
            }
        } catch (IOException e10) {
            r7.g.f().k("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e10);
        }
        return f0.a.a().c(applicationExitInfo.getImportance()).e(applicationExitInfo.getProcessName()).g(applicationExitInfo.getReason()).i(applicationExitInfo.getTimestamp()).d(applicationExitInfo.getPid()).f(applicationExitInfo.getPss()).h(applicationExitInfo.getRss()).j(strI).a();
    }

    public static String i(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bArr = new byte[8192];
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        while (true) {
            int i10 = bufferedInputStream.read(bArr);
            if (i10 == -1) {
                String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                byteArrayOutputStream.close();
                bufferedInputStream.close();
                return string;
            }
            byteArrayOutputStream.write(bArr, 0, i10);
            bufferedInputStream.close();
            throw th;
        }
    }

    public static r0 j(Context context, h0 h0Var, a8.g gVar, a aVar, w7.f fVar, w7.o oVar, d8.d dVar, c8.j jVar, m0 m0Var, m mVar, v7.i iVar) {
        return new r0(new y(context, h0Var, aVar, dVar, jVar), new a8.e(gVar, jVar, mVar), b8.b.b(context, jVar, m0Var), fVar, oVar, h0Var, iVar);
    }

    public static List o(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(f0.c.a().b((String) entry.getKey()).c((String) entry.getValue()).a());
        }
        Collections.sort(arrayList, new Comparator() { // from class: u7.q0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((f0.c) obj).b().compareTo(((f0.c) obj2).b());
            }
        });
        return Collections.unmodifiableList(arrayList);
    }

    public final f0.e.d d(f0.e.d dVar, w7.f fVar, w7.o oVar) {
        return e(dVar, fVar, oVar, Collections.EMPTY_MAP);
    }

    public final f0.e.d e(f0.e.d dVar, w7.f fVar, w7.o oVar, Map map) {
        f0.e.d.b bVarH = dVar.h();
        String strC = fVar.c();
        if (strC != null) {
            bVarH.d(f0.e.d.AbstractC0445d.a().b(strC).a());
        } else {
            r7.g.f().i("No log data to include with this event.");
        }
        List listO = o(oVar.f(map));
        List listO2 = o(oVar.g());
        if (!listO.isEmpty() || !listO2.isEmpty()) {
            bVarH.b(dVar.b().i().e(listO).g(listO2).a());
        }
        return bVarH.a();
    }

    public final f0.e.d f(f0.e.d dVar, Map map) {
        return g(e(dVar, this.f22356d, this.f22357e, map), this.f22357e);
    }

    public final f0.e.d g(f0.e.d dVar, w7.o oVar) {
        List listH = oVar.h();
        if (listH.isEmpty()) {
            return dVar;
        }
        f0.e.d.b bVarH = dVar.h();
        bVarH.e(f0.e.d.f.a().b(listH).a());
        return bVarH.a();
    }

    public final z k(z zVar) {
        if (zVar.b().h() != null && zVar.b().g() != null) {
            return zVar;
        }
        g0 g0VarD = this.f22358f.d(true);
        return z.a(zVar.b().t(g0VarD.b()).s(g0VarD.a()), zVar.d(), zVar.c());
    }

    public void l(String str, List list, f0.a aVar) {
        r7.g.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f0.d.b bVarC = ((k0) it.next()).c();
            if (bVarC != null) {
                arrayList.add(bVarC);
            }
        }
        this.f22354b.l(str, f0.d.a().b(Collections.unmodifiableList(arrayList)).a(), aVar);
    }

    public void m(long j10, String str) {
        this.f22354b.k(str, j10);
    }

    public final ApplicationExitInfo n(String str, List list) {
        long jQ = this.f22354b.q(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ApplicationExitInfo applicationExitInfoA = n0.a(it.next());
            if (applicationExitInfoA.getTimestamp() < jQ) {
                return null;
            }
            if (applicationExitInfoA.getReason() == 6) {
                return applicationExitInfoA;
            }
        }
        return null;
    }

    public boolean p() {
        return this.f22354b.r();
    }

    public SortedSet q() {
        return this.f22354b.p();
    }

    public void r(String str, long j10) {
        this.f22354b.x(this.f22353a.e(str, j10));
    }

    public final boolean s(Task task) {
        if (!task.isSuccessful()) {
            r7.g.f().l("Crashlytics report could not be enqueued to DataTransport", task.getException());
            return false;
        }
        z zVar = (z) task.getResult();
        r7.g.f().b("Crashlytics report successfully enqueued to DataTransport: " + zVar.d());
        File fileC = zVar.c();
        if (fileC.delete()) {
            r7.g.f().b("Deleted report file: " + fileC.getPath());
            return true;
        }
        r7.g.f().k("Crashlytics could not delete report file: " + fileC.getPath());
        return true;
    }

    public final void t(Throwable th, Thread thread, String str, final w7.c cVar, boolean z10) {
        final boolean zEquals = str.equals(AppMeasurement.CRASH_ORIGIN);
        final f0.e.d dVarF = f(this.f22353a.d(th, thread, str, cVar.c(), 4, 8, z10), cVar.a());
        if (z10) {
            this.f22354b.w(dVarF, cVar.b(), zEquals);
        } else {
            this.f22359g.f23153b.e(new Runnable() { // from class: u7.o0
                @Override // java.lang.Runnable
                public final void run() {
                    r0.a(this.f22309a, dVarF, cVar, zEquals);
                }
            });
        }
    }

    public void u(Throwable th, Thread thread, String str, long j10) {
        r7.g.f().i("Persisting fatal event for session " + str);
        t(th, thread, AppMeasurement.CRASH_ORIGIN, new w7.c(str, j10), true);
    }

    public void v(String str, List list, w7.f fVar, w7.o oVar) {
        ApplicationExitInfo applicationExitInfoN = n(str, list);
        if (applicationExitInfoN == null) {
            r7.g.f().i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        f0.e.d dVarC = this.f22353a.c(h(applicationExitInfoN));
        r7.g.f().b("Persisting anr for session " + str);
        this.f22354b.w(g(d(dVarC, fVar, oVar), oVar), str, true);
    }

    public void w() {
        this.f22354b.i();
    }

    public Task x(Executor executor) {
        return y(executor, null);
    }

    public Task y(Executor executor, String str) {
        List<z> listU = this.f22354b.u();
        ArrayList arrayList = new ArrayList();
        for (z zVar : listU) {
            if (str == null || str.equals(zVar.d())) {
                arrayList.add(this.f22355c.c(k(zVar), str != null).continueWith(executor, new Continuation() { // from class: u7.p0
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        return Boolean.valueOf(this.f22349a.s(task));
                    }
                }));
            }
        }
        return Tasks.whenAll(arrayList);
    }
}
