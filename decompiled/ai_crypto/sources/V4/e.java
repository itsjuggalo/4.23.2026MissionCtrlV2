package V4;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f5330a = new e();

    @Override // V4.h
    public ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object objA = g.a(obj);
        return objA instanceof String ? q.f5350b.a(JSONObject.quote((String) objA)) : q.f5350b.a(objA.toString());
    }

    @Override // V4.h
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(q.f5350b.b(byteBuffer));
            Object objNextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return objNextValue;
        } catch (JSONException e7) {
            throw new IllegalArgumentException("Invalid JSON", e7);
        }
    }
}
