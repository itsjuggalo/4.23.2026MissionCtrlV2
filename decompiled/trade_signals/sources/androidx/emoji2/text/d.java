package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.c;
import androidx.emoji2.text.f;
import h0.i;
import h0.j;
import h0.l;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.j f11493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f11494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.e f11495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f11497e;

    public static final class a {
        public static int a(CharSequence charSequence, int i8, int i9) {
            int length = charSequence.length();
            if (i8 < 0 || length < i8 || i9 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i9 != 0) {
                    i8--;
                    if (i8 < 0) {
                        return z7 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i8);
                    if (z7) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i9--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i9--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z7 = true;
                    }
                }
                return i8;
            }
        }

        public static int b(CharSequence charSequence, int i8, int i9) {
            int length = charSequence.length();
            if (i8 < 0 || length < i8 || i9 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i9 != 0) {
                    if (i8 >= length) {
                        if (z7) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i8);
                    if (z7) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i9--;
                        i8++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i9--;
                        i8++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i8++;
                        z7 = true;
                    }
                }
                return i8;
            }
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f11498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.j f11499b;

        public b(l lVar, c.j jVar) {
            this.f11498a = lVar;
            this.f11499b = jVar;
        }

        @Override // androidx.emoji2.text.d.c
        public boolean a(CharSequence charSequence, int i8, int i9, j jVar) {
            if (jVar.k()) {
                return true;
            }
            if (this.f11498a == null) {
                this.f11498a = new l(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f11498a.setSpan(this.f11499b.a(jVar), i8, i9, 33);
            return true;
        }

        @Override // androidx.emoji2.text.d.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public l b() {
            return this.f11498a;
        }
    }

    public interface c {
        boolean a(CharSequence charSequence, int i8, int i9, j jVar);

        Object b();
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.d$d, reason: collision with other inner class name */
    public static class C0185d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11500a;

        public C0185d(String str) {
            this.f11500a = str;
        }

        @Override // androidx.emoji2.text.d.c
        public boolean a(CharSequence charSequence, int i8, int i9, j jVar) {
            if (!TextUtils.equals(charSequence.subSequence(i8, i9), this.f11500a)) {
                return true;
            }
            jVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.d.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public C0185d b() {
            return this;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11501a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f.a f11502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f.a f11503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f.a f11504d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11505e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11506f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f11507g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f11508h;

        public e(f.a aVar, boolean z7, int[] iArr) {
            this.f11502b = aVar;
            this.f11503c = aVar;
            this.f11507g = z7;
            this.f11508h = iArr;
        }

        public static boolean d(int i8) {
            return i8 == 65039;
        }

        public static boolean f(int i8) {
            return i8 == 65038;
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int a(int r5) {
            /*
                r4 = this;
                androidx.emoji2.text.f$a r0 = r4.f11503c
                androidx.emoji2.text.f$a r0 = r0.a(r5)
                int r1 = r4.f11501a
                r2 = 1
                r3 = 2
                if (r1 == r3) goto L1a
                if (r0 != 0) goto L13
            Le:
                int r3 = r4.g()
                goto L4c
            L13:
                r4.f11501a = r3
                r4.f11503c = r0
                r4.f11506f = r2
                goto L4c
            L1a:
                if (r0 == 0) goto L24
                r4.f11503c = r0
                int r0 = r4.f11506f
                int r0 = r0 + r2
                r4.f11506f = r0
                goto L4c
            L24:
                boolean r0 = f(r5)
                if (r0 == 0) goto L2b
                goto Le
            L2b:
                boolean r0 = d(r5)
                if (r0 == 0) goto L32
                goto L4c
            L32:
                androidx.emoji2.text.f$a r0 = r4.f11503c
                h0.j r0 = r0.b()
                if (r0 == 0) goto Le
                int r0 = r4.f11506f
                r3 = 3
                if (r0 != r2) goto L45
                boolean r0 = r4.h()
                if (r0 == 0) goto Le
            L45:
                androidx.emoji2.text.f$a r0 = r4.f11503c
                r4.f11504d = r0
                r4.g()
            L4c:
                r4.f11505e = r5
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.d.e.a(int):int");
        }

        public j b() {
            return this.f11503c.b();
        }

        public j c() {
            return this.f11504d.b();
        }

        public boolean e() {
            return this.f11501a == 2 && this.f11503c.b() != null && (this.f11506f > 1 || h());
        }

        public final int g() {
            this.f11501a = 1;
            this.f11503c = this.f11502b;
            this.f11506f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.f11503c.b().j() || d(this.f11505e)) {
                return true;
            }
            if (this.f11507g) {
                if (this.f11508h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f11508h, this.f11503c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(f fVar, c.j jVar, c.e eVar, boolean z7, int[] iArr, Set set) {
        this.f11493a = jVar;
        this.f11494b = fVar;
        this.f11495c = eVar;
        this.f11496d = z7;
        this.f11497e = iArr;
        g(set);
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z7) {
        h0.f[] fVarArr;
        if (f(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!e(selectionStart, selectionEnd) && (fVarArr = (h0.f[]) editable.getSpans(selectionStart, selectionEnd, h0.f.class)) != null && fVarArr.length > 0) {
            for (h0.f fVar : fVarArr) {
                int spanStart = editable.getSpanStart(fVar);
                int spanEnd = editable.getSpanEnd(fVar);
                if ((z7 && spanStart == selectionStart) || ((!z7 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(InputConnection inputConnection, Editable editable, int i8, int i9, boolean z7) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i8 >= 0 && i9 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (e(selectionStart, selectionEnd)) {
                return false;
            }
            if (z7) {
                iMax = a.a(editable, selectionStart, Math.max(i8, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i9, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i8, 0);
                iMin = Math.min(selectionEnd + i9, editable.length());
            }
            h0.f[] fVarArr = (h0.f[]) editable.getSpans(iMax, iMin, h0.f.class);
            if (fVarArr != null && fVarArr.length > 0) {
                for (h0.f fVar : fVarArr) {
                    int spanStart = editable.getSpanStart(fVar);
                    int spanEnd = editable.getSpanEnd(fVar);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    public static boolean c(Editable editable, int i8, KeyEvent keyEvent) {
        if (!(i8 != 67 ? i8 != 112 ? false : a(editable, keyEvent, true) : a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public static boolean e(int i8, int i9) {
        return i8 == -1 || i9 == -1 || i8 != i9;
    }

    public static boolean f(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final boolean d(CharSequence charSequence, int i8, int i9, j jVar) {
        if (jVar.d() == 0) {
            jVar.m(this.f11495c.a(charSequence, i8, i9, jVar.h()));
        }
        return jVar.d() == 2;
    }

    public final void g(Set set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            i(str, 0, str.length(), 1, true, new C0185d(str));
        }
    }

    public CharSequence h(CharSequence charSequence, int i8, int i9, int i10, boolean z7) {
        l lVar;
        h0.f[] fVarArr;
        boolean z8 = charSequence instanceof i;
        if (z8) {
            ((i) charSequence).a();
        }
        if (!z8) {
            try {
                lVar = charSequence instanceof Spannable ? new l((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i8 + (-1), i9 + 1, h0.f.class) > i9) ? null : new l(charSequence);
            } finally {
                if (z8) {
                    ((i) charSequence).d();
                }
            }
        }
        if (lVar != null && (fVarArr = (h0.f[]) lVar.getSpans(i8, i9, h0.f.class)) != null && fVarArr.length > 0) {
            for (h0.f fVar : fVarArr) {
                int spanStart = lVar.getSpanStart(fVar);
                int spanEnd = lVar.getSpanEnd(fVar);
                if (spanStart != i9) {
                    lVar.removeSpan(fVar);
                }
                i8 = Math.min(spanStart, i8);
                i9 = Math.max(spanEnd, i9);
            }
        }
        int i11 = i9;
        if (i8 != i11 && i8 < charSequence.length()) {
            if (i10 != Integer.MAX_VALUE && lVar != null) {
                i10 -= ((h0.f[]) lVar.getSpans(0, lVar.length(), h0.f.class)).length;
            }
            l lVar2 = (l) i(charSequence, i8, i11, i10, z7, new b(lVar, this.f11493a));
            if (lVar2 == null) {
                if (z8) {
                    ((i) charSequence).d();
                }
                return charSequence;
            }
            Spannable spannableB = lVar2.b();
            if (z8) {
                ((i) charSequence).d();
            }
            return spannableB;
        }
        return charSequence;
    }

    public final Object i(CharSequence charSequence, int i8, int i9, int i10, boolean z7, c cVar) {
        int iCharCount;
        e eVar = new e(this.f11494b.f(), this.f11496d, this.f11497e);
        int i11 = 0;
        boolean zA = true;
        int iCodePointAt = Character.codePointAt(charSequence, i8);
        loop0: while (true) {
            iCharCount = i8;
            while (i8 < i9 && i11 < i10 && zA) {
                int iA = eVar.a(iCodePointAt);
                if (iA == 1) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                    if (iCharCount < i9) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                    i8 = iCharCount;
                } else if (iA == 2) {
                    i8 += Character.charCount(iCodePointAt);
                    if (i8 < i9) {
                        iCodePointAt = Character.codePointAt(charSequence, i8);
                    }
                } else if (iA == 3) {
                    if (z7 || !d(charSequence, iCharCount, i8, eVar.c())) {
                        zA = cVar.a(charSequence, iCharCount, i8, eVar.c());
                        i11++;
                    }
                }
            }
            break loop0;
        }
        if (eVar.e() && i11 < i10 && zA && (z7 || !d(charSequence, iCharCount, i8, eVar.b()))) {
            cVar.a(charSequence, iCharCount, i8, eVar.b());
        }
        return cVar.b();
    }
}
