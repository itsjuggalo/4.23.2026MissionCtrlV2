package io.flutter.plugin.editing;

import Y3.o;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7098a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7099b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7100c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f7101d = new ArrayList();
    public final ArrayList e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7102f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7103k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7104l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7105m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7106n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7107o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f7108p;

    public e(o oVar, View view) {
        this.f7108p = new c(view, this);
        if (oVar != null) {
            f(oVar);
        }
    }

    public final void a(d dVar) {
        if (this.f7099b > 0) {
            Log.e("ListenableEditingState", "adding a listener " + dVar.toString() + " in a listener callback");
        }
        if (this.f7098a <= 0) {
            this.f7100c.add(dVar);
        } else {
            Log.w("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            this.f7101d.add(dVar);
        }
    }

    public final void b() {
        this.f7098a++;
        if (this.f7099b > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f7098a != 1 || this.f7100c.isEmpty()) {
            return;
        }
        this.f7103k = toString();
        this.f7104l = Selection.getSelectionStart(this);
        this.f7105m = Selection.getSelectionEnd(this);
        this.f7106n = BaseInputConnection.getComposingSpanStart(this);
        this.f7107o = BaseInputConnection.getComposingSpanEnd(this);
    }

    public final void c() {
        int i = this.f7098a;
        if (i == 0) {
            Log.e("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        ArrayList arrayList = this.f7100c;
        ArrayList<d> arrayList2 = this.f7101d;
        if (i == 1) {
            for (d dVar : arrayList2) {
                this.f7099b++;
                dVar.a(true);
                this.f7099b--;
            }
            if (!arrayList.isEmpty()) {
                String.valueOf(arrayList.size());
                d(!toString().equals(this.f7103k), (this.f7104l == Selection.getSelectionStart(this) && this.f7105m == Selection.getSelectionEnd(this)) ? false : true, (this.f7106n == BaseInputConnection.getComposingSpanStart(this) && this.f7107o == BaseInputConnection.getComposingSpanEnd(this)) ? false : true);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList2.clear();
        this.f7098a--;
    }

    public final void d(boolean z6, boolean z7, boolean z8) {
        if (z6 || z7 || z8) {
            for (d dVar : this.f7100c) {
                this.f7099b++;
                dVar.a(z6);
                this.f7099b--;
            }
        }
    }

    public final void e(d dVar) {
        if (this.f7099b > 0) {
            Log.e("ListenableEditingState", "removing a listener " + dVar.toString() + " in a listener callback");
        }
        this.f7100c.remove(dVar);
        if (this.f7098a > 0) {
            this.f7101d.remove(dVar);
        }
    }

    public final void f(o oVar) {
        int i;
        b();
        replace(0, length(), (CharSequence) oVar.f3685a);
        int i6 = oVar.f3686b;
        if (i6 >= 0) {
            Selection.setSelection(this, i6, oVar.f3687c);
        } else {
            Selection.removeSelection(this);
        }
        int i7 = oVar.f3688d;
        if (i7 < 0 || i7 >= (i = oVar.e)) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f7108p.setComposingRegion(i7, i);
        }
        this.e.clear();
        c();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i, int i6, int i7) {
        super.setSpan(obj, i, i6, i7);
        ArrayList arrayList = this.e;
        String string = toString();
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        g gVar = new g();
        gVar.e = selectionStart;
        gVar.f7117f = selectionEnd;
        gVar.f7118g = composingSpanStart;
        gVar.f7119h = composingSpanEnd;
        gVar.f7113a = string;
        gVar.f7114b = "";
        gVar.f7115c = -1;
        gVar.f7116d = -1;
        arrayList.add(gVar);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final String toString() {
        String str = this.f7102f;
        if (str != null) {
            return str;
        }
        String string = super.toString();
        this.f7102f = string;
        return string;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i6, CharSequence charSequence, int i7, int i8) {
        if (this.f7099b > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String string = toString();
        int i9 = i6 - i;
        boolean z6 = i9 != i8 - i7;
        for (int i10 = 0; i10 < i9 && !z6; i10++) {
            z6 |= charAt(i + i10) != charSequence.charAt(i7 + i10);
        }
        if (z6) {
            this.f7102f = null;
        }
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        SpannableStringBuilder spannableStringBuilderReplace = super.replace(i, i6, charSequence, i7, i8);
        ArrayList arrayList = this.e;
        int selectionStart2 = Selection.getSelectionStart(this);
        int selectionEnd2 = Selection.getSelectionEnd(this);
        int composingSpanStart2 = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd2 = BaseInputConnection.getComposingSpanEnd(this);
        g gVar = new g();
        gVar.e = selectionStart2;
        gVar.f7117f = selectionEnd2;
        gVar.f7118g = composingSpanStart2;
        gVar.f7119h = composingSpanEnd2;
        String string2 = charSequence.toString();
        gVar.f7113a = string;
        gVar.f7114b = string2;
        gVar.f7115c = i;
        gVar.f7116d = i6;
        arrayList.add(gVar);
        if (this.f7098a > 0) {
            return spannableStringBuilderReplace;
        }
        d(z6, (Selection.getSelectionStart(this) == selectionStart && Selection.getSelectionEnd(this) == selectionEnd) ? false : true, (BaseInputConnection.getComposingSpanStart(this) == composingSpanStart && BaseInputConnection.getComposingSpanEnd(this) == composingSpanEnd) ? false : true);
        return spannableStringBuilderReplace;
    }
}
