package p5;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n5.d[] f9083a = new n5.d[0];

    public static final void a(int i, int i6, n5.d descriptor) {
        kotlin.jvm.internal.j.e(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i7 = (~i) & i6;
        for (int i8 = 0; i8 < 32; i8++) {
            if ((i7 & 1) != 0) {
                arrayList.add(descriptor.e(i8));
            }
            i7 >>>= 1;
        }
        String serialName = descriptor.b();
        kotlin.jvm.internal.j.e(serialName, "serialName");
        throw new l5.b(arrayList, arrayList.size() == 1 ? "Field '" + ((String) arrayList.get(0)) + "' is required for type with serial name '" + serialName + "', but it was missing" : "Fields " + arrayList + " are required for type with serial name '" + serialName + "', but they were missing", null);
    }
}
