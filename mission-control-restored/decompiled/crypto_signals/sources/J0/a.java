package J0;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f661d;

    public a(List list, Boolean bool, String str, List list2) {
        this.f658a = list;
        this.f659b = bool;
        this.f660c = str;
        this.f661d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            List list = aVar.f658a;
            List list2 = this.f658a;
            if (list2 == null ? list != null : !list2.equals(list)) {
                return false;
            }
            Boolean bool = aVar.f659b;
            Boolean bool2 = this.f659b;
            if (bool2 == null ? bool != null : !bool2.equals(bool)) {
                return false;
            }
            String str = aVar.f660c;
            String str2 = this.f660c;
            if (str2 == null ? str != null : !str2.equals(str)) {
                return false;
            }
            List list3 = aVar.f661d;
            List list4 = this.f661d;
            if (list4 != null) {
                return list4.equals(list3);
            }
            if (list3 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        List list = this.f658a;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Boolean bool = this.f659b;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        String str = this.f660c;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        List list2 = this.f661d;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }
}
