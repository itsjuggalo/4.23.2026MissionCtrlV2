package n9;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.f;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;
import rb.k1;
import rb.l1;
import rb.m1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f16931a = new SecureRandom();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Continuation f16932b = new Continuation() { // from class: n9.b0
        @Override // com.google.android.gms.tasks.Continuation
        public final Object then(Task task) {
            return g0.d(task);
        }
    };

    public static /* synthetic */ Void d(Task task) throws Exception {
        if (task.isSuccessful()) {
            return (Void) task.getResult();
        }
        Exception excN = n(task.getException());
        if (excN instanceof com.google.firebase.firestore.f) {
            throw excN;
        }
        throw new com.google.firebase.firestore.f(excN.getMessage(), f.a.UNKNOWN, excN);
    }

    public static Object e(Iterator it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static List f(int i10, Object obj, Object obj2, Object... objArr) {
        if (objArr.length % 2 == 1) {
            throw new IllegalArgumentException("Missing value in call to update().  There must be an even number of arguments that alternate between field names and values");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        arrayList.add(obj2);
        Collections.addAll(arrayList, objArr);
        for (int i11 = 0; i11 < arrayList.size(); i11 += 2) {
            Object obj3 = arrayList.get(i11);
            if (!(obj3 instanceof String) && !(obj3 instanceof d9.t)) {
                throw new IllegalArgumentException("Excepted field name at argument position " + (i11 + i10 + 1) + " but got " + obj3 + " in call to update.  The arguments to update should alternate between field names and values");
            }
        }
        return arrayList;
    }

    public static Comparator g() {
        return new Comparator() { // from class: n9.c0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        };
    }

    public static int h(boolean z10, boolean z11) {
        if (z10 == z11) {
            return 0;
        }
        return z10 ? 1 : -1;
    }

    public static int i(byte[] bArr, byte[] bArr2) {
        int iMin = Math.min(bArr.length, bArr2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = bArr2[i10] & 255;
            if (i11 < i12) {
                return -1;
            }
            if (i11 > i12) {
                return 1;
            }
        }
        return Integer.compare(bArr.length, bArr2.length);
    }

    public static int j(com.google.protobuf.i iVar, com.google.protobuf.i iVar2) {
        int iMin = Math.min(iVar.size(), iVar2.size());
        for (int i10 = 0; i10 < iMin; i10++) {
            int iE = iVar.e(i10) & 255;
            int iE2 = iVar2.e(i10) & 255;
            if (iE < iE2) {
                return -1;
            }
            if (iE > iE2) {
                return 1;
            }
        }
        return Integer.compare(iVar.size(), iVar2.size());
    }

    public static int k(double d10, double d11) {
        return o6.a.b(d10, d11);
    }

    public static int l(double d10, long j10) {
        return o6.a.a(d10, j10);
    }

    public static int m(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        int iMin = Math.min(str.length(), str2.length());
        for (int i10 = 0; i10 < iMin; i10++) {
            char cCharAt = str.charAt(i10);
            char cCharAt2 = str2.charAt(i10);
            if (cCharAt != cCharAt2) {
                return Character.isSurrogate(cCharAt) == Character.isSurrogate(cCharAt2) ? Character.compare(cCharAt, cCharAt2) : Character.isSurrogate(cCharAt) ? 1 : -1;
            }
        }
        return Integer.compare(str.length(), str2.length());
    }

    public static Exception n(Exception exc) {
        return exc instanceof l1 ? s(((l1) exc).a()) : exc instanceof m1 ? s(((m1) exc).a()) : exc;
    }

    public static void o(final RuntimeException runtimeException) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: n9.d0
            @Override // java.lang.Runnable
            public final void run() {
                g0.c(runtimeException);
            }
        });
    }

    public static void p(Collection collection, Collection collection2, Comparator comparator, n nVar, n nVar2) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, comparator);
        ArrayList arrayList2 = new ArrayList(collection2);
        Collections.sort(arrayList2, comparator);
        q(arrayList.iterator(), arrayList2.iterator(), comparator, nVar, nVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void q(java.util.Iterator r6, java.util.Iterator r7, java.util.Comparator r8, n9.n r9, n9.n r10) {
        /*
            java.lang.Object r0 = e(r6)
            java.lang.Object r1 = e(r7)
        L8:
            if (r0 != 0) goto Le
            if (r1 == 0) goto Ld
            goto Le
        Ld:
            return
        Le:
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L20
            if (r1 == 0) goto L20
            int r4 = r8.compare(r0, r1)
            if (r4 >= 0) goto L1b
            goto L26
        L1b:
            if (r4 <= 0) goto L1e
            goto L23
        L1e:
            r3 = r2
            goto L26
        L20:
            if (r0 == 0) goto L23
            goto L26
        L23:
            r5 = r3
            r3 = r2
            r2 = r5
        L26:
            if (r2 == 0) goto L30
            r9.accept(r1)
            java.lang.Object r1 = e(r7)
            goto L8
        L30:
            if (r3 == 0) goto L3a
            r10.accept(r0)
            java.lang.Object r0 = e(r6)
            goto L8
        L3a:
            java.lang.Object r0 = e(r6)
            java.lang.Object r1 = e(r7)
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: n9.g0.q(java.util.Iterator, java.util.Iterator, java.util.Comparator, n9.n, n9.n):void");
    }

    public static void r(SortedSet sortedSet, SortedSet sortedSet2, n nVar, n nVar2) {
        q(sortedSet.iterator(), sortedSet2.iterator(), sortedSet.comparator() != null ? sortedSet.comparator() : new Comparator() { // from class: n9.e0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        }, nVar, nVar2);
    }

    public static com.google.firebase.firestore.f s(k1 k1Var) {
        l1 l1VarC = k1Var.c();
        return new com.google.firebase.firestore.f(l1VarC.getMessage(), f.a.c(k1Var.n().c()), l1VarC);
    }

    public static Map t(Map map, int i10, final Comparator comparator) {
        if (map.size() <= i10) {
            return map;
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: n9.f0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return comparator.compare(((Map.Entry) obj).getValue(), ((Map.Entry) obj2).getValue());
            }
        });
        HashMap map2 = new HashMap();
        for (int i11 = 0; i11 < i10; i11++) {
            map2.put(((Map.Entry) arrayList.get(i11)).getKey(), ((Map.Entry) arrayList.get(i11)).getValue());
        }
        return map2;
    }

    public static StringBuilder u(CharSequence charSequence, int i10, CharSequence charSequence2) {
        StringBuilder sb2 = new StringBuilder();
        if (i10 != 0) {
            sb2.append(charSequence);
            for (int i11 = 1; i11 < i10; i11++) {
                sb2.append(charSequence2);
                sb2.append(charSequence);
            }
        }
        return sb2;
    }

    public static String v(com.google.protobuf.i iVar) {
        int size = iVar.size();
        StringBuilder sb2 = new StringBuilder(size * 2);
        for (int i10 = 0; i10 < size; i10++) {
            byte bE = iVar.e(i10);
            sb2.append(Character.forDigit((bE & 255) >>> 4, 16));
            sb2.append(Character.forDigit(bE & 15, 16));
        }
        return sb2.toString();
    }

    public static String w(Object obj) {
        return obj == null ? "null" : obj.getClass().getName();
    }

    public static Continuation x() {
        return f16932b;
    }

    public static /* synthetic */ void c(RuntimeException runtimeException) {
        throw runtimeException;
    }
}
