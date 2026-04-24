package U;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class s extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3095b;

    public s(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f3095b = new ArrayList();
        F1.h.f(cls, "watcherClass cannot be null");
        this.f3094a = cls;
    }

    public final void a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3095b;
            if (i >= arrayList.size()) {
                return;
            }
            ((r) arrayList.get(i)).f3093b.incrementAndGet();
            i++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3095b;
            if (i >= arrayList.size()) {
                return;
            }
            ((r) arrayList.get(i)).onTextChanged(this, 0, length(), length());
            i++;
        }
    }

    public final r c(Object obj) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3095b;
            if (i >= arrayList.size()) {
                return null;
            }
            r rVar = (r) arrayList.get(i);
            if (rVar.f3092a == obj) {
                return rVar;
            }
            i++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            return this.f3094a == obj.getClass();
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i, int i6) {
        super.delete(i, i6);
        return this;
    }

    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3095b;
            if (i >= arrayList.size()) {
                return;
            }
            ((r) arrayList.get(i)).f3093b.decrementAndGet();
            i++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        r rVarC;
        if (d(obj) && (rVarC = c(obj)) != null) {
            obj = rVarC;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        r rVarC;
        if (d(obj) && (rVarC = c(obj)) != null) {
            obj = rVarC;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        r rVarC;
        if (d(obj) && (rVarC = c(obj)) != null) {
            obj = rVarC;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i, int i6, Class cls) {
        if (this.f3094a != cls) {
            return super.getSpans(i, i6, cls);
        }
        r[] rVarArr = (r[]) super.getSpans(i, i6, r.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, rVarArr.length);
        for (int i7 = 0; i7 < rVarArr.length; i7++) {
            objArr[i7] = rVarArr[i7].f3092a;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i, int i6, Class cls) {
        if (cls == null || this.f3094a == cls) {
            cls = r.class;
        }
        return super.nextSpanTransition(i, i6, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        r rVarC;
        if (d(obj)) {
            rVarC = c(obj);
            if (rVarC != null) {
                obj = rVarC;
            }
        } else {
            rVarC = null;
        }
        super.removeSpan(obj);
        if (rVarC != null) {
            this.f3095b.remove(rVarC);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i6, CharSequence charSequence) {
        replace(i, i6, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i, int i6, int i7) {
        if (d(obj)) {
            r rVar = new r(obj);
            this.f3095b.add(rVar);
            obj = rVar;
        }
        super.setSpan(obj, i, i6, i7);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i, int i6) {
        return new s(this.f3094a, this, i, i6);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i, int i6) {
        super.delete(i, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i6, CharSequence charSequence, int i7, int i8) {
        replace(i, i6, charSequence, i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i, CharSequence charSequence, int i6, int i7) {
        super.insert(i, charSequence, i6, i7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i6, CharSequence charSequence) {
        a();
        super.replace(i, i6, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c6) {
        super.append(c6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence, int i6, int i7) {
        super.insert(i, charSequence, i6, i7);
        return this;
    }

    public s(Class cls, s sVar, int i, int i6) {
        super(sVar, i, i6);
        this.f3095b = new ArrayList();
        F1.h.f(cls, "watcherClass cannot be null");
        this.f3094a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c6) {
        super.append(c6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c6) {
        super.append(c6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i6, CharSequence charSequence, int i7, int i8) {
        a();
        super.replace(i, i6, charSequence, i7, i8);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i, int i6) {
        super.append(charSequence, i, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i, int i6) {
        super.append(charSequence, i, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i6) {
        super.append(charSequence, i, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }
}
