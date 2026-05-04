package com.google.crypto.tink.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import gb.c;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class JsonParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonElementTypeAdapter f6016a = new JsonElementTypeAdapter(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class JsonElementTypeAdapter extends TypeAdapter {
        private JsonElementTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public i c(gb.a aVar) throws IOException {
            String strH0;
            gb.b bVarN0 = aVar.n0();
            i iVarH = h(aVar, bVarN0);
            if (iVarH == null) {
                return g(aVar, bVarN0);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.Z()) {
                    if (iVarH instanceof l) {
                        strH0 = aVar.h0();
                        if (!JsonParser.a(strH0)) {
                            throw new IOException("illegal characters in string");
                        }
                    } else {
                        strH0 = null;
                    }
                    gb.b bVarN02 = aVar.n0();
                    i iVarH2 = h(aVar, bVarN02);
                    boolean z10 = iVarH2 != null;
                    if (iVarH2 == null) {
                        iVarH2 = g(aVar, bVarN02);
                    }
                    if (iVarH instanceof f) {
                        ((f) iVarH).s(iVarH2);
                    } else {
                        l lVar = (l) iVarH;
                        if (lVar.v(strH0)) {
                            throw new IOException("duplicate key: " + strH0);
                        }
                        lVar.s(strH0, iVarH2);
                    }
                    if (z10) {
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
                        aVar.E();
                    } else {
                        aVar.G();
                    }
                    if (arrayDeque.isEmpty()) {
                        return iVarH;
                    }
                    iVarH = (i) arrayDeque.removeLast();
                }
            }
        }

        public final i g(gb.a aVar, gb.b bVar) throws IOException {
            int i10 = a.f6017a[bVar.ordinal()];
            if (i10 == 3) {
                String strL0 = aVar.l0();
                if (JsonParser.a(strL0)) {
                    return new n(strL0);
                }
                throw new IOException("illegal characters in string");
            }
            if (i10 == 4) {
                return new n(new b(aVar.l0()));
            }
            if (i10 == 5) {
                return new n(Boolean.valueOf(aVar.d0()));
            }
            if (i10 == 6) {
                aVar.j0();
                return k.f6876a;
            }
            throw new IllegalStateException("Unexpected token: " + bVar);
        }

        public final i h(gb.a aVar, gb.b bVar) throws IOException {
            int i10 = a.f6017a[bVar.ordinal()];
            if (i10 == 1) {
                aVar.c();
                return new f();
            }
            if (i10 != 2) {
                return null;
            }
            aVar.e();
            return new l();
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(c cVar, i iVar) {
            throw new UnsupportedOperationException("write is not supported");
        }

        public /* synthetic */ JsonElementTypeAdapter(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6017a;

        static {
            int[] iArr = new int[gb.b.values().length];
            f6017a = iArr;
            try {
                iArr[gb.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6017a[gb.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6017a[gb.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6017a[gb.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6017a[gb.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6017a[gb.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends Number {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6018a;

        public b(String str) {
            this.f6018a = str;
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return Double.parseDouble(this.f6018a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f6018a.equals(((b) obj).f6018a);
            }
            return false;
        }

        @Override // java.lang.Number
        public float floatValue() {
            return Float.parseFloat(this.f6018a);
        }

        public int hashCode() {
            return this.f6018a.hashCode();
        }

        @Override // java.lang.Number
        public int intValue() {
            try {
                try {
                    return Integer.parseInt(this.f6018a);
                } catch (NumberFormatException unused) {
                    return (int) Long.parseLong(this.f6018a);
                }
            } catch (NumberFormatException unused2) {
                return new BigDecimal(this.f6018a).intValue();
            }
        }

        @Override // java.lang.Number
        public long longValue() {
            try {
                return Long.parseLong(this.f6018a);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f6018a).longValue();
            }
        }

        public String toString() {
            return this.f6018a;
        }
    }

    public static boolean a(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 != length) {
            char cCharAt = str.charAt(i10);
            int i11 = i10 + 1;
            if (!Character.isSurrogate(cCharAt)) {
                i10 = i11;
            } else {
                if (Character.isLowSurrogate(cCharAt) || i11 == length || !Character.isLowSurrogate(str.charAt(i11))) {
                    return false;
                }
                i10 += 2;
            }
        }
        return true;
    }
}
