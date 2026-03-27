package V2;

import a5.C;
import android.content.Context;
import android.os.Build;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final T.e f3283b = F1.h.F("fire-global");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final T.e f3284c = F1.h.F("fire-count");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final T.e f3285d = F1.h.P("last-used-date");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B2.h f3286a;

    public l(Context context, String str) {
        this.f3286a = new B2.h(context, AbstractC1024h.b("FirebaseHeartBeat", str));
    }

    public final synchronized ArrayList a() {
        try {
            ArrayList arrayList = new ArrayList();
            String strB = b(System.currentTimeMillis());
            B2.h hVar = this.f3286a;
            hVar.getClass();
            for (Map.Entry entry : ((Map) C.t(new B2.d(hVar, null))).entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(strB);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(new a(((T.e) entry.getKey()).f2891a, new ArrayList(hashSet)));
                    }
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                this.f3286a.a(new k(0, jCurrentTimeMillis));
            }
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String b(long j4) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j4)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j4));
    }

    public final synchronized T.e c(T.b bVar, String str) {
        for (Map.Entry entry : bVar.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return F1.h.Q(((T.e) entry.getKey()).f2891a);
                    }
                }
            }
        }
        return null;
    }

    public final synchronized void d(T.b bVar, String str) {
        try {
            T.e eVarC = c(bVar, str);
            if (eVarC == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) D1.b.s(bVar, eVarC, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                bVar.d(eVarC);
            } else {
                bVar.f(eVarC, hashSet);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean e(T.e key, long j4) {
        long jLongValue;
        B2.h hVar = this.f3286a;
        hVar.getClass();
        kotlin.jvm.internal.j.e(key, "key");
        jLongValue = ((Long) C.t(new B2.e(hVar, key, null))).longValue();
        synchronized (this) {
        }
        if (b(jLongValue).equals(b(j4))) {
            return false;
        }
        B2.h hVar2 = this.f3286a;
        Long lValueOf = Long.valueOf(j4);
        hVar2.getClass();
        return true;
    }
}
