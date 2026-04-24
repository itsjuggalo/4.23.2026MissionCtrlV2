package h0;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class i extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f14707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f14708b;

    public static class a implements TextWatcher, SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f14710b = new AtomicInteger(0);

        public a(Object obj) {
            this.f14709a = obj;
        }

        public final void a() {
            this.f14710b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f14709a).afterTextChanged(editable);
        }

        public final boolean b(Object obj) {
            return obj instanceof f;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            ((TextWatcher) this.f14709a).beforeTextChanged(charSequence, i7, i8, i9);
        }

        public final void c() {
            this.f14710b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i7, int i8) {
            if (this.f14710b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f14709a).onSpanAdded(spannable, obj, i7, i8);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x001e A[PHI: r11
          0x001e: PHI (r11v1 int) = (r11v0 int), (r11v3 int) binds: [B:8:0x0013, B:12:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.text.SpanWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSpanChanged(android.text.Spannable r9, java.lang.Object r10, int r11, int r12, int r13, int r14) {
            /*
                r8 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r8.f14710b
                int r0 = r0.get()
                if (r0 <= 0) goto Lf
                boolean r0 = r8.b(r10)
                if (r0 == 0) goto Lf
                return
            Lf:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 28
                if (r0 >= r1) goto L1e
                r0 = 0
                if (r11 <= r12) goto L19
                r11 = r0
            L19:
                if (r13 <= r14) goto L1e
                r4 = r11
                r6 = r0
                goto L20
            L1e:
                r4 = r11
                r6 = r13
            L20:
                java.lang.Object r11 = r8.f14709a
                r1 = r11
                android.text.SpanWatcher r1 = (android.text.SpanWatcher) r1
                r2 = r9
                r3 = r10
                r5 = r12
                r7 = r14
                r1.onSpanChanged(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h0.i.a.onSpanChanged(android.text.Spannable, java.lang.Object, int, int, int, int):void");
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i7, int i8) {
            if (this.f14710b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f14709a).onSpanRemoved(spannable, obj, i7, i8);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            ((TextWatcher) this.f14709a).onTextChanged(charSequence, i7, i8, i9);
        }
    }

    public i(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f14708b = new ArrayList();
        P.f.h(cls, "watcherClass cannot be null");
        this.f14707a = cls;
    }

    public static i c(Class cls, CharSequence charSequence) {
        return new i(cls, charSequence);
    }

    public void a() {
        b();
    }

    public final void b() {
        for (int i7 = 0; i7 < this.f14708b.size(); i7++) {
            ((a) this.f14708b.get(i7)).a();
        }
    }

    public void d() {
        i();
        e();
    }

    public final void e() {
        for (int i7 = 0; i7 < this.f14708b.size(); i7++) {
            ((a) this.f14708b.get(i7)).onTextChanged(this, 0, length(), length());
        }
    }

    public final a f(Object obj) {
        for (int i7 = 0; i7 < this.f14708b.size(); i7++) {
            a aVar = (a) this.f14708b.get(i7);
            if (aVar.f14709a == obj) {
                return aVar;
            }
        }
        return null;
    }

    public final boolean g(Class cls) {
        return this.f14707a == cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public Object[] getSpans(int i7, int i8, Class cls) {
        if (!g(cls)) {
            return super.getSpans(i7, i8, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i7, i8, a.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, aVarArr.length);
        for (int i9 = 0; i9 < aVarArr.length; i9++) {
            objArr[i9] = aVarArr[i9].f14709a;
        }
        return objArr;
    }

    public final boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    public final void i() {
        for (int i7 = 0; i7 < this.f14708b.size(); i7++) {
            ((a) this.f14708b.get(i7)).c();
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i7, int i8, Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i7, i8, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        a aVarF;
        if (h(obj)) {
            aVarF = f(obj);
            if (aVarF != null) {
                obj = aVarF;
            }
        } else {
            aVarF = null;
        }
        super.removeSpan(obj);
        if (aVarF != null) {
            this.f14708b.remove(aVarF);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i7, int i8, int i9) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f14708b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i7, i8, i9);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i7, int i8) {
        return new i(this.f14707a, this, i7, i8);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i7, int i8) {
        super.delete(i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i7, CharSequence charSequence) {
        super.insert(i7, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i7, int i8, CharSequence charSequence) {
        b();
        super.replace(i7, i8, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i7, CharSequence charSequence, int i8, int i9) {
        super.insert(i7, charSequence, i8, i9);
        return this;
    }

    public i(Class cls, CharSequence charSequence, int i7, int i8) {
        super(charSequence, i7, i8);
        this.f14708b = new ArrayList();
        P.f.h(cls, "watcherClass cannot be null");
        this.f14707a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i7, int i8, CharSequence charSequence, int i9, int i10) {
        b();
        super.replace(i7, i8, charSequence, i9, i10);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c7) {
        super.append(c7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i7, int i8) {
        super.append(charSequence, i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i7) {
        super.append(charSequence, obj, i7);
        return this;
    }
}
