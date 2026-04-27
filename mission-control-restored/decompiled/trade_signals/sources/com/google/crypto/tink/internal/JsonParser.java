package com.google.crypto.tink.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import p4.C2568a;
import p4.C2570c;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonElementTypeAdapter f15546a = new JsonElementTypeAdapter(null);

    public static final class JsonElementTypeAdapter extends TypeAdapter {
        private JsonElementTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public i c(C2568a c2568a) throws IOException {
            String strI0;
            EnumC2569b enumC2569bX0 = c2568a.x0();
            i iVarH = h(c2568a, enumC2569bX0);
            if (iVarH == null) {
                return g(c2568a, enumC2569bX0);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (c2568a.Q()) {
                    if (iVarH instanceof l) {
                        strI0 = c2568a.i0();
                        if (!JsonParser.a(strI0)) {
                            throw new IOException("illegal characters in string");
                        }
                    } else {
                        strI0 = null;
                    }
                    EnumC2569b enumC2569bX02 = c2568a.x0();
                    i iVarH2 = h(c2568a, enumC2569bX02);
                    boolean z7 = iVarH2 != null;
                    if (iVarH2 == null) {
                        iVarH2 = g(c2568a, enumC2569bX02);
                    }
                    if (iVarH instanceof f) {
                        ((f) iVarH).I(iVarH2);
                    } else {
                        l lVar = (l) iVarH;
                        if (lVar.K(strI0)) {
                            throw new IOException("duplicate key: " + strI0);
                        }
                        lVar.I(strI0, iVarH2);
                    }
                    if (z7) {
                        arrayDeque.addLast(iVarH);
                        if (arrayDeque.size() > 100) {
                            throw new IOException("too many recursions");
                        }
                        iVarH = iVarH2;
                    } else {
                        continue;
                    }
                } else {
                    if (iVarH instanceof f) {
                        c2568a.B();
                    } else {
                        c2568a.D();
                    }
                    if (arrayDeque.isEmpty()) {
                        return iVarH;
                    }
                    iVarH = (i) arrayDeque.removeLast();
                }
            }
        }

        public final i g(C2568a c2568a, EnumC2569b enumC2569b) throws IOException {
            int i8 = a.f15547a[enumC2569b.ordinal()];
            if (i8 == 3) {
                String strV0 = c2568a.v0();
                if (JsonParser.a(strV0)) {
                    return new n(strV0);
                }
                throw new IOException("illegal characters in string");
            }
            if (i8 == 4) {
                return new n(new b(c2568a.v0()));
            }
            if (i8 == 5) {
                return new n(Boolean.valueOf(c2568a.U()));
            }
            if (i8 == 6) {
                c2568a.r0();
                return k.f16252a;
            }
            throw new IllegalStateException("Unexpected token: " + enumC2569b);
        }

        public final i h(C2568a c2568a, EnumC2569b enumC2569b) throws IOException {
            int i8 = a.f15547a[enumC2569b.ordinal()];
            if (i8 == 1) {
                c2568a.c();
                return new f();
            }
            if (i8 != 2) {
                return null;
            }
            c2568a.e();
            return new l();
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(C2570c c2570c, i iVar) {
            throw new UnsupportedOperationException("write is not supported");
        }

        public /* synthetic */ JsonElementTypeAdapter(a aVar) {
            this();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15547a;

        static {
            int[] iArr = new int[EnumC2569b.values().length];
            f15547a = iArr;
            try {
                iArr[EnumC2569b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15547a[EnumC2569b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15547a[EnumC2569b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15547a[EnumC2569b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15547a[EnumC2569b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15547a[EnumC2569b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static final class b extends Number {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15548a;

        public b(String str) {
            this.f15548a = str;
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return Double.parseDouble(this.f15548a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f15548a.equals(((b) obj).f15548a);
            }
            return false;
        }

        @Override // java.lang.Number
        public float floatValue() {
            return Float.parseFloat(this.f15548a);
        }

        public int hashCode() {
            return this.f15548a.hashCode();
        }

        @Override // java.lang.Number
        public int intValue() {
            try {
                try {
                    return Integer.parseInt(this.f15548a);
                } catch (NumberFormatException unused) {
                    return (int) Long.parseLong(this.f15548a);
                }
            } catch (NumberFormatException unused2) {
                return new BigDecimal(this.f15548a).intValue();
            }
        }

        @Override // java.lang.Number
        public long longValue() {
            try {
                return Long.parseLong(this.f15548a);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f15548a).longValue();
            }
        }

        public String toString() {
            return this.f15548a;
        }
    }

    public static boolean a(String str) {
        int length = str.length();
        int i8 = 0;
        while (i8 != length) {
            char cCharAt = str.charAt(i8);
            int i9 = i8 + 1;
            if (!Character.isSurrogate(cCharAt)) {
                i8 = i9;
            } else {
                if (Character.isLowSurrogate(cCharAt) || i9 == length || !Character.isLowSurrogate(str.charAt(i9))) {
                    return false;
                }
                i8 += 2;
            }
        }
        return true;
    }
}
