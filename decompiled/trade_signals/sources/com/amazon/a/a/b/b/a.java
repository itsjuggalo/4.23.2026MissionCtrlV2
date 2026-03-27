package com.amazon.a.a.b.b;

import com.amazon.a.a.o.c;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.amazon.a.a.n.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f13688b = new c("SubmitCrashReportsTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.b.a f13689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<com.amazon.a.a.b.c> f13690d;

    @Override // com.amazon.a.a.n.a.a
    public void a(h hVar) {
    }

    @Override // com.amazon.a.a.n.a.a
    public String a_() {
        return "submit_crash_reports";
    }

    @Override // com.amazon.a.a.n.a.a
    public Map<String, Object> b() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<com.amazon.a.a.b.c> it = this.f13690d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        map.put("reports", arrayList);
        return map;
    }

    @Override // com.amazon.a.a.n.a.a
    public String c() {
        return "1.0";
    }

    @Override // com.amazon.a.a.n.a.a
    public boolean d() {
        return !this.f13690d.isEmpty();
    }

    @Override // com.amazon.a.a.n.a.a
    public void e() {
        this.f13690d = this.f13689c.a();
        if (c.f14105a) {
            c cVar = f13688b;
            cVar.a("--------------- Crash Reports -------------------");
            cVar.a("Size: " + this.f13690d.size());
            cVar.a("--------------------------------------------------");
        }
    }

    @Override // com.amazon.a.a.n.a.a
    public void a(j jVar) {
        this.f13689c.a(this.f13690d);
    }
}
