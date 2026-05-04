package u7;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map f22390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f22391h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f22393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f22394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d8.d f22395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c8.j f22396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r7.i f22397f = r7.i.f19381a;

    static {
        HashMap map = new HashMap();
        f22390g = map;
        map.put("armeabi", 5);
        map.put("armeabi-v7a", 6);
        map.put("arm64-v8a", 9);
        map.put("x86", 0);
        map.put("x86_64", 1);
        f22391h = String.format(Locale.US, "Crashlytics Android SDK/%s", "20.0.3");
    }

    public y(Context context, h0 h0Var, a aVar, d8.d dVar, c8.j jVar) {
        this.f22392a = context;
        this.f22393b = h0Var;
        this.f22394c = aVar;
        this.f22395d = dVar;
        this.f22396e = jVar;
    }

    public static long f(long j10) {
        if (j10 > 0) {
            return j10;
        }
        return 0L;
    }

    public static int g() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = (Integer) f22390g.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    public final f0.e.d.a.c A(f0.a aVar) {
        return this.f22397f.a(aVar.e(), aVar.d(), aVar.c());
    }

    public final f0.a a(f0.a aVar) {
        List listUnmodifiableList;
        if (!this.f22396e.b().f3712b.f3721c || this.f22394c.f22221c.size() <= 0) {
            listUnmodifiableList = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (f fVar : this.f22394c.f22221c) {
                arrayList.add(f0.a.AbstractC0430a.a().d(fVar.c()).b(fVar.a()).c(fVar.b()).a());
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return f0.a.a().c(aVar.c()).e(aVar.e()).g(aVar.g()).i(aVar.i()).d(aVar.d()).f(aVar.f()).h(aVar.h()).j(aVar.j()).b(listUnmodifiableList).a();
    }

    public final f0.b b() {
        return x7.f0.b().l("20.0.3").h(this.f22394c.f22219a).i(this.f22393b.a().c()).g(this.f22393b.a().e()).f(this.f22393b.a().d()).d(this.f22394c.f22224f).e(this.f22394c.f22225g).k(4);
    }

    public f0.e.d c(f0.a aVar) {
        int i10 = this.f22392a.getResources().getConfiguration().orientation;
        return f0.e.d.a().g("anr").f(aVar.i()).b(k(i10, a(aVar))).c(l(i10)).a();
    }

    public f0.e.d d(Throwable th, Thread thread, String str, long j10, int i10, int i11, boolean z10) {
        int i12 = this.f22392a.getResources().getConfiguration().orientation;
        return f0.e.d.a().g(str).f(j10).b(j(i12, d8.e.a(th, this.f22395d), thread, i10, i11, z10)).c(l(i12)).a();
    }

    public x7.f0 e(String str, long j10) {
        return b().m(t(str, j10)).a();
    }

    public final f0.e.d.a.b.AbstractC0434a h() {
        return f0.e.d.a.b.AbstractC0434a.a().b(0L).d(0L).c(this.f22394c.f22223e).e(this.f22394c.f22220b).a();
    }

    public final List i() {
        return Collections.singletonList(h());
    }

    public final f0.e.d.a j(int i10, d8.e eVar, Thread thread, int i11, int i12, boolean z10) {
        Boolean boolValueOf;
        f0.e.d.a.c cVarE = this.f22397f.e(this.f22392a);
        if (cVarE.b() > 0) {
            boolValueOf = Boolean.valueOf(cVarE.b() != 100);
        } else {
            boolValueOf = null;
        }
        return f0.e.d.a.a().c(boolValueOf).d(cVarE).b(this.f22397f.d(this.f22392a)).h(i10).f(o(eVar, thread, i11, i12, z10)).a();
    }

    public final f0.e.d.a k(int i10, f0.a aVar) {
        return f0.e.d.a.a().c(Boolean.valueOf(aVar.c() != 100)).d(A(aVar)).h(i10).f(p(aVar)).a();
    }

    public final f0.e.d.c l(int i10) {
        e eVarA = e.a(this.f22392a);
        Float fB = eVarA.b();
        Double dValueOf = fB != null ? Double.valueOf(fB.doubleValue()) : null;
        int iC = eVarA.c();
        boolean zN = i.n(this.f22392a);
        return f0.e.d.c.a().b(dValueOf).c(iC).f(zN).e(i10).g(f(i.b(this.f22392a) - i.a(this.f22392a))).d(i.c(Environment.getDataDirectory().getPath())).a();
    }

    public final f0.e.d.a.b.c m(d8.e eVar, int i10, int i11) {
        return n(eVar, i10, i11, 0);
    }

    public final f0.e.d.a.b.c n(d8.e eVar, int i10, int i11, int i12) {
        String str = eVar.f7839b;
        String str2 = eVar.f7838a;
        StackTraceElement[] stackTraceElementArr = eVar.f7840c;
        int i13 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        d8.e eVar2 = eVar.f7841d;
        if (i12 >= i11) {
            d8.e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f7841d;
                i13++;
            }
        }
        f0.e.d.a.b.c.AbstractC0437a abstractC0437aD = f0.e.d.a.b.c.a().f(str).e(str2).c(r(stackTraceElementArr, i10)).d(i13);
        if (eVar2 != null && i13 == 0) {
            abstractC0437aD.b(n(eVar2, i10, i11, i12 + 1));
        }
        return abstractC0437aD.a();
    }

    public final f0.e.d.a.b o(d8.e eVar, Thread thread, int i10, int i11, boolean z10) {
        return f0.e.d.a.b.a().f(z(eVar, thread, i10, z10)).d(m(eVar, i10, i11)).e(w()).c(i()).a();
    }

    public final f0.e.d.a.b p(f0.a aVar) {
        return f0.e.d.a.b.a().b(aVar).e(w()).c(i()).a();
    }

    public final f0.e.d.a.b.AbstractC0440e.AbstractC0442b q(StackTraceElement stackTraceElement, f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a abstractC0443a) {
        long lineNumber = 0;
        long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            lineNumber = stackTraceElement.getLineNumber();
        }
        return abstractC0443a.e(jMax).f(str).b(fileName).d(lineNumber).a();
    }

    public final List r(StackTraceElement[] stackTraceElementArr, int i10) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(q(stackTraceElement, f0.e.d.a.b.AbstractC0440e.AbstractC0442b.a().c(i10)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final f0.e.a s() {
        return f0.e.a.a().e(this.f22393b.f()).g(this.f22394c.f22224f).d(this.f22394c.f22225g).f(this.f22393b.a().c()).b(this.f22394c.f22226h.d()).c(this.f22394c.f22226h.e()).a();
    }

    public final f0.e t(String str, long j10) {
        return f0.e.a().m(j10).j(str).h(f22391h).b(s()).l(v()).e(u()).i(3).a();
    }

    public final f0.e.c u() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int iG = g();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jB = i.b(this.f22392a);
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean zX = i.x();
        int iL = i.l();
        String str = Build.MANUFACTURER;
        return f0.e.c.a().b(iG).f(Build.MODEL).c(iAvailableProcessors).h(jB).d(blockCount).i(zX).j(iL).e(str).g(Build.PRODUCT).a();
    }

    public final f0.e.AbstractC0447e v() {
        return f0.e.AbstractC0447e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(i.y()).a();
    }

    public final f0.e.d.a.b.AbstractC0438d w() {
        return f0.e.d.a.b.AbstractC0438d.a().d("0").c("0").b(0L).a();
    }

    public final f0.e.d.a.b.AbstractC0440e x(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return y(thread, stackTraceElementArr, 0);
    }

    public final f0.e.d.a.b.AbstractC0440e y(Thread thread, StackTraceElement[] stackTraceElementArr, int i10) {
        return f0.e.d.a.b.AbstractC0440e.a().d(thread.getName()).c(i10).b(r(stackTraceElementArr, i10)).a();
    }

    public final List z(d8.e eVar, Thread thread, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(y(thread, eVar.f7840c, i10));
        if (z10) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(x(key, this.f22395d.a(entry.getValue())));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
