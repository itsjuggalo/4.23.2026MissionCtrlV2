package ua;

import android.content.Context;
import android.os.Process;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import ua.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cd.k f22506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cd.k f22508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cd.k f22509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22510f;

    public a0(Context appContext, final y0 uuidGenerator) {
        kotlin.jvm.internal.t.f(appContext, "appContext");
        kotlin.jvm.internal.t.f(uuidGenerator, "uuidGenerator");
        this.f22505a = appContext;
        this.f22506b = cd.l.b(new Function0() { // from class: ua.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a0.p(this.f22720a);
            }
        });
        this.f22507c = Process.myPid();
        this.f22508d = cd.l.b(new Function0() { // from class: ua.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a0.q(uuidGenerator);
            }
        });
        this.f22509e = cd.l.b(new Function0() { // from class: ua.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a0.o(this.f22723a);
            }
        });
    }

    public static final c0 o(a0 a0Var) {
        return d0.f22568a.b(a0Var.f22505a);
    }

    public static final String p(a0 a0Var) {
        return a0Var.l().c();
    }

    public static final String q(y0 y0Var) {
        String string = y0Var.next().toString();
        kotlin.jvm.internal.t.e(string, "toString(...)");
        return string;
    }

    @Override // ua.w
    public void a() {
        this.f22510f = true;
    }

    @Override // ua.w
    public boolean b(Map processDataMap) {
        kotlin.jvm.internal.t.f(processDataMap, "processDataMap");
        if (this.f22510f) {
            return false;
        }
        List<c0> listJ = j();
        ArrayList<cd.q> arrayList = new ArrayList();
        for (c0 c0Var : listJ) {
            ProcessData processData = (ProcessData) processDataMap.get(c0Var.c());
            cd.q qVar = processData != null ? new cd.q(c0Var, processData) : null;
            if (qVar != null) {
                arrayList.add(qVar);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        for (cd.q qVar2 : arrayList) {
            if (!n((c0) qVar2.a(), (ProcessData) qVar2.b())) {
                return false;
            }
        }
        return true;
    }

    @Override // ua.w
    public String c() {
        return (String) this.f22506b.getValue();
    }

    @Override // ua.w
    public boolean d(Map processDataMap) {
        kotlin.jvm.internal.t.f(processDataMap, "processDataMap");
        ProcessData processData = (ProcessData) processDataMap.get(c());
        return (processData != null && processData.getPid() == k() && kotlin.jvm.internal.t.b(processData.getUuid(), m())) ? false : true;
    }

    @Override // ua.w
    public Map e() {
        return w.a.a(this);
    }

    @Override // ua.w
    public Map f(Map map) {
        Map mapZ;
        if (map != null && (mapZ = dd.o0.z(map)) != null) {
            mapZ.put(c(), new ProcessData(Process.myPid(), m()));
            Map mapV = dd.o0.v(mapZ);
            if (mapV != null) {
                return mapV;
            }
        }
        return dd.n0.e(cd.w.a(c(), new ProcessData(Process.myPid(), m())));
    }

    public final List j() {
        return d0.f22568a.a(this.f22505a);
    }

    public int k() {
        return this.f22507c;
    }

    public final c0 l() {
        return (c0) this.f22509e.getValue();
    }

    public String m() {
        return (String) this.f22508d.getValue();
    }

    public final boolean n(c0 c0Var, ProcessData processData) {
        return kotlin.jvm.internal.t.b(c(), c0Var.c()) ? (c0Var.b() == processData.getPid() && kotlin.jvm.internal.t.b(m(), processData.getUuid())) ? false : true : c0Var.b() != processData.getPid();
    }
}
