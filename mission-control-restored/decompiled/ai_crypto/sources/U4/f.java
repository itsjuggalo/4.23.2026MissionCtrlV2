package U4;

import V4.j;
import android.window.BackEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f4956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j.c f4957b;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            dVar.a(null);
        }
    }

    public f(M4.a aVar) {
        a aVar2 = new a();
        this.f4957b = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/backgesture", V4.p.f5347b);
        this.f4956a = jVar;
        jVar.e(aVar2);
    }

    public final Map a(BackEvent backEvent) {
        HashMap map = new HashMap(3);
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        map.put("touchOffset", (Float.isNaN(touchX) || Float.isNaN(touchY)) ? null : Arrays.asList(Float.valueOf(touchX), Float.valueOf(touchY)));
        map.put("progress", Float.valueOf(backEvent.getProgress()));
        map.put("swipeEdge", Integer.valueOf(backEvent.getSwipeEdge()));
        return map;
    }

    public void b() {
        J4.b.f("BackGestureChannel", "Sending message to cancel back gesture");
        this.f4956a.c("cancelBackGesture", null);
    }

    public void c() {
        J4.b.f("BackGestureChannel", "Sending message to commit back gesture");
        this.f4956a.c("commitBackGesture", null);
    }

    public void d(BackEvent backEvent) {
        J4.b.f("BackGestureChannel", "Sending message to start back gesture");
        this.f4956a.c("startBackGesture", a(backEvent));
    }

    public void e(BackEvent backEvent) {
        J4.b.f("BackGestureChannel", "Sending message to update back gesture progress");
        this.f4956a.c("updateBackGestureProgress", a(backEvent));
    }
}
