package io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f16682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f16683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16689h;

    public s(CharSequence charSequence, int i7, int i8, CharSequence charSequence2, int i9, int i10, int i11, int i12) {
        this.f16686e = i9;
        this.f16687f = i10;
        this.f16688g = i11;
        this.f16689h = i12;
        a(charSequence, charSequence2.toString(), i7, i8);
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2, int i7, int i8) {
        this.f16682a = charSequence;
        this.f16683b = charSequence2;
        this.f16684c = i7;
        this.f16685d = i8;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.f16682a.toString());
            jSONObject.put("deltaText", this.f16683b.toString());
            jSONObject.put("deltaStart", this.f16684c);
            jSONObject.put("deltaEnd", this.f16685d);
            jSONObject.put("selectionBase", this.f16686e);
            jSONObject.put("selectionExtent", this.f16687f);
            jSONObject.put("composingBase", this.f16688g);
            jSONObject.put("composingExtent", this.f16689h);
        } catch (JSONException e7) {
            J4.b.b("TextEditingDelta", "unable to create JSONObject: " + e7);
        }
        return jSONObject;
    }

    public s(CharSequence charSequence, int i7, int i8, int i9, int i10) {
        this.f16686e = i7;
        this.f16687f = i8;
        this.f16688g = i9;
        this.f16689h = i10;
        a(charSequence, "", -1, -1);
    }
}
