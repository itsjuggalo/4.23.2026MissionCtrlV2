package U4;

import V4.a;
import android.view.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.a f4964a;

    public interface a {
        void a(boolean z7);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KeyEvent f4965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Character f4966b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f4965a = keyEvent;
            this.f4966b = ch;
        }
    }

    public i(V4.b bVar) {
        this.f4964a = new V4.a(bVar, "flutter/keyevent", V4.e.f5330a);
    }

    public static a.e b(final a aVar) {
        return new a.e() { // from class: U4.h
            @Override // V4.a.e
            public final void a(Object obj) {
                i.d(aVar, obj);
            }
        };
    }

    public static /* synthetic */ void d(a aVar, Object obj) {
        boolean z7 = false;
        if (obj != null) {
            try {
                z7 = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e7) {
                J4.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e7);
            }
        }
        aVar.a(z7);
    }

    public final Map c(b bVar, boolean z7) {
        HashMap map = new HashMap();
        map.put("type", z7 ? "keyup" : "keydown");
        map.put("keymap", "android");
        map.put("flags", Integer.valueOf(bVar.f4965a.getFlags()));
        map.put("plainCodePoint", Integer.valueOf(bVar.f4965a.getUnicodeChar(0)));
        map.put("codePoint", Integer.valueOf(bVar.f4965a.getUnicodeChar()));
        map.put("keyCode", Integer.valueOf(bVar.f4965a.getKeyCode()));
        map.put("scanCode", Integer.valueOf(bVar.f4965a.getScanCode()));
        map.put("metaState", Integer.valueOf(bVar.f4965a.getMetaState()));
        Character ch = bVar.f4966b;
        if (ch != null) {
            map.put("character", ch.toString());
        }
        map.put("source", Integer.valueOf(bVar.f4965a.getSource()));
        map.put("deviceId", Integer.valueOf(bVar.f4965a.getDeviceId()));
        map.put("repeatCount", Integer.valueOf(bVar.f4965a.getRepeatCount()));
        return map;
    }

    public void e(b bVar, boolean z7, a aVar) {
        this.f4964a.d(c(bVar, z7), b(aVar));
    }
}
