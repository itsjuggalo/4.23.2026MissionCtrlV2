package U4;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.a f5154a;

    public y(M4.a aVar) {
        this.f5154a = new V4.a(aVar, "flutter/system", V4.e.f5330a);
    }

    public void a() {
        J4.b.f("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap map = new HashMap(1);
        map.put("type", "memoryPressure");
        this.f5154a.c(map);
    }
}
