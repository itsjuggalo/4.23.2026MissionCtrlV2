package io.flutter.plugin.editing;

import io.flutter.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class TextEditingDelta {
    private static final String TAG = "TextEditingDelta";
    private int deltaEnd;
    private int deltaStart;
    private CharSequence deltaText;
    private int newComposingEnd;
    private int newComposingStart;
    private int newSelectionEnd;
    private int newSelectionStart;
    private CharSequence oldText;

    public TextEditingDelta(CharSequence charSequence, int i4, int i5, CharSequence charSequence2, int i6, int i7, int i8, int i9) {
        this.newSelectionStart = i6;
        this.newSelectionEnd = i7;
        this.newComposingStart = i8;
        this.newComposingEnd = i9;
        setDeltas(charSequence, charSequence2.toString(), i4, i5);
    }

    private void setDeltas(CharSequence charSequence, CharSequence charSequence2, int i4, int i5) {
        this.oldText = charSequence;
        this.deltaText = charSequence2;
        this.deltaStart = i4;
        this.deltaEnd = i5;
    }

    public int getDeltaEnd() {
        return this.deltaEnd;
    }

    public int getDeltaStart() {
        return this.deltaStart;
    }

    public CharSequence getDeltaText() {
        return this.deltaText;
    }

    public int getNewComposingEnd() {
        return this.newComposingEnd;
    }

    public int getNewComposingStart() {
        return this.newComposingStart;
    }

    public int getNewSelectionEnd() {
        return this.newSelectionEnd;
    }

    public int getNewSelectionStart() {
        return this.newSelectionStart;
    }

    public CharSequence getOldText() {
        return this.oldText;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.oldText.toString());
            jSONObject.put("deltaText", this.deltaText.toString());
            jSONObject.put("deltaStart", this.deltaStart);
            jSONObject.put("deltaEnd", this.deltaEnd);
            jSONObject.put("selectionBase", this.newSelectionStart);
            jSONObject.put("selectionExtent", this.newSelectionEnd);
            jSONObject.put("composingBase", this.newComposingStart);
            jSONObject.put("composingExtent", this.newComposingEnd);
            return jSONObject;
        } catch (JSONException e4) {
            Log.e(TAG, "unable to create JSONObject: " + e4);
            return jSONObject;
        }
    }

    public TextEditingDelta(CharSequence charSequence, int i4, int i5, int i6, int i7) {
        this.newSelectionStart = i4;
        this.newSelectionEnd = i5;
        this.newComposingStart = i6;
        this.newComposingEnd = i7;
        setDeltas(charSequence, "", -1, -1);
    }
}
