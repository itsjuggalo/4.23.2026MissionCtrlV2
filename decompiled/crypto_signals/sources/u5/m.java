package u5;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f10539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f10540d;
    public final Long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f10541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f10542g;

    public m(boolean z6, boolean z7, Long l6, Long l7, Long l8, Long l9) {
        H4.q qVar = H4.q.f578a;
        this.f10537a = z6;
        this.f10538b = z7;
        this.f10539c = l6;
        this.f10540d = l7;
        this.e = l8;
        this.f10541f = l9;
        this.f10542g = H4.t.V(qVar);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f10537a) {
            arrayList.add("isRegularFile");
        }
        if (this.f10538b) {
            arrayList.add("isDirectory");
        }
        Long l6 = this.f10539c;
        if (l6 != null) {
            arrayList.add("byteCount=" + l6);
        }
        Long l7 = this.f10540d;
        if (l7 != null) {
            arrayList.add("createdAt=" + l7);
        }
        Long l8 = this.e;
        if (l8 != null) {
            arrayList.add("lastModifiedAt=" + l8);
        }
        Long l9 = this.f10541f;
        if (l9 != null) {
            arrayList.add("lastAccessedAt=" + l9);
        }
        Map map = this.f10542g;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return H4.h.h0(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }
}
