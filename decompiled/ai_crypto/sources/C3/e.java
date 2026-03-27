package C3;

import G3.v;

/* JADX INFO: loaded from: classes.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f1042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1044e;

    public e(String str, int i7, v vVar, int i8, long j7) {
        this.f1040a = str;
        this.f1041b = i7;
        this.f1042c = vVar;
        this.f1043d = i8;
        this.f1044e = j7;
    }

    public String a() {
        return this.f1040a;
    }

    public v b() {
        return this.f1042c;
    }

    public int c() {
        return this.f1041b;
    }

    public long d() {
        return this.f1044e;
    }

    public int e() {
        return this.f1043d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f1041b == eVar.f1041b && this.f1043d == eVar.f1043d && this.f1044e == eVar.f1044e && this.f1040a.equals(eVar.f1040a)) {
            return this.f1042c.equals(eVar.f1042c);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((this.f1040a.hashCode() * 31) + this.f1041b) * 31) + this.f1043d) * 31;
        long j7 = this.f1044e;
        return ((iHashCode + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.f1042c.hashCode();
    }
}
