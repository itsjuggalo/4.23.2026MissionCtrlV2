package Y3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3688d;
    public final int e;

    public o(String str, int i, int i6, int i7, int i8) {
        if (!(i == -1 && i6 == -1) && (i < 0 || i6 < 0)) {
            throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i) + ", " + String.valueOf(i6) + ")");
        }
        if (!(i7 == -1 && i8 == -1) && (i7 < 0 || i7 > i8)) {
            throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i7) + ", " + String.valueOf(i8) + ")");
        }
        if (i8 > str.length()) {
            throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i7));
        }
        if (i > str.length()) {
            throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i));
        }
        if (i6 > str.length()) {
            throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i6));
        }
        this.f3685a = str;
        this.f3686b = i;
        this.f3687c = i6;
        this.f3688d = i7;
        this.e = i8;
    }

    public static o a(JSONObject jSONObject) {
        return new o(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
    }
}
