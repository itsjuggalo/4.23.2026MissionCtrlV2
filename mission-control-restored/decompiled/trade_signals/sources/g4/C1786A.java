package g4;

import android.content.Context;
import android.os.Process;
import g4.InterfaceC1834w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2489q;
import o5.InterfaceC2483k;

/* JADX INFO: renamed from: g4.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1786A implements InterfaceC1834w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2483k f18008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2483k f18010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2483k f18011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f18012f;

    public C1786A(Context appContext, final InterfaceC1810Z uuidGenerator) {
        AbstractC2304t.f(appContext, "appContext");
        AbstractC2304t.f(uuidGenerator, "uuidGenerator");
        this.f18007a = appContext;
        this.f18008b = AbstractC2484l.a(new Function0() { // from class: g4.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return C1786A.p(this.f18230a);
            }
        });
        this.f18009c = Process.myPid();
        this.f18010d = AbstractC2484l.a(new Function0() { // from class: g4.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return C1786A.q(uuidGenerator);
            }
        });
        this.f18011e = AbstractC2484l.a(new Function0() { // from class: g4.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return C1786A.o(this.f18232a);
            }
        });
    }

    public static final C1788C o(C1786A c1786a) {
        return C1789D.f18019a.b(c1786a.f18007a);
    }

    public static final String p(C1786A c1786a) {
        return c1786a.l().c();
    }

    public static final String q(InterfaceC1810Z interfaceC1810Z) {
        String string = interfaceC1810Z.next().toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }

    @Override // g4.InterfaceC1834w
    public void a() {
        this.f18012f = true;
    }

    @Override // g4.InterfaceC1834w
    public boolean b(Map processDataMap) {
        AbstractC2304t.f(processDataMap, "processDataMap");
        if (this.f18012f) {
            return false;
        }
        List<C1788C> listJ = j();
        ArrayList<C2489q> arrayList = new ArrayList();
        for (C1788C c1788c : listJ) {
            ProcessData processData = (ProcessData) processDataMap.get(c1788c.c());
            C2489q c2489q = processData != null ? new C2489q(c1788c, processData) : null;
            if (c2489q != null) {
                arrayList.add(c2489q);
            }
        }
        if (!arrayList.isEmpty()) {
            for (C2489q c2489q2 : arrayList) {
                if (!n((C1788C) c2489q2.a(), (ProcessData) c2489q2.b())) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // g4.InterfaceC1834w
    public String c() {
        return (String) this.f18008b.getValue();
    }

    @Override // g4.InterfaceC1834w
    public boolean d(Map processDataMap) {
        AbstractC2304t.f(processDataMap, "processDataMap");
        ProcessData processData = (ProcessData) processDataMap.get(c());
        return (processData != null && processData.getPid() == k() && AbstractC2304t.b(processData.getUuid(), m())) ? false : true;
    }

    @Override // g4.InterfaceC1834w
    public Map e() {
        return InterfaceC1834w.a.a(this);
    }

    @Override // g4.InterfaceC1834w
    public Map f(Map map) {
        Map mapY;
        if (map != null && (mapY = p5.M.y(map)) != null) {
            mapY.put(c(), new ProcessData(Process.myPid(), m()));
            Map mapW = p5.M.w(mapY);
            if (mapW != null) {
                return mapW;
            }
        }
        return p5.L.e(o5.w.a(c(), new ProcessData(Process.myPid(), m())));
    }

    public final List j() {
        return C1789D.f18019a.a(this.f18007a);
    }

    public int k() {
        return this.f18009c;
    }

    public final C1788C l() {
        return (C1788C) this.f18011e.getValue();
    }

    public String m() {
        return (String) this.f18010d.getValue();
    }

    public final boolean n(C1788C c1788c, ProcessData processData) {
        boolean zB = AbstractC2304t.b(c(), c1788c.c());
        int iB = c1788c.b();
        if (zB) {
            if (iB != processData.getPid() || !AbstractC2304t.b(m(), processData.getUuid())) {
                return true;
            }
        } else if (iB != processData.getPid()) {
            return true;
        }
        return false;
    }
}
