package com.google.firebase.firestore.util;

import K2.l0;
import K2.m0;
import K2.n0;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.protobuf.AbstractC1062i;
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

/* JADX INFO: loaded from: classes.dex */
public class Util {
    private static final String AUTO_ID_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int AUTO_ID_LENGTH = 20;
    private static final Random rand = new SecureRandom();
    private static final Continuation<Void, Void> VOID_ERROR_TRANSFORMER = new Continuation() { // from class: com.google.firebase.firestore.util.r
        @Override // com.google.android.gms.tasks.Continuation
        public final Object then(Task task) {
            return Util.e(task);
        }
    };

    private static <T> T advanceIterator(Iterator<T> it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static String autoId() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 20; i4++) {
            sb.append(AUTO_ID_ALPHABET.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public static /* synthetic */ Iterator b(Iterable iterable) {
        final Iterator it = iterable.iterator();
        return new Iterator<V>() { // from class: com.google.firebase.firestore.util.Util.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return (V) ((Map.Entry) it.next()).getValue();
            }
        };
    }

    public static List<Object> collectUpdateArguments(int i4, Object obj, Object obj2, Object... objArr) {
        if (objArr.length % 2 == 1) {
            throw new IllegalArgumentException("Missing value in call to update().  There must be an even number of arguments that alternate between field names and values");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        arrayList.add(obj2);
        Collections.addAll(arrayList, objArr);
        for (int i5 = 0; i5 < arrayList.size(); i5 += 2) {
            Object obj3 = arrayList.get(i5);
            if (!(obj3 instanceof String) && !(obj3 instanceof FieldPath)) {
                throw new IllegalArgumentException("Excepted field name at argument position " + (i5 + i4 + 1) + " but got " + obj3 + " in call to update.  The arguments to update should alternate between field names and values");
            }
        }
        return arrayList;
    }

    public static <T extends Comparable<T>> Comparator<T> comparator() {
        return new Comparator() { // from class: com.google.firebase.firestore.util.u
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        };
    }

    public static int compareBooleans(boolean z4, boolean z5) {
        if (z4 == z5) {
            return 0;
        }
        return z4 ? 1 : -1;
    }

    public static int compareByteArrays(byte[] bArr, byte[] bArr2) {
        int iMin = Math.min(bArr.length, bArr2.length);
        for (int i4 = 0; i4 < iMin; i4++) {
            int i5 = bArr[i4] & 255;
            int i6 = bArr2[i4] & 255;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
        }
        return compareIntegers(bArr.length, bArr2.length);
    }

    public static int compareByteStrings(AbstractC1062i abstractC1062i, AbstractC1062i abstractC1062i2) {
        int iMin = Math.min(abstractC1062i.size(), abstractC1062i2.size());
        for (int i4 = 0; i4 < iMin; i4++) {
            int iK = abstractC1062i.k(i4) & 255;
            int iK2 = abstractC1062i2.k(i4) & 255;
            if (iK < iK2) {
                return -1;
            }
            if (iK > iK2) {
                return 1;
            }
        }
        return compareIntegers(abstractC1062i.size(), abstractC1062i2.size());
    }

    public static int compareDoubles(double d4, double d5) {
        return Y1.a.c(d4, d5);
    }

    public static int compareIntegers(int i4, int i5) {
        if (i4 < i5) {
            return -1;
        }
        return i4 > i5 ? 1 : 0;
    }

    public static int compareLongs(long j4, long j5) {
        return Y1.a.a(j4, j5);
    }

    public static int compareMixed(double d4, long j4) {
        return Y1.a.b(d4, j4);
    }

    public static int compareUtf8Strings(String str, String str2) {
        int iCharCount = 0;
        while (iCharCount < str.length() && iCharCount < str2.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt != iCodePointAt2) {
                if (iCodePointAt < 128 && iCodePointAt2 < 128) {
                    return Integer.compare(iCodePointAt, iCodePointAt2);
                }
                int iCompareByteStrings = compareByteStrings(AbstractC1062i.r(getUtf8SafeBytes(str, iCharCount)), AbstractC1062i.r(getUtf8SafeBytes(str2, iCharCount)));
                return iCompareByteStrings != 0 ? iCompareByteStrings : Integer.compare(iCodePointAt, iCodePointAt2);
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return Integer.compare(str.length(), str2.length());
    }

    private static Exception convertStatusException(Exception exc) {
        return exc instanceof m0 ? exceptionFromStatus(((m0) exc).a()) : exc instanceof n0 ? exceptionFromStatus(((n0) exc).a()) : exc;
    }

    public static Exception convertThrowableToException(Throwable th) {
        return th instanceof Exception ? convertStatusException((Exception) th) : new Exception(th);
    }

    public static void crashMainThread(final RuntimeException runtimeException) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.firebase.firestore.util.q
            @Override // java.lang.Runnable
            public final void run() {
                Util.d(runtimeException);
            }
        });
    }

