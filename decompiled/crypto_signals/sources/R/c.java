package R;

import F1.h;
import G4.j;
import S.k;
import S.l;
import android.content.Context;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f2748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f2749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f2750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2751d;
    public final j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashSet f2752f;

    public c(Context context, String sharedPreferencesName, Set keysToMigrate, l lVar, k kVar) {
        kotlin.jvm.internal.j.e(context, "context");
        kotlin.jvm.internal.j.e(sharedPreferencesName, "sharedPreferencesName");
        kotlin.jvm.internal.j.e(keysToMigrate, "keysToMigrate");
        B0.j jVar = new B0.j(1, context, sharedPreferencesName);
        this.f2748a = lVar;
        this.f2749b = kVar;
        this.f2750c = context;
        this.f2751d = sharedPreferencesName;
        this.e = h.B(jVar);
        this.f2752f = keysToMigrate == d.f2753a ? null : new LinkedHashSet(keysToMigrate);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r5, K4.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof R.b
            if (r0 == 0) goto L13
            r0 = r6
            R.b r0 = (R.b) r0
            int r1 = r0.f2747d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2747d = r1
            goto L18
        L13:
            R.b r0 = new R.b
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f2745b
            J4.a r1 = J4.a.f791a
            int r2 = r0.f2747d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            R.c r5 = r0.f2744a
            a.AbstractC0284a.E(r6)
            goto L42
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            a.AbstractC0284a.E(r6)
            r0.f2744a = r4
            r0.f2747d = r3
            S.l r6 = r4.f2748a
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            r5 = r4
        L42:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L4d
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L4d:
            java.util.LinkedHashSet r6 = r5.f2752f
            G4.j r5 = r5.e
            r0 = 0
            if (r6 != 0) goto L6c
            java.lang.Object r5 = r5.getValue()
            android.content.SharedPreferences r5 = (android.content.SharedPreferences) r5
            java.util.Map r5 = r5.getAll()
            java.lang.String r6 = "sharedPrefs.all"
            kotlin.jvm.internal.j.d(r5, r6)
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L6a
            goto L8f
        L6a:
            r3 = r0
            goto L8f
        L6c:
            java.lang.Object r5 = r5.getValue()
            android.content.SharedPreferences r5 = (android.content.SharedPreferences) r5
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L79
            goto L6a
        L79:
            java.util.Iterator r6 = r6.iterator()
        L7d:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6a
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L7d
        L8f:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: R.c.a(java.lang.Object, K4.c):java.lang.Object");
    }
}
