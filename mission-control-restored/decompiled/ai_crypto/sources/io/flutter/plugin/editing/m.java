package io.flutter.plugin.editing;

import U4.z;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class m extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16661a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16662b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f16663c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f16664d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f16665e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f16667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BaseInputConnection f16672l;

    public class a extends BaseInputConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Editable f16673a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, boolean z7, Editable editable) {
            super(view, z7);
            this.f16673a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f16673a;
        }
    }

    public interface b {
        void a(boolean z7, boolean z8, boolean z9);
    }

    public m(z.e eVar, View view) {
        this.f16672l = new a(view, true, this);
        if (eVar != null) {
            n(eVar);
        }
    }

    public void a(b bVar) {
        if (this.f16662b > 0) {
            J4.b.b("ListenableEditingState", "adding a listener " + bVar.toString() + " in a listener callback");
        }
        if (this.f16661a <= 0) {
            this.f16663c.add(bVar);
        } else {
            J4.b.g("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            this.f16664d.add(bVar);
        }
    }

    public void b() {
        this.f16661a++;
        if (this.f16662b > 0) {
            J4.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f16661a != 1 || this.f16663c.isEmpty()) {
            return;
        }
        this.f16667g = toString();
        this.f16668h = i();
        this.f16669i = h();
        this.f16670j = g();
        this.f16671k = f();
    }

    public void c() {
        this.f16665e.clear();
    }

    public void d() {
        int i7 = this.f16661a;
        if (i7 == 0) {
            J4.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i7 == 1) {
            Iterator it = this.f16664d.iterator();
            while (it.hasNext()) {
                j((b) it.next(), true, true, true);
            }
            if (!this.f16663c.isEmpty()) {
                J4.b.f("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.f16663c.size()) + " listener(s)");
                k(!toString().equals(this.f16667g), (this.f16668h == i() && this.f16669i == h()) ? false : true, (this.f16670j == g() && this.f16671k == f()) ? false : true);
            }
        }
        this.f16663c.addAll(this.f16664d);
        this.f16664d.clear();
        this.f16661a--;
    }

    public ArrayList e() {
        ArrayList arrayList = new ArrayList(this.f16665e);
        this.f16665e.clear();
        return arrayList;
    }

    public final int f() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int g() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int h() {
        return Selection.getSelectionEnd(this);
    }

    public final int i() {
        return Selection.getSelectionStart(this);
    }

    public final void j(b bVar, boolean z7, boolean z8, boolean z9) {
        this.f16662b++;
        bVar.a(z7, z8, z9);
        this.f16662b--;
    }

    public final void k(boolean z7, boolean z8, boolean z9) {
        if (z7 || z8 || z9) {
            Iterator it = this.f16663c.iterator();
            while (it.hasNext()) {
                j((b) it.next(), z7, z8, z9);
            }
        }
    }

    public void l(b bVar) {
        if (this.f16662b > 0) {
            J4.b.b("ListenableEditingState", "removing a listener " + bVar.toString() + " in a listener callback");
        }
        this.f16663c.remove(bVar);
        if (this.f16661a > 0) {
            this.f16664d.remove(bVar);
        }
    }

    public void m(int i7, int i8) {
        if (i7 < 0 || i7 >= i8) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f16672l.setComposingRegion(i7, i8);
        }
    }

    public void n(z.e eVar) {
        b();
        replace(0, length(), (CharSequence) eVar.f5185a);
        if (eVar.c()) {
            Selection.setSelection(this, eVar.f5186b, eVar.f5187c);
        } else {
            Selection.removeSelection(this);
        }
        m(eVar.f5188d, eVar.f5189e);
        c();
        d();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i7, int i8, int i9) {
        super.setSpan(obj, i7, i8, i9);
        this.f16665e.add(new s(toString(), i(), h(), g(), f()));
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.f16666f;
        if (str != null) {
            return str;
        }
        String string = super.toString();
        this.f16666f = string;
        return string;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i7, int i8, CharSequence charSequence, int i9, int i10) {
        boolean z7;
        boolean z8;
        if (this.f16662b > 0) {
            J4.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String string = toString();
        int i11 = i8 - i7;
        boolean z9 = i11 != i10 - i9;
        for (int i12 = 0; i12 < i11 && !z9; i12++) {
            z9 |= charAt(i7 + i12) != charSequence.charAt(i9 + i12);
        }
        if (z9) {
            this.f16666f = null;
        }
        int i13 = i();
        int iH = h();
        int iG = g();
        int iF = f();
        SpannableStringBuilder spannableStringBuilderReplace = super.replace(i7, i8, charSequence, i9, i10);
        boolean z10 = z9;
        this.f16665e.add(new s(string, i7, i8, charSequence, i(), h(), g(), f()));
        if (this.f16661a > 0) {
            return spannableStringBuilderReplace;
        }
        boolean z11 = (i() == i13 && h() == iH) ? false : true;
        if (g() == iG && f() == iF) {
            z7 = z10;
            z8 = false;
        } else {
            z7 = z10;
            z8 = true;
        }
        k(z7, z11, z8);
        return spannableStringBuilderReplace;
    }
}
