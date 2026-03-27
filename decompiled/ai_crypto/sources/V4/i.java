package V4;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5333b;

    public i(String str, Object obj) {
        this.f5332a = str;
        this.f5333b = obj;
    }

    public Object a(String str) {
        Object obj = this.f5333b;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    public Object b() {
        return this.f5333b;
    }

    public boolean c(String str) {
        Object obj = this.f5333b;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).has(str);
        }
        throw new ClassCastException();
    }
}
