package Z3;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4014b;

    public n(Object obj, String str) {
        this.f4013a = str;
        this.f4014b = obj;
    }

    public final Object a(String str) {
        Object obj = this.f4014b;
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
}
