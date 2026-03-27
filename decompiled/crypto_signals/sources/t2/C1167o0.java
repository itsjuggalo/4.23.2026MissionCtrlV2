package t2;

import android.os.Build;

/* JADX INFO: renamed from: t2.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1167o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10182a;

    public C1167o0(boolean z6) {
        String str = Build.VERSION.RELEASE;
        String str2 = Build.VERSION.CODENAME;
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f10182a = z6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1167o0)) {
            return false;
        }
        C1167o0 c1167o0 = (C1167o0) obj;
        c1167o0.getClass();
        String str = Build.VERSION.RELEASE;
        if (!str.equals(str)) {
            return false;
        }
        String str2 = Build.VERSION.CODENAME;
        return str2.equals(str2) && this.f10182a == c1167o0.f10182a;
    }

    public final int hashCode() {
        return ((((Build.VERSION.RELEASE.hashCode() ^ 1000003) * 1000003) ^ Build.VERSION.CODENAME.hashCode()) * 1000003) ^ (this.f10182a ? 1231 : 1237);
    }

    public final String toString() {
        return "OsData{osRelease=" + Build.VERSION.RELEASE + ", osCodeName=" + Build.VERSION.CODENAME + ", isRooted=" + this.f10182a + "}";
    }
}
