package com.amazon.a.a.h.a;

import com.amazon.a.a.h.b;
import com.amazon.a.a.o.c;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.amazon.a.a.n.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f8466b = new c("SubmitMetricsTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c f8467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f8468d;

    @Override // com.amazon.a.a.n.a.a
    public void a(h hVar) {
    }

    @Override // com.amazon.a.a.n.a.a
    public String a_() {
        return "submit_metrics";
    }

    @Override // com.amazon.a.a.n.a.a
    public Map<String, Object> b() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList(this.f8468d.c());
        Iterator<com.amazon.a.a.h.a> it = this.f8468d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        map.put("metrics", arrayList);
        return map;
    }

    @Override // com.amazon.a.a.n.a.a
    public String c() {
        return "1.0";
    }

    @Override // com.amazon.a.a.n.a.a
    public boolean d() {
        return !this.f8468d.a();
    }

    @Override // com.amazon.a.a.n.a.a
    public void e() {
        this.f8468d = this.f8467c.a();
        if (c.f8809a) {
            c cVar = f8466b;
            cVar.a("--------------- SUBMIT METRICS -------------------");
            cVar.a("Size: " + this.f8468d.c());
            cVar.a("--------------------------------------------------");
        }
    }

    @Override // com.amazon.a.a.n.a.a
    public void a(j jVar) {
    }
}
