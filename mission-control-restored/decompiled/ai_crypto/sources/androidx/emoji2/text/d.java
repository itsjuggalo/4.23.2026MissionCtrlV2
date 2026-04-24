package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.c;
import androidx.emoji2.text.f;
import h0.i;
import h0.k;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.i f7679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f7680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.d f7681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f7682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f7683e;

    public static final class a {
        public static int a(CharSequence charSequence, int i7, int i8) {
            int length = charSequence.length();
            if (i7 < 0 || length < i7 || i8 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i8 != 0) {
                    i7--;
                    if (i7 < 0) {
                        return z7 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i7);
                    if (z7) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i8--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i8--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z7 = true;
                    }
                }
                return i7;
            }
        }

        public static int b(CharSequence charSequence, int i7, int i8) {
            int length = charSequence.length();
            if (i7 < 0 || length < i7 || i8 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i8 != 0) {
                    if (i7 >= length) {
                        if (z7) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i7);
                    if (z7) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i8--;
                        i7++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i8--;
                        i7++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i7++;
                        z7 = true;
                    }
                }
                return i7;
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7684a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f.a f7685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f.a f7686c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f.a f7687d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7688e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7689f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f7690g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f7691h;

        public b(f.a aVar, boolean z7, int[] iArr) {
            this.f7685b = aVar;
            this.f7686c = aVar;
            this.f7690g = z7;
            this.f7691h = iArr;
        }

        public static boolean d(int i7) {
            return i7 == 65039;
        }

        public static boolean f(int i7) {
            return i7 == 65038;
        }

        public int a(int i7) {
            f.a aVarA = this.f7686c.a(i7);
            int iG = 2;
            if (this.f7684a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.f7684a = 2;
                    this.f7686c = aVarA;
                    this.f7689f = 1;
                }
            } else if (aVarA != null) {
                this.f7686c = aVarA;
                this.f7689f++;
            } else if (f(i7)) {
                iG = g();
            } else if (!d(i7)) {
                if (this.f7686c.b() != null) {
                    iG = 3;
                    if (this.f7689f != 1 || h()) {
                        this.f7687d = this.f7686c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.f7688e = i7;
            return iG;
        }

        public h0.e b() {
            return this.f7686c.b();
        }

        public h0.e c() {
            return this.f7687d.b();
        }

        public boolean e() {
            return this.f7684a == 2 && this.f7686c.b() != null && (this.f7689f > 1 || h());
        }

        public final int g() {
            this.f7684a = 1;
            this.f7686c = this.f7685b;
            this.f7689f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.f7686c.b().j() || d(this.f7688e)) {
                return true;
            }
            if (this.f7690g) {
                if (this.f7691h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f7691h, this.f7686c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(f fVar, c.i iVar, c.d dVar, boolean z7, int[] iArr) {
        this.f7679a = iVar;
        this.f7680b = fVar;
        this.f7681c = dVar;
        this.f7682d = z7;
        this.f7683e = iArr;
    }

    public static boolean b(Editable editable, KeyEvent keyEvent, boolean z7) {
        h0.f[] fVarArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (fVarArr = (h0.f[]) editable.getSpans(selectionStart, selectionEnd, h0.f.class)) != null && fVarArr.length > 0) {
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

    public static boolean c(InputConnection inputConnection, Editable editable, int i7, int i8, boolean z7) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i7 >= 0 && i8 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z7) {
                iMax = a.a(editable, selectionStart, Math.max(i7, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i8, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i7, 0);
                iMin = Math.min(selectionEnd + i8, editable.length());
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

    public static boolean d(Editable editable, int i7, KeyEvent keyEvent) {
        if (!(i7 != 67 ? i7 != 112 ? false : b(editable, keyEvent, true) : b(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public static boolean f(int i7, int i8) {
        return i7 == -1 || i8 == -1 || i7 != i8;
    }

    public static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final void a(Spannable spannable, h0.e eVar, int i7, int i8) {
        spannable.setSpan(this.f7679a.a(eVar), i7, i8, 33);
    }

    public final boolean e(CharSequence charSequence, int i7, int i8, h0.e eVar) {
        if (eVar.d() == 0) {
            eVar.k(this.f7681c.a(charSequence, i7, i8, eVar.h()));
        }
        return eVar.d() == 2;
    }

    public CharSequence h(CharSequence charSequence, int i7, int i8, int i9, boolean z7) {
        k kVar;
        int iCharCount;
        h0.f[] fVarArr;
        boolean z8 = charSequence instanceof i;
        if (z8) {
            ((i) charSequence).a();
        }
        if (!z8) {
            try {
                kVar = charSequence instanceof Spannable ? new k((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i7 + (-1), i8 + 1, h0.f.class) > i8) ? null : new k(charSequence);
            } finally {
                if (z8) {
                    ((i) charSequence).d();
                }
            }
        }
        if (kVar != null && (fVarArr = (h0.f[]) kVar.getSpans(i7, i8, h0.f.class)) != null && fVarArr.length > 0) {
            for (h0.f fVar : fVarArr) {
                int spanStart = kVar.getSpanStart(fVar);
                int spanEnd = kVar.getSpanEnd(fVar);
                if (spanStart != i8) {
                    kVar.removeSpan(fVar);
                }
                i7 = Math.min(spanStart, i7);
                i8 = Math.max(spanEnd, i8);
            }
        }
        if (i7 != i8 && i7 < charSequence.length()) {
            if (i9 != Integer.MAX_VALUE && kVar != null) {
                i9 -= ((h0.f[]) kVar.getSpans(0, kVar.length(), h0.f.class)).length;
            }
            b bVar = new b(this.f7680b.f(), this.f7682d, this.f7683e);
            int iCodePointAt = Character.codePointAt(charSequence, i7);
            int i10 = 0;
            k kVar2 = kVar;
            loop1: while (true) {
                iCharCount = i7;
                while (i7 < i8 && i10 < i9) {
                    int iA = bVar.a(iCodePointAt);
                    if (iA == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i8) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i7 = iCharCount;
                    } else if (iA == 2) {
                        i7 += Character.charCount(iCodePointAt);
                        if (i7 < i8) {
                            iCodePointAt = Character.codePointAt(charSequence, i7);
                        }
                    } else if (iA == 3) {
                        if (z7 || !e(charSequence, iCharCount, i7, bVar.c())) {
                            if (kVar2 == null) {
                                kVar2 = new k((Spannable) new SpannableString(charSequence));
                            }
                            a(kVar2, bVar.c(), iCharCount, i7);
                            i10++;
                        }
                    }
                }
                break loop1;
            }
            if (bVar.e() && i10 < i9 && (z7 || !e(charSequence, iCharCount, i7, bVar.b()))) {
                if (kVar2 == null) {
                    kVar2 = new k(charSequence);
                }
                a(kVar2, bVar.b(), iCharCount, i7);
            }
            if (kVar2 == null) {
                if (z8) {
                    ((i) charSequence).d();
                }
                return charSequence;
            }
            Spannable spannableB = kVar2.b();
            if (z8) {
                ((i) charSequence).d();
            }
            return spannableB;
        }
        return charSequence;
    }
}