    public static <T> void diffCollections(Collection<T> collection, Collection<T> collection2, Comparator<T> comparator, Consumer<T> consumer, Consumer<T> consumer2) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, comparator);
        ArrayList arrayList2 = new ArrayList(collection2);
        Collections.sort(arrayList2, comparator);
        diffCollections(arrayList.iterator(), arrayList2.iterator(), comparator, consumer, consumer2);
    }

    public static /* synthetic */ Void e(Task task) throws Exception {
        if (task.isSuccessful()) {
            return (Void) task.getResult();
        }
        Exception excConvertStatusException = convertStatusException(task.getException());
        if (excConvertStatusException instanceof FirebaseFirestoreException) {
            throw excConvertStatusException;
        }
        throw new FirebaseFirestoreException(excConvertStatusException.getMessage(), FirebaseFirestoreException.Code.UNKNOWN, excConvertStatusException);
    }

    public static FirebaseFirestoreException exceptionFromStatus(l0 l0Var) {
        m0 m0VarC = l0Var.c();
        return new FirebaseFirestoreException(m0VarC.getMessage(), FirebaseFirestoreException.Code.fromValue(l0Var.m().g()), m0VarC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> firstNEntries(Map<K, V> map, int i4, final Comparator<V> comparator) {
        if (map.size() <= i4) {
            return map;
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: com.google.firebase.firestore.util.t
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return comparator.compare(((Map.Entry) obj).getValue(), ((Map.Entry) obj2).getValue());
            }
        });
        HashMap map2 = new HashMap();
        for (int i5 = 0; i5 < i4; i5++) {
            map2.put(((Map.Entry) arrayList.get(i5)).getKey(), ((Map.Entry) arrayList.get(i5)).getValue());
        }
        return map2;
    }

    private static String getUtf8SafeBytes(String str, int i4) {
        return str.substring(i4, Character.charCount(str.codePointAt(i4)) + i4);
    }

    public static StringBuilder repeatSequence(CharSequence charSequence, int i4, CharSequence charSequence2) {
        StringBuilder sb = new StringBuilder();
        if (i4 != 0) {
            sb.append(charSequence);
            for (int i5 = 1; i5 < i4; i5++) {
                sb.append(charSequence2);
                sb.append(charSequence);
            }
        }
        return sb;
    }

    public static String toDebugString(AbstractC1062i abstractC1062i) {
        int size = abstractC1062i.size();
        StringBuilder sb = new StringBuilder(size * 2);
        for (int i4 = 0; i4 < size; i4++) {
            byte bK = abstractC1062i.k(i4);
            sb.append(Character.forDigit((bK & 255) >>> 4, 16));
            sb.append(Character.forDigit(bK & 15, 16));
        }
        return sb.toString();
    }

    public static String typeName(Object obj) {
        return obj == null ? "null" : obj.getClass().getName();
    }

    public static <K, V> Iterable<V> values(final Iterable<Map.Entry<K, V>> iterable) {
        return new Iterable() { // from class: com.google.firebase.firestore.util.v
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return Util.b(iterable);
            }
        };
    }

    public static Continuation<Void, Void> voidErrorTransformer() {
        return VOID_ERROR_TRANSFORMER;
    }

    public static <T extends Comparable<T>> void diffCollections(SortedSet<T> sortedSet, SortedSet<T> sortedSet2, Consumer<T> consumer, Consumer<T> consumer2) {
        diffCollections(sortedSet.iterator(), sortedSet2.iterator(), sortedSet.comparator() != null ? sortedSet.comparator() : new Comparator() { // from class: com.google.firebase.firestore.util.s
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        }, consumer, consumer2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T> void diffCollections(java.util.Iterator<T> r6, java.util.Iterator<T> r7, java.util.Comparator<? super T> r8, com.google.firebase.firestore.util.Consumer<T> r9, com.google.firebase.firestore.util.Consumer<T> r10) {
        /*
            java.lang.Object r0 = advanceIterator(r6)
            java.lang.Object r1 = advanceIterator(r7)
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
            java.lang.Object r1 = advanceIterator(r7)
            goto L8
        L30:
            if (r3 == 0) goto L3a
            r10.accept(r0)
            java.lang.Object r0 = advanceIterator(r6)
            goto L8
        L3a:
            java.lang.Object r0 = advanceIterator(r6)
            java.lang.Object r1 = advanceIterator(r7)
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.util.Util.diffCollections(java.util.Iterator, java.util.Iterator, java.util.Comparator, com.google.firebase.firestore.util.Consumer, com.google.firebase.firestore.util.Consumer):void");
    }

    public static /* synthetic */ void d(RuntimeException runtimeException) {
        throw runtimeException;
    }
}
