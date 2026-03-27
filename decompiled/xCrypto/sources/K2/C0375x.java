package K2;

import K2.C0353a;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: K2.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0375x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0353a.c f1322d = C0353a.c.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0353a f1324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1325c;

    public C0375x(List list, C0353a c0353a) {
        Z1.m.e(!list.isEmpty(), "addrs is empty");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f1323a = listUnmodifiableList;
        this.f1324b = (C0353a) Z1.m.o(c0353a, "attrs");
        this.f1325c = listUnmodifiableList.hashCode();
    }

    public List a() {
        return this.f1323a;
    }

    public C0353a b() {
        return this.f1324b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0375x)) {
            return false;
        }
        C0375x c0375x = (C0375x) obj;
        if (this.f1323a.size() != c0375x.f1323a.size()) {
            return false;
        }
        for (int i4 = 0; i4 < this.f1323a.size(); i4++) {
            if (!((SocketAddress) this.f1323a.get(i4)).equals(c0375x.f1323a.get(i4))) {
                return false;
            }
        }
        return this.f1324b.equals(c0375x.f1324b);
    }

    public int hashCode() {
        return this.f1325c;
    }

    public String toString() {
        return "[" + this.f1323a + RemoteSettings.FORWARD_SLASH_STRING + this.f1324b + "]";
    }

    public C0375x(SocketAddress socketAddress) {
        this(socketAddress, C0353a.f1111c);
    }

    public C0375x(SocketAddress socketAddress, C0353a c0353a) {
        this(Collections.singletonList(socketAddress), c0353a);
    }
}
