package u4;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: u4.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1236s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1219a f10483d = new C1219a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1220b f10485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10486c;

    public C1236s(SocketAddress socketAddress) {
        C1220b c1220b = C1220b.f10380b;
        List listSingletonList = Collections.singletonList(socketAddress);
        s3.D.f("addrs is empty", !listSingletonList.isEmpty());
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(listSingletonList));
        this.f10484a = listUnmodifiableList;
        s3.D.j(c1220b, "attrs");
        this.f10485b = c1220b;
        this.f10486c = listUnmodifiableList.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1236s)) {
            return false;
        }
        C1236s c1236s = (C1236s) obj;
        List list = this.f10484a;
        if (list.size() != c1236s.f10484a.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!((SocketAddress) list.get(i)).equals(c1236s.f10484a.get(i))) {
                return false;
            }
        }
        return this.f10485b.equals(c1236s.f10485b);
    }

    public final int hashCode() {
        return this.f10486c;
    }

    public final String toString() {
        return "[" + this.f10484a + "/" + this.f10485b + "]";
    }
}
