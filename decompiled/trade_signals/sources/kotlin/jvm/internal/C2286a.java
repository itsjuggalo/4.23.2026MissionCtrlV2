package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: renamed from: kotlin.jvm.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2286a implements InterfaceC2300o, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f20478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f20481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f20482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f20483g;

    public C2286a(int i8, Object obj, Class cls, String str, String str2, int i9) {
        this.f20477a = obj;
        this.f20478b = cls;
        this.f20479c = str;
        this.f20480d = str2;
        this.f20481e = (i9 & 1) == 1;
        this.f20482f = i8;
        this.f20483g = i9 >> 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2286a)) {
            return false;
        }
        C2286a c2286a = (C2286a) obj;
        return this.f20481e == c2286a.f20481e && this.f20482f == c2286a.f20482f && this.f20483g == c2286a.f20483g && AbstractC2304t.b(this.f20477a, c2286a.f20477a) && AbstractC2304t.b(this.f20478b, c2286a.f20478b) && this.f20479c.equals(c2286a.f20479c) && this.f20480d.equals(c2286a.f20480d);
    }

    @Override // kotlin.jvm.internal.InterfaceC2300o
    public int getArity() {
        return this.f20482f;
    }

    public int hashCode() {
        Object obj = this.f20477a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.f20478b;
        return ((((((((((iHashCode + (cls != null ? cls.hashCode() : 0)) * 31) + this.f20479c.hashCode()) * 31) + this.f20480d.hashCode()) * 31) + (this.f20481e ? 1231 : 1237)) * 31) + this.f20482f) * 31) + this.f20483g;
    }

    public String toString() {
        return O.i(this);
    }
}
